# Valid Anagram - LeetCode 242

## Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

## Approach 1: Brute Force - Sorting

### Approach

* Check if the lengths of both strings are equal. If not, they cannot be anagrams.
* Convert both strings into character arrays.
* Sort both character arrays.
* Compare the sorted arrays element by element.
* If all corresponding characters match, the strings are anagrams.

### Algorithm

1. Check if `s.length() != t.length()`. If true, return `false`.
2. Convert string `s` and string `t` to character arrays.
3. Sort both character arrays.
4. Traverse through both arrays using a loop.
5. If any character at index `i` does not match, return `false`.
6. Return `true` if the loop finishes without finding any mismatch.

### Time Complexity

**O(n log n)**

Sorting both arrays takes **O(n log n)** time, and the linear scan takes **O(n)** time.

### Space Complexity

**O(n)**

Extra space is required to store the character arrays for sorting.

## Approach 2: Optimal - Hashing / Frequency Count

### Approach

* Use a frequency counter (array or hash map) to count occurrences of each character.
* Increment counts for characters in string `s` and decrement counts for characters in string `t`.
* If all counts in the frequency array return to zero, the strings are valid anagrams.

### Algorithm

1. Check if `s.length() != t.length()`. If true, return `false`.
2. Initialize a frequency array of size 26 with zeros.
3. Traverse the strings and update frequencies: increment for `s[i]` and decrement for `t[i]`.
4. Iterate through the frequency array to check if all values are `0`.
5. If any value is non-zero, return `false`; otherwise, return `true`.

### Time Complexity

**O(n)**

The strings are traversed once to record frequencies, and a fixed-size array of 26 elements is checked in constant time.

### Space Complexity

**O(1)**

The space used for the frequency array is constant since the alphabet size is fixed at 26.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force (Sorting) | O(n log n) | O(n) |
| Optimal (Hashing) | O(n) | O(1) |

## Concepts Used

* Hashing
* Frequency Array
* Sorting
* String Traversal
* Character Manipulation
* Time Complexity
* Space Complexity

## Sample Input

~~~text
anagram
nagaram
~~~

## Sample Output

~~~text
true
~~~

## Sample Input

~~~text
rat
car
~~~

## Sample Output

~~~text
false
~~~
