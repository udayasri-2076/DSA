# 🚀 Two Sum II – Input Array Is Sorted

## 📌 Problem Statement

Given a sorted array of integers `nums` and an integer `target`, return the 1-based indices of the two numbers such that they add up to the target.

You may assume:

- Exactly one valid solution exists.
- The same element cannot be used twice.
- The array is sorted in non-decreasing order.

---

## 📝 Approach

This problem can be solved efficiently using the Two Pointer technique.

- Initialize one pointer (`left`) at the beginning of the array.
- Initialize another pointer (`right`) at the end of the array.
- Calculate the sum of the elements at both pointers.
- If the sum equals the target, return the 1-based indices.
- If the sum is smaller than the target, move the `left` pointer one step to the right.
- If the sum is greater than the target, move the `right` pointer one step to the left.
- Continue until the required pair is found.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Read the target value.
4. Initialize two pointers:
   - `left = 0`
   - `right = n - 1`
5. While `left < right`:
   - Calculate `sum = nums[left] + nums[right]`.
   - If `sum == target`, print `left + 1` and `right + 1`.
   - If `sum < target`, increment `left`.
   - Otherwise, decrement `right`.
6. Print the required 1-based indices.

---

## ⏱️ Time Complexity

O(n)

The array is traversed only once using two pointers.

---

## 💾 Space Complexity

O(1)

The solution uses only two pointers and does not require any extra space.

---

## 📚 Concepts Used

- Arrays
- Two Pointers
- Sorted Array
- Traversal

---

## 📥 Sample Input

```text
4
2 7 11 15
9
```

## 📤 Sample Output

```text
1 2
```

---

## 📖 Example

### Input

```text
4
2 7 11 15
9
```

### Output

```text
1 2
```

### Explanation

The numbers at positions `1` and `2` are:

```text
2 + 7 = 9
```

Hence, the required 1-based indices are:

```text
1 2
```

---

## 🎯 Key Takeaway

The Two Pointer technique takes advantage of the sorted array to find the required pair in a single traversal. By adjusting the pointers based on the current sum, the solution achieves O(n) time complexity while using only constant extra space.
