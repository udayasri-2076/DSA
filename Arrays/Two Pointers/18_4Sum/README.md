# 🚀 4Sum - LeetCode 18

## 📌 Problem Statement

Given an integer array `nums` and an integer `target`, return all unique quadruplets `[nums[a], nums[b], nums[c], nums[d]]` such that:

- `0 <= a, b, c, d < nums.length`
- `a`, `b`, `c`, and `d` are distinct indices.
- `nums[a] + nums[b] + nums[c] + nums[d] == target`

The solution set must not contain duplicate quadruplets.

---

## Approach 1: Brute Force

### Approach

* Check every combination of 4 indices `(i, j, k, l)` to see if their sum matches the target.
* Use a Set to store and filter out duplicate quadruplets.

### Algorithm

1. Sort the array.
2. Use four nested loops to traverse all possible quadruplets.
3. Calculate the sum of the four elements.
4. If the sum equals the target, add the quadruplet to the set.
5. Convert the set to a list and return.

### Time Complexity

**O(n⁴)**

Four nested loops traverse the array combinations.

### Space Complexity

**O(n)**

Extra space used for storing unique quadruplets in the set.

---

## Approach 2: Optimal - Two Pointers

### Approach

* Fix the first two numbers using nested loops (`i` and `j`).
* Use two pointers (`l` and `r`) to find the remaining pair, similar to 3Sum.
* Skip duplicates at every level to ensure unique quadruplets.

### Algorithm

1. Sort the array.
2. Traverse using index `i` and skip duplicates.
3. Traverse using index `j` and skip duplicates.
4. Initialize `l = j + 1` and `r = n - 1`.
5. While `l < r`:
   * Calculate the 4-sum.
   * If the sum equals the target, store the quadruplet, move pointers inward, and skip duplicates.
   * If the sum is greater than the target, decrement `right`.
   * If the sum is less than the target, increment `left`.
6. Return the list of unique quadruplets.

### Time Complexity

**O(n³)**

Two nested loops combined with a linear scan using two pointers.

### Space Complexity

**O(1)**

Constant extra space used, excluding the output list.

---

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---||
| Brute Force | O(n⁴) | O(n) |
| Two Pointers | O(n³) | O(1) |

---

## Concepts Used

- Arrays
- Sorting
- Two Pointers
- Nested Loops
- Duplicate Handling
- Time Complexity
- Space Complexity

---

## Sample Input

```text
6
1 0 -1 0 -2 2
0
```

## Sample Output

```text
[
  [-2, -1, 1, 2],
  [-2, 0, 0, 2],
  [-1, 0, 0, 1]
]
```
