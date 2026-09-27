# 3Sum Closest - LeetCode 16

## Problem Statement

Given an integer array `nums` of length `n` and an integer `target`, find three integers in `nums` such that the sum is closest to `target`.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

## Approach 1: Brute Force

### Approach

* Check every possible combination of three elements in the array using three nested loops.
* Calculate the sum of each triplet.
* Compare the absolute difference between the triplet sum and the target with the current closest sum's difference.
* Update the closest sum if a closer triplet is found.

### Algorithm

1. Initialize `close` with the sum of the first three elements.
2. Use three nested loops to traverse all unique triplets `(i, j, k)`.
3. Compute `sum = nums[i] + nums[j] + nums[k]`.
4. If `abs(sum - target) < abs(close - target)`, update `close = sum`.
5. Return `close` after checking all triplets.

### Time Complexity

**O(n³)**

Three nested loops are used to check all triplet combinations.

### Space Complexity

**O(1)**

No extra data structure is used.

## Approach 2: Optimal - Two Pointers

### Approach

* Sort the array first to enable the two-pointer approach.
* Fix one number using a loop index `i`.
* Use two pointers, `l` starting from `i + 1` and `r` starting from the end of the array.
* Calculate the sum of the three numbers.
* If the sum is closer to the target than the previous closest sum, update the closest sum.
* If the sum is less than the target, increment `l` to increase the sum.
* If the sum is greater than the target, decrement `r` to decrease the sum.

### Algorithm

1. Sort the array `nums`.
2. Initialize `close` with the sum of the first three elements.
3. Traverse the array with index `i` from `0` to `n - 3`.
4. Set `l = i + 1` and `r = n - 1`.
5. While `l < r`:
   * Calculate `sum = nums[i] + nums[l] + nums[r]`.
   * If `abs(sum - target) < abs(close - target)`, update `close = sum`.
   * If `sum == target`, return `sum` immediately.
   * Else if `sum < target`, increment `l`.
   * Else, decrement `r`.
6. Return `close`.

### Time Complexity

**O(n²)**

Sorting takes **O(n log n)** time and the two-pointer traversal takes **O(n)** time inside the outer loop.

### Space Complexity

**O(1)**

Only constant extra space is used.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n³) | O(1) |
| Two Pointers | O(n²) | O(1) |

## Concepts Used

* Arrays
* Two Pointers
* Sorting
* Nested Loops
* Absolute Difference Tracking
* Time Complexity
* Space Complexity

## Sample Input

~~~text
4
-1 2 1 -4
1
~~~

## Sample Output

~~~text
2
~~~
