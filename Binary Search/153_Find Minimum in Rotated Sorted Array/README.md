# Find Minimum in Rotated Sorted Array - LeetCode 153

## Problem Statement

Suppose an array of length `n` sorted in ascending order is rotated between `1` and `n` times. For example, the array `nums = [0,1,2,4,5,6,7]` might become:
- `[4,5,6,7,0,1,2]` if it was rotated `4` times.
- `[0,1,2,4,5,6,7]` if it was rotated `7` times.

Notice that rotating an array `[a[0], a[1], a[2], ..., a[n-1]]` 1 time results in the array `[a[n-1], a[0], a[1], a[2], ..., a[n-2]]`.

Given the sorted rotated array `nums` of unique elements, return the minimum element of this array.

You must write an algorithm that runs in `O(log n)` time.

## Approach 1: Brute Force

### Approach

* Traverse through the entire array element by element.
* Keep track of the minimum value found so far.
* Return the minimum value after checking all elements.

### Algorithm

1. Initialize `minBrute` with the first element of the array.
2. Iterate through each element in the array.
3. If the current element is smaller than `minBrute`, update `minBrute`.
4. Return `minBrute`.

### Time Complexity

**O(n)**

Every element in the array is visited once.

### Space Complexity

**O(1)**

No extra space is used.

## Approach 2: Optimal - Binary Search

### Approach

* Use Binary Search since the array is sorted and rotated.
* Maintain two pointers `l` and `r` for the search range.
* Compute `mid` and compare `nums[mid]` with `nums[r]`.
* If `nums[mid] <= nums[r]`, the right half is sorted and the minimum lies in the left half including `mid`. Move `r` to `mid`.
* Otherwise, the minimum lies in the right half. Move `l` to `mid + 1`.
* Continue until `l == r`, which points to the minimum element.

### Algorithm

1. Initialize `l = 0` and `r = nums.length - 1`.
2. While `l < r`:
   * Calculate `mid = l + (r - l) / 2`.
   * If `nums[mid] <= nums[r]`, set `r = mid`.
   * Else, set `l = mid + 1`.
3. Return `nums[l]` as the minimum element.

### Time Complexity

**O(log n)**

The search space is halved in each step.

### Space Complexity

**O(1)**

Only a few pointers are used.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---||
| Brute Force | O(n) | O(1) |
| Binary Search | O(log n) | O(1) |

## Concepts Used

* Binary Search
* Arrays
* Rotated Sorted Array
* Time Complexity
* Space Complexity

## Sample Input

~~~text
5
3 4 5 1 2
~~~

## Sample Output

~~~text
1
~~~
