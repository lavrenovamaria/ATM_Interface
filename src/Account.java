import java.util.ArrayList;

public class Account {

    private String name;
    private String uuid;
    private User holder;
    private ArrayList<Transaction> transactions;

    /**
     *
     * @param name the name of the account
     * @param holder the User object that holds this account
     * @param theBank the bank that issues the account
     */

    public Account(String name, User holder, Bank theBank){
        this.name = name;
        this.holder = holder;

        //get a new account UUID
        this.uuid = theBank.getNewAccountUUID();

        //init transactions
        this.transactions = new ArrayList<Transaction>();

        //add to holder and bank lists
        holder.addAccount(this);
        theBank.addAccount(this);
    }

    /**
     * Get the account ID
     * @return the uuid
     */
    public String getUuid(){
        return this.uuid;
    }
}
