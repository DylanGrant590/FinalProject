Jamaica Bank of the West Indies – Java Console Banking System
A simple, interactive Java console application simulating core banking operations such as creating accounts, depositing, withdrawing, and managing interest. Developed for learning, testing, or expanding into a more advanced system.

Overview
This application provides a menu-driven experience where users can:

Open or access accounts

Deposit and withdraw funds

View account balances

Apply interest rates

View total assets across all accounts

Edit or delete accounts

The program is built with a modular structure using three main classes:

Teller: Handles the UI and user navigation

Bank: Manages a list of accounts and related operations

BankAccount: Represents individual bank accounts and handles transactions

Project Structure
plaintext
Copy
Edit
jamaica-bank
Teller.java          // Entry point and main menu system
BankAccount.java     // Logic for each bank account
Bank.java            // Manages all accounts and interest functionality
README.md            // Project documentation (this file)
Features
Feature	Description
Account Creation	Users can create accounts with a unique name
Account Access	Access existing accounts to perform transactions
Deposit & Withdraw	Robust logic with error handling (e.g., negative deposits, insufficient funds)
Interest Rate Support	Apply interest manually or automatically when balance ≥ $1000
Total Assets Calculation	View total assets across all accounts
Delete / ✏️ Edit Accounts	Delete accounts or update names
Exception Handling	Handles common exceptions (InputMismatch, AccountNotFound, InsufficientResources)
Getting Started
Prerequisites
Java JDK 8 or later

Terminal or IDE (e.g., IntelliJ IDEA, Eclipse)

Running the App
Download the code

Clone this repo or download the .java files into a folder.

Compile the Java files

bash
Copy
Edit
javac Teller.java Bank.java BankAccount.java
Run the application

Welcome to Jamaica Bank of the West Indies!
-------------------------------------------

Please enter a number from the following menu:
1) Open a new account.
2) Open an existing account.
3) View total assets of all bank accounts.
4) Delete an account.
5) Edit account.
6) Exit.
Submenu (after accessing an account):

Copy
Edit
Please enter a number:
1) Withdraw from an account
2) Deposit to an account
3) Check account balance
4) Choose interest rate
5) Go back
6) Exit
7) 
Known Issues & Bugs
Interest listener methods (addInterestListener, removeInterestListener) may recurse or misfire due to confusion between Bank and CaretListener logic.

CaretListener interface is not required; UI references (e.g., CaretEvent) can be removed.

Some try-catch blocks catch exceptions that never occur in those contexts.

getTotalAssets() logic is flawed and doesn’t calculate actual total across accounts.

Account identification is based only on name, which may not be unique.

Suggested Improvements
Replace account name with unique account ID (e.g., UUID)

Add persistent storage (file or database)

Clean up unused methods and redundant code

Implement unit tests with JUnit

Refactor to remove unused Swing/CaretListener components

Use BigDecimal for accurate financial calculations

Technologies Used
Java Standard Edition (JDK 8+)

Java Collections (ArrayList, Iterator)

Java Exception Handling

Console I/O (Scanner)

Author
Created by a passionate Java developer for educational and experimental purposes. Contributions and improvements are welcome!

License
This project is licensed under the MIT License. Feel free to use, modify, and share it.

