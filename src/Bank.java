import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;

    private ArrayList<User> user;

    private  ArrayList<Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }

    /**
     * Generate a new universally unique ID for a user
     * @return the uuid
     */
    public String getNewUserUUID(){
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;

        do{
            //generate the number
            uuid = "";
            for (int c = 0; c < len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            //check if unique
            nonUnique = false;
            for(User u : this.user){
                if (uuid.compareTo(u.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }
        } while(nonUnique);
        return uuid;
    }

    public String getNewAccountUUID(){
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;

        do{
            //generate the number
            uuid = "";
            for (int c = 0; c < len; c++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }
            //check if unique
            nonUnique = false;
            for(Account a : this.accounts){
                if (uuid.compareTo(a.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }
        } while(nonUnique);
        return uuid;
    }

    public void addUser(String firstName, String lastName, String pin){
        User newUser = new User(firstName, lastName, pin, this);
        this.user.add(newUser))));

        //create a savings account for the user and add to User and Bank
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(NewAccount);
        this.accounts.add(NewAccount);

        return newUser;
    }

    public User userLogin(String userID, String pin){
        for(User u : this.users){
            if (u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)){
                return u;
            }
        }
        //if we get here, the user was not found or incorrect pin
        return null;
    }
}
