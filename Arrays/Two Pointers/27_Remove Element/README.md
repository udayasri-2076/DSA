# Remove Element - LeetCode 27

## Problem Statement
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in `nums` in-place. The order of the elements may be changed. Then return the number of elements in `nums` which are not equal to `val`.

Consider the number of elements in `nums` which are not equal to `val` to be `k`, to get accepted, you need to do the following things:
- Change the array `nums` such that the first `k` elements of `nums` contain the elements which are not equal to `val`. The remaining elements of `nums` are not important as well as the size of `nums`.
- Return `k`.

## Approach 1: Optimal Approach (Two Pointers)
### Approach
Maintain a pointer `k` to track the placement index for elements that are not equal to `val`. Iterate through the array with another pointer `i`. Whenever `nums[i]` is not equal to `val`, copy `nums[i]` to `nums[k]` and increment `k`.

### Algorithm
1. Initialize `k = 0` to track the position for valid elements.
2. Loop through the array using index `i` from `0` to `nums.length - 1`.
3. Check if `nums[i] != val`.
4. If true, assign `nums[k] = nums[i]` and increment `k` by 1.
5. After the loop completes, return `k` representing the count of elements not equal to `val`.

### Time Complexity
O(n) where n is the number of elements in the array, since we traverse the array a single time.

### Space Complexity
O(1) because the removal and rearrangement are performed in-place.

## Comparison of Approaches
- **Optimal Approach (Two Pointers):** Achieves O(n) time complexity and O(1) space complexity by overwriting target values in-place using two synchronized indices, avoiding extra memory allocation.

## Concepts Used
- Arrays
- Two Pointers
- In-place Modification

## Sample Input
nums = [3, 2, 2, 3], val = 3

## Sample Output
k = 2, nums = [2, 2, _, _]