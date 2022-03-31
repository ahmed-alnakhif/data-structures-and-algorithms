package Problems.Sequences;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * 
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * 
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int result = 0;
        int prev = 0;
        for(int i = s.length()-1; i>=0; i--){
            int curr = getRomanValue(s.charAt(i));
            if(curr < prev) result -= curr;
            else result += curr;
            prev = curr;
        }
        
        return result;
    }

    private int getRomanValue(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }


    public static void main(String[] args) {
        RomanToInteger i = new RomanToInteger();
        System.out.println(i.romanToInt("III"));
        System.out.println(i.romanToInt("LVIII"));
        System.out.println(i.romanToInt("MCMXCIV"));
    }
}
