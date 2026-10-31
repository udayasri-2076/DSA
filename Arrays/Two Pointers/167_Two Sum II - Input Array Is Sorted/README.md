# Two Sum II - Input Array Is Sorted - 167

## Problem Statement

Given a 1-indexed array of integers `numbers` that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.

Let these two numbers be `numbers[index1]` and `numbers[index2]`, where `1 <= index1 < index2 <= numbers.length`.

Return the indices of the two numbers, `index1` and `index2`, as an integer array `[index1, index2]` of length 2.

## Approach 1: Two Pointers

### Approach

Since the array is already sorted, we can efficiently find the two numbers using the **Two Pointers** pattern.

- Place one pointer at the beginning (`left`) and another at the end (`right`) of the array.
- If the sum of the elements at both pointers equals the target, return their 1-based indices.
- If the sum is greater than the target, decrement the right pointer to decrease the sum.
- If the sum is less than the target, increment the left pointer to increase the sum.

### Algorithm

1. Initialize the left pointer `l = 0` and the right pointer `r = numbers.length - 1`.
2. Loop while `l < r`.
3. Calculate the sum of `numbers[l]` and `numbers[r]`.
4. If the sum equals `target`, return `[l + 1, r + 1]`.
5. If the sum is greater than `target`, decrement `r`.
6. If the sum is less than `target`, increment `l`.
7. Return `[-1, -1]` if no solution is found.

### Time Complexity

**O(n)**, where `n` is the number of elements in the array, because each element is visited at most once by the two pointers.

### Space Complexity

**O(1)**, as only a constant amount of extra space is used for pointers.

## Comparison of Approaches

- **Brute Force:** Checks all pairs using nested loops, resulting in O(n²) time complexity, which is inefficient for large sorted arrays.
- **Two Pointers:** Leverages the sorted nature of the array to achieve O(n) time complexity and O(1) space complexity without using extra memory like hash maps.

## Concepts Used

- Arrays
- Two Pointers
- Sorted Array Search Optimization

## Sample Input

```text
numbers = [2, 7, 11, 15]
target = 9
```

## Sample Output

```text
[1, 2]
```
