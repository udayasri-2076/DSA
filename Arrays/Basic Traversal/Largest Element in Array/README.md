
# Largest Element in Array

## Problem Statement

Given an array of integers, find the largest element present in the array.

## Approach

* Read the size of the array.
* Store all elements in an array.
* Traverse the array while maintaining a variable to store the maximum element found so far.
* Update the maximum whenever a larger element is encountered.
* Print the largest element.

## Algorithm

1. Input the size of the array `n`.
2. Read `n` array elements.
3. Initialize a variable `max`.
4. Traverse the array from left to right.
5. Compare each element with `max`.
6. Update `max` if the current element is greater.
7. Display the largest element.

## Time Complexity

**O(n)**

The array is traversed once.

## Space Complexity

**O(1)**

No extra space is used apart from a few variables.

## Concepts Used

* Arrays
* Traversal
* Comparison
* Scanner Class

## Sample Input

```text
5
4 6 3 8 2
```

## Sample Output

```text
Largest element in the array is: 8
```
