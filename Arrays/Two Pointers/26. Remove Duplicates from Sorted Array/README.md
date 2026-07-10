# 🚀 Remove Duplicates from Sorted Array

## 📌 Problem Statement

Given a sorted integer array `nums`, remove the duplicates in-place such that each unique element appears only once. Return the number of unique elements in the array.

The relative order of the elements should be preserved, and the operation must be performed without using extra space.

---

## 📝 Approach

This problem can be solved efficiently using the Two Pointer technique.

- Initialize one pointer (`i`) to keep track of the last unique element.
- Use another pointer (`j`) to traverse the array.
- If `nums[j]` is different from `nums[i]`:
  - Place `nums[j]` at position `i + 1`.
  - Increment `i`.
- After completing the traversal, the first `i + 1` elements of the array contain all the unique values.
- Return `i + 1` as the number of unique elements.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize `i = 0`.
4. Traverse the array using `j` from index `1` to `n - 1`.
5. If `nums[j] != nums[i]`:
   - Increment `i`.
   - Assign `nums[i] = nums[j]`.
6. Return `i + 1` as the count of unique elements.

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
- In-place Modification
- Traversal

---

## 📥 Sample Input

```text
7
1 1 2 2 2 3 3
```

## 📤 Sample Output

```text
3
```

---

## 📖 Example

### Input

```text
7
1 1 2 2 2 3 3
```

### Output

```text
3
```

### Explanation

After removing the duplicates, the array becomes:

```text
1 2 3
```

The number of unique elements is:

```text
3
```

---

## 🎯 Key Takeaway

The Two Pointer technique efficiently removes duplicates from a sorted array in O(n) time while using O(1) extra space. One pointer tracks the last unique element, while the other scans the array to identify and place new unique values in their correct positions.
