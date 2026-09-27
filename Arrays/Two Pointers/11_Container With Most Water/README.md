# Container With Most Water - LeetCode 11

## Problem Statement

You are given an integer array `height` of length `n`. There are `n` vertical lines drawn such that the two endpoints of the `i`-th line are `(i, 0)` and `(i, height[i])`.

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

## Approach 1: Brute Force

### Approach

* Check every possible pair of lines using two nested loops.
* Calculate the width as the distance between the two indices: `j - i`.
* Calculate the height as the minimum of the two line heights: `min(height[i], height[j])`.
* Calculate the area as `width * height`.
* Track and update the maximum area found.

### Algorithm

1. Initialize `maxi = 0`.
2. Traverse the array with an outer loop `i` from `0` to `n - 1`.
3. Traverse the remaining array with an inner loop `j` from `i + 1` to `n - 1`.
4. Calculate `width = j - i` and `h = min(height[i], height[j])`.
5. Update `maxi` with the maximum of `maxi` and `width * h`.
6. Return `maxi` after checking all pairs.

### Time Complexity

**O(n²)**

Every pair of lines is checked using nested loops.

### Space Complexity

**O(1)**

No extra data structure is used.

## Approach 2: Optimal - Two Pointers

### Approach

* Use two pointers, `l` starting at the beginning (`0`) and `r` starting at the end (`n - 1`).
* The width between the pointers is at its maximum at the start and decreases as pointers move inward.
* The area is constrained by the shorter of the two lines.
* To potentially find a larger area, always move the pointer corresponding to the shorter line inward, hoping to encounter a taller line.
* Stop when `l` meets `r`.

### Algorithm

1. Initialize `l = 0` and `r = n - 1`.
2. Initialize `maxi = 0`.
3. While `l < r`:
   * Calculate `width = r - l`.
   * Calculate `h = min(height[l], height[r])`.
   * Calculate `area = width * h`.
   * Update `maxi = max(area, maxi)`.
   * If `height[l] < height[r]`, increment `l`.
   * Else, decrement `r`.
4. Return `maxi`.

### Time Complexity

**O(n)**

The array is traversed at most once with both pointers moving towards each other.

### Space Complexity

**O(1)**

Only a few variables are used for pointers and area tracking.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n²) | O(1) |
| Two Pointers | O(n) | O(1) |

## Concepts Used

* Arrays
* Two Pointers
* Greedy Approach
* Area Calculation
* Maximum Value Tracking
* Time Complexity
* Space Complexity

## Sample Input

~~~text
9
1 8 6 2 5 4 8 3 7
~~~

## Sample Output

~~~text
49
~~~
