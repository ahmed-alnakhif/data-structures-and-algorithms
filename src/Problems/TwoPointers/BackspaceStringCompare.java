package Problems.TwoPointers;

/**
 * Given two strings s and t, return true if they are equal when both are typed
 * into empty text editors. '#' means a backspace character.
 * 
 * Note that after backspacing an empty text, the text will continue empty.
 * 
 * Example 1:
 * 
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 */

public class BackspaceStringCompare {

    // using two pointers
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        // While there may be chars in build(S) or build (T)
        while (i >= 0 || j >= 0) {

            // Find position of next possible char in build(S)
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }

            // Find position of next possible char in build(T)
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            // if two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }

            // if expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }

    // using stringBuilder/stack
    public boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    private String build(String str) {
        StringBuilder strBuilder = new StringBuilder(); // or we can use a stack

        for (char c : str.toCharArray()) {
            if (c != '#') {
                strBuilder.append(c);
            } else if (strBuilder.length() != 0) {
                strBuilder.deleteCharAt(strBuilder.length() - 1);
            }
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        BackspaceStringCompare s = new BackspaceStringCompare();
        
        System.out.println(s.backspaceCompare("a##c", "#a#c"));
    }
}
