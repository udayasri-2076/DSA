# Valid Palindrome - LeetCode 125

## Problem Statement

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

## Approach 1: Brute Force

### Approach
* Traverse the string and filter out all non-alphanumeric characters.
* Convert all remaining characters to lowercase.
* Compare the cleaned string with its reversed version.
* If they are equal, return `true`; otherwise, return `false`.

### Algorithm
1. Initialize a `StringBuilder` or temporary storage.
2. Iterate through each character of the string.
3. Check if the character is a letter or digit.
4. If yes, convert to lowercase and append to the storage.
5. Compare the resulting string with its reverse.

### Time Complexity
**O(n)**
Traversing the string and reversing it takes linear time.

### Space Complexity
**O(n)**
Extra space is required to store the cleaned string and its reverse.

## Approach 2: Optimal - Two Pointers

### Approach
* Use two pointers: `left` starting at the beginning and `right` starting at the end of the string.
* Move `left` forward if the character is not alphanumeric.
* Move `right` backward if the character is not alphanumeric.
* Compare the characters at `left` and `right` in a case-insensitive manner.
* If they do not match, return `false`. If pointers cross without mismatch, return `true`.

### Algorithm
1. Initialize `left = 0` and `right = s.length() - 1`.
2. While `left < right`:
   * Get characters `l = s.charAt(left)` and `r = s.charAt(right)`.
   * If `l` is not alphanumeric, increment `left`.
   * Else if `r` is not alphanumeric, decrement `right`.
   * Else, compare `toLowerCase(l)` and `toLowerCase(r)`.
   * If they mismatch, return `false`.
   * Otherwise, increment `left` and decrement `right`.
3. Return `true` if loop completes successfully.

### Time Complexity
**O(n)**
Each character is visited at most once by the two pointers.

### Space Complexity
**O(1)**
Only a constant amount of extra space is used for pointer variables.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n) | O(n) |
| Two Pointers | O(n) | O(1) |

## Concepts Used

* Strings
* Two Pointers
* Character Manipulation
* Palindrome Check
* Time Complexity
* Space Complexity

## Sample Input

~~~text
A man, a plan, a canal: Panama
~~~

## Sample Output

~~~text
true
~~~
