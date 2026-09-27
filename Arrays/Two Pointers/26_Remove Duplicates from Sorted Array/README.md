# Remove Duplicates from Sorted Array - LeetCode 26

## Problem Statement

Given an integer array `nums` sorted in non-decreasing order, remove the duplicates **in-place** such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in `nums`.

Consider the number of unique elements of `nums` to be `k`, to get accepted, you need to do the following things:
- Change the array `nums` such that the first `k` elements of `nums` contain the unique elements in the order they were present in `nums` initially.
- Return `k`.

## Approach 1: Brute Force - Using HashSet

### Approach

* Use a Hash Set (or LinkedHashSet to preserve order) to filter out duplicate elements.
* Traverse the array and insert each element into the set.
* Copy the unique elements from the set back into the original array.
* Return the size of the set as the number of unique elements.

### Algorithm

1. Initialize an empty `LinkedHashSet`.
2. Traverse the input array and add every element to the set.
3. Iterate through the set and overwrite the beginning of the original array with the unique elements.
4. Return the size of the set.

### Time Complexity

**O(n)** or **O(n log n)**

Inserting elements into a HashSet takes O(1) average time per element, leading to O(n) overall time.

### Space Complexity

**O(n)**

Extra space is required to store the unique elements in the HashSet.

## Approach 2: Optimal - Two Pointers

### Approach

* Since the array is already sorted, duplicate elements will always be adjacent to each other.
* Use two pointers: `l` and `r`.
* `l` tracks the position of the last unique element.
* `r` scans through the array to find new unique elements.
* When `nums[r] != nums[l]`, we have found a new unique element. Increment `l` and copy `nums[r]` to `nums[l]`.

### Algorithm

1. Initialize `l = 0`.
2. Traverse the array with a pointer `r` starting from `1` to `n - 1`.
3. If `nums[r] != nums[l]`:
   * Increment `l` by 1.
   * Update `nums[l] = nums[r]`.
4. After the loop finishes, return `l + 1` as the number of unique elements.

### Time Complexity

**O(n)**

The array is traversed exactly once using the `r` pointer.

### Space Complexity

**O(1)**

No extra space is used; the operation is performed strictly in-place.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force (HashSet) | O(n) | O(n) |
| Two Pointers | O(n) | O(1) |

## Concepts Used

* Arrays
* Two Pointers
* In-Place Modification
* Sorted Array Traversal
* Time Complexity
* Space Complexity

## Sample Input

~~~text
10
0 0 1 1 1 2 2 3 3 4
~~~

## Sample Output

~~~text
5
~~~
