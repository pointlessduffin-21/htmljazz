public class Account {
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public double debit(double amount) {
        this.balance=this.balance-amount;
        return this.balance;
    }

    public double credit(double amount) {
        this.balance=this.balance+amount;
        return this.balance;
    }

    public double checkBalance() {
        return this.balance;
    }

    public static void main(String[] args) {
        Account credit1 = new Account(100000.00);
        credit1.credit(1500);
        System.out.println("Your Credit Balance is: " + credit1.balance);
    }


}
