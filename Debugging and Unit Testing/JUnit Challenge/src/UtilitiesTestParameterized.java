import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

public class UtilitiesTestParameterized {

    private Utilities util;
    private String input;
    private String output;

    public UtilitiesTestParameterized(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @BeforeEach
    public void setup() {
        util = new Utilities();
    }

    @ParameterizedTest
    public static Collection<Object[]> testConditions() {
      return Arrays.asList(new Object[][]{
              {"ABCDEFF", "ABCDEF"},
              {"AB88EFFG", "AB8EFG"},
              {"112233445566", "123456"},
              {"ZYZQQB", "ZYZQB"},
              {"A", "A"}
      });
    }

    @Test
     void removePairs() {
        assertEquals(output, util.removePairs(input));
    }
}
