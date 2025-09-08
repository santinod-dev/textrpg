import java.util.Scanner;
 // character creation
public class CharacterCreation{
	static Scanner scanner = new Scanner(System.in);
	
	public static Player create() {
       
		
        System.out.println("\033\143");
        System.out.println("Select a Class \n1. Warrior\n2. Mage\n3. Rogue");

        int job = scanner.nextInt();
		System.out.println("\033\143");
		System.out.println("What is your name?");
		
		scanner.nextLine();
		String name = scanner.nextLine();
		Player player =null;
        if (job == 1) { // PLAYER NAME , JOB, ATTACK, DEFENSE, INTELLIGENCE, DEX, HP, MANA
		
		  player = new Player(name, "Warrior", 8, 7, 2, 4, 120, 40);// create new Player object
			
        } else if (job == 2) { // PLAYER NAME , JOB, ATTACK, DEFENSE, INTELLIGENCE, DEX, HP, MANA
		
          player = new Player(name, "Mage", 3, 2, 10, 5, 75, 120);// create new Player object
			
        } else if (job == 3) { // PLAYER NAME , JOB, ATTACK, DEFENSE, INTELLIGENCE, DEX, HP, MANA
		
          player = new Player(name, "Rogue", 6, 4, 4, 9, 90, 60);// create new Player object
			
        }
		
		System.out.println("Welcome "+ player.name + " the " + player.job);
        System.out.println("You are a " + player.job + "!");
        System.out.println("Attack: " + player.attack);
        System.out.println("Intelligence: " + player.intelligence);
        System.out.println("Dexterity: " + player.dexterity);
		
		
        // Show Player stats
		
		System.out.println("enter 'ready' to begin");
		
		
		while (!scanner.hasNext("ready")) {
			System.out.println("\033\143");
			System.out.println("enter 'ready' to begin");
			scanner.next();
		}
		System.out.println("\033\143");
		System.out.println("this is where the actual game would go");
		return player; 
	}
}
