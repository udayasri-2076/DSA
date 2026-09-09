# Two Sum - LeetCode 1

## Problem Statement

Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to `target`.

You may assume that each input has exactly one solution, and you may not use the same element twice.

## Approach 1: Brute Force

### Approach

* Use two loops to check every possible pair of elements.
* The outer loop selects the first element.
* The inner loop selects the second element.
* Check whether `nums[i] + nums[j]` is equal to the `target`.
* If the sum is equal to the target, return the indices.
* If no pair is found, return `[-1, -1]`.

### Algorithm

1. Traverse the array using an outer loop.
2. For each element, traverse the remaining elements using an inner loop.
3. Calculate `nums[i] + nums[j]`.
4. If the sum is equal to `target`, return `[i, j]`.
5. If no pair is found, return `[-1, -1]`.

### Time Complexity

**O(n²)**

Every possible pair of elements may be checked.

### Space Complexity

**O(1)**

No extra data structure is used.

## Approach 2: Optimal - Hashing

### Approach

* Use a `HashMap` to store each value and its index.
* Traverse the array from left to right.
* For every element, calculate the required value using `target - nums[i]`.
* Check whether the required value is already present in the `HashMap`.
* If it is present, return the stored index and the current index.
* Otherwise, store the current value and its index in the `HashMap`.

### Algorithm

1. Create an empty `HashMap`.
2. Traverse the array from left to right.
3. Calculate `difference = target - nums[i]`.
4. Check whether `difference` is present in the `HashMap`.
5. If it is present, return `[map.get(difference), i]`.
6. Otherwise, store `nums[i]` and its index in the `HashMap`.
7. If no pair is found, return `[-1, -1]`.

### Dry Run

~~~text
nums = [2, 1, 5, 3]
target = 4

i = 0
value = 2
difference = 4 - 2 = 2

2 is not present in HashMap.

Store:
2 -> 0

HashMap = {2=0}


i = 1
value = 1
difference = 4 - 1 = 3

3 is not present in HashMap.

Store:
1 -> 1

HashMap = {2=0, 1=1}


i = 2
value = 5
difference = 4 - 5 = -1

-1 is not present in HashMap.

Store:
5 -> 2

HashMap = {2=0, 1=1, 5=2}


i = 3
value = 3
difference = 4 - 3 = 1

1 is present in HashMap.

1 -> index 1
3 -> index 3

Answer = [1, 3]
~~~

### Time Complexity

**O(n) average**

The array is traversed once, and `HashMap` insertion and search take **O(1)** average time.

### Space Complexity

**O(n)**

In the worst case, the `HashMap` stores all `n` elements.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n²) | O(1) |
| Hashing | O(n) average | O(n) |

## Concepts Used

* Arrays
* Hashing
* HashMap
* Nested Loops
* Difference Calculation
* Index Tracking
* Array Traversal
* Time Complexity
* Space Complexity

## Sample Input

~~~text
4
2 1 5 3
4
~~~

## Sample Output

~~~text
1 3
~~~

## Sample Input

~~~text
4
2 7 11 15
9
~~~

## Sample Output

~~~text
0 1
~~~
