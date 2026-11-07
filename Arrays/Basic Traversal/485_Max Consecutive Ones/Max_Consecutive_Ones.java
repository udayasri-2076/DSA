public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Brute Force Approach:
        // Check all possible subarrays or nested loops to find the maximum consecutive 1s (though simply iterating is efficient, a nested approach or redundant scan can represent brute force by re-checking subarrays, or we can use a nested check).
        // Time Complexity: O(n^2)
        // Space Complexity: O(1)
        // Example nums: [1, 1, 0, 1]
        int bruteN = nums.length; // bruteN = 4 (number of elements)
        int bruteMaxans = 0;      // bruteMaxans = 0 (stores max consecutive ones)
        for (int i = 0; i < bruteN; i++) { // i = 0, 1, 2, 3... checking start of subarrays
            int bruteCount = 0; // bruteCount = 0 (current streak)
            for (int j = i; j < bruteN; j++) { // j = 0, 1, 2, 3... extending subarray
                if (nums[j] == 1) { // Iteration 1: nums[0] == 1 (1 == 1 -> true) | Iteration 2: nums[1] == 1 (1 == 1 -> true) | Iteration 3: nums[2] == 1 (0 == 1 -> false)
                    bruteCount++; // Iteration 1: bruteCount = 0 + 1 = 1 | Iteration 2: bruteCount = 1 + 1 = 2
                } else {
                    break; // breaks streak on 0
                }
            }
            bruteMaxans = Math.max(bruteMaxans, bruteCount); // bruteMaxans = Math.max(0, 2) = 2
        }
        // return bruteMaxans; // returns max consecutive ones

        // Optimal Approach:
        // Iterate through the array, counting consecutive 1s. When a 0 is encountered, update the maximum count and reset the current count.
        // Time Complexity: O(n) where n is the number of elements in the array.
        // Space Complexity: O(1).
        // Example nums: [1, 1, 0, 1]
        int n = nums.length;        // n = 4 (number of elements)

        int maxans = 0;             // maxans = 0 (stores maximum consecutive ones)
        int count = 0;              // count = 0 (stores current consecutive ones)

        for (int j = 0; j < n; j++) { // j = 0, 1, 2, 3... checking each element
            if (nums[j] == 1) {     // Iteration 1: nums[0] == 1 (1 == 1 -> true) | Iteration 2: nums[1] == 1 (1 == 1 -> true) | Iteration 3: nums[2] == 1 (0 == 1 -> false) | Iteration 4: nums[3] == 1 (1 == 1 -> true)
                count++;            // Iteration 1: count = 0 + 1 = 1 | Iteration 2: count = 1 + 1 = 2 | Iteration 4: count = 0 + 1 = 1
            }

            else {                  // Iteration 3: taken (0 != 1)
                maxans = Math.max(maxans, count); // Iteration 3: maxans = Math.max(0, 2) = 2
                count = 0;          // Iteration 3: count = 0
            }
        }

        return Math.max(maxans, count); // returns Math.max(2, 1) = 2
    }
}