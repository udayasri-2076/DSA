# Ransom Note - LeetCode 383

## Problem Statement

Given two strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed by using the letters from `magazine` and `false` otherwise.

Each letter in `magazine` can only be used once in `ransomNote`.

## Approach 1: Brute Force

### Approach

* Traverse each character in the `ransomNote` string.
* For each character, search for a match in a mutable copy of the `magazine` string.
* If a match is found, remove that character from the magazine copy so it cannot be reused.
* If any character is not found, return `false`.
* If all characters are found, return `true`.

### Algorithm

1. Create a mutable copy of the `magazine` string.
2. Iterate through each character of `ransomNote` using index `i`.
3. Scan the magazine copy to find the matching character.
4. If the character is not found, return `false`.
5. If found, delete the matched index from the magazine copy and continue.
6. Return `true` after successful traversal.

### Time Complexity

**O(m * n)**

Where `m` is the length of `ransomNote` and `n` is the length of `magazine`. In the worst case, every character lookup requires scanning the remaining magazine copy.

### Space Complexity

**O(n)**

Extra space is used to store the mutable copy of the magazine string.

## Approach 2: Optimal - Hashing

### Approach

* Use a hash map to count the frequency of each character in `magazine`.
* Traverse the `ransomNote` string and check if each character exists in the frequency map with a count greater than `0`.
* If it does, decrement its count in the map.
* If it does not exist or its count is `0`, return `false`.
* If all characters are successfully validated, return `true`.

### Algorithm

1. Initialize an empty hash map.
2. Traverse `magazine` and record the frequency of each character.
3. Traverse `ransomNote` character by character.
4. Check if the current character is present in the hash map and has a count greater than `0`.
5. If the condition fails, return `false`.
6. Otherwise, decrement the character's count in the map.
7. Return `true` after the loop completes.

### Time Complexity

**O(m + n)**

Traversing `magazine` takes `O(n)` time and traversing `ransomNote` takes `O(m)` time. Hash map insertions and lookups take `O(1)` average time.

### Space Complexity

**O(1)** (or **O(k)** where **k** is the size of the alphabet)

At most, 26 lowercase English letters are stored in the hash map.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(m * n) | O(n) |
| Hashing (Optimal) | O(m + n) | O(1) |

## Concepts Used

* Hashing
* Hash Map
* Frequency Counting
* String Traversal
* Time Complexity
* Space Complexity

## Sample Input

~~~text
a
ab
~~~

## Sample Output

~~~text
true
~~~

## Sample Input

~~~text
aa
ab
~~~

## Sample Output

~~~text
false
~~~
