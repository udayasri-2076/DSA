# Reverse String - LeetCode 344

## Problem Statement

Write a function that reverses a string. The input string is given as an array of characters `s`.

You must do this by modifying the input array in-place with `O(1)` extra memory.

## Approach 1: Optimal - Two Pointers

### Approach

* Use two pointers, `l` and `r`.
* `l` starts at the beginning of the array (`0`), and `r` starts at the end of the array (`s.length - 1`).
* Swap the characters at index `l` and index `r`.
* Move `l` one step forward (`l++`) and `r` one step backward (`r--`).
* Repeat this process until `l` is no longer less than `r` (`l < r`).

### Algorithm

1. Initialize `l = 0` as the left pointer.
2. Initialize `r = n - 1` as the right pointer.
3. While `l < r`:
   * Store `s[l]` in a temporary variable.
   * Assign `s[r]` to `s[l]`.
   * Assign the temporary variable to `s[r]`.
   * Increment `l`.
   * Decrement `r`.
4. The array is reversed in-place.

### Time Complexity

**O(n)**

The array is traversed up to the middle, meaning roughly `n/2` swaps are performed, which is linear time.

### Space Complexity

**O(1)**

No extra data structures are used; everything is modified in-place.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Two Pointers | O(n) | O(1) |

## Concepts Used

* Strings
* Arrays
* Two Pointers
* In-Place Modification
* Time Complexity
* Space Complexity

## Sample Input

~~~text
5
h e l l o
~~~

## Sample Output

~~~text
o l l e h
~~~
