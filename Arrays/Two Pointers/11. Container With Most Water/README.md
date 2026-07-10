# 🚀 Container With Most Water

## 📌 Problem Statement

Given an integer array `height`, where each element represents the height of a vertical line, find two lines that together with the x-axis form a container capable of holding the maximum amount of water.

The amount of water a container can hold is determined by the shorter of the two lines and the distance between them.

---

## 📝 Approach

This problem can be solved efficiently using the Two Pointer technique.

- Initialize one pointer (`left`) at the beginning of the array.
- Initialize another pointer (`right`) at the end of the array.
- Calculate:
  - `width = right - left`
  - `currentHeight = min(height[left], height[right])`
  - `area = width × currentHeight`
- Update the maximum area if the current area is larger.
- Move the pointer pointing to the shorter line inward.
- Continue until the two pointers meet.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize:
   - `left = 0`
   - `right = n - 1`
   - `maximum = 0`
4. While `left < right`:
   - Calculate the width between the two pointers.
   - Find the smaller of the two heights.
   - Compute the current area.
   - Update the maximum area if needed.
   - If `height[left] < height[right]`, increment `left`.
   - Otherwise, decrement `right`.
5. Print the maximum area.

---

## ⏱️ Time Complexity

O(n)

The array is traversed only once using two pointers.

---

## 💾 Space Complexity

O(1)

The solution uses only constant extra space.

---

## 📚 Concepts Used

- Arrays
- Two Pointers
- Greedy Technique
- Traversal

---

## 📥 Sample Input

```text
9
1 8 6 2 5 4 8 3 7
```

## 📤 Sample Output

```text
49
```

---

## 📖 Example

### Input

```text
9
1 8 6 2 5 4 8 3 7
```

### Output

```text
49
```

### Explanation

The maximum water is contained between the lines with heights `8` and `7`.

```text
Width = 8 - 1 = 7
Height = min(8, 7) = 7
Area = 7 × 7 = 49
```

No other pair of lines forms a container with a larger area.

---

## 🎯 Key Takeaway

The Two Pointer technique efficiently finds the maximum water container in O(n) time by always moving the pointer pointing to the shorter line. This greedy strategy avoids checking every possible pair while guaranteeing the optimal result.
