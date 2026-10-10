# Letter Combinations of a Phone Number - 17

## Problem Statement
Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

## Approach 1: Optimal Approach (Backtracking)
### Approach
We use backtracking to explore all possible combinations of letters mapped to the given digits. At each step, we pick a digit, retrieve its corresponding letters, and recursively build the combination character by character until we reach the length of the input digits string.

### Algorithm
1. Handle the edge case where the input string `digits` is empty, returning an empty list.
2. Initialize a telephone mapping array/list from digits `2` to `9`.
3. Define a recursive backtracking function that tracks the current index in the `digits` string and the `current` built string.
4. If the current index equals the length of the `digits` string, add the `current` combination to the result list and return.
5. Otherwise, fetch the letters corresponding to the current digit and iterate through each letter, recursively calling the backtrack function with the next index and updated string.

### Time Complexity
O(4^n * n), where `n` is the length of the digits string, since digits like '7' and '9' map to 4 letters and we construct strings of length `n`.

### Space Complexity
O(n) for the recursion stack depth and storing the current combination string.

## Comparison of Approaches
- **Backtracking Approach**: The standard and optimal way to explore decision trees where each digit branches into 3 or 4 choices. It systematically generates all valid combinations without redundant work.

## Concepts Used
- Backtracking
- Recursion
- String Manipulation
- Depth-First Search (DFS)

## Sample Input
digits = "23"

## Sample Output
["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]