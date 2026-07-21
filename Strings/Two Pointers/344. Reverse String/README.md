# 🚀 Reverse String

## 📌 Problem Statement

Given a character array `s`, reverse the array **in-place**.

You must modify the input array directly without using any extra array.

---

## 📝 Approach

This problem can be solved efficiently using the Two Pointer technique.

- Initialize one pointer (`left`) at the beginning of the array.
- Initialize another pointer (`right`) at the end of the array.
- Swap the characters at both pointers.
- Move both pointers toward the center.
- Continue until the pointers meet.

---

## 🔄 Algorithm

1. Read the size of the character array.
2. Store all characters in the array.
3. Initialize:
   - `left = 0`
   - `right = n - 1`
4. While `left < right`:
   - Store the left character in a temporary variable.
   - Replace the left character with the right character.
   - Place the temporary character at the right position.
   - Increment `left`.
   - Decrement `right`.
5. Print the reversed character array.

---

## ⏱️ Time Complexity

O(n)

Each character is swapped at most once.

---

## 💾 Space Complexity

O(1)

The reversal is performed in-place using only one temporary variable.

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
h e l l o
```

## 📤 Sample Output

```text
o l l e h
```

---

## 📖 Example

### Input

```text
5
h e l l o
```

### Output

```text
o l l e h
```

### Explanation

Initially:

```text
left = 0
right = 4

Array:
h e l l o
```

**Iteration 1**

```text
Swap h and o

Array:
o e l l h

left = 1
right = 3
```

**Iteration 2**

```text
Swap e and l

Array:
o l l e h

left = 2
right = 2
```

Now `left` and `right` meet, so the array is completely reversed.

---

## 🎯 Key Takeaway

The Two Pointer technique efficiently reverses the character array in **O(n)** time by swapping characters from both ends toward the center. Since the reversal is performed **in-place**, it requires only **O(1)** extra space, making it both simple and optimal.
