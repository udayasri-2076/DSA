# 🚀 3Sum

## 📌 Problem Statement

Given an integer array `nums`, return all unique triplets `[nums[i], nums[j], nums[k]]` such that:

- `i`, `j`, and `k` are distinct indices.
- `nums[i] + nums[j] + nums[k] == 0`.

The solution set must not contain duplicate triplets.

---

## 📝 Approach

This problem can be solved efficiently using Sorting and the Two Pointer technique.

- Sort the array first.
- Traverse the array by fixing one element using index `i`.
- Skip duplicate values for `i` to avoid repeated triplets.
- Initialize two pointers:
  - `left = i + 1`
  - `right = n - 1`
- Calculate the sum of the three elements.
- If the sum equals `0`:
  - Store the triplet.
  - Move both pointers inward.
  - Skip duplicate values for both pointers.
- If the sum is less than `0`, move the `left` pointer to the right.
- If the sum is greater than `0`, move the `right` pointer to the left.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Sort the array.
4. Traverse the array using index `i`.
5. Skip duplicate values for `i`.
6. Initialize two pointers:
   - `left = i + 1`
   - `right = n - 1`
7. While `left < right`:
   - Calculate `sum = nums[i] + nums[left] + nums[right]`.
   - If `sum == 0`:
     - Store the triplet.
     - Move both pointers.
     - Skip duplicate values.
   - If `sum < 0`, increment `left`.
   - Otherwise, decrement `right`.
8. Return the list of unique triplets.

---

## ⏱️ Time Complexity

O(n²)

- Sorting takes O(n log n).
- The Two Pointer traversal for each fixed element takes O(n).

---

## 💾 Space Complexity

O(1)

- Only constant extra space is used (excluding the space required for storing the output).

---

## 📚 Concepts Used

- Arrays
- Sorting
- Two Pointers
- Duplicate Handling

---

## 📥 Sample Input

```text
6
-4 -1 -1 0 1 2
```

## 📤 Sample Output

```text
[
  [-1, -1, 2],
  [-1, 0, 1]
]
```

---

## 📖 Example

### Input

```text
6
-4 -1 -1 0 1 2
```

### Output

```text
[
  [-1, -1, 2],
  [-1, 0, 1]
]
```

### Explanation

After sorting the array:

```text
[-4, -1, -1, 0, 1, 2]
```

The algorithm fixes one element and uses two pointers to find the remaining two numbers whose sum equals `0`. Duplicate values are skipped to ensure that each triplet appears only once in the final result.

---

## 🎯 Key Takeaway

Sorting combined with the Two Pointer technique efficiently finds all unique triplets in O(n²) time. Skipping duplicate values ensures that the final result contains only distinct triplets while using constant extra space.
