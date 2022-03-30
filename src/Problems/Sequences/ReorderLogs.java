package Problems.Sequences;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an array of logs. Each log is a space-delimited string of
 * words, where the first word is the identifier.
 * 
 * There are two types of logs:
 * 
 * Letter-logs: All words (except the identifier) consist of lowercase English
 * letters.
 * Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 * 
 * The letter-logs come before all digit-logs.
 * The letter-logs are sorted lexicographically by their contents. If their
 * contents are the same, then sort them lexicographically by their identifiers.
 * The digit-logs maintain their relative ordering.
 * Return the final order of the logs.
 * 
 * 
 * Example 1:
 * 
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit
 * dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5
 * 1","dig2 3 6"]
 * Explanation:
 * The letter-log contents are all different, so their ordering is "art can",
 * "art zero", "own kit dig".
 * The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 */


public class ReorderLogs {

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> customComparator = new Comparator<>() {
            @Override
            public int compare(String str1, String str2) {
                String[] log1 = str1.split(" ", 2);
                String[] log2 = str2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(log1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(log2[1].charAt(0));

                // case 1: both letters
                if (!isDigit1 && !isDigit2) {
                    int comp = log1[1].compareTo(log2[1]);
                    if (comp != 0) return comp;
                    return log1[0].compareTo(log2[0]);
                }

                // case 2: one digit and one letter
                if (!isDigit1 && isDigit2) {
                    return -1;
                } else if (isDigit1 && !isDigit2) {
                    return 1;
                }

                // case 3: both digits
                else {
                    return 0;
                }
            }
        };

        Arrays.sort(logs, customComparator);

        return logs;
    }

    public static void main(String[] args) {
        ReorderLogs obj = new ReorderLogs();
        String[] logs = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero" };
        System.out.println(Arrays.toString(obj.reorderLogFiles(logs)));
    }
}
