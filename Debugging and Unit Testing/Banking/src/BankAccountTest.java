import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;
    private static int count;

    @BeforeAll
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    // setup() method is executed each time a method is called
    // prior to that test being executed
    @BeforeEach
    public void setup() {
        account = new BankAccount("Daniel","Georgiev",10000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        double balance = account.deposit(2000.00, true);
        assertEquals(12000, balance, 0);
        fail("Should have thrown an IllegalArgumentException");
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(6000.00, true);
        assertEquals(4000.00, balance, 0);
    }

    @Test
    public void withdraw_notBranch() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        account.withdraw(6000.00, false);
        });
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        account.deposit(2000.00, true);
        assertEquals(12000.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        account.withdraw(2000.00, true);
        assertEquals(8000.00, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    public void isChecking_true() {
        assertTrue(account.isChecking(), "The account is NOT a checking account");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @AfterEach
    public void teardown() {
        System.out.println("Count = " + count++);
    }
}

