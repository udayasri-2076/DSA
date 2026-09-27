# Max Consecutive Ones III - LeetCode 1004

## Problem Statement

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`'s in the array if you can flip at most `k` `0`'s.

## Approach 1: Brute Force

### Approach

* Check every possible subarray by fixing the starting index with an outer loop.
* Use an inner loop to expand the subarray and count the number of zeros encountered.
* If the count of zeros exceeds `k`, stop expanding the current subarray.
* Track the maximum length of valid subarrays where zeros are less than or equal to `k`.

### Algorithm

1. Initialize `maxLenBrute = 0`.
2. Traverse the array with an outer loop `i` from `0` to `n - 1`.
3. For each `i`, initialize `zeros = 0`.
4. Use an inner loop `j` from `i` to `n - 1` to traverse subsequent elements.
5. If `nums[j] == 0`, increment `zeros`.
6. If `zeros <= k`, update `maxLenBrute = max(maxLenBrute, j - i + 1)`.
7. If `zeros > k`, break out of the inner loop.
8. Return `maxLenBrute`.

### Time Complexity

**O(n²)**

Every possible starting position evaluates all subsequent ending positions in the worst case.

### Space Complexity

**O(1)**

No extra space used.

## Approach 2: Optimal - Sliding Window

### Approach

* Use the Sliding Window pattern with two pointers, `l` (left) and `r` (right).
* Expand the window by moving `r` to the right and incrementing `zerocount` whenever a `0` is encountered.
* If `zerocount` exceeds `k`, shrink the window from the left by incrementing `l` until `zerocount` drops back to `k` or less.
* The size of the valid window gives the count of consecutive ones with at most `k` flips.

### Algorithm

1. Initialize `l = 0`, `zerocount = 0`, and `maxLen = 0`.
2. Traverse the array with pointer `r` from `0` to `n - 1`.
3. If `nums[r] == 0`, increment `zerocount`.
4. If `zerocount > k`:
   * If `nums[l] == 0`, decrement `zerocount`.
   * Increment `l` to shrink the window.
5. Update `maxLen` with the maximum window size encountered (`r - l + 1`).
6. Return the maximum length.

### Time Complexity

**O(n)**

The right pointer traverses the array once, and the left pointer at most once, resulting in linear time complexity.

### Space Complexity

**O(1)**

Only a few pointer and count variables are used.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n²) | O(1) |
| Sliding Window | O(n) | O(1) |

## Concepts Used

* Arrays
* Sliding Window
* Two Pointers
* Zero Counting
* Time Complexity
* Space Complexity

## Sample Input

~~~text
11
1 1 1 0 0 0 1 1 1 1 0
2
~~~

## Sample Output

~~~text
6
~~~
