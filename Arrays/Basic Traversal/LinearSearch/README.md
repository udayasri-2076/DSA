# Linear Search

## Problem Statement

Given an array of integers and a target element, find the index of the target element using linear search.

If the target element is not present in the array, return `-1`.

If the target appears multiple times, return the index of its first occurrence.

## Approach

* Read the size of the array.
* Store all elements in an array.
* Read the target element to search.
* Traverse the array from left to right.
* Compare each element with the target.
* If the target is found, store its index and stop the traversal.
* If the target is not found, the index remains `-1`.
* Print the result.

## Algorithm

1. Input the size of the array `n`.
2. Read `n` array elements.
3. Input the target element.
4. Initialize `index = -1`.
5. Traverse the array from left to right.
6. Compare each element with the target.
7. If the current element equals the target:
   * Store the current index.
   * Stop the loop using `break`.
8. Display the index.
9. If the target is not present, `index` remains `-1`.

## Time Complexity

**O(n)**

In the worst case, the entire array is traversed once.

## Space Complexity

**O(1)**

No extra space is used apart from a few variables.

## Concepts Used

* Arrays
* Linear Search
* Traversal
* Comparison
* `break` Statement
* Scanner Class

## Sample Input

```text
5
4 6 3 8 2
8
