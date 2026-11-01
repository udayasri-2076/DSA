# Sort Colors - 75

## Problem Statement
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

## Approach 1: Brute Force
### Approach
Count the frequency of each color (0, 1, and 2) by iterating through the array once. Then, overwrite the array in a second pass by filling in the exact number of 0s, 1s, and 2s sequentially.
### Algorithm
1. Initialize three counter variables `count0`, `count1`, and `count2` to 0.
2. Traverse the array and increment the respective counter based on the element's value.
3. Traverse the array a second time, overwriting elements with 0 until `count0` is exhausted, then with 1 until `count1` is exhausted, and finally with 2 for the remainder.
### Time Complexity
O(n) where n is the number of elements in the array (requires two passes).
### Space Complexity
O(1) auxiliary space.

## Approach 2: Optimal
### Approach
Use the Dutch National Flag algorithm. Maintain three pointers: `low` for placing 0s, `high` for placing 2s, and `mid` for scanning through the array in a single pass.
### Algorithm
1. Initialize `low = 0`, `mid = 0`, and `high = n - 1`.
2. While `mid <= high`, check the value of `nums[mid]`:
   - If `nums[mid] == 0`, swap `nums[mid]` and `nums[low]`, then increment both `low` and `mid`.
   - If `nums[mid] == 1`, simply increment `mid`.
   - If `nums[mid] == 2`, swap `nums[mid]` and `nums[high]`, then decrement `high`.
3. Terminate when `mid` exceeds `high`, resulting in a fully sorted array.
### Time Complexity
O(n) since the array is traversed in a single pass.
### Space Complexity
O(1) as sorting is performed in-place using constant extra space.

## Comparison of Approaches
- **Brute Force**: Simple to understand and implement, but requires two passes over the data and extra bookkeeping for counts.
- **Optimal**: Highly efficient single-pass solution using three pointers, minimizing operations and adhering strictly to O(1) space constraints.

## Concepts Used
- Arrays
- Two Pointers
- Dutch National Flag Algorithm

## Sample Input
nums = [2, 0, 2, 1, 1, 0]

## Sample Output
[0, 0, 1, 1, 2, 2]