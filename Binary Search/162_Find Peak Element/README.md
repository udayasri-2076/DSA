# Find Peak Element - LeetCode 162

## Problem Statement

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array `nums`, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that `nums[-1] = nums[n] = -∞`. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in `O(log n)` time.

## Approach 1: Brute Force

### Approach

* Traverse every element in the array.
* Check whether the current element is greater than or equal to its left and right neighbors.
* Handle boundary conditions for the first and last elements.
* Return the index of the first element that satisfies the condition.

### Algorithm

1. Initialize `brutePeak = -1`.
2. Iterate through each element using index `i` from `0` to `n - 1`.
3. Check if `i == 0` or `nums[i] >= nums[i - 1]`.
4. Check if `i == n - 1` or `nums[i] >= nums[i + 1]`.
5. If both conditions hold true, update `brutePeak = i` and break out of the loop.
6. Return `brutePeak`.

### Time Complexity

**O(n)**

Every element in the array is visited once.

### Space Complexity

**O(1)**

No extra space is used.

## Approach 2: Optimal - Binary Search

### Approach

* Use Binary Search to find a peak element in logarithmic time.
* Compare the middle element `nums[mid]` with its right neighbor `nums[mid + 1]`.
* If `nums[mid] > nums[mid + 1]`, a peak must exist on the left half (including `mid`), so move `r = mid`.
* Otherwise, a peak must exist on the right half, so move `l = mid + 1`.
* Continue until `l` and `r` converge to the peak index.

### Algorithm

1. Initialize `l = 0` and `r = nums.length - 1`.
2. While `l < r`:
   * Calculate `mid = l + (r - l) / 2`.
   * If `nums[mid] > nums[mid + 1]`, set `r = mid`.
   * Else, set `l = mid + 1`.
3. Return `l` as the peak index.

### Time Complexity

**O(log n)**

The search space is halved in each step.

### Space Complexity

**O(1)**

Only pointers are used.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n) | O(1) |
| Binary Search | O(log n) | O(1) |

## Concepts Used

* Binary Search
* Array Traversal
* Peak Detection
* Time Complexity
* Space Complexity

## Sample Input

~~~text
4
1 2 3 1
~~~

## Sample Output

~~~text
2
~~~
