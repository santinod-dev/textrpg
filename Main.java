import java.util.*;
public class Main {

    static Scanner scanner = new Scanner(System.in); // make scanner accessible everywhere

    public static void main(String[] args) {
		
		 Player player = new Player("mia", "Warrior", 8, 4, 2, 4, 120, 40,false);
		 List<Player> party = new ArrayList<>(); // add player
			party.add(player);
		
		Enemy slime = new Enemy("Slime", 3, 2, 3, 0, 25, 0,false);
		
		List<Enemy> monsters = new ArrayList<>();
			monsters.add(slime);
		
		List<Unit> units = new ArrayList<>();
			units.addAll(party);
			units.addAll(monsters);
      
		 CombatManager.startBattle(units);
		 
		 
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
        }
		*/
		
        
    }
}