# Container With Most Water - 11

## Problem Statement
You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`-th line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

## Approach 1: Brute Force
### Approach
Iterate through every possible pair of lines and calculate the area formed by them, keeping track of the maximum area found.

### Algorithm
1. Initialize `bruteMaxArea` to 0.
2. Use a nested loop where the outer loop `i` selects the left line and the inner loop `j` selects the right line.
3. Calculate the area as `min(height[i], height[j]) * (j - i)`.
4. Update `bruteMaxArea` if the current area is greater.
5. Return the maximum area.

### Time Complexity
O(n^2) where n is the number of elements in the height array.

### Space Complexity
O(1)

## Approach 2: Optimal Approach
### Approach
Use two pointers starting at both ends of the array. The area is constrained by the shorter line. To maximize the area, we should always move the pointer pointing to the shorter line inward.

### Algorithm
1. Initialize `l` at index 0 and `r` at index `n - 1`.
2. Initialize `maxarea` to 0.
3. While `l <= r`, calculate the height as the minimum of `height[l]` and `height[r]`, and width as `r - l`.
4. Update `maxarea` with the maximum of current `maxarea` and calculated area.
5. If `height[l] < height[r]`, increment `l`. Otherwise, decrement `r`.
6. Return `maxarea` when the pointers cross.

### Time Complexity
O(n)

### Space Complexity
O(1)

## Comparison of Approaches
- **Brute Force:** Checks every possible pair resulting in O(n^2) time complexity, which is inefficient for large arrays.
- **Optimal Approach:** Uses the Two Pointers pattern to process each element at most once, reducing time complexity to O(n) while maintaining O(1) space complexity.

## Concepts Used
- Arrays
- Two Pointers

## Sample Input
height = [1, 8, 6, 2, 5, 4, 8, 3, 7]

## Sample Output
49