/*
Let's assume that we pass the integer 922342959 to the method writeInt. The purpose of this method, as I understand it, is to add this number to the output stream in a binary format.

922342959 in binary is 00110110 11111001 11010110 00101111

Let's consider the line out.write((v >>> 24) & 0xFF);.

v >>> 24  means that we shift all the bits 24 bits to the right.

So we go from:

0110110 11111001 11010110 00101111

to:

00000000 00000000 00000000 00110110

The first byte (the first 8 bits) ends up at the end.

Then we do a boolean AND operation between v >>> 24 and 0xFF.

0xFF  in binary is 00000000 00000000 00000000 11111111

Therefore:

00000000 00000000 00000000 00110110

&

00000000 00000000 00000000 11111111

EQUALS

00000000 00000000 00000000 00110110

(a bit is equal to 1 when both bits equal 1)

(this is equal to 54 in decimals)

Finally, the write method (out.write((v >>> 24) & 0xFF);) will add this result to the output stream. As explained in the write method, ”the byte to be written is the eight low-order bits of the argument. The 24 high-order bits of the argument are ignored.”

That is why the write method will only write the last 8 bits in the output stream : 00110110.

Then we can proceed to the second 8-bit chunk (the second byte):

v>>>16  means that we shift everything 16 bits to the right.

So we go from:

00110110 11111001 11010110 00101111

to:

00000000 00000000 00110110 11111001

(this time, because we made only a 16-bit shift, the second byte 11111001 ends up at the end)

Then we do a boolean AND operation between v >>> 16 and 0xFF.

00000000 00000000 00110110 11111001

&

00000000 00000000 00000000 11111111

EQUALS

00000000 00000000 00000000 11111001

With this technique, we were able to isolate the second byte of our initial number 922342959.

Then the write method adds the last 8 bits to the output stream (11111001). The output stream already contains 00110110, so the output stream is now 00110110 11111001.

We continue the same process for the remaining 2 bytes that define our integer.

At the end of this process, the output stream will contain the 4 bytes that define the integer that we wanted to write in the first place: 922342959

00110110 11111001 11010110 00101111 */

public class ShiftInt {
        private static final String ANSI_RESET = "\u001B[0m";
        private static final String ANSI_BLACK = "\u001B[30m";
        private static final String ANSI_RED = "\u001B[31m";
        private static final String ANSI_GREEN = "\u001B[32m";
        private static final String ANSI_YELLOW = "\u001B[33m";
        private static final String ANSI_BLUE = "\u001B[34m";
        private static final String ANSI_PURPLE = "\u001B[35m";
        private static final String ANSI_CYAN = "\u001B[36m";
        private static final String ANSI_WHITE = "\u001B[37m";

        public static void main(String[] args) {
            int x = 922342959;

            writeInt(x);
        }


        private static void display(int x) {
            String all = String.format("%32s", Integer.toBinaryString(x)).replace(" ", "0");
            String colouredBinary = all.substring(0, 24) + ANSI_PURPLE + all.substring(24) + ANSI_RESET;
            int y = x & 0xFF;
            String output = String.format("%10d and 0xFF is %8s \t %10d is ",  y, Integer.toBinaryString(y), x) + colouredBinary;
            System.out.println(output);
        }

        private static void writeInt(int v) {
            int x;
            display(v >>> 24);
            display(v >>> 16);
            display(v >>> 8);
            display(v >>> 0);
        }
    }
