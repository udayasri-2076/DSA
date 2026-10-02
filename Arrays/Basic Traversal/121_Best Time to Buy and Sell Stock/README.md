# Best Time to Buy and Sell Stock - 121

## Problem Statement
You are given an array prices where prices[i] is the price of a given stock on the ith day. You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

## Approach 1: Two Pointers
### Approach
We use two pointers, l (left) representing the buy day and r (right) representing the sell day. We traverse the array with r while keeping l at the minimum price seen so far.
### Algorithm
1. Initialize l = 0, r = 1, and max_profit = 0.
2. Iterate with r until it reaches the end of the prices array.
3. Calculate the profit as prices[r] - prices[l].
4. If prices[r] < prices[l], update l to r because we found a new lower buying price.
5. Otherwise, update max_profit with the maximum of current profit and max_profit.
6. Increment r in each step.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches
The two-pointer / greedy approach allows us to find the optimal buying and sell days in a single pass instead of checking all pairs using a nested loop.

## Concepts Used
- Arrays
- Two Pointers
- Basic Traversal

## Sample Input
[7, 1, 5, 3, 6, 4]

## Sample Output
5