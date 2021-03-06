package Problems.Sequences;

import java.util.HashSet;

/**
 * return the first recurring character in a string
 */

public class FirstRecurringCharacter {

    public Character firstRecurringCharacter(String str) {
        HashSet<Character> set = new HashSet<>();

        for (Character character : str.toCharArray()) {
            if (set.contains(character)) {
                return character;
            } else {
                set.add(character);
            }
        }
        return null;
    }

    public void run() {
        String str = "ABC";
        System.out.println(firstRecurringCharacter(str));

    }
}
