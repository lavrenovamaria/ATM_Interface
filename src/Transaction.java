import java.util.Date;
public class Transaction {

    //the amount of this transaction
    private double amount;
    //the time and date of this transaction
    private Date timestamp;
    //a memo for this transaction
    private String memo;

    //the account in which the transaction was performed
    private Account inAccount;

    public Transaction(double amount, Account inAccount){
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";
    }

    /**
     * Create a new transaction
     * @param amount the amount transacted
     * @param memo the memo for the transaction
     * @param inAccount the account the transaction belongs to
     */

    public Transaction(double amount, String memo, Account inAccount){
        //call the two-arg constructor first
        this(amount, inAccount);
        this.memo = memo;
    }
}
