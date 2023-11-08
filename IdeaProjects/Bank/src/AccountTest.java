import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @org.junit.jupiter.api.Test
    void debit() {
        Account user = new Account(500000.00);
        assertEquals(499000,user.debit(1000)); //Subtraction
    }

    @org.junit.jupiter.api.Test
    void credit() {
        Account user = new Account(200000.00);
        assertEquals(201000,user.credit(1000)); //Addition
    }

    @org.junit.jupiter.api.Test
    void checkBalance() {
        Account a = new Account(20000.00);
        a.credit(5000);
        a.debit(3000);
        assertEquals(22000,a.checkBalance());
    }
}