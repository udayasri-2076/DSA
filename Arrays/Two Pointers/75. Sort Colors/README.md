# 🚀 75. Sort Colors

## 📌 Problem Statement

Given an array `nums` containing only `0`s, `1`s, and `2`s, sort the array in-place so that all `0`s come first, followed by all `1`s, and then all `2`s.

The solution must not use the library's sort function and should be performed in-place.

---

## 📝 Approach

This problem can be solved efficiently using the Dutch National Flag Algorithm.

- Maintain three pointers:
  - `low` points to the position where the next `0` should be placed.
  - `mid` traverses the array.
  - `high` points to the position where the next `2` should be placed.
- Traverse the array while `mid <= high`.
- If `nums[mid] == 0`:
  - Swap `nums[low]` and `nums[mid]`.
  - Increment both `low` and `mid`.
- If `nums[mid] == 1`:
  - Increment `mid`.
- If `nums[mid] == 2`:
  - Swap `nums[mid]` and `nums[high]`.
  - Decrement `high`.
  - Do not increment `mid` because the swapped element needs to be checked.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize:
   - `low = 0`
   - `mid = 0`
   - `high = n - 1`
4. While `mid <= high`:
   - If `nums[mid] == 0`:
     - Swap `nums[low]` and `nums[mid]`.
     - Increment both `low` and `mid`.
   - Else if `nums[mid] == 1`:
     - Increment `mid`.
   - Else:
     - Swap `nums[mid]` and `nums[high]`.
     - Decrement `high`.
5. Print the sorted array.

---

## ⏱️ Time Complexity

O(n)

The array is traversed only once.

---

## 💾 Space Complexity

O(1)

The sorting is performed in-place without using any extra space.

---

## 📚 Concepts Used

- Arrays
- Three Pointers
- Dutch National Flag Algorithm
- In-place Sorting

---

## 📥 Sample Input

```text
6
2 0 2 1 1 0
```

## 📤 Sample Output

```text
0 0 1 1 2 2
```

---

## 📖 Example

### Input

```text
6
2 0 2 1 1 0
```

### Output

```text
0 0 1 1 2 2
```

### Explanation

The array contains only three distinct values: `0`, `1`, and `2`.

The Dutch National Flag Algorithm partitions the array into three sections:
- `0`s at the beginning.
- `1`s in the middle.
- `2`s at the end.

After one traversal, the array becomes:

```text
0 0 1 1 2 2
```

---

## 🎯 Key Takeaway

The Dutch National Flag Algorithm sorts an array containing only `0`, `1`, and `2` in a single traversal. By maintaining three pointers (`low`, `mid`, and `high`), it achieves O(n) time complexity and O(1) space complexity without using any built-in sorting method.
