public class Solution {
    public int removeElement(int[] nums, int val) {
        // Brute Force Approach:
        // Create a new array or list to store elements not equal to val, then copy them back to nums.
        // Time Complexity: O(n) where n is the number of elements in the array.
        // Space Complexity: O(n) due to extra storage for elements.
        // Example nums: [3, 2, 2, 3], val = 3
        int[] brute_temp = new int[nums.length]; // brute_temp = [0, 0, 0, 0] (temporary storage)
        int brute_k = 0;                          // brute_k = 0 (count of non-val elements)
        for (int i = 0; i < nums.length; i++) {   // i = 0, 1, 2, 3... checking each element in the array
            if (nums[i] != val) {                 // Iteration 1: nums[0] != 3 (3 != 3 -> false) | Iteration 2: nums[1] != 3 (2 != 3 -> true) | Iteration 3: nums[2] != 3 (2 != 3 -> true) | Iteration 4: nums[3] != 3 (3 != 3 -> false)
                brute_temp[brute_k] = nums[i];    // Iteration 2: brute_temp[0] = nums[1] (2) | Iteration 3: brute_temp[1] = nums[2] (2)
                brute_k++;                        // Iteration 2: brute_k = 1 | Iteration 3: brute_k = 2
            }
        }
        for (int i = 0; i < brute_k; i++) {       // i = 0, 1... copying back valid elements
            nums[i] = brute_temp[i];              // Iteration 1: nums[0] = 2 | Iteration 2: nums[1] = 2
        }
        // return brute_k; // returns brute_k = 2

        // Optimal Approach:
        // Use a two-pointer approach where one pointer iterates through the array and another pointer keeps track of the position to place the next non-val element.
        // Time Complexity: O(n) where n is the number of elements in the array.
        // Space Complexity: O(1).
        // Example nums: [3, 2, 2, 3], val = 3
        int k = 0;                                // k = 0 (pointer for the next valid element position)
        for (int i = 0; i < nums.length; i++) {   // i = 0, 1, 2, 3... checking each element in the array
            if (nums[i] != val) {                 // Iteration 1: nums[0] != 3 (3 != 3 -> false) | Iteration 2: nums[1] != 3 (2 != 3 -> true) | Iteration 3: nums[2] != 3 (2 != 3 -> true) | Iteration 4: nums[3] != 3 (3 != 3 -> false)
                nums[k] = nums[i];                // Iteration 2: nums[0] = nums[1] ([2, 2, 2, 3]) | Iteration 3: nums[1] = nums[2] ([2, 2, 2, 3])
                k++;                              // Iteration 2: k = 0 + 1 = 1 | Iteration 3: k = 1 + 1 = 2
            }
        }
        return k;                                 // returns k = 2 (number of elements not equal to val)
    }
}