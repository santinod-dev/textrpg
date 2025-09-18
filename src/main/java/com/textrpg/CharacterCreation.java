
import java.util.*;
 // character creation
public class CharacterCreation{
	static Scanner scanner = new Scanner(System.in);
	
	public static Player create() {
		String menu = """
					─── Character Creation ───
					Choose your Class:
					[1] ⚔️ Warrior
					[2] 🪄 Mage
					[3] 🗡️ Rogue
					──────────────────────────
					""";
					
		
        System.out.println("\033\143");
        System.out.println(menu);

        int job = -1;
        while (true) {
            if (scanner.hasNextInt()) {
                job = scanner.nextInt();
                scanner.nextLine(); // consume leftover newline
                if (job >= 1 && job <= 3) break; // valid choice
            } else {
                scanner.nextLine(); // discard invalid input
            }
            System.out.println("Please enter a valid command (1-3):");
        }
		
		System.out.println("What is your name?");
		String name = scanner.nextLine();
		
		
		Player player = null;
        switch (job) { // PLAYER NAME , JOB, ATTACK, DEFENSE, INTELLIGENCE, DEX, HP, MANA, IS DEFENDING
            case 1 -> player = new Player(name, "Warrior", 8, 7, 2, 4, 120, 40, false);
            case 2 -> player = new Player(name, "Mage", 3, 2, 10, 5, 75, 120, false);
            case 3 -> player = new Player(name, "Rogue", 6, 4, 4, 9, 90, 60, false);
        }

		
		String stats = String.format("""
					─── Player Stats ───
					Name:       %s
					Class:      %s
					HP:         ❤️ %d
					Mana:       🔋 %d
					Attack:     ⚔️ %d
					Defense:    🛡 %d
					Dexterity:  🌀 %d
					────────────────────
					""", player.name, player.job, player.hp, player.mana, player.attack, player.defense, player.dexterity);
					

		System.out.println(stats);  // Show Player stats
		System.out.println("enter 'ready' to begin");
		while (!scanner.hasNext("ready")) {
			System.out.println("\033\143");
			System.out.println("enter 'ready' to begin");
			scanner.next();
		}
		
		return player; 
		}
}
