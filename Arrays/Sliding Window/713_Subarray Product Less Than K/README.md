# Subarray Product Less Than K - LeetCode 713

## Problem Statement
Given an array of integers `nums` and an integer `k`, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than `k`.

## Approach 1: Brute Force
### Approach
Generate every possible subarray using nested loops, calculate the product of elements in each subarray, and increment the count if the product is strictly less than `k`.
### Algorithm
1. Initialize `bruteCount = 0`.
2. Iterate through each starting index `i` from `0` to `n - 1`.
3. For each `i`, initialize `bruteProd = 1` and iterate through ending index `j` from `i` to `n - 1`.
4. Multiply `bruteProd` by `nums[j]` and check if it is less than `k`. If true, increment `bruteCount`. If false, break the inner loop early since products will only grow larger (assuming positive numbers).
5. Return `bruteCount`.
### Time Complexity
O(n^2)
### Space Complexity
O(1)

## Approach 2: Optimal
### Approach
Use a sliding window approach with two pointers (`l` and `r`). As the right pointer expands the window, multiply the incoming element into the running product. If the product becomes greater than or equal to `k`, contract the window from the left by dividing out elements until the product is less than `k`. For every valid position of `r`, the number of valid subarrays ending at `r` is given by `r - l + 1`.
### Algorithm
1. Handle edge cases where `k <= 1`, returning `0` immediately since products of positive integers cannot be less than `1`.
2. Initialize pointers `l = 0`, product accumulator `prod = 1`, and `count = 0`.
3. Iterate `r` from `0` to `n - 1`:
   - Multiply `prod` by `nums[r]`.
   - While `prod >= k` and `l <= r`, divide `prod` by `nums[l]` and increment `l`.
   - Add the number of valid subarrays ending at `r` (`r - l + 1`) to `count`.
4. Return `count`.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches
- **Brute Force** explores all subarrays quadratically, making it too slow for large inputs.
- **Optimal (Sliding Window)** tracks running products dynamically by expanding and contracting bounds in linear time, achieving optimal performance.

## Concepts Used
- Arrays
- Sliding Window
- Two Pointers

## Sample Input
nums = [10, 5, 2, 6], k = 100

## Sample Output
8