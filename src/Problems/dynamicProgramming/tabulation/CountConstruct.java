package Problems.dynamicProgramming.tabulation;

/*
  given a word and a string of words, count the number of ways that the target can be constructed from the word bank array 
*/

public class CountConstruct {

    // T: O(m^2 * n), S: O(m)
    static int countConstruct(String target, String[] wordBank) {
        int[] table = new int[target.length() + 1];
        table[0] = 1;

        for (int i = 0; i < table.length; i++) {
            for (String word : wordBank) {
                if (i + word.length() < table.length) {
                    String suffix = target.substring(i, i + word.length());
                    if (word.equals(suffix)) {
                        table[i + word.length()] += table[i];
                    }
                }
            }
        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(countConstruct("purple", new String[] { "purp", "p", "ur", "le", "purpl" }));
        System.out.println(countConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" }));
        System.out.println(countConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" }));
        System.out
                .println(countConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" }));
        System.out.println(countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee" }));
    }
}
