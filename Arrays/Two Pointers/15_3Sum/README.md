# 3Sum - 15

## Problem Statement
Given an integer array nums, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, and `j != k`, and `nums[i] + nums[j] + nums[k] == 0`.

Notice that the solution set must not contain duplicate triplets.

## Approach 1: Brute Force
### Approach
Generate all possible triplets using three nested loops and check if their sum is zero. Filter out duplicate triplets using a set or conditional checks.
### Algorithm
1. Initialize an empty list to store valid triplets.
2. Run three nested loops with indices `i`, `j`, and `k` to examine every possible combination.
3. Check if `nums[i] + nums[j] + nums[k] == 0`.
4. Add unique matching triplets to the result collection.
### Time Complexity
O(n^3)
### Space Complexity
O(1) auxiliary space (excluding output space)

## Approach 2: Optimal Approach
### Approach
Sort the array first. Fix one element and utilize two pointers (`l` and `r`) to scan the remaining portion of the array from both ends inward, effectively finding pairs that sum to the negative of the fixed element.
### Algorithm
1. Sort the input array `nums` in ascending order.
2. Iterate through the array with index `i` up to `n - 2` to fix the first element of the triplet.
3. Skip duplicate values for `i` to avoid duplicate triplets in the output.
4. Set `l = i + 1` and `r = n - 1`.
5. While `l < r`, compute the sum of `nums[i] + nums[l] + nums[r]`.
6. If the sum is zero, add the triplet to the result, and advance both pointers past any duplicate values.
7. If the sum is less than zero, increment `l` to increase the sum.
8. If the sum is greater than zero, decrement `r` to decrease the sum.
9. Return the accumulated list of unique triplets.
### Time Complexity
O(n^2)
### Space Complexity
O(1) auxiliary space (excluding output space)

## Comparison of Approaches
- **Brute Force**: Extremely slow with O(n^3) time complexity, making it impractical for large input sizes.
- **Optimal (Two Pointers)**: Reduces the time complexity to O(n^2) by leveraging sorting and converging pointers, providing an efficient and clean solution.

## Concepts Used
- Arrays
- Sorting
- Two Pointers Pattern
- Duplicate Elimination

## Sample Input
nums = [-1, 0, 1, 2, -1, -4]

## Sample Output
[[-1, -1, 2], [-1, 0, 1]]