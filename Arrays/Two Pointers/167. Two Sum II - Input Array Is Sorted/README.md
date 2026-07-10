# Two Sum II – Input Array Is Sorted

## Problem Statement

Given a sorted array of integers and a target value, return the **1-based indices** of the two numbers such that they add up to the target.

You may assume:

- Exactly one valid solution exists.
- The same element cannot be used twice.
- The array is sorted in non-decreasing order.

---

## Approach

Use the **Two Pointers** technique:

- Place one pointer (`left`) at the beginning of the array.
- Place another pointer (`right`) at the end of the array.
- Calculate the sum of the elements at both pointers.
- If the sum equals the target, return their **1-based indices**.
- If the sum is smaller than the target, move the `left` pointer to the right.
- If the sum is greater than the target, move the `right` pointer to the left.
- Continue until the required pair is found.

---

## Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Read the target value.
4. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`
5. While `left < right`:
   - Compute `sum = arr[left] + arr[right]`.
   - If `sum == target`, print `left + 1` and `right + 1`.
   - If `sum < target`, increment `left`.
   - Otherwise, decrement `right`.
6. End after finding the required pair.

---

## Time Complexity

**O(n)**

The two pointers traverse the array at most once.

---

## Space Complexity

**O(1)**

The solution uses only two pointers and does not require any extra space.

---

## Concepts Used

- Arrays
- Two Pointers
- Sorted Array
- Traversal

---

## Sample Input

```text
4
2 7 11 15
9
```

## Sample Output

```text
1 2
```

---

## Explanation

The numbers at positions **1** and **2** are:

```text
2 + 7 = 9
```

Therefore, the required **1-based indices** are:

```text
1 2
```
