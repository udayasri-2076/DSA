# Left Rotate Array by One Position

## Problem Statement

Given an array of integers, rotate the array to the left by one position.

After rotation:

* The first element moves to the last position.
* All other elements shift one position to the left.

## Approach

* Store the first element of the array in a temporary variable.
* Shift all remaining elements one position to the left.
* Place the stored element at the last index of the array.
* Print the rotated array.

## Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Save the first element in a temporary variable.
4. Shift each element one position to the left.
5. Place the temporary element at the last position.
6. Print the updated array.

## Time Complexity

**O(n)**

The array is traversed once for shifting elements.

## Space Complexity

**O(1)**

Only one extra variable is used.

## Concepts Used

* Arrays
* Traversal
* In-Place Modification
* Array Rotation

## Sample Input

```text
5
1 2 3 4 5
```

## Sample Output

```text
2 3 4 5 1
```

## Explanation

Original Array:

```text
1 2 3 4 5
```

After left rotation by one position:

```text
2 3 4 5 1
```
