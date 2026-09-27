# Search Insert Position - LeetCode 35

## Problem Statement

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with `O(log n)` runtime complexity.

## Approach 1: Brute Force

### Approach

* Traverse the array from left to right.
* Compare each element with the target value.
* If an element is greater than or equal to the target, return its index.
* If no such element is found, return the length of the array as the insert position.

### Algorithm

1. Initialize `bruteIndex` to the length of the array `n`.
2. Traverse the array using a loop from `i = 0` to `n - 1`.
3. Check if `nums[i] >= target`.
4. If true, set `bruteIndex = i` and break.
5. Return `bruteIndex`.

### Time Complexity

**O(n)**

In the worst case, every element in the array is checked once.

### Space Complexity

**O(1)**

No extra space is used.

## Approach 2: Optimal - Binary Search

### Approach

* Use two pointers, `l` (left) and `r` (right), to represent the search range.
* Find the middle index `mid`.
* If `nums[mid] == target`, return `mid`.
* If `nums[mid] > target`, the target must be in the left half, so move `r` to `mid - 1`.
* If `nums[mid] < target`, the target must be in the right half, so move `l` to `mid + 1`.
* If the loop terminates without finding the target, `l` points to the exact insert position.

### Algorithm

1. Initialize `l = 0` and `r = nums.length - 1`.
2. While `l <= r`:
   * Calculate `mid = l + (r - l) / 2`.
   * If `nums[mid] == target`, return `mid`.
   * Else if `nums[mid] > target`, update `r = mid - 1`.
   * Else, update `l = mid + 1`.
3. Return `l` if the target is not found.

### Time Complexity

**O(log n)**

The search space is divided in half at each step.

### Space Complexity

**O(1)**

Only a few pointer variables are used.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n) | O(1) |
| Binary Search | O(log n) | O(1) |

## Concepts Used

* Arrays
* Binary Search
* Two Pointers
* Search Space Reduction
* Time Complexity
* Space Complexity

## Sample Input

~~~text
4
1 3 5 6
5
~~~

## Sample Output

~~~text
2
~~~

## Sample Input

~~~text
4
1 3 5 6
2
~~~

## Sample Output

~~~text
1
~~~
