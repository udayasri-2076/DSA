# Product of Array Except Self - LeetCode 238

## Problem Statement
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]. The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer. You must write an algorithm that runs in O(n) time and without using the division operation.

## Approach 1: Brute Force
### Approach
Iterate through each element of the array using nested loops and compute the product of all other elements by skipping the current index.
### Algorithm
1. Initialize a result array of the same size as input nums.
2. Use an outer loop to pick each element at index i.
3. Use an inner loop to iterate through all elements at index j, multiplying them together if i != j.
4. Store the computed product in the result array and return it.
### Time Complexity
O(n^2) where n is the number of elements in the array.
### Space Complexity
O(n) to store the result array.

## Approach 2: Optimal Approach
### Approach
Avoid division and reduce time complexity to O(n) by breaking the problem into prefix products and suffix products. We first compute prefix products for each element in a forward pass, and then multiply them by suffix products in a backward pass.
### Algorithm
1. Initialize a result array and set the first element to 1.
2. Iterate from left to right to compute the prefix product for each index and store it in the result array.
3. Initialize a suffix variable to 1.
4. Iterate from right to left, multiplying the existing value in the result array by the suffix product, then updating the suffix product by multiplying it with the current element of nums.
5. Return the final result array.
### Time Complexity
O(n)
### Space Complexity
O(1) auxiliary space (excluding the output array).

## Comparison of Approaches
- Brute Force uses nested loops, resulting in a slow O(n^2) time complexity, which is inefficient for large arrays.
- Optimal Approach eliminates nested loops by utilizing prefix and suffix product passes, achieving an optimal O(n) time complexity and O(1) auxiliary space without using division.

## Concepts Used
- Arrays
- Prefix Sum / Prefix Product Pattern

## Sample Input
nums = [1, 2, 3, 4]

## Sample Output
[24, 12, 8, 6]