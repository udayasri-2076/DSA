# Move Zeroes - LeetCode 283

## Problem Statement
Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

## Approach 1: Brute Force
### Approach
Use a temporary storage container to collect all non-zero elements from the array. Afterwards, iterate through the original array to overwrite the elements using the stored non-zero values, filling any remaining indices with zeros.

### Algorithm
1. Initialize a temporary list and a pointer to track non-zero elements.
2. Iterate through the array and append any non-zero elements to the temporary list.
3. Iterate through the array a second time to place the non-zero elements back from the temporary list.
4. Fill the remaining positions of the array with zeros.

### Time Complexity
O(n) where n is the number of elements in the array.

### Space Complexity
O(n) due to the usage of extra space for the temporary list/array.

## Approach 2: Optimal
### Approach
Maintain two pointers: a left pointer (`l`) pointing to the position where the next non-zero element should be placed, and a right pointer (`r`) scanning through the array. Whenever a non-zero element is encountered at `r`, swap it with the element at `l` and advance `l`.

### Algorithm
1. Initialize pointer `l` to 0.
2. Iterate pointer `r` from 0 to `n - 1`.
3. If `nums[r] != 0`, swap `nums[r]` with `nums[l]` and increment `l` by 1.
4. Continue until the end of the array is reached.

### Time Complexity
O(n) since we iterate through the array once with the right pointer.

### Space Complexity
O(1) because the operations are performed in-place.

## Comparison of Approaches
- **Brute Force**: Simple to conceptualize but requires O(n) extra space to store elements temporarily.
- **Optimal**: Achieves the same O(n) time complexity while reducing the space complexity to O(1) through in-place swapping using two pointers.

## Concepts Used
- Arrays
- Two Pointers
- In-place Modification

## Sample Input
nums = [0, 1, 0, 3, 12]

## Sample Output
[1, 3, 12, 0, 0]