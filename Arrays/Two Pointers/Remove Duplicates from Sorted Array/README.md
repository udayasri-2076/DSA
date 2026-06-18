# Remove Duplicates from Sorted Array

## Problem Statement

Given a sorted array, remove the duplicate elements in-place and return the number of unique elements present in the array.

## Approach

Use the Two Pointers technique:

* One pointer (`i`) keeps track of the position of the last unique element.
* Another pointer (`j`) traverses the array.
* Whenever a new unique element is found, place it at the next position after `i` and increment `i`.
* At the end, the number of unique elements is `i + 1`.

## Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize pointer `i` to `0`.
4. Traverse the array using pointer `j` from index `1`.
5. If the current element differs from the previous unique element:

   * Place it at position `i + 1`.
   * Increment `i`.
6. Print `i + 1`, which represents the count of unique elements.

## Time Complexity

**O(n)**

The array is traversed only once.

## Space Complexity

**O(1)**

The operation is performed in-place without using extra space.

## Concepts Used

* Arrays
* Two Pointers
* In-Place Modification
* Traversal

## Sample Input

```text id="vr2ayq"
7
1 1 2 2 2 3 3
```

## Sample Output

```text id="thh4ks"
3
```

## Explanation

Unique elements in the array:

```text id="lvtq2e"
1 2 3
```

Therefore, the count of unique elements is:

```text id="4ulucv"
3
```

