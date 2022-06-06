import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<User> user;
    private  ArrayList<Account> accounts;

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

    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }
}
