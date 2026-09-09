# Contains Duplicate - LeetCode 217

## Problem Statement

Given an integer array `nums`, determine whether the array contains any duplicate elements. Return `true` if any value appears at least twice, otherwise return `false`.

## Approach 1: Brute Force

### Approach

* Compare every element with every other element in the array.
* Use two loops to check all possible pairs.
* If two elements are equal, a duplicate exists.
* Return `true` when a duplicate is found.
* If no duplicate is found, return `false`.

### Algorithm

1. Traverse the array using an outer loop.
2. For each element, traverse the remaining elements using an inner loop.
3. Compare `nums[i]` with `nums[j]`.
4. If both elements are equal, return `true`.
5. If no duplicate is found, return `false`.

### Time Complexity

**O(n²)**

Every element may be compared with every other element.

### Space Complexity

**O(1)**

No extra data structure is used.

## Approach 2: Better - Sorting

### Approach

* Sort the array.
* After sorting, duplicate elements will be placed next to each other.
* Traverse the sorted array and compare adjacent elements.
* If two adjacent elements are equal, a duplicate exists.
* If no adjacent elements are equal, there are no duplicates.

### Algorithm

1. Sort the array.
2. Traverse the array from left to right.
3. Compare `nums[i]` with `nums[i - 1]`.
4. If they are equal, return `true`.
5. If no equal adjacent elements are found, return `false`.

### Time Complexity

**O(n log n)**

Sorting takes **O(n log n)** time and the traversal takes **O(n)** time.

### Space Complexity

**O(1)**

No extra data structure is used apart from the internal space used by the sorting algorithm.

## Approach 3: Optimal - Hashing

### Approach

* Use a `HashSet` to store elements that have already been encountered.
* Traverse the array once.
* For each element, check whether it is already present in the `HashSet`.
* If the element is already present, a duplicate exists.
* Otherwise, add the element to the `HashSet`.
* If all elements are processed without finding a duplicate, return `false`.

### Algorithm

1. Create an empty `HashSet`.
2. Traverse the array from left to right.
3. Check whether the current element is already present in the `HashSet`.
4. If it is present, return `true`.
5. Otherwise, add the element to the `HashSet`.
6. If the traversal completes without finding a duplicate, return `false`.

### Time Complexity

**O(n)** average

The array is traversed once, and `HashSet` insertion and search take **O(1)** average time.

### Space Complexity

**O(n)**

In the worst case, the `HashSet` stores all `n` elements.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n²) | O(1) |
| Sorting | O(n log n) | O(1) |
| Hashing | O(n) average | O(n) |

## Concepts Used

* Arrays
* Hashing
* HashSet
* Sorting
* Nested Loops
* Traversal
* Duplicate Detection
* Time Complexity
* Space Complexity

## Sample Input

~~~text
5
1 2 3 1 4
~~~

## Sample Output

~~~text
true
~~~

## Sample Input

~~~text
5
1 2 3 4 5
~~~

## Sample Output

~~~text
false
~~~
