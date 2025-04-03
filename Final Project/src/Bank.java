import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import javax.naming.InsufficientResourcesException;
import javax.security.auth.login.AccountNotFoundException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
public class Bank implements CaretListener{
	 private static BankAccount selectedAcc1;
	//The code starts by declaring a variable called input.
	//This is the Scanner object that will be used to read in data from the user.
    Scanner scanner = new Scanner(System.in);
    private static ArrayList <BankAccount> accountList = new ArrayList<>();
    private static boolean flag = false;
    //The balance variable stores an integer value of how much money is currently in the bank account, while accounts stores a list of BankAccount objects which are created using new ArrayList().
    private int balance;
    //The balance variable stores an integer value of how much money is currently in the bank account, while accounts stores a list of BankAccount objects which are created using new ArrayList().
    private Collection<BankAccount> accounts = new ArrayList<BankAccount>();
    //The code then creates an instance of CaretListener named Bank with its constructor taking three arguments.
    private Collection<CaretListener> interestGainingAccounts = new ArrayList<CaretListener>();
    private double rate;

    Bank(){
    }

    Collection<BankAccount> getAccounts() throws AccountNotFoundException{
        if (accounts != null){
            return accounts;
        }
        else{
        	//If there are no accounts, it throws an exception saying that the account is not found.
            AccountNotFoundException anfe = new AccountNotFoundException("Account not found!");
            throw anfe;
        }
    }

    public BankAccount createAccount (String accountName) throws AccountNotFoundException {
    	//The code starts by asking the user to enter a name for their new account.
        System.out.println("\nWhat would you like to name your new account? ");
        //The code then creates a new BankAccount object and adds it to the list of accounts.
        BankAccount newAccount = new BankAccount(scanner.nextLine());
        accounts.add(newAccount);
        System.out.println("");
        System.out.println(newAccount.getAccountName() + " has created a new account.");
        System.out.println("\nNumber of accounts: " + accounts.size());
        for (BankAccount account : accounts){ //It loops through all of these objects and analyzes each one individually.
            if (newAccount.getAccountName() != null && newAccount.getAccountName().equals(accountName)){
                System.out.println("\nAccount name already exists.");
            }
        }
        return newAccount;
    }

    BankAccount findAccount (String accountName) {
    	for (BankAccount account : accounts){
    	     try {
				if (account != null && account.getAccountName().equals(accountName)){
				     return account;
				 }
			} catch (AccountNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        AccountNotFoundException anfe = new AccountNotFoundException("Account not found!"); //Displays a message to the user is an account is not found. 
        return null;
    }

    public void deposit (String accountName, double credit) throws AccountNotFoundException, NegativeArraySizeException{
        findAccount(accountName).deposit(credit);   
        if (credit < 0){
            NegativeArraySizeException nde= new NegativeArraySizeException("Cannot deposit negative credit!"); //Displays a message to the user if a negative number is entered.  
            throw nde;
        }
        for (BankAccount account : accounts){
            if (account.getBalance() >= (1000 * 100)){
                postInterest(0.05);
            }
            AccountNotFoundException anfe = new AccountNotFoundException("Account not found!"); //Displays a message if the account is not found. 
            throw anfe;
        }
    }

    //This method will search for the account and allow the user to do a withdrawal.
    public void withdraw(String accountName, double debit) throws InsufficientResourcesException, AccountNotFoundException{
        findAccount(accountName).withdraw(debit);
        for (BankAccount account :  accounts) {
            if (account.getBalance() < (1000 * 100)){
                postInterest(0.00);
            }
            InsufficientResourcesException ife = new InsufficientResourcesException("Insufficient funds!"); //Displays a message if insufficient funds is on account. 
            throw ife;
        }
    }

    public void getTotalAssets(String acountName) throws AccountNotFoundException{
        for (BankAccount accountName : accounts){
            if (findAccount(accountName.getAccountName()) != null){
                double total = 0;
                for (int i = 0; i < accounts.size(); i++){
                }
                System.out.println("\nSelected account: " + selectedAcc1);
                System.out.println("\nTotal assets for all accounts found is $ " + (total + findAccount(accountName.getAccountName()).getBalance()));
                System.out.println("\nNumber of accounts: " + accounts.size());
            }
            else{
                System.out.println("\nNo accounts found!"); //Displays a message if no accounts are found. 
            }
        }
    }
    
    //Adds interest listener and post interest at desired user amount when balance is $1000 or greater.
    public void addInterestListener (CaretListener listener) throws AccountNotFoundException{
        for (BankAccount account : accounts){
            if (account.getBalance() >= (1000 * 100)){
                rate = scanner.nextDouble(); //Inputs decimal number.
                postInterest(rate);
            }
        }
    }

    //Removes interest listener and post interest at 0% when balance is below $1000.
    public void removeInterestListener (CaretListener listener) throws AccountNotFoundException{
        for (BankAccount account : accounts){
            if (account.getBalance()  < (1000 * 100)){
                postInterest(rate);
            }
        }
    }

    //Post interest to accounts that are considered interest gaining accounts.
    public void postInterest (double rate) throws AccountNotFoundException{
        for (CaretListener listener : interestGainingAccounts) {
            ((Bank) listener).postInterest(rate);
            balance = (int) (balance * rate);
        }
    }

    public void addInterestListener(BankAccount holder) {
        addInterestListener(holder); 
    }

    public void removeInterestListener(BankAccount holder) {
        removeInterestListener(holder);
    }

	@Override
	public void caretUpdate(CaretEvent e) {
		
	}

	public void getDelete() {
		//Performs a delete function.
		 System.out.println("\nPlease enter an account number for further transactions: ");
         Object selectedAcc1 = scanner.nextInt();
         System.out.println("\nSelected account: " + selectedAcc1);
         Iterator <BankAccount> iterator = accountList.iterator();
         while (iterator.hasNext()) {
             selectedAcc1 = (BankAccount) iterator.next();
             if (Bank.getSelectedAcc1() == selectedAcc1) {
                 iterator.remove();
                 flag = true;
	}
}
         if (!flag) {
        	 System.out.println("\nAccount does not exist!"); //Shows a message if an account does not exist. 
         }
         System.out.println("\nAccount " + selectedAcc1 + " closed.");
	}
		   
	public static BankAccount getSelectedAcc1() {
		return selectedAcc1;
	}
	//Creates a new file. 
	public static void setSelectedAcc1(BankAccount selectedAcc1) throws IOException {
		Bank.selectedAcc1 = selectedAcc1;
	}
	//This method allows a user to edit their account name. 
	public Collection<BankAccount> getEdit() throws AccountNotFoundException, InsufficientResourcesException, NegativeArraySizeException {
	    System.out.println("\nPlease enter the name of the account: "); //Shows the user a message to edit their name. 
	    BankAccount newAccount = new BankAccount(scanner.nextLine());
	    String n1 = scanner.nextLine();
        accounts.add(newAccount);
        System.out.println(newAccount.getAccountName() + " has created a new account name.");
	    Bank.setAccountName(n1);
		return accounts; //Returns to the main menu. 
			}

	private static void setAccountName(String n1) {
	}

	public String getTotalAssets1() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTotalAssets() {
		// TODO Auto-generated method stub
		return null;
	}
	    }//End of class. 