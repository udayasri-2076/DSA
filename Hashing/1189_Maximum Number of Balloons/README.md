# Maximum Number of Balloons - LeetNumber 1189

## Problem Statement
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible. You can use each character in text at most once. Return the maximum number of instances that can be formed.

## Approach 1: Hashing (Optimal)
### Approach
To form the word "balloon", we need specific counts of characters: 'b' (1), 'a' (1), 'l' (2), 'o' (2), and 'n' (1). We can use a hash map to count the frequencies of every character present in the input string. Since 'l' and 'o' appear twice in the target word, their total counts must be divided by 2. The maximum number of complete "balloon" words we can form will be constrained by the minimum availability among all required characters.

### Algorithm
1. Initialize a frequency map (or hash map) to store character counts.
2. Iterate through each character of the input string and update its frequency in the map.
3. Retrieve the counts for 'b', 'a', 'l', 'o', and 'n' from the map, defaulting to 0 if a character is missing.
4. Divide the counts of 'l' and 'o' by 2 since each requires two occurrences per "balloon".
5. Return the minimum value among the counts of all required characters.

### Time Complexity
- O(N) where N is the length of the string text, since we iterate through the text once to populate the map.

### Space Complexity
- O(1) auxiliary space, because the hash map will store at most 26 lowercase English letters.

## Comparison of Approaches
- The Hashing approach is both optimal and straightforward, running in linear time O(N) and constant space O(1) relative to the alphabet size.

## Concepts Used
- Hashing
- Frequency Counting
- String Manipulation

## Sample Input
text = "nlaebolko"

## Sample Output
0