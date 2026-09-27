# Binary Search - 704

## Problem Statement
Given an array of integers `nums` which is sorted in ascending order, and an integer `target`, write a function to search `target` in `nums`. If `target` exists, then return its index. Otherwise, return `-1`.

You must write an algorithm with `O(log n)` runtime complexity.

## Approach 1: Optimal (Binary Search)
### Approach
We can use the Binary Search algorithm since the array is already sorted. We maintain two pointers, `l` (left) and `r` (right), defining the search space. In each step, we find the middle element `mid`. If `nums[mid]` equals the target, we return its index. If `nums[mid]` is greater than the target, we eliminate the right half by moving `r` to `mid - 1`. If `nums[mid]` is less than the target, we eliminate the left half by moving `l` to `mid + 1`.

### Algorithm
1. Initialize `n` as the length of `nums`.
2. Set `l = 0` and `r = n - 1`.
3. While `l <= r`, compute `mid = (l + r) / 2`.
4. If `nums[mid] == target`, return `mid`.
5. If `nums[mid] > target`, update `r = mid - 1`.
6. Else, update `l = mid + 1`.
7. If the loop ends without finding the target, return `-1`.

### Time Complexity
O(log n) because the search space is halved in each iteration.

### Space Complexity
O(1) because we only use a few variables for pointers.

## Comparison of Approaches
- Brute Force: Iterates through every element, taking O(n) time.
- Optimal (Binary Search): Halves the search space in each step, taking O(log n) time.

## Concepts Used
- Binary Search
- Divide and Conquer

## Sample Input
nums = [-1, 0, 3, 5, 9, 12], target = 9

## Sample Output
4