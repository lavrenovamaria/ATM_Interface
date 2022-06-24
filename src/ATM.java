import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        //init Scanner
        Scanner sc = new Scanner(System.in);

        // Create a new bank
        Bank theBank = new Bank("Bank of Maria");

        //add a User to the bank
        User aUser = theBank.addUser("Maria", "Lavrenova", "1234");

        //add a checking account to the user
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true) {

        //stay in the login prompt until successful login
        curUser = ATM.mainMenuPrompt(theBank, sc);

        //stay in main menu until user logs out
        ATM.printUserMenu(curUser, sc);

        }
    }
    public static User mainMenuPrompt(Bank theBank, Scanner sc) {
        //inits
        String userID;
        String pin;
        User authUser;

        //prompt for userID and pin combo until a correct one is reached
        do {
        System.out.println("\n\nWelcome to the " + theBank.getName() + " ATM!");
            System.out.println("Please enter your user ID: ");
            userID = sc.nextLine();
            System.out.println("Please enter your pin: ");
            pin = sc.nextLine();
            authUser = theBank.userLogin(userID, pin);
            if (authUser == null){
                System.out.println("Invalid user ID or pin. Please try again.");
            }
        } while (authUser == null); //continue looping until a successful login
        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner sc){

        //print a summary of the user's accounts
        theUser.printAccountsSummary();

        //init
        int choice;

        //user menu
        do{
            System.out.println("Welcome %s, what would you like to do?", theUser.getFirstName());
            System.out.println("1. View Account Transaction History");
            System.out.println("2. Logout");
            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    theUser.printAccountsSummary();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 2);
    }
}
