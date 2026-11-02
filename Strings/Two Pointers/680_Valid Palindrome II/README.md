# Valid Palindrome II - 680

## Problem Statement
Given a string `s`, return `true` if the `s` can be palindrome after deleting at most one character from it.

## Approach 1: Brute Force
### Approach
Generate all possible strings by removing exactly one character at each index and check if any of the resulting strings is a palindrome.
### Algorithm
1. Iterate through each index `i` of the string.
2. Construct a new string by omitting the character at index `i`.
3. Check if the modified string reads the same forwards and backwards.
4. If a palindrome is found, return `true`.
5. If the loop finishes without finding any palindrome, return `false`.
### Time Complexity
O(n^2)
### Space Complexity
O(n)

## Approach 2: Optimal
### Approach
Use a two-pointer approach starting from the outermost bounds and moving inward. When a mismatch is encountered, verify if skipping either the left character or the right character resolves the mismatch into a valid palindrome.
### Algorithm
1. Initialize two pointers `l = 0` and `r = s.length() - 1`.
2. While `l < r`, compare characters at `s.charAt(l)` and `s.charAt(r)`.
3. If they match, increment `l` and decrement `r`.
4. If they do not match, check if either the substring from `l+1` to `r` or `l` to `r-1` is a palindrome.
5. Return `true` if either check succeeds; otherwise, return `false`.
6. If the loop completes without mismatches, the original string is already a palindrome, return `true`.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches
- **Brute Force:** Simple to conceptualize but inefficient due to repeated substring generation and palindrome checks taking O(n^2) time.
- **Optimal:** Exploits the nature of mismatches in palindromes, reducing time complexity to O(n) and auxiliary space to O(1) by reusing pointer bounds.

## Concepts Used
- Strings
- Two Pointers
- Palindrome Validation

## Sample Input
s = "abca"

## Sample Output
true