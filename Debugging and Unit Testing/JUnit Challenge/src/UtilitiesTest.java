import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

private Utilities util;

@BeforeEach
private void setup() {
    util = new Utilities();
}

    @org.junit.jupiter.api.Test
    void everyNthChar() {
        char[] output = util.everyNthChar(new char[] {'h','e','l','l','o'}, 2);
        assertArrayEquals(new char[] {'e','l'}, output);

        char[] output2 = util.everyNthChar(new char[] {'h','e','l','l','o'}, 6);
        assertArrayEquals(new char[] {'h','e','l','l','o'}, output2);
    }

    @org.junit.jupiter.api.Test
    void removePairs() {
       util.removePairs("AABCDDEFF");
        assertEquals("ABCDEF", util.removePairs("AABCDDEFF"));
        assertEquals("ABCABDEF", util.removePairs("ABCCABDEEF"));
        assertNull(util.removePairs(null), "Did not get null returned when argument passed is null" );
        assertEquals("A", util.removePairs("A"));
        assertEquals("", util.removePairs(""));
    }

    @org.junit.jupiter.api.Test
    void converter() {
        assertEquals(300,util.converter(10,5));
    }

    @Test
    public void converter_arithmeticException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            util.converter(10,0);
        });
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        util.nullIfOddLength("AABBCCDDEEFF");
        util.nullIfOddLength("ABBCCDDEEFF");
    }
}