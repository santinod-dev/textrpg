import java.util.*;
public class Main {

    static Scanner scanner = new Scanner(System.in); // make scanner accessible everywhere

    public static void main(String[] args) {
		String menu = """
		─── Main Menu ───
		[1] 🎮 Start Game
		[2] 🧑‍🎨 Create Character
		[3] 📊 View Stats
		[4] ❌ Exit
		────────────────
		""";
		System.out.println("\033\143");
        System.out.println(menu);

        // This part checks for ints inside of scanner
        while (!scanner.hasNextInt()) { 
            System.out.println("Enter a valid input");
            scanner.next();
            System.out.println("\033\143");
            System.out.println(menu);
        }
        int choice = scanner.nextInt();

        switch (choice){
		case 1:
            System.out.println("\033\143");
            System.out.println("You are playing the game.");
			
            Player player = CharacterCreation.create();  

			List<Player> party = new ArrayList<>(); // add player
				party.add(player);			
			Enemy slime = new Enemy("Slime", 3, 2, 3, 0, 25, 0,false);
			
			List<Enemy> monsters = new ArrayList<>();
				monsters.add(slime);
			
			List<Unit> units = new ArrayList<>();
				units.addAll(party);
				units.addAll(monsters);
				CombatManager.startBattle(units);
        
        case 2:
            System.out.println("You are now resting.");
        case 3:
            System.exit(0);
        }
    }
}