# Group Anagrams - LeetCode 49

## Problem Statement

Given an array of strings `strs`, group the anagrams together. You can return the answer in **any order**.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Approach 1: Optimal - Hashing with Sorted String Key

### Approach

* An anagram is formed by rearranging the same characters.
* If we sort the characters of any string in alphabetical order, all anagrams will result in the exact same sorted string.
* Use a Hash Map (`HashMap` in Java, `defaultdict` in Python) to map each sorted string key to a list of original strings belonging to that anagram group.
* Traverse through every string in the array, sort its characters to form the key, and append the original string to the corresponding list in the map.
* Return all the grouped lists from the map values.

### Algorithm

1. Initialize an empty Hash Map.
2. Traverse the input array of strings `strs` from left to right.
3. For each string, convert it to a character array, sort it, and convert it back to a string to form the `key`.
4. Check if the `key` already exists in the map. If it does not, create a new empty list for that key.
5. Add the original string to the list corresponding to the `key` in the map.
6. After processing all strings, collect all values from the map and return them as the result.

### Time Complexity

**O(n * k log k)**

Where `n` is the number of strings in the array and `k` is the maximum length of a string. Sorting each string takes **O(k log k)** time, and we do this for all `n` strings.

### Space Complexity

**O(n * k)**

In the worst case, all strings are stored in the hash map, requiring space proportional to the total number of characters across all strings.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Hashing with Sorted String Key | O(n * k log k) | O(n * k) |

## Concepts Used

* Hashing
* HashMap / Dictionary
* String Sorting
* Array Traversal
* Grouping
* Time Complexity
* Space Complexity

## Sample Input

~~~text
6
eat tea tan ate nat bat
~~~

## Sample Output

~~~text
[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
~~~
