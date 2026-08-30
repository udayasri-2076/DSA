# Minimum Size Subarray Sum - LeetCode 209
## Problem Statement
Given an array of positive integers `nums` and a positive integer `target`, return the minimal length of a contiguous subarray whose sum is greater than or equal to `target`.
If no such subarray exists, return `0` instead.

## Approach 1: Brute Force
### Approach
* For every starting index, keep adding elements until the sum reaches or exceeds the `target`.
* The outer loop selects the starting index of the subarray.
* The inner loop extends the subarray one element at a time and adds it to the sum.
* As soon as the sum is greater than or equal to `target`, record the length of that subarray.
* Stop extending further for that starting index and move to the next one.
* Track the minimum length found across all starting indices.

### Algorithm
1. Traverse the array using an outer loop for the starting index.
2. For each starting index, traverse the remaining elements using an inner loop.
3. Add the current element to the running sum.
4. If the sum is greater than or equal to `target`, calculate the length of the subarray.
5. Update the minimum length if the current length is smaller.
6. Stop the inner loop once a valid subarray is found for that starting index.
7. If no valid subarray was found, return `0`; otherwise return the minimum length.

### Time Complexity
**O(n²)**
Every possible starting index may extend up to the end of the array in the worst case.

### Space Complexity
**O(1)**
No extra data structure is used.

## Approach 2: Optimal - Variable Size Sliding Window
### Approach
* Use two pointers, `left` and `right`, to represent a window over the array.
* Expand the window by moving `right` forward and adding the element to the sum.
* Once the sum becomes greater than or equal to `target`, the window is valid.
* While the window is valid, record the window length and try to shrink it from the left.
* Shrink the window by subtracting `nums[left]` from the sum and moving `left` forward.
* Continue shrinking until the sum drops below `target`, then resume expanding from the right.

### Algorithm
1. Initialize `left = 0`, `sum = 0`, and `minLength = infinity`.
2. Traverse the array using a `right` pointer.
3. Add `nums[right]` to `sum`.
4. While `sum` is greater than or equal to `target`:
5. Update `minLength` with the current window size `right - left + 1`.
6. Subtract `nums[left]` from `sum`.
7. Move `left` forward by one.
8. If `minLength` was never updated, return `0`; otherwise return `minLength`.

### Dry Run
~~~text
nums = [2, 3, 1, 2, 4, 3]
target = 7
left = 0
sum = 0
minLength = infinity
right = 0
sum = 0 + 2 = 2
2 is not >= 7, continue expanding.
right = 1
sum = 2 + 3 = 5
5 is not >= 7, continue expanding.
right = 2
sum = 5 + 1 = 6
6 is not >= 7, continue expanding.
right = 3
sum = 6 + 2 = 8
8 is >= 7.
minLength = min(infinity, 3-0+1) = 4
sum = 8 - nums[0] = 8 - 2 = 6
left = 1
6 is not >= 7, stop shrinking.
right = 4
sum = 6 + 4 = 10
10 is >= 7.
minLength = min(4, 4-1+1) = 4
sum = 10 - nums[1] = 10 - 3 = 7
left = 2
7 is >= 7.
minLength = min(4, 4-2+1) = 3
sum = 7 - nums[2] = 7 - 1 = 6
left = 3
6 is not >= 7, stop shrinking.
right = 5
sum = 6 + 3 = 9
9 is >= 7.
minLength = min(3, 5-3+1) = 3
sum = 9 - nums[3] = 9 - 2 = 7
left = 4
7 is >= 7.
minLength = min(3, 5-4+1) = 2
sum = 7 - nums[4] = 7 - 4 = 3
left = 5
3 is not >= 7, stop shrinking.
Answer = 2
~~~

### Time Complexity
**O(n)**
Each element is added to the window once and removed at most once.

### Space Complexity
**O(1)**
Only a few integer variables are used.

## Comparison of Approaches
| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n²) | O(1) |
| Sliding Window | O(n) | O(1) |

## Concepts Used
* Arrays
* Sliding Window
* Two Pointers
* Variable Size Window
* Minimum Tracking
* Array Traversal
* Time Complexity
* Space Complexity

## Sample Input
~~~text
6
2 3 1 2 4 3
7
~~~

## Sample Output
~~~text
2
~~~

## Sample Input
~~~text
4
1 4 4
4
~~~

## Sample Output
~~~text
1
~~~
