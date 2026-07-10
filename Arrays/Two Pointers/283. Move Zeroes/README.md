# 🚀 Move Zeroes

## 📌 Problem Statement

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.

Note: The operation must be performed in-place without making a copy of the array.

---

## 📝 Approach

This problem can be solved efficiently using the Two Pointer technique.

- Use one pointer (`left`) to track the position where the next non-zero element should be placed.
- Use another pointer (`right`) to traverse the array.
- Whenever a non-zero element is encountered:
  - Swap `nums[left]` and `nums[right]`.
  - Increment `left`.
- After one complete traversal, all non-zero elements will be at the beginning of the array, and all zeros will be moved to the end while preserving the relative order of non-zero elements.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize a pointer `left = 0`.
4. Traverse the array using pointer `right` from `0` to `n - 1`.
5. If `nums[right]` is not `0`:
   - Swap `nums[left]` and `nums[right]`.
   - Increment `left`.
6. Print the modified array.

---

## ⏱️ Time Complexity

O(n)

The array is traversed only once.

---

## 💾 Space Complexity

O(1)

The operation is performed in-place without using any extra space.

---

## 📚 Concepts Used

- Arrays
- Two Pointers
- Swapping
- In-place Algorithm

---

## 📥 Sample Input

```text
5
0 1 0 3 12
```

## 📤 Sample Output

```text
1 3 12 0 0
```

---

## 📖 Example

### Input

```text
5
0 1 0 3 12
```

### Output

```text
1 3 12 0 0
```

### Explanation

The non-zero elements (`1`, `3`, `12`) maintain their original relative order, while all zeros are moved to the end of the array.

---

## 🎯 Key Takeaway

The Two Pointer technique efficiently solves this problem in O(n) time and O(1) space by moving each non-zero element to its correct position while pushing all zeros to the end without using any extra array.
