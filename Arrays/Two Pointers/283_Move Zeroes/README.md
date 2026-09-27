# Move Zeroes - LeetCode 283

## Problem Statement

Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

## Approach 1: Brute Force

### Approach

* Traverse the array and collect all non-zero elements into a temporary structure.
* Fill the remaining positions of the original array with zeros.
* This satisfies the requirement of moving zeros to the end while preserving order, but uses extra space.

### Algorithm

1. Initialize an empty temporary list.
2. Traverse the input array and append all non-zero elements to the temporary list.
3. Fill the rest of the temporary list with zeros until it matches the original length.
4. Copy elements back from the temporary list into the original array.

### Time Complexity

**O(n)**

The array is traversed twice.

### Space Complexity

**O(n)**

An extra temporary structure is used to store elements.

## Approach 2: Optimal - Two Pointers

### Approach

* Use two pointers, `l` and `r`.
* `r` iterates through every element in the array.
* `l` points to the position where the next non-zero element should be placed.
* Whenever `nums[r]` is non-zero, swap `nums[l]` and `nums[r]`, then increment `l`.
* This places all non-zero elements at the front in their original relative order and pushes zeros to the end in-place.

### Algorithm

1. Initialize pointer `l = 0`.
2. Traverse the array using pointer `r` from `0` to `n - 1`.
3. If `nums[r] != 0`, swap `nums[l]` with `nums[r]` and increment `l` by 1.
4. Continue until `r` reaches the end of the array.

### Time Complexity

**O(n)**

The array is traversed exactly once using pointer `r`.

### Space Complexity

**O(1)**

Sorting and rearrangement are done entirely in-place with no extra data structures.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n) | O(n) |
| Two Pointers | O(n) | O(1) |

## Concepts Used

* Arrays
* Two Pointers
* In-Place Array Modification
* Array Traversal
* Time Complexity
* Space Complexity

## Sample Input

~~~text
5
0 1 0 3 12
~~~

## Sample Output

~~~text
1 3 12 0 0
~~~
