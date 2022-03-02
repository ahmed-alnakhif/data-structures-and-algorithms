package Problems.dynamicProgramming.tabulation;

/*
  given a word and a string of words. can you construct the word using any combination of of the strings in the word back
*/

//Review 

public class CanConstruct {

    // T: O(m^2 * n), S: O(m)
    static boolean canConstruct(String target, String[] wordBank) {
        boolean[] table = new boolean[target.length() + 1];
        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == true) {
                for (String word : wordBank) {
                    if(i + word.length() < target.length() + 1){
                        String suffix = target.substring(i, i + word.length());
                        if (word.equals(suffix)) {
                            table[i + word.length()] = true;
                        }
                    }
                }
            }
        }

        return table[target.length()];
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("abcdef", new String[] { "ab", "abc", "cd", "def", "abcd" })); // true
        System.out.println(canConstruct("skateboard", new String[] { "bo", "rd", "ate", "t", "ska", "sk", "boar" })); // false
        System.out.println(canConstruct("enterapotentpot", new String[] { "a", "p", "ent", "enter", "ot", "o", "t" })); // true
        System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                new String[] { "e", "ee", "eee", "eeee", "eeeee" })); // false
    }
}
