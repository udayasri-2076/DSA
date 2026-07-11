# 🚀 Maximum Sum Subarray of Size K

## 📌 Problem Statement

Given an integer array `arr` and an integer `k`, find the maximum sum of any contiguous subarray of size `k`.

---

## 📝 Approach

This problem can be solved efficiently using the Sliding Window technique.

- Compute the sum of the first `k` elements.
- Store this as the initial maximum sum.
- Slide the window one element at a time:
  - Add the new element entering the window.
  - Remove the element leaving the window.
- Update the maximum sum after each slide.
- After traversing the array, the maximum recorded sum is the answer.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Read the window size `k`.
4. Calculate the sum of the first `k` elements.
5. Store this sum as `maximum`.
6. Traverse the remaining elements:
   - Add the current element to the window sum.
   - Subtract the element leaving the window.
   - Update the maximum sum if required.
7. Print the maximum sum.

---

## ⏱️ Time Complexity

O(n)

The array is traversed only once after calculating the initial window sum.

---

## 💾 Space Complexity

O(1)

Only a few integer variables are used.

---

## 📚 Concepts Used

- Arrays
- Sliding Window
- Traversal
- Maximum Tracking

---

## 📥 Sample Input

```text
5
5 2 -1 0 3
3
```

## 📤 Sample Output

```text
6
```

---

## 📖 Example

### Input

```text
5
5 2 -1 0 3
3
```

### Output

```text
6
```

### Explanation

The subarrays of size `3` are:

```text
[5, 2, -1] → Sum = 6
[2, -1, 0] → Sum = 1
[-1, 0, 3] → Sum = 2
```

The maximum sum among all subarrays of size `3` is:

```text
6
```

---

## 🎯 Key Takeaway

The Sliding Window technique avoids recalculating the sum for every subarray. Instead, it updates the current window sum by adding the new element and removing the old one, reducing the time complexity from O(n × k) to O(n).
