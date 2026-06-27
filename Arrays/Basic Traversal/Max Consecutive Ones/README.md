
# Maximum Consecutive Ones

## Problem Statement

Given a binary array consisting of only `0`s and `1`s, find the maximum number of consecutive `1`s present in the array.

## Approach

Traverse the array and maintain a count of consecutive `1`s.

* If the current element is `1`, increment the count.
* Update the maximum count whenever a larger sequence is found.
* If the current element is `0`, reset the count to `0`.
* The maximum count obtained during traversal is the answer.

## Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize two variables:

   * `cnt` to track the current consecutive count.
   * `maxi` to track the maximum consecutive count.
4. Traverse the array.
5. If the current element is `1`:

   * Increment `cnt`.
   * Update `maxi`.
6. If the current element is `0`:

   * Reset `cnt` to `0`.
7. Print `maxi`.

## Time Complexity

**O(n)**

The array is traversed exactly once.

## Space Complexity

**O(1)**

Only a few variables are used.

## Concepts Used

* Arrays
* Traversal
* Counting
* Maximum Value Tracking

## Sample Input

```text
9
1 1 0 1 1 1 0 1 1
```

## Sample Output

```text
3
```

## Explanation

The consecutive sequences of `1`s are:

```text
1 1
1 1 1
1 1
```

The longest sequence contains:

```text
3
```

consecutive `1`s.

