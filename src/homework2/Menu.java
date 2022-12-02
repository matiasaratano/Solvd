package homework2;

public class Menu {
    public static void printMenu() {
        System.out.println("Hello, press: " + "\n" +
                "\r" + "1.Register" + "\n" +
                "\r" + "2.Log in" + "\n" +
                "\r" + "3.List Accounts Registered" + "\n" +
                "\r" + "4.Exit");
    }

    public static void existAccountMenu() {
        System.out.println("What would you like to do?" + "\n" +
                "\r" + "1.Info" + "\n" +
                "\r" + "2.Deposit money" + "\n" +
                "\r" + "3.Withdrawal money" + "\n" +
                "\r" + "4.Money transferring" + "\n" +
                "\r" + "5.Get a Credit" + "\n" + "\r" + "6.Exit");
    }

    public static void accTypeMenu() {
        System.out.println("What type of account do you want to register?" + "\n" +
                "\r" + "1.Checking" + "\n" +
                "\r" + "2.Savings" + "\n" +
                "3.Exit");
    }
}
