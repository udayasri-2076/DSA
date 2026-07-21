# 🚀 Valid Palindrome

## 📌 Problem Statement

Given a string `s`, determine whether it is a palindrome after converting all uppercase letters to lowercase and removing all non-alphanumeric characters.

A palindrome is a string that reads the same forward and backward.

---

## 📝 Approach

This problem can be solved efficiently using the Two Pointer technique.

- Initialize one pointer (`left`) at the beginning of the string.
- Initialize another pointer (`right`) at the end of the string.
- Ignore all characters that are not letters or digits.
- Convert both valid characters to lowercase.
- Compare the characters:
  - If they are different, return `false`.
  - Otherwise, move both pointers inward.
- Continue until the two pointers meet.
- If all valid characters match, return `true`.

---

## 🔄 Algorithm

1. Read the input string.
2. Initialize:
   - `left = 0`
   - `right = s.length() - 1`
3. While `left < right`:
   - If `s[left]` is not alphanumeric, increment `left`.
   - Else if `s[right]` is not alphanumeric, decrement `right`.
   - Otherwise:
     - Convert both characters to lowercase.
     - If the characters are different, return `false`.
     - Increment `left` and decrement `right`.
4. If the loop completes, return `true`.

---

## ⏱️ Time Complexity

O(n)

Each character is visited at most once by the two pointers.

---

## 💾 Space Complexity

O(1)

The solution uses only constant extra space.

---

## 📚 Concepts Used

- Strings
- Two Pointers
- Character Manipulation
- Traversal

---

## 📥 Sample Input

```text
A man, a plan, a canal: Panama
```

## 📤 Sample Output

```text
true
```

---

## 📖 Example

### Input

```text
A man, a plan, a canal: Panama
```

### Output

```text
true
```

### Explanation

Ignoring spaces, punctuation, and converting all letters to lowercase:

```text
Original String:
A man, a plan, a canal: Panama

Processed String:
amanaplanacanalpanama
```

Both the forward and backward strings are identical, so the string is a palindrome.

---

## 🎯 Key Takeaway

The Two Pointer technique efficiently checks whether a string is a palindrome in **O(n)** time without creating a new string. By skipping non-alphanumeric characters and comparing lowercase characters from both ends, the solution uses **constant extra space** while guaranteeing the correct result.
