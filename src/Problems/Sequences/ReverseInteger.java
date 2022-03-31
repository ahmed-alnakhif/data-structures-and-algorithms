package Problems.Sequences;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-231, 231 - 1], then return 0.
 * 
 * Assume the environment does not allow you to store 64-bit integers (signed or
 * unsigned).
 * 
 * Example 1:
 * 
 * Input: x = 123
 * Output: 321
 * Example 2:
 * 
 * Input: x = -123
 * Output: -321
 * Example 3:
 * 
 * Input: x = 120
 * Output: 21
 */

public class ReverseInteger {

    public int reverse(int x) {
        String reversed = new StringBuilder()
            .append(Math.abs(x))
            .reverse()
            .toString();
        
        try {
            return (x < 0) ? Integer.parseInt(reversed) * -1 : Integer.parseInt(reversed);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public int reverse2(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(123));
        System.out.println(r.reverse(-123));
        System.out.println(r.reverse(120));
    }
}
