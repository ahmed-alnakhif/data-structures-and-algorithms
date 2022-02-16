# Data Structure

| #   | Title | Solution                              | Basic Idea |  O Notation  |
| --- | ----- | ------------------------------------- | ---------- | ------------ |
| 1   | Linked List | [java](src/dataStructures/LinkedList.java) | 1. a node that has a pointer to another node | 1. searching/inserstion/deletion at the beginning or end: O(1) <br>2. O(N) for a specific index
| 2   | Binary Tree | [java](src/dataStructures/Trees.java) | 1. left child is smaller than root <br>2. right child is larger than root | 1. searching: O(log(N)) <br>2. insertion O(log(N)) <br>3. deletion: O(log(N))
| 3   | Priority Queue | [java](src/dataStructures/PriorityQ.java) | 1. min PQ: root is always the smallest <br>2. max PQ: root is always the largest | 1. fetching: O(1) <br>2. insertion O(log(N)) <br>3. deletion: O(log(N))
| 4   | Graphs | [java](src/dataStructures/Graph.java) | we can use adjacency list to represent graphs | 1. searching: O(E) <br>2. has a path: O(E) 
<br><br>
# Algorithms

| #   | Title         | Solution                                    | Basic Idea |  O Notation  |
| --- | ------------- | ------------------------------------------- | ---------- | ------------ |
| 1   | Permutation   | [Java](src/algorithms/PermutationList.java) | use recursion <br>1. base case is when left == array length <br>2. swap left with i <br>3. call recursive function and increment left <br>4. swap again to revert back | O(N!) |
| 2   | [Subsets](https://leetcode.com/problems/subsets/)  | [java](src/algorithms/Subset.java)  | 1. iterate through the list <br>2. get each subset in the result list, add the current number to it, and then add the new subset to the result list  | O(2^N) |
| 3   | Binary Search | [java](src/algorithms/BinarySearch.java) | 1. set a most left & most right pointer <br>2. while pointers don't cross each other, calculate mid index <br>3. check if mid value equals the target | O(log(N)) |
| 4   | Quick Sort    | [java](src/algorithms/QuickSort.java) |  | O(N^2) |

<br><br>

# Patterns

## 1) Sliding Window
|  #  | Title                       | Solution                    | Basic Idea                                    |  O Notation  |
| --- | --------------------------- | --------------------------- | --------------------------------------------- |------------- |
|  1  | [Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/) | [Java](src/Problems/SlidingWindow/MaxConsecutiveOnes.java) | 1. expand window to the right and keep count of 1s <br>2. if 0, then reset count | T: O(N)  
|  2  | [Max Consecutive Ones II](https://leetcode.com/problems/max-consecutive-ones-ii/) | [Java](src/Problems/SlidingWindow/MaxConsecutiveOnesII.java) | 1. if num is zero, decrement allowed number of zeros <br>2. if allowedZeros < 0, increment allowedZeros if num == 0, and increment left <br>3. keep incrementing right | T: O(N)
|  3  | [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) | [Java](src/Problems/SlidingWindow/MaxConsecutiveOnesIII.java) | 1. if num is zero, decrement k <br>2. if k < 0, increment k if num == 0, and increment left <br>3. keep incrementing right | T: O(N)
|  4  | [Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/) | [Java](src/Problems/SlidingWindow/RepeatedDNASequences.java) | fixed window, and a hash map to check for DNA occurance | T: O(N)
|  5  | [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/solution/) | [Java](src/Problems/SlidingWindow/FindAllAnagramsInString.java) | 1. fixed window, and a hash map for each string <br>2. check if both hash maps are equal | T: O(N)
|  6  | [Subarray Product Less Than K](https://leetcode.com/problems/subarray-product-less-than-k/) | [Java](src/Problems/SlidingWindow/SubarrayProductLessThanK.java) | 1. calculate product <br>2. if product is greater than K, then remove left most num and increment left <br>3. then calculate count = count + window size and increment right | T: O(N)

## 2) Two Pointers
|  #  | Title                       | Solution                    | Basic Idea                                    |  O Notation  |
| --- | --------------------------- | --------------------------- | --------------------------------------------- |------------- |
|  1  | [Two Sum](https://leetcode.com/problems/max-consecutive-ones/) | [Java](src/Problems/SlidingWindow/MaxConsecutiveOnes.java) | 1. expand window to the right and keep count of 1s <br>2. if 0, then reset count | O(N)
|  2  | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | [Java](src/Problems/TwoPointers/RemoveDuplicates.java) | 1. if left != right, increment left <br>2. left = right | T: O(N) <br>S: O(1)
|  3  | [Remove Element](https://leetcode.com/problems/remove-element/) | [Java](src/Problems/TwoPointers/RemoveElement.java) | 1. if right != val, left = right and increment left  | T: O(N) <br>S: O(1)
|  4  | [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array) | [Java](src/Problems/TwoPointers/SquaresOfSortedArray.java) | 1. check the largest absolute value and place the square value to the end of the result array <br>2. adjust right or left pointer accordingly  | T: O(N) <br>S: O(N)
|  5  | [Three Sum](https://leetcode.com/problems/3sum/) | [Java](src/Problems/TwoPointers/ThreeSum.java) | using two pointers <br>1. sort the array first <br>2. iterate and find the two sum from i + 1| T: O(N^2) |
|  6  | [3Sum Closest](https://leetcode.com/problems/3sum-closest/) | [Java](src/Problems/TwoPointers/Sum3Closest.java) | using two pointers <br>1. sort the array first <br>2. iterate and find the two sum from i + 1 <br>3. calculate the closest difference to the target | T: O(N^2) |
|  7  | [3Sum Smaller](https://leetcode.com/problems/3sum-smaller/) | [Java](src/Problems/TwoPointers/Sum3Smaller.java) | using two pointers <br>1. sort the array first <br>2. iterate and find the two sum from i + 1 <br>3. check if sum is smaller than target | T: O(N^2) |
|  8  | [Sort Colors](https://leetcode.com/problems/sort-colors/) | [Java](src/Problems/TwoPointers/SortColors.java) | 1. if 0 => swap(i++, left++) <br>2. if 1 => i++ <br>3. if 2 => swap(i++, right++) | T: O(N) |
|  9  | [4Sum](https://leetcode.com/problems/4sum/) | [Java](src/Problems/TwoPointers/FourSum.java) | 3sum + 2 sum | T: O(N^3) |
|  10 | [Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/) | [Java](src/Problems/TwoPointers/BackspaceStringCompare.java) | two pointer: <br>1. start from the end of the string <br>2. inner while loop to skip backspaces <br>3. compare if current char in s != t<br> can be solved using a stack | T: O(N+M) <br>S: O(1)) |
|  11 | [Shortest Subarray to be Removed to Make Array Sorted](https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/) | [Java](src/Problems/TwoPointers/ShortestSubarrayToBeRemoved.java) |  |  |



## 3) FastAndSlowPointers
|  #  | Title                       | Solution                    | Basic Idea                                    |  O Notation  |
| --- | --------------------------- | --------------------------- | --------------------------------------------- |------------- |
|  1  | [Middle of the Linked List](https://leetcode.com/problems/happy-number/) | [Java](src/Problems/FastAndSlowPointers/MiddleOfLinkedList.java) | 1. fast and slow pointer <br>2. return the slow pointer | T: O(N) <br>S: O(1)
|  2  | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | [Java](src/Problems/FastAndSlowPointers/LinkedListCycle.java) | 1. a fast pointer that moves two steps <br>2. if fast ptr == slow, then there's a cycle | T: O(N) <br> S: O(1)
|  3  | [Linked List CycleII](https://leetcode.com/problems/linked-list-cycle-ii/) | [Java](src/Problems/FastAndSlowPointers/LinkedListCycleII.java) | 1. a fast pointer that moves two steps <br>2. find intersection node <br>3. traverse from intersect node and a new head ptr until they reach each other <br>4. return ptr | T: O(N) <br> S: O(1)
|  4  | [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/) | [Java](src/Problems/FastAndSlowPointers/FindDuplicateNumber.java) | Floyd's Algorithm | T: O(N) <br>S: O(1)
|  5  | [Happy Number](https://leetcode.com/problems/happy-number/) | [Java](src/Problems/FastAndSlowPointers/HappyNumber.java) | Floyd's Algorithm <br>2. calculate next digit by using mod operator and division <br>3. use Floyd's algorithm to calculate fast and slow pointer <br>4. check also if fast == 1 (happy number) | T: O(log(N)) <br>S: O(1)
|  6  | [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [Java](src/Problems/FastAndSlowPointers/PalindromeLinkedList.java) | 1. get the end of the first half <br>2. reverse the second half <br>3. check if each repective nodes are equal | T: O(N) <br>S: O(1)
|  7  | [Reorder Linked List](https://leetcode.com/problems/reorder-list/) | [Java](src/Problems/FastAndSlowPointers/ReorderLinkedList.java) | 1. get the end of the first half <br>2. reverse the second half <br>3. merge the two lists | T: O(N) <br>S: O(1)


## 3) Intervals
|  #  | Title                       | Solution                    | Basic Idea                                    |  O Notation  |
| --- | --------------------------- | --------------------------- | --------------------------------------------- |------------- |
|  1  | [Merge Intervals](https://leetcode.com/problems/merge-intervals/) | [Java](src/Problems/Intervals/MergeIntervals.java) | 3 conditions: <br>1. sort intervals <br>2. toAdd < curr => add toAdd result list and update toAdd = curr <br>3. toAdd > curr => add curr to result list <br>4. toAdd & curr overlap => update toAdd min and max | T: O(N) <br>S: O(N) | T: O(N*log(N)) <br>S: O(N)
|  2  | [Insert Interval](https://leetcode.com/problems/insert-interval/) | [Java](src/Problems/Intervals/InsertInterval.java) | same is merge intervals <br> if intervals are sorted then skip the first step | T: O(N) <br>S: O(N)
|  3  | [Interval List Intersections](https://leetcode.com/problems/interval-list-intersections/) | [Java](src/Problems/Intervals/IntervalListIntersections.java) | 1. find max of start between the two lists <br>2. find min of end between the two lists <br>3. if start<=end, add start and end to result <br>4. increment who has smaller end | T: O(N + M) <br>S: O(N + M)


#
|  #   | Title         | Solution                                    | Basic idea |  O Notation  |   Pattern   |
| ---- | ------------- | ------------------------------------------- | ---------- | ------------ | ----------- |
| 1   | [Two Sum](https://leetcode.com/problems/two-sum/)  | [Java](src/Problems/Sequences/TwoSum.java) | 1. HashMap <br>2. for loop to check if complement exists in the map | O(N) |
| 2   | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)  | [Java](src/Problems/Sequences/BestTimeToBuyAndSell.java) | 1. HashSet <br>2. for loop to check if complement exists in the set | O(N) |
| 3   | [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) | [Java](src/Problems/Sequences/ContainsDuplicate.java) | 1. keep track of the minimum price <br>2. keep track of the max profit | O(N) |
| 4   | [Valid Anagram](https://leetcode.com/problems/valid-anagram/)  | [Java](src/Problems/Sequences/ValidAnagram.java) | 1. HashMap <br>2. add occurrence of first string chars and then subtract occurrence from second string <br>3. map values should be 0 | O(N) |
| 5   | [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)  | [Java](src/Problems/Sequences/ProductOfArrayExceptSelf.java) | 1. calculate product and number of zeros <br>2. check number of zeros and return the proper product | O(N) |
| 6   | [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)  | [Java](src/Problems/Sequences/ValidParentheses.java) | 1. use a stack to push open brackets <br>2. check if next char is matching closing bracket && stack is empty at the end | O(N) |
| 7   | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)  | [Java](src/Problems/Sequences/MaxSubarray.java) | 1. iterate and count the sum <br>2. reset if sum + nums[i] is negative <br>3. keep track of max subarray | O(N) |
| 8   | [Two Sum II](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)  | [Java](src/Problems/Sequences/TwoSumII.java) | 1. use a left and a right pointer <br>2. check if the sum is equal to the target <br>3. increment left if sum is lower, decrement right if sum is larger | O(N) |
| 9   | [Three Sum Sorted](https://leetcode.com/problems/3sum/)  | [Java](src/Problems/TwoPointers/ThreeSum.java) | 1. two nested loop; first loop gets the first value, and second loop performs 2Sum (find 2 values == target) <br>2. Array must be sorted to avoid duplicates <br>3. we can use L & R pointers, hashSet, or binary search to solve 2Sum| O(N^2) |
| 10  | [Three Sum Unsorted](https://leetcode.com/problems/3sum/)  | [Java](src/Problems/TwoPointers/ThreeSum.java) | 1. since the array is not sorted, we can avoid duplicate by sorting the 3 values before adding them to the resultSet list and if the new set is not new, it won't be added again| O(N^2) |
| 11   | [Group Anagrams](https://leetcode.com/problems/group-anagrams/)  | [Java](src/Problems/Sequences/GroupAnagram.java) | sort each word and put it in a map where key is the word and value is a list of the words that match the sorted word| O(n* wLog(w)) | 
| 12   | [Max Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)  | [Java](src/Problems/Sequences/MaxProductSubarray.java) |  | O(N) | 
| 13   | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)  | [Java](src/Problems/Sequences/SearchRotatedSortedArray.java) |  | O(log(N))  | 
| 14   | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)  | [Java](src/Problems/LinkedLists/ReverseLinkedList.java) | track prev node, traverse the linked list and switch next pointer  | O(N)  | 
| 15   | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)  | [Java](src/Problems/LinkedLists/LinkedListCycle.java) | 1. a slow and a faster pointer <br>2. if fast == slow, then there's a cycle  | O(N)  | 
| 16   | [Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)  | [Java](src/Problems/Sequences/MinimumInRotatedSortedArray.java) | 1. use binary search logic <br>2. if mid < right -> search left side <br>3. if mid > right -> search right side  | O(log(N))  | 
| 17   | [Number of Islands](https://leetcode.com/problems/number-of-islands/)  | [Java](src/Problems/GraphsProblems/IslandCount.java) | 1. use BFS or DFS <br>2. dfs returns true if all checks are valid, else retruns false <br>3. if dfs returns true, increment count | O(M*N)  | 
| 18   | [Remove Nth Node From End of List](https://leetcode.com/problems/number-of-islands/)  | [Java](src/Problems/LinkedLists/RemoveNodeFromEnd.java) | 1. get the node position from head <br>2. traverse to the node before the to delete node | O(N)  | 
| 19   | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)  | [Java](src/Problems/Sequences/ContainerWithMostWater.java) | 1. left and right pointer <br>2. get the area of min(value[left], value[right]) <br>3. keep track of the max area | O(N)  | 
| 20   | [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)  | [Java](src/Problems/SlidingWindow/MaxAverage.java) | 1. sliding window <br>2. calculate the sum of the first window <br>3. slide the window and recalculate the max sum <br>4. return maxSum/windowSize | O(N)  | 
| 21   | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)  | [Java](src/Problems/SlidingWindow/LongestSubstringWithoutRepeatingCharacters.java) | 1. sliding window <br>2. if char is seen, remove most-left char, else increment our window | O(N)  | Sliding Window
| 22   | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)  | [Java](src/Problems/SlidingWindow/LongestRepeatingCharacterReplacement.java) | 1. sliding window & hash map <br>2. check if window size - max freq char > k (we exhausted all replacement) <br>3. if true slide left side and decrement char count <br>4. result is equal to the maximum window size | O(N)  | 
| 23   | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)  | [Java](src/Problems/SlidingWindow/MinimumWindowSubstring.java) |  | O(S + T)  | 
| 24   | [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)  | [Java](src/Problems/Sequences/PalindromicSubstrings.java) | 1. palindromes are like unions, so if we count palnidromes around centers <br>2. center is every character in a string | Time: O(N^2) <br>Space: O(1) | 
| 25   | [Pacific Atlantic Water Flow](https://leetcode.com/problems/pacific-atlantic-water-flow/)  | [Java](src/Problems/GraphsProblems/PacificAtlanticWaterFlow.java) |  |  | 
| 26   | [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)  | [Java](src/Problems/Sequences/TopKFrequentElements.java) | 1. HashMap to count frequency <br>2. Priority Queue to get max K times | Time: O(N Log(N)) <br> Space: O(N) | 
| 27   | [Validate Binary Tree](https://leetcode.com/problems/validate-binary-search-tree/)  | [Java](src/Problems/Trees/ValidateBinaryTree.java) | 1. validate each subtree <br>2. if curr.val < low || curr.val > high return false | Time: O(N) <br> Space: O(N) | 
| 28   | [Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree/)  | [Java](src/Problems/Trees/InvertBinaryTree.java) | 1. swap children <br>2. call recursive function one for the left side and one for the right side | Time: O(N) <br> Space: O(N) | 
| 29   | [Maximum Sum Subarray of Size K](https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP)  | [Java](src/Problems/SlidingWindow/MaximumSumSubarrayOfSizeK.java) | 1. calcuate window of size k <br>2. slide the window to the right and track the max value  | Time: O(N) <br> Space: O(1) | Sliding Window
| 30   | [Smallest Subarray With a Greater Sum](https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ)  | [Java](src/Problems/SlidingWindow/MinSizeSubArraySum.java) | 1. increase window size until sum is >= K <br>2. if true, calculate min and increment left <br>3. else incrementright | Time: O(N) <br> Space: O(1) | Sliding Window
| 31   | [Largest Subarray Length K](https://leetcode.com/problems/largest-subarray-length-k/)  | [Java](src/Problems/SlidingWindow/LargestSubarrayLengthK.java) | 1. find largest starting value of a window <br>2. return all elements from start | Time: O(N) <br> Space: O(N) | Fixed Window
| 32   | [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/submissions/)  | [Java](src/Problems/SlidingWindow/LongestSubstringwithAtMostKDistinctCharacters.java) | 1. ordered hash map <br>2. if we get a seen char, remove it from the map and put the new index <br>3. if the map size > k keep removing left most char and assign left to its index <br>4. keep track of max length | Time: O(N) <br> Space: O(N) | Sliding Window, Hash Map
| 33   | [First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)  | [Java](src/Problems/Sequences/FirstandLastPositionOfElement.java) |  | Time: O(log(N)) <br> Space: O(1) | Binary Search
| 34   | [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)  | [Java](src/Problems/SlidingWindow/FruitIntoBaskets.java) | Same as [Longest Substring with K Distinct Characters](src/Problems/SlidingWindow/LongestSubstringwithAtMostKDistinctCharacters.java) | Time: O(N) <br> Space: O(1) | Sliding Window, Hash Map
| 35   | [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)  | [Java](src/Problems/Sequences/SubarraySumEqualsK.java) | 1. calculate sum while iterating <br>2. check if sum - k is in the map <br>3. if yes then our map has the desired sum  | Time: O(N) <br> Space: O(N) | Hash Map
| 36   | [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)  | [Java](src/Problems/Trees/BinaryTreeRightSideView.java) | 1. DFS and keep incrementing depth <br>2. if depth is larger than result size then add | Time: O(N) <br> Space: O(H) - H is a tree height | DFS
| 37  | [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | [Java](src/Problems/Sequences/PermutationInString.java) | sort each substring and check if equal | O(L1Log(L1) + (L2 - L1)*L1Log(L1))

## Grokking the Coding Interview
|  #  | Title                                                   | Solution                                      | Pattern           |
| --- | ------------------------------------------------------- | --------------------------------------------- |------------------ |
|  1  | [Maximum Sum Subarray of Size K](https://www.educative.io/courses/grokking-the-coding-interview/JPKr0kqLGNP) | [Java](src/Problems/SlidingWindow/MaximumSumSubarrayOfSizeK.java) | Sliding Window
|  2  | [Smallest Subarray With a Greater Sum](https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ) | [Java](src/Problems/SlidingWindow/MinSizeSubArraySum.java) | | Sliding Window
|  3  | [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/submissions/)  | [Java](src/Problems/SlidingWindow/LongestSubstringwithAtMostKDistinctCharacters.java) | Sliding Window
|  4  | [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)  | [Java](src/Problems/SlidingWindow/FruitIntoBaskets.java) | Sliding Window
|  5  | [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)  | [Java](src/Problems/SlidingWindow/LongestRepeatingCharacterReplacement.java) | Sliding Window 
|  7  | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)  | [Java](src/Problems/SlidingWindow/LongestSubstringWithoutRepeatingCharacters.java) | Sliding Window
|  8  | [Two Sum](https://leetcode.com/problems/max-consecutive-ones/) | [Java](src/Problems/SlidingWindow/MaxConsecutiveOnes.java) | use hash map if array is not sorted <br>1. expand window to the right and keep count of 1s <br>2. if 0, then reset count | Two Pointers


## Uber
|  #  | Title                                                   | Solution                                      | Type              |
| --- | ------------------------------------------------------- | --------------------------------------------- |------------------ |
|  1  | [Two Sum](https://leetcode.com/problems/two-sum/)       | [Java](src/Problems/Sequences/TwoSum.java)    | Arrays & Strings  |
|  2  | [First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | [Java](src/Problems/Sequences/FirstandLastPositionOfElement.java) |  Arrays & Strings  |
|  3  | [Group Anagrams](https://leetcode.com/problems/group-anagrams/)  | [Java](src/Problems/Sequences/GroupAnagram.java) | Arrays & Strings  |
|  4  | [Text Justification](https://leetcode.com/problems/text-justification/) |  | Arrays & Strings  |
|  5  | [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)  | [Java](src/Problems/SlidingWindow/MinimumWindowSubstring.java) | Arrays & Strings  |
|  6  | [Validate IP Address](https://leetcode.com/problems/validate-ip-address/)  | [Java](src/Problems/Sequences/ValidateIPAddress.java) | Arrays & Strings  |
|  7  | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)  | [java](src/Problems/LinkedLists/MergeTwoSortedLists.java)  | Linked Lists  |
|  8  | [Merge K Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)  | [java](src/Problems/LinkedLists/MergeKSortedLists.java)  | Linked Lists  |
|  9  | [Reconstruct Itinerary](https://leetcode.com/problems/reconstruct-itinerary/)  | [java](src/Problems/Graphs/ReconstructItinerary.java)  | Graphs  |
|  10  | [Evaluate Division](https://leetcode.com/problems/evaluate-division/)  | [java](src/Problems/Graphs/EvaluateDivision.java)  | Graphs  |
|  11  | [Find Duplicate Subtrees](https://leetcode.com/problems/find-duplicate-subtrees/)  | [java](src/Problems/Trees/FindDuplicateSubtrees.java)  | Trees  |
|  12  | [Print Binary Tree](https://leetcode.com/problems/print-binary-tree/)  | [java]()  | Trees  |
|  13  | [Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)  | [java](src/Problems/Trees/SerializeAndDeserializeBinaryTree.java)  | Trees  |
|  14  | [Serialize and Deserialize N-ary Tree](https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/)  | [java](src/Problems/Trees/SerializeAndDeserializeNTree.java)  | Trees  |
|  15  | [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)  | [java](src/Problems/TwoPointers/TrappingRainWater.java)  | Two Pointers  |
|  16  | [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)  | [java](src/Problems/Permutations/LetterCombinationOfPhone.java)  | Recursion & Backtarcking  |
|  17  | [Subsets](https://leetcode.com/problems/subsets/)  | [java](src/algorithms/Subset.java)  | Recursion & Backtarcking  |







