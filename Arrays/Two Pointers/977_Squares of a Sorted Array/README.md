# Squares of a Sorted Array - LeetCode 977

## Problem Statement

Given an integer array `nums` sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

## Approach 1: Brute Force

### Approach

* Traverse the array and square every element.
* Sort the squared array using a standard sorting algorithm.
* Return the sorted array.

### Algorithm

1. Create a copy of the input array or compute the square of each element in place.
2. Square each element `nums[i] * nums[i]`.
3. Sort the resulting array.
4. Return the sorted array.

### Time Complexity

**O(n log n)**

Squaring takes **O(n)** time and sorting takes **O(n log n)** time.

### Space Complexity

**O(n)** or **O(1)**

Depends on whether extra space is used for storing the result or sorting in place.

## Approach 2: Optimal - Two Pointers

### Approach

* Since the input array is sorted, the largest squared values will always be at the extreme ends (either large negative numbers or large positive numbers).
* Use two pointers, `l` starting at the beginning and `r` starting at the end of the array.
* Compare the absolute values of `nums[l]` and `nums[r]`.
* Place the square of the larger absolute value at the current end of the result array.
* Move the corresponding pointer inward.
* Repeat until all elements are processed.

### Algorithm

1. Initialize `l = 0` and `r = n - 1`.
2. Create a result array `res` of size `n`.
3. Loop from `i = n - 1` down to `0`:
   * Compare `abs(nums[l])` and `abs(nums[r])`.
   * If `abs(nums[l]) > abs(nums[r])`, store `nums[l] * nums[l]` at `res[i]` and increment `l`.
   * Otherwise, store `nums[r] * nums[r]` at `res[i]` and decrement `r`.
4. Return the result array `res`.

### Dry Run

~~~text
nums = [-4, -1, 0, 3, 10]
n = 5

l = 0, nums[l] = -4
r = 4, nums[r] = 10

i = 4:
|-4| > |10| -> false
res[4] = 10 * 10 = 100
r = 3

i = 3:
|-4| > |3| -> true
res[3] = (-4) * (-4) = 16
l = 1

i = 2:
|-1| > |3| -> false
res[2] = 3 * 3 = 9
r = 2

i = 1:
|-1| > |0| -> true
res[1] = (-1) * (-1) = 1
l = 2

i = 0:
|0| > |0| -> false
res[0] = 0 * 0 = 0
r = 1

Result = [0, 1, 9, 16, 100]
~~~

### Time Complexity

**O(n)**

The array is traversed once using two pointers.

### Space Complexity

**O(n)**

Extra space is required to store the result array of size `n`.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n log n) | O(n) |
| Two Pointers | O(n) | O(n) |

## Concepts Used

* Arrays
* Two Pointers
* Sorting
* Absolute Value
* Array Traversal
* Time Complexity
* Space Complexity

## Sample Input

~~~text
5
-4 -1 0 3 10
~~~

## Sample Output

~~~text
0 1 9 16 100
~~~

## Sample Input

~~~text
5
-7 -3 2 3 11
~~~

## Sample Output

~~~text
4 9 9 49 121
~~~
