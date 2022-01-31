## Data Structure

| #   | Title | Solution                              | Basic idea |  O Notation  |
| --- | ----- | ------------------------------------- | ---------- | ------------ |
| 1   | Linked List | [java](src/dataStructures/LinkedList.java) | 1. a node that has a pointer to another node | 1. searching/inserstion/deletion at the beginning or end: O(1) <br>2. O(n) for a specific index
| 2   | Binary Tree | [java](src/dataStructures/Trees.java) | 1. left child is smaller than root <br>2. right child is larger than root | 1. searching: O(log(n)) <br>2. insertion O(log(n)) <br>3. deletion: O(log(n))
| 3   | Priority Queue | [java](src/dataStructures/PriorityQ.java) | 1. min PQ: root is always the smallest <br>2. max PQ: root is always the largest | 1. fetching: O(1) <br>2. insertion O(log(n)) <br>3. deletion: O(log(n))
| 4   | Graphs | [java](src/dataStructures/Graph.java) | we can use adjacency list to represent graphs | 1. searching: O(e) <br>2. has a path: O(e) 

## Algorithms

| #   | Title         | Solution                                    | Basic idea |  O Notation  |
| --- | ------------- | ------------------------------------------- | ---------- | ------------ |
| 1   | Permutation   | [Java](src/algorithms/PermutationList.java) | use recursion <br>1. base case is when left == array length <br>2. swap left with i <br>3. call recursive function and increment left <br>4. swap again to revert back | O(n!) |
| 2   | Binary Search | [java](src/algorithms/BinarySearch.java) | 1. set a most left & most right pointer <br>2. while pointers don't cross each other, calculate mid index <br>3. check if mid value equals the target | O(log(n)) |
| 3   | Quick Sort    | [java](src/algorithms/QuickSort.java) |  | O(n^2) |
## Questions & Solutions

