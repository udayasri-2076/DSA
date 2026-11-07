# Max Consecutive Ones - LeetCode 485

## Problem Statement
Given a binary array `nums`, return the maximum number of consecutive 1's in the array.

## Approach 1: Optimal Approach
### Approach
Traverse the array while keeping track of the current count of consecutive 1s. Whenever a 1 is encountered, increment our current count. Whenever a 0 is encountered, update our maximum recorded consecutive ones with the current count, and then reset the current count to zero. Finally, return the maximum of the last counted consecutive ones and the global maximum.

### Algorithm
1. Initialize `maxans` and `count` to 0.
2. Loop through each element in the array `nums` using an index `j` from 0 to `n - 1`.
3. If `nums[j] == 1`, increment `count` by 1.
4. If `nums[j] == 0`, update `maxans = Math.max(maxans, count)` and reset `count = 0`.
5. After the loop terminates, return `Math.max(maxans, count)` to handle cases where the array ends with a sequence of 1s.

### Time Complexity
O(n) where n is the number of elements in the array, as we traverse the array a single time.

### Space Complexity
O(1) since we only use a few variables for counting and no extra data structures.

## Comparison of Approaches
- **Optimal Approach**: Single-pass traversal operating in O(n) time and O(1) space, which is the most efficient way to solve this linear scan problem.

## Concepts Used
- Arrays
- Basic Traversal
- Linear Scan

## Sample Input
nums = [1, 1, 0, 1, 1, 1]

## Sample Output
3
