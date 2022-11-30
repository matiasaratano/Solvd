package homework2;

import java.util.ArrayList;
import java.util.Scanner;

import homework2.persons.Client;

public class Bank {

    private String name;
    private Address address;
    private ArrayList<Account> accounts;
    private Scanner scanner;

    public Bank(String name, Address address) {
        this.name = name;
        this.address = address;
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public Account lookupAccount(int accountID, String phoneNumber) {
        for (Account account : accounts) {
            if (account.getID() == accountID && account.getPhoneNumber().equals(phoneNumber)) {
                return account;
            }
        }
        System.out.println("One of the details is incorrect");
        return null;
    }

    public Account lookupAccount(String phoneNumber) {
        for (Account account : accounts) {
            if (account.getPhoneNumber().equals(phoneNumber)) {
                return account;
            }
        }
        System.out.println("One of the details is incorrect");
        return null;
    }

    public void registerAccount(Client client) {
        accounts.add(new Account(client));
    }

    public void registerAccount() {
        System.out.println("First name?");
        String firstName = scanner.next();
        System.out.println("Last name?");
        String lastName = scanner.next();
        System.out.println("Phone number?");
        String phoneNumber = scanner.next();
        if (isPhoneNumberCorrect(phoneNumber)) {
            accounts.add(new Account(new Client(firstName, lastName, phoneNumber)));
            System.out.println("You have created account successfully!" + "\n" + "Your account ID is: "
                    + accounts.get(accounts.size() - 1).getID());

        }
    }

    public Account readAccount() {
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

    public static boolean isPhoneNumberCorrect(String phoneNumber) {
        if (phoneNumber.length() != 10) {
            System.out.println("Phone number must be 10 digits.");
            return false;
        } else {
            return true;
        }
    }

    public void manageAccount() {
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
        long creditAmount = 0;
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
}