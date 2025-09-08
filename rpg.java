import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in); // make scanner accessible everywhere

    public static void main(String[] args) {
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
            create();   
        } else if (choice == 2) {
            System.out.println("You are now resting.");
        } else if (choice == 3) {
            System.exit(0);
        }

        
    }
}