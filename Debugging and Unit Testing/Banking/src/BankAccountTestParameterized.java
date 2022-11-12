import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTestParameterized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @BeforeEach
    public void setup() {
        account = new BankAccount("Daniel","Georgiev", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @ParameterizedTest
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {100.0, true, 1100.0},
                {200.0, true, 1200.0},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.0, true, 2000.0}
        });
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
    }
}
