# Valid Palindrome - 125

## Problem Statement
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

## Approach 1: Brute Force
### Approach
Clean the string by extracting only alphanumeric characters and converting them to lowercase. Then, compare the cleaned string with its exact reverse to determine if it reads the same forwards and backwards.

### Algorithm
1. Initialize an empty list or builder for the filtered string.
2. Iterate through each character of the input string `s`.
3. If the character is alphanumeric, convert it to lowercase and append it to the filtered collection.
4. Construct the reversed version of the filtered string.
5. Return true if the filtered string equals its reverse, otherwise return false.

### Time Complexity
O(n) where n is the length of the string, due to traversing the string and reversing the filtered result.

### Space Complexity
O(n) for storing the filtered string and the reversed string.

## Approach 2: Optimal Approach
### Approach
Instead of allocating extra memory for a filtered string, use two pointers starting at the opposite ends of the string. Move the pointers inward, skipping any non-alphanumeric characters, and compare the characters case-insensitively on the fly.

### Algorithm
1. Initialize two pointers: `left` at index 0 and `right` at index `s.length() - 1`.
2. While `left` is less than `right`:
   - Increment `left` while `s[left]` is not alphanumeric and `left < right`.
   - Decrement `right` while `s[right]` is not alphanumeric and `left < right`.
   - Compare `s[left]` and `s[right]` case-insensitively. If they do not match, return false.
   - Move both pointers inward (`left++`, `right--`).
3. If the loop finishes without mismatches, return true.

### Time Complexity
O(n) as each character in the string is visited at most once by the pointers.

### Space Complexity
O(1) as only a constant amount of extra space is used for pointers.

## Comparison of Approaches
| Approach | Time Complexity | Space Complexity | Notes |
| --- | --- | --- | --- |
| Brute Force | O(n) | O(n) | Uses extra memory for string manipulation and reversal |
| Optimal | O(n) | O(1) | In-place two-pointer scan with optimal space efficiency |

## Concepts Used
- Strings
- Two Pointers
- Character validation and case manipulation

## Sample Input
s = "A man, a plan, a canal: Panama"

## Sample Output
true
