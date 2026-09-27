# Fruit Into Baskets - LeetCode 904

## Problem Statement

You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array `fruits` where `fruits[i]` is the type of fruit the `i`-th tree produces.

You want to collect as much fruit as possible. However, the farm owner has some strict rules that you must follow:

- You only have two baskets, and each basket can hold only a single type of fruit. There is no limit on the amount of fruit each basket can hold.
- Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in your baskets.
- Once you reach a tree with fruit that cannot fit in your baskets, you must stop.

Given the integer array `fruits`, return the maximum number of fruits you can collect.

## Approach 1: Brute Force

### Approach

- Check every possible subarray of the array.
- For each subarray, use a set to count the number of unique fruit types.
- If the number of unique fruit types is less than or equal to 2, calculate its length and update the maximum length.

### Algorithm

1. Initialize `maxlenBrute = 0`.
2. Use an outer loop `i` from `0` to `n - 1` to fix the start of the subarray.
3. Use an inner loop `j` from `i` to `n - 1` to fix the end of the subarray.
4. Traverse from `i` to `j` and add all elements to a `HashSet`.
5. If the size of the set is `<= 2`, update `maxlenBrute` with the maximum of its current value and `j - i + 1`.
6. Return `maxlenBrute`.

### Time Complexity

**O(n³)**

Three nested loops are used to check every subarray and compute the distinct elements.

### Space Complexity

**O(n)**

Extra space is used for the set to store distinct fruit types in the current subarray.

## Approach 2: Optimal - Sliding Window

### Approach

- Use the Sliding Window pattern with two pointers, `l` (left) and `r` (right).
- Maintain a hash map (`freq`) to track the count of each fruit type present in the current window `[l, r]`.
- Expand the window by moving `r` to the right and adding `fruits[r]` to the map.
- If the number of distinct fruit types in the map exceeds 2, shrink the window from the left by incrementing `l` until there are at most 2 distinct types.
- At each step, update the maximum length found so far.

### Algorithm

1. Initialize `l = 0`, `maxlen = 0`, and an empty hash map `freq`.
2. Traverse the array with pointer `r` from `0` to `n - 1`:
   - Add `fruits[r]` to `freq` and update its count.
   - While `freq.size() > 2`:
     - Get the fruit at pointer `l`: `leftFruit = fruits[l]`.
     - Decrement the count of `leftFruit` in `freq`.
     - If the count becomes `0`, remove `leftFruit` from `freq`.
     - Increment `l`.
   - Update `maxlen = max(maxlen, r - l + 1)`.
3. Return `maxlen`.

### Time Complexity

**O(n)**

The right pointer `r` traverses the array once, and the left pointer `l` also moves at most `n` times. Thus, each element is visited at most twice.

### Space Complexity

**O(1)**

The hash map stores at most 3 distinct fruit types at any given time before shrinking the window, which takes constant space.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n³) | O(n) |
| Sliding Window (Optimal) | O(n) | O(1) |

## Concepts Used

- Arrays
- Sliding Window
- Two Pointers
- Hash Table / HashMap
- Frequency Tracking
- Time Complexity
- Space Complexity

## Sample Input

~~~text
5
1 2 1 2 3
~~~

## Sample Output

~~~text
4
~~~
