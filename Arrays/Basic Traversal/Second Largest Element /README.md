
# Second Largest Element in Array

## Problem Statement

Given an array of integers, find the second largest distinct element present in the array.

## Approach

Traverse the array while maintaining two variables:

* `max` to store the largest element.
* `smax` to store the second largest element.

Whenever a new largest element is found:

* Update `smax` with the previous `max`.
* Update `max` with the current element.

If the current element is smaller than `max` but larger than `smax`, update `smax`.

## Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize variables for the largest and second largest elements.
4. Traverse the array.
5. Update the largest and second largest elements accordingly.
6. Print the second largest element.

## Time Complexity

**O(n)**

The array is traversed only once.

## Space Complexity

**O(1)**

No extra data structure is used.

## Concepts Used

* Arrays
* Traversal
* Comparison
* Variables Tracking Maximum Values

## Sample Input

```text
6
1 2 4 7 7 5
```

## Sample Output

```text
5
```
