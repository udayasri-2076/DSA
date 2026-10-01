# Search a 2D Matrix - 74

## Problem Statement
You are given an m x n integer matrix with the following two properties:
- Each row is sorted in non-decreasing order.
- The first integer of each row is greater than the last integer of the previous row.

Given an integer target, return true if target is in matrix or false otherwise.

## Approach 1: Optimal (Binary Search)
### Approach
Treat the 2D matrix as a virtual 1D array of size m * n since it is strictly sorted row by row. Apply standard binary search over the range [0, m * n - 1]. Map the 1D mid index back to 2D coordinates using row = mid / n and col = mid % n.

### Algorithm
1. Initialize left pointer l = 0 and right pointer r = m * n - 1.
2. While l <= r, find mid = l + (r - l) / 2.
3. Compute row = mid / n and col = mid % n.
4. If matrix[row][col] == target, return true.
5. If matrix[row][col] < target, search right half by setting l = mid + 1.
6. Else, search left half by setting r = mid - 1.

### Time Complexity
O(log(m * n))

### Space Complexity
O(1)

## Comparison of Approaches
- Brute Force: Iterates through every element, taking O(m * n) time.
- Optimal Binary Search: Treats the 2D matrix as a flattened sorted array, taking O(log(m * n)) time.

## Concepts Used
- Binary Search
- 2D Array Mapping

## Sample Input
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3

## Sample Output
true