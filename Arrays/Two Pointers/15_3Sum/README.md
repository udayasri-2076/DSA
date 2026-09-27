# 3Sum - 15

## Problem Statement
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0. Notice that the solution set must not contain duplicate triplets.

## Approach 1: Optimal (Sorting + Two Pointers)
### Approach
Sort the array first to easily manage duplicates and use two pointers to find pairs that sum up to the negation of the current element.
### Algorithm
1. Sort the input array nums.
2. Iterate through the array with index i.
3. Skip duplicate elements for i to avoid duplicate triplets.
4. Set j = i + 1 and k = n - 1.
5. While j < k, calculate sum = nums[i] + nums[j] + nums[k].
6. If sum == 0, add triplet to result and advance both pointers past duplicates.
7. If sum < 0, increment j.
8. If sum > 0, decrement k.
### Time Complexity
O(N log N + N^2) which simplifies to O(N^2).
### Space Complexity
O(1) auxiliary space excluding the space needed for the output list.

## Comparison of Approaches
- Brute Force: Uses 3 nested loops with O(N^3) time complexity.
- Optimal: Uses Sorting and Two Pointers reducing time complexity to O(N^2).

## Concepts Used
- Arrays
- Two Pointers
- Sorting

## Sample Input
nums = [-1, 0, 1, 2, -1, -4]

## Sample Output
[[-1, -1, 2], [-1, 0, 1]]