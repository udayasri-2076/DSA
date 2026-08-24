# Best Time to Buy and Sell Stock - LeetCode 121

## Problem Statement

You are given an array `prices` where `prices[i]` represents the price of a stock on day `i`.

You want to maximize your profit by choosing one day to buy the stock and a future day to sell it.

Return the maximum profit you can achieve.

If no profit can be made, return `0`.

## Approach 1: Brute Force

### Approach

* Use two loops to check every possible buying and selling day.
* The outer loop selects the buying day.
* The inner loop selects a future selling day.
* Calculate the profit using `prices[j] - prices[i]`.
* Update the maximum profit if the current profit is greater.
* Return the maximum profit.

### Algorithm

1. Initialize `maxProfit = 0`.
2. Traverse the array using an outer loop.
3. For each buying day `i`, traverse all future days using an inner loop `j`.
4. Calculate `profit = prices[j] - prices[i]`.
5. Update `maxProfit` using the maximum of the current profit and `maxProfit`.
6. Return `maxProfit`.

### Time Complexity

**O(n²)**

Every possible buying and selling pair may be checked.

### Space Complexity

**O(1)**

No extra data structure is used.

## Approach 2: Optimal - Two Pointers

### Approach

* Use two pointers, `l` and `r`.
* `l` represents the buying day.
* `r` represents the selling day.
* If `prices[r] < prices[l]`, move `l` to `r` because we found a cheaper buying price.
* Otherwise, calculate the profit using `prices[r] - prices[l]`.
* Update the maximum profit.
* Continue until `r` reaches the end of the array.

### Algorithm

1. Initialize `l = 0` as the buying day.
2. Initialize `r = 1` as the selling day.
3. Initialize `maxProfit = 0`.
4. While `r < prices.length`:
   * Calculate `profit = prices[r] - prices[l]`.
   * If `prices[r] < prices[l]`, update `l = r`.
   * Otherwise, update `maxProfit`.
   * Move `r` forward.
5. Return `maxProfit`.

### Dry Run

~~~text
prices = [7, 1, 5, 3, 6, 4]

l = 0
r = 1

prices[l] = 7
prices[r] = 1

1 < 7

Buying at 1 is better.

l = 1


r = 2

prices[l] = 1
prices[r] = 5

profit = 5 - 1 = 4

maxProfit = max(0, 4)

maxProfit = 4


r = 3

prices[l] = 1
prices[r] = 3

profit = 3 - 1 = 2

maxProfit = max(4, 2)

maxProfit = 4


r = 4

prices[l] = 1
prices[r] = 6

profit = 6 - 1 = 5

maxProfit = max(4, 5)

maxProfit = 5


r = 5

prices[l] = 1
prices[r] = 4

profit = 4 - 1 = 3

maxProfit = max(5, 3)

maxProfit = 5


Answer = 5
~~~

### Time Complexity

**O(n)**

The array is traversed only once.

### Space Complexity

**O(1)**

Only a few variables are used.

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n²) | O(1) |
| Two Pointers | O(n) | O(1) |

## Concepts Used

* Arrays
* Two Pointers
* Array Traversal
* Profit Calculation
* Maximum Value Tracking
* Time Complexity
* Space Complexity

## Sample Input

~~~text
6
7 1 5 3 6 4
~~~

## Sample Output

~~~text
5
~~~

## Sample Input

~~~text
5
7 6 4 3 1
~~~

## Sample Output

~~~text
0
~~~
