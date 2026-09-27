# Sqrt(x) - LeetCode 69

## Problem Statement

Given a non-negative integer `x`, compute and return the square root of `x`.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as `x ** 0.5` or `pow(x, 0.5)`.

## Approach 1: Brute Force

### Approach

* Iterate through all numbers starting from `1` up to `x / 2`.
* Compute the square of the current number.
* If the square equals `x`, return the number.
* If the square exceeds `x`, the integer square root is the previous number.
* Handle edge cases where `x < 2` separately.

### Algorithm

1. If `x < 2`, return `x`.
2. Initialize a loop from `i = 1` to `x / 2`.
3. Calculate `sq = i * i`.
4. If `sq == x`, return `i`.
5. If `sq > x`, return `i - 1`.
6. Return `x` if no condition met.

### Time Complexity

**O(sqrt(x))**

In the worst case, we check up to `x / 2` numbers.

### Space Complexity

**O(1)**

No extra space is used.

## Approach 2: Optimal - Binary Search

### Approach

* The square root of `x` for any `x >= 2` always lies between `0` and `x / 2`.
* Use Binary Search to efficiently narrow down the search space.
* Compute `mid` and check if `mid * mid == x`.
* If `mid * mid < x`, move the `left` pointer to `mid + 1` since a larger value might be valid.
* If `mid * mid > x`, move the `right` pointer to `mid - 1` since `mid` is too large.
* Return `right` as the truncated integer square root when the search concludes.

### Algorithm

1. If `x < 2`, return `x`.
2. Initialize `left = 0` and `right = x / 2`.
3. While `left <= right`:
   * Calculate `mid = left + (right - left) / 2`.
   * Calculate `sq = mid * mid` (using `long` to prevent integer overflow).
   * If `sq == x`, return `mid`.
   * If `sq < x`, set `left = mid + 1`.
   * Else, set `right = mid - 1`.
4. Return `right`.

### Time Complexity

**O(log x)**

The search space is halved in each iteration.

### Space Complexity

**O(1)**

Only a few variables are used for pointers.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(sqrt(x)) | O(1) |
| Binary Search | O(log x) | O(1) |

## Concepts Used

* Binary Search
* Mathematics
* Number Theory
* Integer Overflow Prevention
* Time Complexity
* Space Complexity

## Sample Input

~~~text
8
~~~

## Sample Output

~~~text
2
~~~
