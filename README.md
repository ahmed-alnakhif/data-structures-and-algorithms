## Data Structure

| #   | Title | Solution                              | Basic idea | O Notation |
| --- | ----- | ------------------------------------- | ---------- | ---------- |
| 1   | Linked List | [java](src/dataStructures/LinkedList.java) | 1. a node that has a pointer to another node | 1. searching/inserstion/deletion at the beginning or end: O(1) <br>2. O(n) for a specific index
| 2   | Binary Tree | [java](src/dataStructures/Trees.java) | 1. left child is smaller than root <br>2. right child is larger than root | 1. searching: O(log(n)) <br>2. insertion O(log(n)) <br>3. deletion: O(log(n))
| 3   | Priority Queue | [java](src/dataStructures/PriorityQ.java) | 1. min PQ: root is always the smallest <br>2. max PQ: root is always the largest | 1. fetching: O(1) <br>2. insertion O(log(n)) <br>3. deletion: O(log(n))
| 4   | Graphs | [java](src/dataStructures/Graph.java) | we can use adjacency list to represent graphs | 1. searching: O(e) <br>2. has a path: O(e) 

## Algorithms

| #   | Title         | Solution                                    | Basic idea | O Notation |
| --- | ------------- | ------------------------------------------- | ---------- | ---------- |
| 1   | Permutation   | [Java](src/algorithms/PermutationList.java) | use recursion <br>1. base case is when left == array length <br>2. swap left with i <br>3. call recursive function and increment left <br>4. swap again to revert back | O(n!) |
| 2   | Binary Search | [java](src/algorithms/BinarySearch.java) | 1. set a most left & most right pointer <br>2. while pointers don't cross each other, calculate mid index <br>3. check if mid value equals the target | O(log(n)) |
| 3   | Quick Sort    | [java](src/algorithms/QuickSort.java) |  | O(n^2) |
## Questions & Solutions

| #   | Title         | Solution                                    | Basic idea | O Notation |
| --- | ------------- | ------------------------------------------- | ---------- | ---------- |
| 1   | [Two Sum](https://leetcode.com/problems/two-sum/)  | [Java](src/Problems/StringAndArrayManipulation/TwoSum.java) | 1. HashMap <br>2. for loop to check if complement exists in the map | O(n) |
| 2   | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)  | [Java](src/Problems/StringAndArrayManipulation/ContainsDuplicate.java) | 1. HashSet <br>2. for loop to check if complement exists in the set | O(n) |
| 3   | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | [Java](src/Problems/StringAndArrayManipulation/ContainsDuplicate.java) | 1. keep track of the minimum price <br>2. keep track of the max profit | O(n) |
| 4   | [Valid Anagram](https://leetcode.com/problems/valid-anagram/)  | [Java](src/Problems/StringAndArrayManipulation/ValidAnagram.java) | 1. HashMap <br>2. add occurrence of first string chars and then subtract occurrence from second string <br>3. map values should be 0 | O(n) |
| 5   | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)  | [Java](src/Problems/StringAndArrayManipulation/ProductOfArrayExceptSelf.java) | 1. calculate product and number of zeros <br>2. check number of zeros and return the proper product | O(n) |