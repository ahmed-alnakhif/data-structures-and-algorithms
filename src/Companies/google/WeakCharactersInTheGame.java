package Companies.google;

import java.util.Arrays;

/**
 * You are playing a game that contains multiple characters, and each of the
 * characters has two main properties: attack and defense. You are given a 2D
 * integer array properties where properties[i] = [attacki, defensei] represents
 * the properties of the ith character in the game.
 * 
 * A character is said to be weak if any other character has both attack and
 * defense levels strictly greater than this character's attack and defense
 * levels. More formally, a character i is said to be weak if there exists
 * another character j where attackj > attacki and defensej > defensei.
 * 
 * Return the number of weak characters.
 * 
 * 
 * Example 1:
 * 
 * Input: properties = [[5,5],[6,3],[3,6]]
 * Output: 0
 * Explanation: No character has strictly greater attack and defense than the
 * other.
 */

public class WeakCharactersInTheGame {

    public int numberOfWeakCharacters(int[][] properties) {
        // sort the attack in a descending order.
        // if attack values are the same, sort defense values in ascending order
        // sort ascending so we don't include items with the same attack values 
        Arrays.sort(properties, (a, b) -> b[0] != a[0] ? b[0] - a[0] : a[1] - b[1]);

        int max = 0;
        int count = 0;
        for (int[] property : properties) {
            if (property[1] < max) {
                count++;
            }
            max = Math.max(max, property[1]);
        }

        return count;
    }

    public static void main(String[] args) {
        WeakCharactersInTheGame wGame = new WeakCharactersInTheGame();
        System.out.println(wGame.numberOfWeakCharacters(new int[][] { { 5, 5 }, { 6, 3 }, { 3, 6 } }));
    }
}
