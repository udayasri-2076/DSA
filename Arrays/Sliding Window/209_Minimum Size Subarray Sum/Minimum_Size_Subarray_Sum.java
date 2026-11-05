public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Brute Force Approach:
        // Check every possible subarray to find the minimum length whose sum is greater than or equal to target.
        // Time Complexity: O(n^2)
        // Space Complexity: O(1)
        // Example nums: [2, 3, 1, 2, 4, 3], target = 7
        int bruteN = nums.length;                 // bruteN = 6 (number of elements)
        int bruteAns = Integer.MAX_VALUE;         // bruteAns = 2147483647 (initial max value)
        for (int i = 0; i < bruteN; i++) {        // i = 0, 1, 2, 3, 4, 5... starting index of subarray
            int bruteSum = 0;                     // bruteSum = 0 (sum of current subarray)
            for (int j = i; j < bruteN; j++) {    // j = 0, 1, 2... ending index of subarray
                bruteSum += nums[j];              // Iteration i=0: bruteSum = 0 + 2 = 2, 5, 6, 8... | Iteration i=1: bruteSum = 0 + 3 = 3, 4, 6, 10...
                if (bruteSum >= target) {         // Iteration i=0, j=3: 8 >= 7 (true) | Iteration i=1, j=4: 10 >= 7 (true)
                    bruteAns = Math.min(bruteAns, j - i + 1); // Iteration i=0, j=3: bruteAns = min(2147483647, 3 - 0 + 1) = 4 | Iteration i=1, j=4: bruteAns = min(4, 4 - 1 + 1) = 4
                    break;                        // break inner loop once target is met for current starting index
                }
            }
        }
        // return bruteAns == Integer.MAX_VALUE ? 0 : bruteAns; // returns 2 if brute force completes

        // Optimal Approach:
        // Use a sliding window with two pointers (l and r) to dynamically adjust the window size.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example nums: [2, 3, 1, 2, 4, 3], target = 7
        int n = nums.length;                      // n = 6 (number of elements)

        int ans = Integer.MAX_VALUE;              // ans = 2147483647 (minimum length found)
        int sum = 0;                              // sum = 0 (current window sum)

        int l = 0;                                // l = 0 (left pointer of sliding window)
        for (int r = 0; r < n; r++) {             // r = 0, 1, 2, 3, 4, 5 (right pointer expanding window)

            sum = sum + nums[r];                  // Iteration 1: sum = 0 + 2 = 2 | Iteration 2: sum = 2 + 3 = 5 | Iteration 3: sum = 5 + 1 = 6 | Iteration 4: sum = 6 + 2 = 8 | Iteration 5: sum = 3 + 4 = 7 | Iteration 6: sum = 3 + 3 = 6

            while (sum >= target) {               // Condition: Iteration 4: 8 >= 7 (true) | Iteration 5: 7 >= 7 (true)

                ans = Math.min(ans, r - l + 1);   // Iteration 4: ans = min(2147483647, 3 - 0 + 1) = 4 | Iteration 5: ans = min(4, 4 - 1 + 1) = 4
                sum = sum - nums[l];              // Iteration 4: sum = 8 - nums[0] (8 - 2 = 6) | Iteration 5: sum = 7 - nums[1] (7 - 3 = 4)
                l++;                              // Iteration 4: l = 0 + 1 = 1 | Iteration 5: l = 1 + 1 = 2

            }                                     // Iteration 4: loop ends because 6 >= 7 is false | Iteration 5: loop ends because 4 >= 7 is false
        }

        return ans == Integer.MAX_VALUE ? 0 : ans; // returns 2
    }
}