# Find Missing Number in Array

## Problem Statement

Given an array containing `n` numbers from the range `1` to `n+1`, with exactly one number missing, find the missing number.

## Approach

* Calculate the expected sum of numbers from `1` to `n` using the formula:

  `Sum = n × (n + 1) / 2`

* Calculate the actual sum of all elements present in the array.

* The difference between the actual sum and expected sum gives the missing number.

## Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Calculate the expected sum using the formula.
4. Calculate the actual sum of array elements.
5. Find the difference between the two sums.
6. Print the missing number.

## Time Complexity

**O(n)**

The array is traversed once to calculate the sum.

## Space Complexity

**O(1)**

No extra space is used apart from a few variables.

## Concepts Used

* Arrays
* Mathematical Formula
* Traversal
* Summation

## Sample Input

```text id="mzt4f6"
5
1 2 4 5 6
```

## Sample Output

```text id="wpquu3"
3
```

## Explanation

Expected numbers:

```text id="s4zkrt"
1 2 3 4 5 6
```

Array elements:

```text id="hvw3y2"
1 2 4 5 6
```

Missing number:

```text id="v0u5bh"
3
```

