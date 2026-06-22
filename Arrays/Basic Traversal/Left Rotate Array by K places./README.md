# Left Rotate Array by K Places

## Problem Statement

Given an array of integers and an integer `k`, rotate the array to the left by `k` positions.

After rotation:

* The first `k` elements move to the end of the array.
* The remaining elements shift to the left.

## Approach

Use the Reversal Algorithm for efficient in-place rotation.

1. Reverse the first `k` elements.
2. Reverse the remaining `n-k` elements.
3. Reverse the entire array.

This produces the array rotated left by `k` positions.

## Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Read the value of `k`.
4. Compute `k = k % n` to handle larger values of `k`.
5. Reverse the first `k` elements.
6. Reverse the remaining elements.
7. Reverse the entire array.
8. Print the rotated array.

## Time Complexity

**O(n)**

The array is traversed a constant number of times.

## Space Complexity

**O(1)**

Rotation is performed in-place without using extra arrays.

## Concepts Used

* Arrays
* Reversal Algorithm
* In-Place Modification
* Array Rotation
* Two Pointers

## Sample Input

```text
7
1 2 3 4 5 6 7
2
```

## Sample Output

```text
3 4 5 6 7 1 2
```

## Explanation

Original Array:

```text
1 2 3 4 5 6 7
```

Rotate left by `k = 2` positions:

```text
3 4 5 6 7 1 2
```

## Applications

* Circular array operations
* Scheduling algorithms
* Data shifting and buffer management
* Competitive programming problems involving rotations
