package Companies.facebook;


/**
 * One simple way to encrypt a string is to "rotate" every alphanumeric
 * character by a certain amount. Rotating a character means replacing it with
 * another character that is a certain number of steps away in normal alphabetic
 * or numerical order.
 * For example, if the string "Zebra-493?" is rotated 3 places, the resulting
 * string is "Cheud-726?". Every alphabetic character is replaced with the
 * character 3 letters higher (wrapping around from Z to A), and every numeric
 * character replaced with the character 3 digits higher (wrapping around from 9
 * to 0). Note that the non-alphanumeric characters remain unchanged.
 * Given a string and a rotation factor, return an encrypted string.
 * 
 * input = Zebra-493?
 * rotationFactor = 3
 * output = Cheud-726?
 */

public class RotationalCipher {

    String rotationalCipher(String input, int rotationFactor) {
        StringBuilder sBuilder = new StringBuilder(input);

        // T: O(N), S: O(N)
        for (int i = 0; i < sBuilder.length(); i++) {
            char ch = sBuilder.charAt(i);

            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    // subtract ascii value and take mod 26 so we can find the position from 0 -> 25
                    // add + 'A' (ascii value) to convert it back to a char
                    ch = (char) (((ch - 'A' + rotationFactor) % 26) + 'A');
                } else {
                    ch = (char) (((ch - 'a' + rotationFactor) % 26) + 'a');
                }
            } else if (Character.isDigit(ch)) {
                ch = (char) (((ch - '0' + rotationFactor) % 10) + '0');
            }

            sBuilder.setCharAt(i, ch);
        }

        return sBuilder.toString();
    }

    // T: O(N * R), S: O(N)
    String rotationalCipher2(String input, int rotationFactor) {
        StringBuilder sBuilder = new StringBuilder(input);

        for (int k = 0; k < rotationFactor; k++) {
            for (int i = 0; i < sBuilder.length(); i++) {
                char ch = sBuilder.charAt(i);

                if (Character.isLetter(ch)) {

                    if (Character.isUpperCase(ch)) {
                        if (ch == 'Z') {
                            ch = 'A';
                        } else {
                            char temp = Character.toLowerCase(ch);
                            temp += 1;
                            ch = Character.toUpperCase(temp);
                        }

                    } else {
                        if (ch == 'z') {
                            ch = 'a';
                        } else {
                            ch += 1;
                        }
                    }
                } else if (Character.isDigit(ch)) {
                    int num = Integer.parseInt(String.valueOf(ch));
                    if (num == 9) {
                        num = 0;
                    } else {
                        num += 1;
                    }
                    ch = Integer.toString(num).charAt(0);
                }

                sBuilder.setCharAt(i, ch);
            }
        }

        return sBuilder.toString();
    }

    int test_case_number = 1;

    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_0 = "Zebra-493";
        int rotationFactor_0 = 3;
        String expected_0 = "Cheud-726";
        String output_0 = rotationalCipher(input_0, rotationFactor_0);
        check(expected_0, output_0);

        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

    }

    public static void main(String[] args) {
        new RotationalCipher().run();
    }
}
