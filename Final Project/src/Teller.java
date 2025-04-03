import java.util.InputMismatchException;
import java.util.Scanner;
import javax.naming.InsufficientResourcesException;
import javax.security.auth.login.AccountNotFoundException;

public class Teller {
    private final Bank bank = new Bank();
    private BankAccount bankAccount;
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Teller menu = new Teller();
        menu.display();
    }

    public void display() {
        System.out.println("-------------------------------------------");
        System.out.println("Welcome to Jamaica Bank of the West Indies!");
        System.out.println("-------------------------------------------");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        while (true) {
            try {
                System.out.println("***********************************************");
                System.out.println("Please enter a number from the following menu: ");
                System.out.println("1) Open a new account.\n" +
                        "2) Open an existing account.\n" +
                        "3) View total assets of all bank accounts.\n" +
                        "4) Delete an account.\n" +
                        "5) Edit account.\n" +
                        "6) Exit.");
                System.out.println("***********************************************");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter your account name: ");
                        String newAccountName = scanner.nextLine();
                        bankAccount = bank.createAccount(newAccountName);
                        display2();
                        break;
                    case 2:
                        System.out.print("Enter your account name: ");
                        String existingAccountName = scanner.nextLine();
                        bankAccount = bank.findAccount(existingAccountName);
                        display2();
                        break;
                    case 3:
                        System.out.println("Total assets: " + bank.getTotalAssets());
                        break;
                    case 4:
                        bank.getDelete();
                        break;
                    case 5:
                        bank.getEdit();
                        break;
                    case 6:
                        System.out.println("Thank you for doing business with us!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid selection! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); 
            } catch (AccountNotFoundException e) {
                System.out.println("Error: Account not found.");
            } catch (InsufficientResourcesException e) {
                System.out.println("Error: Insufficient funds.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public void display2() {
        while (true) {
            try {
                System.out.println("\n**************************************************");
                System.out.println("Please enter a number from the following list: ");
                System.out.println("1) Withdraw from an account\n" +
                        "2) Deposit to an account\n" +
                        "3) Check account balance\n" +
                        "4) Choose interest rate for your account\n" +
                        "5) Go back\n" +
                        "6) Exit");
                System.out.println("**************************************************");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter the amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();
                        bankAccount.withdraw(withdrawAmount);
                        System.out.println("New balance: " + bankAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();
                        bankAccount.deposit(depositAmount);
                        System.out.println("New balance: " + bankAccount.getBalance());
                        break;
                    case 3:
                        System.out.println("Current balance: " + bankAccount.getBalance());
                        break;
                    case 4:
                        System.out.print("Enter interest rate (e.g., 0.05 for 5%): ");
                        double rate = scanner.nextDouble();
                        scanner.nextLine();
                        bankAccount.setInterestRate(rate);
                        System.out.println("New interest rate: " + bankAccount.getInterestRate());
                        break;
                    case 5:
                        return; 
                    case 6:
                        System.out.println("Thank you for doing business with us!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid selection! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }
}
