import java.util.*;

public class CombatManager {
   public static void startBattle(List<Unit> units) {
		List<Enemy> monsters = new ArrayList<>();
		List<Player> party = new ArrayList<>();

	 
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

				if (u instanceof Player) {
					u.attack(monsters.get(0));
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