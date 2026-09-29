# Find First and Last Position of Element in Sorted Array - 34

## Problem Statement
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If target is not found in the array, return [-1, -1].

## Approach 1: Optimal (Binary Search for First and Last Position)
### Approach
Instead of doing a linear scan which takes O(N) time, we can use binary search twice. First binary search locates the leftmost occurrence of the target by moving the right pointer to `mid - 1` even after finding the target. The second binary search locates the rightmost occurrence by moving the left pointer to `mid + 1` after finding the target.

### Algorithm
1. Define a helper method `findFirst` to find the starting index of the target using binary search.
2. Inside `findFirst`, if `nums[mid] == target`, record `ans = mid` and search the left half by setting `r = mid - 1`.
3. Define a helper method `findLast` to find the ending index of the target using binary search.
4. Inside `findLast`, if `nums[mid] == target`, record `ans = mid` and search the right half by setting `l = mid + 1`.
5. Return both indices as an array.

### Time Complexity
O(log N) since we perform two independent binary searches.

### Space Complexity
O(1) as we only use a few variables for pointers.

## Comparison of Approaches
- **Linear Search Approach**: O(N) time complexity by scanning all elements.
- **Binary Search Approach**: O(log N) time complexity by leveraging the sorted property of the array twice.

## Concepts Used
- Binary Search
- Two Pointers / Modified Binary Search Range Boundaries

## Sample Input
nums = [5, 7, 7, 8, 8, 10], target = 8

## Sample Output
[3, 4]