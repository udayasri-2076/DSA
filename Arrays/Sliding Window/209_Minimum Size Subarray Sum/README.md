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
