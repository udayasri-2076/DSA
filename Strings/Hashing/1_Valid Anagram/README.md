# Valid Anagram - LeetCode 242

## Problem Statement

Given two strings `s` and `t`, determine whether `t` is an anagram of `s`. Return `true` if `t` contains the same characters with the same frequency as `s`, otherwise return `false`.

## Approach 1: Brute Force - Hashing

### Approach

* Use two `HashMap`s to store the frequency of characters in both strings.
* Traverse the first string and count the frequency of each character.
* Traverse the second string and count the frequency of each character.
* Compare both `HashMap`s.
* If both maps contain the same characters with the same frequencies, return `true`.
* Otherwise, return `false`.

### Algorithm

1. Check whether the lengths of both strings are equal.
2. Create two empty `HashMap`s.
3. Traverse string `s` and count the frequency of each character.
4. Traverse string `t` and count the frequency of each character.
5. Compare both `HashMap`s.
6. If both maps are equal, return `true`.
7. Otherwise, return `false`.

### Time Complexity

**O(n)**

Both strings are traversed once, and `HashMap` insertion and search take **O(1)** average time.

### Space Complexity

**O(n)**

The `HashMap`s store the characters and their frequencies.

## Approach 2: Optimal - Sorting

### Approach

* Convert both strings into character arrays.
* Sort both character arrays.
* Compare the sorted arrays.
* If both arrays are equal, the strings are anagrams.
* If the arrays are different, the strings are not anagrams.

### Algorithm

1. Check whether the lengths of both strings are equal.
2. Convert string `s` into a character array.
3. Convert string `t` into a character array.
4. Sort both character arrays.
5. Compare both sorted arrays.
6. If both arrays are equal, return `true`.
7. Otherwise, return `false`.

### Time Complexity

**O(n log n)**

Sorting both character arrays takes **O(n log n)** time.

### Space Complexity

**O(n)**

Character arrays are created from both strings.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Hashing | O(n) average | O(n) |
| Sorting | O(n log n) | O(n) |

## Concepts Used

* Strings
* Hashing
* HashMap
* Character Frequency
* Sorting
* Character Arrays
* String Comparison
* Traversal
* Anagram
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
