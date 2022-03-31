package Companies.amazon;

/**
 * https://leetcode.com/discuss/interview-question/1858858/Amazon-OA
 * 
 * An item is represented as an asterisk ( * = ascii decimal 42). A compartment
 * is represented as a pair of pipes that may or may not have items between them
 * ( | = ascii decimal 124).
 * 
 * Example 1:
 * Input: s = |**|*|*, startIndices = [1, 1], endIndices = [5, 6]
 * Output: [2, 3]
 * Explanation:
 * The string has a total of 2 closed compartments, one with 2 items and one
 * with 1 item.
 * For the first pair of indices, (0, 4), the substring |**|*. There are 2 items
 * in a compartment.
 * For the second pair of indices, (0, 6), the substring is |**|*|* and there
 * are 2 + 1 = 3 items in compartments.
 * Both of the answers are returned in an array, [2, 3]
 * 
 * Example 2:
 * Input: s = *|*|, startIndices = [1], endIndices = [3]
 * Output: [1]
 * Explanation:
 * the substring from index = 1 to index = 3 is |*|. There is one compartments
 * with one item in this string.
 * 
 * Constraints:
 * 1 <= m, n <= 10^5
 * 1 <= startIndices[i] <= endIndices[i] <= n
 * Each character or s is either * or |
 */

 //TODO: solve

public class FindCompartments {

    public int findNumOfCompartments(String s, int[] startIndices, int[] endIndices) {
        int numOfCompartments = 0;
        int numOfItems = 0;
        for (int i = 0; i < startIndices.length; i++) {
            int startIndex = startIndices[i];
            int endIndex = endIndices[i];

            if (startIndex == endIndex) {
                numOfItems++;
            } else {
                numOfCompartments++;
                numOfItems = 0;
                for (int j = startIndex; j < endIndex; j++) {
                    if (s.charAt(j) == '*') {
                        numOfItems++;
                    }
                }
            }
        }

        return numOfCompartments;
    }

    public static void main(String[] args) {
        FindCompartments f = new FindCompartments();
        System.out.println(f.findNumOfCompartments("|**|*|*", new int[] { 1, 1 }, new int[] { 5, 6 }));
        System.out.println(f.findNumOfCompartments("*|*|", new int[] { 1 }, new int[] { 3 }));
    }
}
