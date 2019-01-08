/*
Kata Name: Second Variation on Caesar Cipher
Problem Task: In this country soldiers are poor but they need a certain level of secrecy for their communications so, though they do not know Caesar cypher, they reinvent it in the following way.
They use ASCII, without really knowing it, but code only letters a-z and A-Z. Other caracters are kept such as.
They change the "rotate" each new message. This "rotate" is a prefix for their message once the message is coded. The prefix is built of 2 letters, the second one being shifted from the first one by the "rotate", the first one is the first letter, after being downcased, of the uncoded message.
For example if the "rotate" is 2, if the first letter of the uncoded message is 'J' the prefix should be 'jl'.
To lessen risk they cut the coded message and the prefix in five pieces since they have only five runners and each runner has only one piece.
If possible the message will be evenly split between the five runners; if not possible, parts 1, 2, 3, 4 will be longer and part 5 shorter. The fifth part can have length equal to the other ones or shorter. If there are many options of how to split, choose the option where the fifth part has the longest length, provided that the previous conditions are fulfilled. If the last part is the empty string don't put this empty string in the resulting array.
For example, if the coded message has a length of 17 the five parts will have lengths of 4, 4, 4, 4, 1. The parts 1, 2, 3, 4 are evenly split and the last part of length 1 is shorter. If the length is 16 the parts will be of lengths 4, 4, 4, 4, 0. Parts 1, 2, 3, 4 are evenly split and the fifth runner will stay at home since his part is the empty string and is not kept.

Could you ease them in programming their coding?

Example with shift = 1 :

message : "I should have known that you would have a perfect answer for me!!!"

code : => ["ijJ tipvme ibw", "f lopxo uibu z", "pv xpvme ibwf ", "b qfsgfdu botx", "fs gps nf!!!"]

Sample Tests:
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CaesarTwoTest {

    @Test
    public void test1() {
        String u = "I should have known that you would have a perfect answer for me!!!";
        List<String> v = Arrays.asList("ijJ tipvme ibw", "f lopxo uibu z", "pv xpvme ibwf ", "b qfsgfdu botx", "fs gps nf!!!");
        assertEquals(v, CaesarTwo.encodeStr(u, 1));
    }
    @Test
    public void test2() {
        String u = "O CAPTAIN! my Captain! our fearful trip is done;";
        List<String> v = Arrays.asList("opP DBQUBJ", "O! nz Dbqu", "bjo! pvs g", "fbsgvm usj", "q jt epof;");
        assertEquals(v, CaesarTwo.encodeStr(u, 1));
    }
}
*/


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CaesarTwo {

    private static final int NUM_OF_SPLITS = 5;

    public static List<String> encodeStr(String s, int shift) {
        String encrypted = encryptString(s, shift);
        return splitString(encrypted);
    }

    public static String decode(List<String> s) {
        String encrypted = s.stream().collect(Collectors.joining());
        int shift = encrypted.charAt(0) - encrypted.charAt(1);
        return encryptString(encrypted, shift).substring(4);
    }

    private static String encryptString(String s, int shift) {

        int offset = shift >= 0 ? shift % 26 : 26 + (shift % 26);
        char firstChar = Character.toLowerCase(s.charAt(0));
        char shifted = (char) (firstChar + offset);

        StringBuilder sb = new StringBuilder(s.length() + 2)
                .append(firstChar)
                .append(shifted);
        s.chars()
                .map(c -> shiftChar(c, offset))
                .forEach(c -> sb.append((char) c));

        return sb.toString();
    }

    private static int shiftChar(int c, int shift) {
        if (!Character.isAlphabetic(c))
            return c;
        if (Character.isLowerCase(c))
            return ((c - 'a' + shift) % 26) + 'a';
        return ((c - 'A' + shift) % 26) + 'A';
    }

    private static List<String> splitString(String s) {

        int splitSize;
        int restSize = 0;
        if (0 == s.length() % NUM_OF_SPLITS) {
            splitSize = s.length() / NUM_OF_SPLITS;
        } else {
            splitSize = (s.length() + NUM_OF_SPLITS) / NUM_OF_SPLITS;
            restSize = s.length() % splitSize;
        }

        List<String> substrings = new ArrayList<>();
        for (int i = 0; (i + 1) * splitSize <= s.length(); i++) {
            substrings.add(s.substring(i * splitSize, (i + 1) * splitSize));
        }
        if (restSize > 0) {
            substrings.add(s.substring(s.length() - restSize, s.length()));
        }

        return substrings;
    }
}