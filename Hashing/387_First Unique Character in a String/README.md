# First Unique Character in a String - 387

## Problem Statement
Given a string `s`, find the first non-repeating character in it and return its index. If it does not exist, return `-1`.

## Approach 1: Hashing (Optimal)
### Approach
We can use a hash map (or a frequency array) to keep track of the occurrence count of each character in the string. By iterating through the string twice—first to build the frequency map and second to check for the first character with a count of 1—we can efficiently find the first unique character.

### Algorithm
1. Calculate the length of the string `n`.
2. Initialize a hash map to store character-to-frequency mappings.
3. Traverse the string from index `0` to `n-1` to populate the frequency map.
4. Traverse the string again from index `0` to `n-1`.
5. For each character, check its frequency in the hash map. If it equals `1`, return the current index.
6. If no such character is found after the loop finishes, return `-1`.

### Time Complexity
- O(n), where `n` is the length of the string. We iterate through the string twice.

### Space Complexity
- O(1) or O(k), where `k` is the number of distinct characters. Since the alphabet size is fixed (e.g., 26 lowercase English letters), the space complexity is effectively O(1).

## Comparison of Approaches
- **Hashing Approach**: Efficiently solves the problem in O(n) time by trading off O(k) space for frequency lookups, avoiding the O(n^2) nested loop comparisons of a brute force search.

## Concepts Used
- Hashing / Hash Maps
- Frequency Counting
- Two-pass Linear Scan

## Sample Input
s = "leetcode"

## Sample Output
0
