# Contains Duplicate - LeetCode 217

## Problem Statement
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

## Approach 1: Hashing
### Approach
Use a HashSet to keep track of the numbers we have seen so far as we iterate through the array. If we encounter a number that is already in the set, we immediately return true.
### Algorithm
1. Initialize an empty HashSet.
2. Iterate through each number in the array.
3. Check if the current number is already present in the set.
4. If it is present, return true.
5. Otherwise, add the current number to the set.
6. If the loop finishes without finding duplicates, return false.
### Time Complexity
O(N) where N is the number of elements in the array.
### Space Complexity
O(N) to store elements in the HashSet.

## Comparison of Approaches
- Hashing approach provides an optimal O(N) time complexity by trading off O(N) space complexity.

## Concepts Used
- Hashing
- HashSet Data Structure

## Sample Input
nums = [1, 2, 3, 1]

## Sample Output
true