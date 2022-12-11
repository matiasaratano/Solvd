package homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import homework2.accounts.Account;
import homework2.accounts.CheckingAccount;
import homework2.accounts.SavingsAccount;
import homework2.exceptions.*;
import homework2.interfaces.IAccTypeMenu;
import homework2.interfaces.IPrintBasicOperations;
import homework2.persons.Client;

public class Bank implements IPrintBasicOperations {

    private String name;
    private Address address;
    private ArrayList<Account> accounts; //Falta implementar para trabajar con cualquier tipo de Account
    private Scanner scanner;


    public Bank(String name, Address address) {
        this.name = name;
        this.address = address;
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public Account lookupAccount(int accountID, String phoneNumber) throws IncorrectDetailException {
        for (Account account : accounts) {
            if (account.getID() == accountID && account.getPhoneNumber().equals(phoneNumber)) {
                return account;
            }
        }
        throw new IncorrectDetailException("One of the details is incorrect");
    }

    public Account lookupAccount(String phoneNumber) throws IncorrectDetailException {
        for (Account account : accounts) {
            if (account.getPhoneNumber().equals(phoneNumber)) {
                return account;
            }
        }
        throw new IncorrectDetailException("One of the details is incorrect");

    }


    public void listAccounts() {
        for (Account account : accounts) {
            System.out.println(account.getSummary());
        }
    }

    public void registerCheckingAccount(Client client) {
        accounts.add(new CheckingAccount(client));
    }

    public void registerSavingsAccount(Client client) {
        accounts.add(new SavingsAccount(client));
    }

    public void registerAccount() throws IncorrectNumberException {
        try {
            System.out.println("First name?");
            String firstName = scanner.next();
            System.out.println("Last name?");
            String lastName = scanner.next();
            System.out.println("Phone number?");
            String phoneNumber = scanner.next();
            if (isPhoneNumberCorrect(phoneNumber)) {
                boolean exitRequested = false;
                while (!exitRequested) {
                    IAccTypeMenu.IAccTypeMenu();
                    int choice = Integer.parseInt(scanner.next());
                    switch (choice) {
                        case 1:
                            accounts.add(new CheckingAccount(new Client(firstName, lastName, phoneNumber)));
                            System.out.println("You have created a checking account successfully!" + "\n" + "Your account ID is: "
                                    + accounts.get(accounts.size() - 1).getID());
                            exitRequested = true;
                            break;
                        case 2:
                            accounts.add(new SavingsAccount(new Client(firstName, lastName, phoneNumber)));
                            System.out.println("You have created a savings account successfully!" + "\n" + "Your account ID is: "
                                    + accounts.get(accounts.size() - 1).getID());
                            exitRequested = true;
                            break;
                        case 3:
                            exitRequested = true;
                            break;
                        default:
                            System.out.println("Wrong input");
                            break;
                    }
                }
            }
        } catch (IncorrectNumberException ex) {
            throw new IncorrectNumberException("Phone number must be 10 digits.");
        }

    }

    public Account readAccount() throws IncorrectDetailException {
        Account selectedAccount = null;
        while (selectedAccount == null) {
            System.out.println("Please enter your ID:");
            int accountID = scanner.nextInt();
            System.out.println("Please enter your phone number:");
            String phoneNumber = scanner.next();
            selectedAccount = lookupAccount(accountID, phoneNumber);
        }
        return selectedAccount;

    }

    public static boolean isPhoneNumberCorrect(String phoneNumber) throws IncorrectNumberException {
        if (phoneNumber.length() != 10) {
            throw new IncorrectNumberException("Phone number must be 10 digits.");
        } else {
            return true;
        }
    }

    public void manageAccount() throws InvalidAmountException, InsufficientFundsException, InvalidAccountException, IncorrectNumberException, IncorrectDetailException {
        Account selectedAccount = this.readAccount();
        boolean exitRequested = false;
        while (!exitRequested) {
            Menu.existAccountMenu();
            int choice = Integer.parseInt(scanner.next());
            switch (choice) {
                case 1:
                    System.out.println(selectedAccount.toString());
                    break;
                case 2:
                    System.out.println("Please enter deposit amount:");
                    long depositAmount = (long) scanner.nextDouble();
                    selectedAccount.depositMoney(depositAmount);
                    break;
                case 3:
                    System.out.println("Please enter withdrawal amount:");
                    long withdrawalAmount = (long) scanner.nextDouble();
                    selectedAccount.withdrawal(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Please enter the phone number of the account you want to transfer to: ");
                    String accountPhoneNumber = scanner.next();
                    if (isPhoneNumberCorrect(accountPhoneNumber)) {
                        Account accountToTransfer = lookupAccount(accountPhoneNumber);
                        System.out.println("Enter the amount of money you would like to transfer:");
                        long moneyToTransfer = (long) scanner.nextDouble();
                        selectedAccount.transferMoney(selectedAccount, accountToTransfer, moneyToTransfer);
                    }
                    break;
                case 5:
                    CreditSummary creditSum = selectedAccount.getClient().getCreditSummary();
                    long creditDepositAmount = this.getCredit(creditSum);
                    if (creditSum != null && isApproved(creditSum, creditDepositAmount)) {
                        creditSum.setHasCredit(true);
                        selectedAccount.depositMoney(creditDepositAmount);
                    }
                    break;
                case 6:
                    exitRequested = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }

        }
    }

    private long getCredit(CreditSummary creditSummary) {
        long creditAmount;
        try {
            creditAmount = 0;
            if (creditSummary == null) {
                System.out.println("Credit Refused, no credit summary in your account, update it at your nearest bank");
            } else {
                do {
                    if (creditAmount > creditSummary.getSalary() * 10) {
                        System.out.println("You cant get more than 10 salaries");
                    }
                    System.out.println("Enter the amount (up to 10 salaries) or 0 to close");
                    creditAmount = (long) scanner.nextDouble();
                } while (creditAmount < 0 || creditAmount > creditSummary.getSalary() * 10);
            }
        } catch (RuntimeException e) {
            throw new CustomInputMismatchException("Wrong input");
        }
        return creditAmount;
    }

    public boolean isApproved(CreditSummary creditSummary, long creditAmount) {
        boolean isApproved = false;

        if (creditAmount == 0) {
            System.out.println("Exit");
        } else if (!creditSummary.isDefaulter() && !creditSummary.hasCredit() && creditSummary.getSalary() > 0) {
            isApproved = true;
            System.out.println("Credit Approved");
        } else if (creditSummary.isDefaulter()) {
            System.out.println("Credit denied because of a default, call the bank to find out your credit status");
        } else if (creditSummary.hasCredit()) {
            System.out.println("Credit denied because you already have another one");
        } else if (creditSummary.getSalary() > 0) {
            System.out.println("Credit denied because of your stated salary, call the bank to update it");
        } else {
            System.out.println("Credit Denied");
        }
        return isApproved;
    }


    @Override
    public void IPrintBasicOperations() {
        HashMap<String, String> map = new HashMap<>();

        map.put("Deposit", "A deposit is when you add money to your account.");
        map.put("Withdrawal", "A withdrawal is when you take money out of your account.");
        map.put("Transfer", "A transfer is when you move money from one account to another.");

        System.out.println("Basic bank operations: ");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + ": " + value);
        }
    }
}