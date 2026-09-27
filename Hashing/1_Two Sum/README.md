# Two Sum - 1

## Problem Statement
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice.

## Approach 1: Optimal (Hash Map)
### Approach
Instead of checking every possible pair using nested loops which takes O(N^2) time, we can use a Hash Map to store the numbers we have visited so far along with their indices. For each element, we calculate its complement (target - current element) and check if it already exists in the Hash Map.

### Algorithm
1. Initialize an empty Hash Map to store numbers and their indices.
2. Iterate through the array from index 0 to n-1.
3. For each element nums[i], calculate the difference: diff = target - nums[i].
4. Check if diff exists in the Hash Map.
5. If it exists, return the index of diff and the current index i.
6. If it does not exist, store the current element and its index in the Hash Map and continue.

### Time Complexity
O(N) because we traverse the list containing n elements only once. Hash Map lookups take O(1) time on average.

### Space Complexity
O(N) because the extra space required depends on the number of items stored in the hash map, which stores at most n elements.

## Comparison of Approaches
- Brute Force Approach: Uses nested loops to check all pairs. Time complexity is O(N^2) and space complexity is O(1).
- Optimal Approach (Hash Map): Uses a single pass with a Hash Map to find the complement instantly. Time complexity is O(N) and space complexity is O(N).

## Concepts Used
- Hashing
- Array Traversal
- Complement Logic

## Sample Input
nums = [2, 7, 11, 15]
target = 9

## Sample Output
[0, 1]