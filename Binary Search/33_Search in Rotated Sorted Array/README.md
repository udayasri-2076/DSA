# Search in Rotated Sorted Array - LeetCode 33

## Problem Statement

There is an integer array `nums` sorted in ascending order (with distinct values).

Prior to being passed to your function, `nums` is possibly rotated at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]` (0-indexed). For example, `[0,1,2,4,5,6,7]` might be rotated at pivot index `3` and become `[4,5,6,7,0,1,2]`.

Given the array `nums` after the possible rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not in `nums`.

You must write an algorithm with `O(log n)` runtime complexity.

## Approach 1: Brute Force

### Approach

* Traverse the array linearly from start to end.
* Compare each element with the `target`.
* If a match is found, return its index.
* If the traversal finishes without a match, return `-1`.

### Algorithm

1. Initialize `bruteResult = -1`.
2. Iterate through each element using a loop from `i = 0` to `n - 1`.
3. Check if `nums[i] == target`.
4. If true, set `bruteResult = i` and break.
5. Return `bruteResult`.

### Time Complexity

**O(n)**

Every element in the array is checked in the worst case.

### Space Complexity

**O(1)**

No extra data structures are used.

## Approach 2: Optimal - Binary Search

### Approach

* Apply modified Binary Search.
* In a rotated sorted array, dividing the array in half will always result in at least one strictly sorted half.
* Determine which half is sorted (`nums[mid] >= nums[l]` for left, otherwise right).
* Check if the `target` falls within the boundaries of the sorted half.
* If it does, narrow the search range to that half. Otherwise, search the other half.
* Repeat until the pointers cross or the element is found.

### Algorithm

1. Initialize `l = 0` and `r = nums.length - 1`.
2. While `l <= r`:
   * Calculate `mid = l + (r - l) / 2`.
   * If `nums[mid] == target`, return `mid`.
   * Check if the left half is sorted (`nums[mid] >= nums[l]`):
     * If `target` lies within the left sorted half (`nums[l] <= target && target < nums[mid]`), move `r = mid - 1`.
     * Otherwise, move `l = mid + 1`.
   * Else, the right half is sorted:
     * If `target` lies within the right sorted half (`nums[mid] < target && target <= nums[r]`), move `l = mid + 1`.
     * Otherwise, move `r = mid - 1`.
3. If the loop terminates without finding the target, return `-1`.

### Time Complexity

**O(log n)**

The search space is halved in each iteration.

### Space Complexity

**O(1)**

Only pointers and variables are used.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n) | O(1) |
| Binary Search (Optimal) | O(log n) | O(1) |

## Concepts Used

* Binary Search
* Rotated Sorted Array
* Array Traversal
* Conditional Partitioning
* Time Complexity
* Space Complexity

## Sample Input

~~~text
4 5 6 7 0 1 2
0
~~~

## Sample Output

~~~text
4
~~~
