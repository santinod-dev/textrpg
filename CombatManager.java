import java.util.*;

public class CombatManager {
   public static void startBattle(List<Unit> units) {
		List<Enemy> monsters = new ArrayList<>();
		List<Player> party = new ArrayList<>();
		Scanner choice = new Scanner(System.in);
		String menu = """ 
								─── Choose Action ───
								[1]  Attack
								[2]  Defend
								[3]  Skip Turn
								─────────────────────

								""";
								
		
		for (Unit unit : units) {   // separate units into players and enemies
			if (unit instanceof Player) {
				party.add((Player) unit);
			} else if (unit instanceof Enemy) {
				monsters.add((Enemy) unit);
			}
		}
		boolean partyAlive = party.stream().anyMatch(p -> p.hp > 0);
		boolean monstersAlive = monsters.stream().anyMatch(e -> e.hp > 0);

		while(partyAlive && monstersAlive){
			List<Unit> turnOrder = new ArrayList<>(units);
			turnOrder.sort((a, b) -> b.dexterity - a.dexterity); // create turn order

			// battle loop (1 round for now)
			for (Unit u : turnOrder) {
				if (u.hp <= 0) continue; // skip dead

				if (u instanceof Player) { // get player action
					boolean valid = false;
					while(!valid){
					
					System.out.println(menu);
					if (choice.hasNextInt()){
						int action = choice.nextInt();
							switch (action){
							case 1 : //attack
								boolean validTarget = false;
								int target = -1;
								while (!validTarget) {
									StringBuilder choiceLine = new StringBuilder();
									choiceLine.append("─────── Target ──────\n");

									// print all enemies
									for (int e = 0; e < monsters.size(); e++) {
										Enemy enemy = monsters.get(e);
										choiceLine.append(String.format("[%d] %s (HP: %d)\n", e, enemy.name, enemy.hp));
									}
									choiceLine.append("─────────────────────");
									System.out.println(choiceLine.toString());

									System.out.print("Choose a target: ");

									if (choice.hasNextInt()) {
										target = choice.nextInt();

										if (target >= 0 && target < monsters.size()) {
											validTarget = true;
										} else {
											System.out.println("Invalid target! Please choose again.");
										}
									} else {
										System.out.println("Please enter a number!");
										choice.next(); // consume invalid input
									}
								}
								// once we break out, attack the chosen target
								u.attack(monsters.get(target));
								valid = true;
								break;
							case 2 : 
								u.isDefending = true;
								String brace = String.format("""
															────── Defense ──────
															%s braces for impact!
															─────────────────────
															""", u.name);
								System.out.println(brace);
								valid = true;
								break;
							case 3:
								valid = true;
								break;
							default:
								System.out.println("please enter a valid input");
							}	
						} else {
						System.out.println("please enter a valid input");
						choice.next();
						}
					}
						

				} else if (u instanceof Enemy) {
					u.attack(party.get(0));
				}

				// check win/lose after each action
				boolean allEnemiesDead = monsters.stream().allMatch(e -> e.hp <= 0);
				boolean allPlayersDead = party.stream().allMatch(p -> p.hp <= 0);

				if (allEnemiesDead) {
					System.out.println("You win!");
					return;
				} else if (allPlayersDead) {
					System.out.println("You lose!");
					return;
				}
			}
		}
	}
}