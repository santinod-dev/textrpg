import java.util.*;
public class Main {

    static Scanner scanner = new Scanner(System.in); // make scanner accessible everywhere

    public static void main(String[] args) {
		List<Player> party = new ArrayList<>();
			party.add(new Player("Alice", "Warrior", 8, 7, 2, 4, 120, 40));
			party.add(new Player("Bob", "Mage", 3, 2, 10, 5, 75, 120));
		List<Enemy> monsters = new ArrayList<>();
			monsters.add(new Enemy("Slime", 3, 2, 2, 0, 25, 0));
			monsters.add(new Enemy("Spider", 5, 3, 4, 1, 40, 10));

		CombatManager.startBattle(party, monsters);
		
        /*
		System.out.println("\033\143");
        System.out.println("Welcome \n1. Play\n2. Rest\n3. Quit");

        // This part checks for ints inside of scanner
        while (!scanner.hasNextInt()) { 
            System.out.println("Enter a valid input");
            scanner.next();
            System.out.println("\033\143");
            System.out.println("Welcome \n1. Play\n2. Rest\n3. Quit");
        }
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("\033\143");
            System.out.println("You are playing the game.");
            CharacterCreation.create();   
        } else if (choice == 2) {
            System.out.println("You are now resting.");
        } else if (choice == 3) {
            System.exit(0);
        }s
		*/
		
        
    }
}