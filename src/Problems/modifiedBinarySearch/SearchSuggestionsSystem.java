package Problems.modifiedBinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of strings products and a string searchWord.
 * 
 * Design a system that suggests at most three product names from products after
 * each character of searchWord is typed. Suggested products should have common
 * prefix with searchWord. If there are more than three products with a common
 * prefix return the three lexicographically minimums products.
 * 
 * Return a list of lists of the suggested products after each character of
 * searchWord is typed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
 * searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically =
 * ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user
 * ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 */

public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestionsList = new ArrayList<>();

        //sort products lexicographically
        Arrays.sort(products);

        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);

            // Note: binary search returns the index of the first element if it is present,
            // otherwise returns (-)insertion point for the element.
            int index = Arrays.binarySearch(products, prefix);

            // no prefix in products
            // find the first one larger than prefix.
            if (index < 0) {
                index = -index - 1;
            }

            List<String> suggestions = new ArrayList<>();
            int max = index + 3;
            for (int j = index; j < products.length; j++) {
                if (j == max){ // if we have reached the max number of suggestions
                    break;
                }

                if (products[j].startsWith(prefix)) { // if the product starts with the prefix
                    suggestions.add(products[j]);
                }
            }

            suggestionsList.add(suggestions);
        }

        return suggestionsList;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem s = new SearchSuggestionsSystem();
        System.out.println(
                s.suggestedProducts(new String[] { "bags", "baggage", "banner", "cdf", "box", "clothes", "dog", "dig" }, "clothes"));
    }
}