| #   | Title         | Solution                                    | Basic idea |  O Notation  |
| --- | ------------- | ------------------------------------------- | ---------- | ------------ |
| 1   | [Two Sum](https://leetcode.com/problems/two-sum/)  | [Java](src/Problems/Sequences/TwoSum.java) | 1. HashMap <br>2. for loop to check if complement exists in the map | O(n) |
| 2   | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)  | [Java](src/Problems/Sequences/BestTimeToBuyAndSell.java) | 1. HashSet <br>2. for loop to check if complement exists in the set | O(n) |
| 3   | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | [Java](src/Problems/Sequences/ContainsDuplicate.java) | 1. keep track of the minimum price <br>2. keep track of the max profit | O(n) |
| 4   | [Valid Anagram](https://leetcode.com/problems/valid-anagram/)  | [Java](src/Problems/Sequences/ValidAnagram.java) | 1. HashMap <br>2. add occurrence of first string chars and then subtract occurrence from second string <br>3. map values should be 0 | O(n) |
| 5   | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)  | [Java](src/Problems/Sequences/ProductOfArrayExceptSelf.java) | 1. calculate product and number of zeros <br>2. check number of zeros and return the proper product | O(n) |
| 6   | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)  | [Java](src/Problems/Sequences/ValidParentheses.java) | 1. use a stack to push open brackets <br>2. check if next char is matching closing bracket && stack is empty at the end | O(n) |
| 7   | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)  | [Java](src/Problems/Sequences/MaxSubarray.java) | 1. iterate and count the sum <br>2. reset if sum + nums[i] is negative <br>3. keep track of max subarray | O(n) |
| 8   | [Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)  | [Java](src/Problems/Sequences/TwoSumII.java) | 1. use a left and a right pointer <br>2. check if the sum is equal to the target <br>3. increment left if sum is lower, decrement right if sum is larger | O(n) |
| 9   | [Three Sum Sorted](https://leetcode.com/problems/3sum/)  | [Java](src/Problems/Sequences/ThreeSum.java) | 1. two nested loop; first loop gets the first value, and second loop performs 2Sum (find 2 values == target) <br>2. Array must be sorted to avoid duplicates <br>3. we can use L & R pointers, hashSet, or binary search to solve 2Sum| O(n^2) |
| 10  | [Three Sum Unsorted](https://leetcode.com/problems/3sum/)  | [Java](src/Problems/Sequences/ThreeSum.java) | 1. since the array is not sorted, we can avoid duplicate by sorting the 3 values before adding them to the resultSet list and if the new set is not new, it won't be added again| O(n^2) |
| 11   | [Group Anagrams](https://leetcode.com/problems/group-anagrams/)  | [Java](src/Problems/Sequences/GroupAnagram.java) | sort each word and put it in a map where key is the word and value is a list of the words that match the sorted word| O(n* wLog(w)) | 
| 12   | [Max Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)  | [Java](src/Problems/Sequences/MaxProductSubarray.java) |  | O(n) | 
| 13   | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)  | [Java](src/Problems/Sequences/SearchRotatedSortedArray.java) |  | O(log(n))  | 
| 14   | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)  | [Java](src/Problems/LinkedLists/ReverseLinkedList.java) | track prev node, traverse the linked list and switch next pointer  | O(n)  | 
| 15   | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)  | [Java](src/Problems/LinkedLists/LinkedListCycle.java) | 1. a slow and a faster pointer <br>2. if fast == slow, then there's a cycle  | O(n)  | 
| 16   | [Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)  | [Java](src/Problems/Sequences/MinimumInRotatedSortedArray.java) | 1. use binary search logic <br>2. if mid < right -> search left side <br>3. if mid > right -> search right side  | O(log(n))  | 
| 17   | [Number of Islands](https://leetcode.com/problems/number-of-islands/)  | [Java](src/Problems/GraphsProblems/IslandCount.java) | 1. use BFS or DFS <br>2. dfs returns true if all checks are valid, else retruns false <br>3. if dfs returns true, increment count | O(M*N)  | 
| 18   | [Remove Nth Node From End of List](https://leetcode.com/problems/number-of-islands/)  | [Java](src/Problems/LinkedLists/RemoveNodeFromEnd.java) | 1. get the node position from head <br>2. traverse to the node before the to delete node | O(n)  | 
| 19   | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)  | [Java](src/Problems/Sequences/ContainerWithMostWater.java) | 1. left and right pointer <br>2. get the area of min(value[left], value[right]) <br>3. keep track of the max area | O(n)  | 
| 20   | [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)  | [Java](src/Problems/SlidingWindow/MaxAverage.java) | 1. sliding window <br>2. calculate the sum of the first window <br>3. slide the window and recalculate the max sum <br>4. return maxSum/windowSize | O(n)  | 
| 21   | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)  | [Java](src/Problems/SlidingWindow/LongestSubstringWithoutRepeatingCharacters.java) | 1. sliding window <br>2. if char is seen, remove most-left char, else increment our window | O(n)  |
| 22   | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)  | [Java](src/Problems/SlidingWindow/LongestRepeatingCharacterReplacement.java) | 1. sliding window & hash map <br>2. check if window size - max freq char > k (we exhausted all replacement) <br>3. if true slide left side and decrement char count <br>4. result is equal to the maximum window size | O(n)  | 
| 23   | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)  | [Java](src/Problems/SlidingWindow/MinimumWindowSubstring.java) |  | O(S + T)  | 
| 24   | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)  | [Java](src/Problems/Sequences/PalindromicSubstrings.java) | 1. palindromes are like unions, so if we count palnidromes around centers <br>2. center is every character in a string | Time: O(N^2) <br>Space: O(1) | 
| 25   | [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)  | [Java](src/Problems/GraphsProblems/PacificAtlanticWaterFlow.java) |  |  | 
| 26   | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)  | [Java](src/Problems/Sequences/TopKFrequentElements.java) | 1. HashMap to count frequency <br>2. Priority Queue to get max K times | Time: O(N Log(N)) <br> Space: O(N) | 
| 27   | [Top K Frequent Elements](https://leetcode.com/problems/validate-binary-search-tree/)  | [Java](src/Problems/Trees/ValidateBinaryTree.java) | 1. validate each subtree <br>2. if curr.val < low || curr.val > high return false | Time: O(N) <br> Space: O(N) | 








