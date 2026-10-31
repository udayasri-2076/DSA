# Two Sum II - Input Array Is Sorted - 167

## Problem Statement
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

## Approach 1: Brute Force
### Approach
Iterate through all possible pairs using nested loops and check if their sum equals the target.
### Algorithm
1. Get the length of the array n.
2. Use an outer loop i from 0 to n - 1.
3. Use an inner loop j from i + 1 to n - 1.
4. Check if numbers[i] + numbers[j] == target. If true, return [i + 1, j + 1].
5. If no pair is found after checking all combinations, return [-1, -1].
### Time Complexity
O(n^2)
### Space Complexity
O(1)

## Approach 2: Optimal Approach (Two Pointers)
### Approach
Since the array is sorted, we can use two pointers: one starting at the beginning (left) and one at the end (right). If the sum of the values at the two pointers is greater than the target, we decrement the right pointer. If the sum is less than the target, we increment the left pointer. If it matches the target, we return the 1-based indices.
### Algorithm
1. Initialize left pointer l to 0 and right pointer r to n - 1.
2. Loop while l < r.
3. Calculate sum = numbers[l] + numbers[r].
4. If sum == target, return [l + 1, r + 1].
5. If sum > target, decrement r.
6. Else, increment l.
7. Return [-1, -1] if the loop terminates without a match.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches
- Brute Force checks every combination, resulting in an inefficient O(n^2) runtime.
- Two Pointers leverages the sorted nature of the array, reducing the time complexity to O(n) and space complexity to O(1) without requiring extra data structures.

## Concepts Used
- Arrays
- Two Pointers
- Sorted Array Property

## Sample Input
numbers = [2, 7, 11, 15], target = 9

## Sample Output
[1, 2]