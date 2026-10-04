# Koko Eating Bananas - 875

## Problem Statement
Koko loves to eat bananas. There are n piles of bananas, the i-th pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

## Approach 1: Binary Search
### Approach
The problem asks us to find the minimum eating speed k such that Koko can eat all the bananas within h hours. The search space for k lies between 1 (minimum possible speed) and the maximum pile size in the array (maximum sensible speed because eating faster than the largest pile does not save extra time). We can use binary search to efficiently find this minimum speed.

### Algorithm
1. Initialize the search space for speed: `l = 1` and `r = max(piles)`.
2. Set `ans` to `r`.
3. While `l <= r`, calculate the middle speed `mid = l + (r - l) / 2`.
4. Iterate through each pile and compute the total hours required to finish all piles at the speed `mid` using `(pile + mid - 1) / mid`.
5. If the total hours `hrs <= h`, it means `mid` is a valid speed. Record `ans = mid` and search the left half by setting `r = mid - 1` to find a potentially smaller valid speed.
6. If `hrs > h`, `mid` is too slow. Search the right half by setting `l = mid + 1`.
7. Return `ans` once the search completes.

### Time Complexity
O(N log M), where N is the number of piles and M is the maximum number of bananas in a pile. The binary search runs in log M iterations, and in each iteration, we iterate through all N piles.

### Space Complexity
O(1), as we only use a few variables for pointers and calculations.

## Comparison of Approaches
- **Brute Force:** Would check every possible eating speed from 1 to max(piles), taking O(M * N) time, which can result in Time Limit Exceeded when the maximum pile size is very large.
- **Binary Search (Optimal):** Drastically reduces the search time to O(N log M) by discarding half of the candidate speeds in each step.

## Concepts Used
- Binary Search on Answer
- Array Iteration
- Mathematical Ceiling Division

## Sample Input
piles = [3, 6, 7, 11]
h = 8

## Sample Output
4
