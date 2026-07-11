# 🚀 485. Max Consecutive Ones

## 📌 Problem Statement

Given a binary array `nums` consisting of only `0`s and `1`s, return the maximum number of consecutive `1`s in the array.

---

## 📝 Approach

This problem can be solved efficiently using a single traversal.

- Initialize a variable `count` to keep track of the current consecutive `1`s.
- Initialize another variable `maxCount` to store the maximum consecutive `1`s found so far.
- Traverse the array:
  - If the current element is `1`:
    - Increment `count`.
    - Update `maxCount` if `count` is greater.
  - Otherwise:
    - Reset `count` to `0`.
- After the traversal, `maxCount` contains the required answer.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize:
   - `count = 0`
   - `maxCount = 0`
4. Traverse the array:
   - If the current element is `1`:
     - Increment `count`.
     - Update `maxCount`.
   - Otherwise:
     - Reset `count` to `0`.
5. Print `maxCount`.

---

## ⏱️ Time Complexity

O(n)

The array is traversed only once.

---

## 💾 Space Complexity

O(1)

Only two integer variables are used.

---

## 📚 Concepts Used

- Arrays
- Traversal
- Counting
- Maximum Tracking

---

## 📥 Sample Input

```text
6
1 1 0 1 1 1
```

## 📤 Sample Output

```text
3
```

---

## 📖 Example

### Input

```text
6
1 1 0 1 1 1
```

### Output

```text
3
```

### Explanation

The array contains two groups of consecutive `1`s:

```text
1 1
```

and

```text
1 1 1
```

The second group has the maximum length.

Therefore, the answer is:

```text
3
```

---

## 🎯 Key Takeaway

A single traversal is sufficient to find the maximum consecutive `1`s. By maintaining the current streak and updating the maximum streak whenever necessary, the problem is solved in O(n) time using O(1) extra space.
