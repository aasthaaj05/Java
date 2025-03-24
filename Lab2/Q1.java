//Define a class to represent a bank account. Include the following details like name of the depositor, account number, type of account, balance amount in the account. Write methods to assign initial values, to deposit an amount, withdraw an amount after checking the balance, to display name, account number, account type and balance.

class BankAccount {
    String accountHolderName;
    double balance;
    static String bankName;

    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Balance after deposition is " + balance);
    }

    void withdraw(double amount) {
        String result = (amount > balance || amount <= 0)
                ? "Non-deductible amount"
                : "Balance after withdrawal is " + (balance -= amount);
        System.out.println(result);
    }

    void display() {
        System.out.println("Bank holder's name is " + accountHolderName +
                ", they have a balance of Rs." + balance +
                " in the bank " + bankName);
    }

    public static void setBankName(String name) {
        bankName = name;
    }
}

public class Q1 {
    public static void main(String[] args) {
        BankAccount.setBankName("SBI");

        BankAccount acc1 = new BankAccount("Aastha", 3000);
        BankAccount acc2 = new BankAccount("Akansha", 2000);

        acc1.display();
        acc1.deposit(2000);
        acc1.withdraw(4000);

        System.out.println("\n");

        acc2.display();
        acc2.deposit(1000);
        acc2.withdraw(5000);
    }
}
