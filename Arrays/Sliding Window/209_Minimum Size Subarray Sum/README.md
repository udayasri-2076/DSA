# Minimum Size Subarray Sum - 209

## Problem Statement
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

## Approach 1: Brute Force
### Approach
Iterate through all possible starting and ending indices of subarrays, compute their sum, and find the minimum length that satisfies the condition sum >= target.
### Algorithm
1. Initialize bruteAns to infinity.
2. Loop through each index i from 0 to n - 1 as the start of the subarray.
3. Loop through each index j from i to n - 1 as the end of the subarray.
4. Maintain a running sum and check if it meets or exceeds the target.
5. Update bruteAns with the minimum length (j - i + 1) and break the inner loop.
### Time Complexity
O(n^2)
### Space Complexity
O(1)

## Approach 2: Optimal Approach
### Approach
Use the sliding window technique with two pointers (l and r) to keep track of a dynamic subarray sum. Expand the right pointer to include elements until the sum meets or exceeds the target, then contract from the left pointer to find the minimum valid length.
### Algorithm
1. Initialize pointers l = 0, sum = 0, and ans = infinity.
2. Iterate with r from 0 to n - 1, adding nums[r] to sum.
3. While sum >= target, update ans with the current window size (r - l + 1), subtract nums[l] from sum, and increment l.
4. Return 0 if ans remains infinity, otherwise return ans.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches
- Brute Force checks every possible subarray, leading to an inefficient O(n^2) time complexity.
- Optimal Sliding Window maintains a dynamic range that expands and contracts in a single pass, achieving an efficient O(n) time complexity.

## Concepts Used
- Arrays
- Sliding Window
- Two Pointers

## Sample Input
target = 7, nums = [2, 3, 1, 2, 4, 3]

## Sample Output
2