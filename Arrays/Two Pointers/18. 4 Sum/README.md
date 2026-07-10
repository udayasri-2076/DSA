# 🚀 4Sum

## 📌 Problem Statement

Given an integer array `nums` and an integer `target`, return all unique quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:

- `0 <= a, b, c, d < nums.length`
- `a`, `b`, `c`, and `d` are distinct indices.
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

The solution set must not contain duplicate quadruplets.

---

## 📝 Approach

This problem can be solved using Sorting and the Two Pointer technique.

- Sort the array first.
- Fix the first element using index `i`.
- Fix the second element using index `j`.
- Use two pointers:
  - `left` starting from `j + 1`
  - `right` starting from the end of the array.
- Calculate the sum of the four elements.
- If the sum equals the target:
  - Store the quadruplet.
  - Move both pointers inward.
  - Skip duplicate values to avoid repeated quadruplets.
- If the sum is smaller than the target, move the `left` pointer forward.
- If the sum is greater than the target, move the `right` pointer backward.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Read the target value.
4. Sort the array.
5. Traverse the array using index `i`.
6. Skip duplicate values for `i`.
7. Traverse the remaining array using index `j`.
8. Skip duplicate values for `j`.
9. Initialize two pointers:
   - `left = j + 1`
   - `right = n - 1`
10. While `left < right`:
    - Calculate the sum of the four elements.
    - If the sum equals the target:
      - Store the quadruplet.
      - Move both pointers.
      - Skip duplicate values.
    - If the sum is less than the target, increment `left`.
    - Otherwise, decrement `right`.
11. Return the list of unique quadruplets.

---

## ⏱️ Time Complexity

O(n³)

- Two nested loops are used to fix the first two elements.
- The remaining two elements are found using the Two Pointer technique in linear time.

---

## 💾 Space Complexity

O(1)

- Only constant extra space is used (excluding the space required for storing the output).

---

## 📚 Concepts Used

- Arrays
- Sorting
- Two Pointers
- Nested Loops
- Duplicate Handling

---

## 📥 Sample Input

```text
6
1 0 -1 0 -2 2
0
```

## 📤 Sample Output

```text
[
  [-2, -1, 1, 2],
  [-2, 0, 0, 2],
  [-1, 0, 0, 1]
]
```

---

## 📖 Example

### Input

```text
6
1 0 -1 0 -2 2
0
```

### Output

```text
[
  [-2, -1, 1, 2],
  [-2, 0, 0, 2],
  [-1, 0, 0, 1]
]
```

### Explanation

After sorting the array:

```text
[-2, -1, 0, 0, 1, 2]
```

The algorithm fixes the first two numbers and uses two pointers to find the remaining two numbers whose sum equals the target. Duplicate values are skipped to ensure that only unique quadruplets are included in the final result.

---

## 🎯 Key Takeaway

Sorting combined with the Two Pointer technique reduces the search for the remaining two numbers to linear time after fixing the first two elements. This efficiently finds all unique quadruplets in O(n³) time while avoiding duplicate results.
