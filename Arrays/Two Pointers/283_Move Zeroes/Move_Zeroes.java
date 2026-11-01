public class Solution {
    public void moveZeroes(int[] nums) {
        // Brute Force Approach:
        // Use a temporary array to store all non-zero elements, then copy them back and fill the rest with zeros.
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        // Example nums: [0, 1, 0, 3, 12]
        int bruteN = nums.length; // bruteN = 5 (number of elements)
        int[] bruteTemp = new int[bruteN]; // bruteTemp = [0, 0, 0, 0, 0]
        int bruteIdx = 0; // bruteIdx = 0 (pointer for temp array)
        for (int i = 0; i < bruteN; i++) { // i = 0, 1, 2, 3, 4... checking each element
            if (nums[i] != 0) { // nums[0] != 0 (0 != 0 -> false), nums[1] != 0 (1 != 0 -> true), nums[2] != 0 (0 != 0 -> false), nums[3] != 0 (3 != 0 -> true), nums[4] != 0 (12 != 0 -> true)
                bruteTemp[bruteIdx] = nums[i]; // Iteration 1: bruteTemp[0] = 1 | Iteration 2: bruteTemp[1] = 3 | Iteration 3: bruteTemp[2] = 12
                bruteIdx++; // Iteration 1: bruteIdx = 1 | Iteration 2: bruteIdx = 2 | Iteration 3: bruteIdx = 3
            }
        }
        for (int i = 0; i < bruteN; i++) { // i = 0, 1, 2, 3, 4... copying back
            if (i < bruteIdx) { // i < 3: copying non-zero elements
                nums[i] = bruteTemp[i]; // nums[0] = 1, nums[1] = 3, nums[2] = 12
            } else { // i >= 3: filling remaining with zeros
                nums[i] = 0; // nums[3] = 0, nums[4] = 0
            }
        }
        // return; // returns modified nums array: [1, 3, 12, 0, 0]

        // Optimal Approach:
        // Use a two-pointer approach where 'l' tracks the insertion position for non-zero elements and 'r' iterates through the array.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example nums: [0, 1, 0, 3, 12]
        int n = nums.length;      // n = 5 (number of elements)

        int l = 0;                // l = 0 (left pointer for non-zero placement)

        for (int r = 0; r < n; r++) { // Condition: Iteration 1: 0 < 5 (true) | Iteration 2: 1 < 5 (true) | Iteration 3: 2 < 5 (true) | Iteration 4: 3 < 5 (true) | Iteration 5: 4 < 5 (true)
            if (nums[r] != 0) {   // Iteration 1: nums[0] != 0 (0 != 0 -> false) | Iteration 2: nums[1] != 0 (1 != 0 -> true) | Iteration 3: nums[2] != 0 (0 != 0 -> false) | Iteration 4: nums[3] != 0 (3 != 0 -> true) | Iteration 5: nums[4] != 0 (12 != 0 -> true)
                int temp = nums[r]; // Iteration 2: temp = 1 | Iteration 4: temp = 3 | Iteration 5: temp = 12
                nums[r] = nums[l];  // Iteration 2: nums[1] = nums[0] (0) | Iteration 4: nums[3] = nums[1] (0) | Iteration 5: nums[4] = nums[2] (0)
                nums[l] = temp;     // Iteration 2: nums[0] = 1 | Iteration 4: nums[1] = 3 | Iteration 5: nums[2] = 12

                l++;              // Iteration 2: l = 0 + 1 = 1 | Iteration 4: l = 1 + 1 = 2 | Iteration 5: l = 2 + 1 = 3
            }
        }
    }
}