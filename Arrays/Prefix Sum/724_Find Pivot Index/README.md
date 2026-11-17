# Find Pivot Index - LeetCode 724

## Problem Statement
Given an array of integers nums, calculate the pivot index of this array.

The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.

If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.

Return the leftmost pivot index. If no such index exists, return -1.

## Approach 1: Brute Force
### Approach
Iterate through each index of the array, and for each index, compute the left sum and right sum independently by running nested loops. If a matching sum is found, return the index.
### Algorithm
1. Get the length of the array `n`.
2. Loop through each index `i` from `0` to `n - 1`.
3. Initialize `bruteLeftSum` and `bruteRightSum` to 0.
4. Run an inner loop from `0` to `i - 1` to compute `bruteLeftSum`.
5. Run another inner loop from `i + 1` to `n - 1` to compute `bruteRightSum`.
6. Compare `bruteLeftSum` and `bruteRightSum`. If they are equal, return `i`.
7. If no such index is found after the loop, return `-1`.
### Time Complexity
O(n^2)
### Space Complexity
O(1)

## Approach 2: Optimal (Prefix Sum)
### Approach
Instead of recalculating the left and right sums from scratch for every single index, we can compute the total sum of the array in advance. As we iterate through the array, we maintain a running `leftsum`. The `rightsum` at any index can be derived in O(1) time using the formula: `rightsum = totalsum - leftsum - nums[i]`.
### Algorithm
1. Initialize `totalsum` to 0 and calculate the sum of all elements in `nums`.
2. Initialize `leftsum` to 0.
3. Loop through each index `i` in `nums`.
4. Compute `rightsum` using `totalsum - leftsum - nums[i]`.
5. Check if `leftsum == rightsum`. If true, return `i`.
6. Update `leftsum` by adding `nums[i]` for the next iteration.
7. Return `-1` if the loop completes without finding a pivot index.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches
- **Brute Force**: Easy to conceptualize, but recalculates sums repeatedly, leading to an inefficient O(n^2) time complexity.
- **Optimal**: Uses prefix sum concepts to reduce time complexity to O(n) with a single pass after computing the total sum, using O(1) auxiliary space.

## Concepts Used
- Arrays
- Prefix Sum

## Sample Input
nums = [1, 7, 3, 6, 5, 6]

## Sample Output
3
