
# Check if Array is Sorted

## Problem Statement

Given an array of integers, determine whether the array is sorted in non-decreasing order.

## Approach

Traverse the array from left to right and compare each element with its previous element.

* If the current element is greater than or equal to the previous element, continue checking.
* If any element is smaller than its previous element, the array is not sorted.
* Print the result as `true` or `false`.

## Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Assume the array is sorted.
4. Traverse the array starting from index `1`.
5. Compare each element with its previous element.
6. If a smaller element is found, mark the array as not sorted.
7. Print the result.

## Time Complexity

**O(n)**

The array is traversed once.

## Space Complexity

**O(1)**

No extra space is used.

## Concepts Used

* Arrays
* Traversal
* Comparison
* Boolean Variables

## Sample Input

```text
6
1 2 4 7 7 5
```

## Sample Output

```text
false
```

## Example

**Sorted Array**

```text
1 2 3 4 5
```

Output:

```text
true
```

**Unsorted Array**

```text
1 3 2 4 5
```

Output:

```text
false
```
