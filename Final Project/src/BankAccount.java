import javax.naming.InsufficientResourcesException;
import javax.security.auth.login.AccountNotFoundException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class BankAccount implements CaretListener{

    //The BankAccount class has two data fields: accountName and balance.
    private String accountName;
    private int balance; 

    //Converts balance in dollars to cents and vice versa.
    private static double centsToDollars (int cents){ 
        //Divides by 0.01 to convert cents to dollars.
        return (cents * 0.01);
    }

    private static int dollarsToCents (double dollars){
        //Multiply dollar by 100 then implement Math.round(double).
        return ((int)Math.round(dollars * 100.0));
    }

    //The code starts by declaring an instance of the BankAccount class, which is named "bankAccount".
    public BankAccount (){

    }

    //Next, it creates an object of type AccountNotFoundException to be thrown when no bank accounts are found in the database.
    public String getAccountName() throws AccountNotFoundException{
        if (accountName != null){
            return accountName;
        }
        else if (accountName == null){
        }try {
        	System.out.println("\nAccount not found!"); //Prints a statement to the user if the account is not found. 
        } catch (Exception e) {
        	 System.out.println("\nAccount not found!");
        }
		return accountName;
          
    }

    public double getBalance(){
        return centsToDollars(balance);
    }

    double getInterestRate(double rate){
        return rate;
    }

    public void setInterestRate(double rate){
        balance = balance + (int) (balance * rate);
    }

    //Deposit method.
    public void deposit (double credit) throws NegativeArraySizeException{
        balance = balance + dollarsToCents(credit);
    }

    //Withdraw method throws insufficient funds exception.
    public void withdraw (double debit) throws InsufficientResourcesException{
        int debitInCents = dollarsToCents(debit);
        if (debitInCents <= balance) {
            balance = (balance - debitInCents);
        }try {

        } catch (Exception e) {
        	 System.out.println("\nInsufficient funds!");
        }
    }

    public BankAccount (String accountName){
        this.accountName = accountName;
    }

    public String toString(){
        try {
            return String.format ("\nAccount \"%s\" has a balance of $%.2f", getAccountName(), getBalance());
        } catch (AccountNotFoundException e) {
            System.out.println("\nAccount not found!");
        }
        return accountName;
    }

    public void postInterest(double rate) throws AccountNotFoundException {
        Bank bank = new Bank();
        if (balance >= (1000 * 100)){
            ((Bank) bank.getAccounts()).addInterestListener(this);
        }
        if (balance < (1000 * 100)){
            ((Bank) bank.getAccounts()).removeInterestListener(this);
        }

    }

	@Override
	public void caretUpdate(CaretEvent e) {
		
	}

	public BankAccount getSelectedAcc1() {
		return null;
	}

	public String getInterestRate() {
		// TODO Auto-generated method stub
		return null;
	}
}