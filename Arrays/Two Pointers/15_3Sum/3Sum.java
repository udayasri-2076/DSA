import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Brute Force Approach:
        // Generate all possible triplets using three nested loops and check if their sum is zero, using a set or list check to filter duplicates.
        // Time Complexity: O(n^3)
        // Space Complexity: O(1) (excluding space for output)
        // Example nums: [-1, 0, 1, 2, -1, -4]
        List<List<Integer>> bruteRes = new ArrayList<>(); // bruteRes = [] (stores all valid triplets)
        int bruteN = nums.length; // bruteN = 6 (length of the array)
        for (int i = 0; i < bruteN; i++) { // i = 0, 1, 2... checking first element
            for (int j = i + 1; j < bruteN; j++) { // j = 1, 2, 3... checking second element
                for (int k = j + 1; k < bruteN; k++) { // k = 2, 3, 4... checking third element
                    if (nums[i] + nums[j] + nums[k] == 0) { // nums[0]+nums[1]+nums[2] == 0 (-1+0+1 == 0 -> true) | ...
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]); // triplet = [-1, 0, 1]
                        // (Duplicate checking omitted for brevity in brute force description)
                    }
                }
            }
        }
        // return bruteRes; // returns all valid unique triplets found by brute force

        // Optimal Approach:
        // Sort the array, fix one number, and use two pointers for the remaining two numbers to find sums equal to zero efficiently.
        // Time Complexity: O(n^2)
        // Space Complexity: O(1) auxiliary space (excluding output list)

        // Example nums: [-1, 0, 1, 2, -1, -4]
        List<List<Integer>> res = new ArrayList<>(); // res = [] (stores final result)
        int n = nums.length;                         // n = 6 (length of array)
        Arrays.sort(nums);                           // nums becomes [-4, -1, -1, 0, 1, 2] (sorted array)

        for (int i = 0; i < n - 2; i++) {            // i = 0, 1, 2... fixing the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue; // i = 2: nums[2] == nums[1] (-1 == -1 -> true, skips duplicate)

            int l = i + 1;                           // l = 1 | Iteration 2: l = 2 | Iteration 3: l = 4 (left pointer)
            int r = n - 1;                           // r = 5 | Iteration 2: r = 5 | Iteration 3: r = 5 (right pointer)

            while (l < r) {                          // Condition: Iteration 1: 1 < 5 (true) | Iteration 2: 2 < 5 (true) | Iteration 3: 4 < 5 (true)
                int sum = nums[i] + nums[l] + nums[r]; // Iteration 1: sum = -4 + (-1) + 2 = -3 | Iteration 2: sum = -1 + (-1) + 2 = 0 | Iteration 3: sum = -1 + 0 + 1 = 0

                if (sum == 0) {                      // Iteration 1: -3 == 0 (false) | Iteration 2: 0 == 0 (true) | Iteration 3: 0 == 0 (true)
                    res.add(Arrays.asList(nums[i], nums[l], nums[r])); // Iteration 2: res = [[-1, -1, 2]] | Iteration 3: res = [[-1, -1, 2], [-1, 0, 1]]

                    while (l < r && nums[l] == nums[l + 1]) l++; // Iteration 2: nums[1] == nums[2] (-1 == -1), l increments to 2 | Iteration 3: nums[4] == nums[1] (0 == 1 -> false)

                    while (l < r && nums[r] == nums[r - 1]) r--; // Iteration 2: nums[5] == nums[4] (2 == 1 -> false) | Iteration 3: nums[5] == nums[4] (1 == 0 -> false)

                    l++;                             // Iteration 2: l = 2 + 1 = 3 | Iteration 3: l = 4 + 1 = 5
                    r--;                             // Iteration 2: r = 5 - 1 = 4 | Iteration 3: r = 5 - 1 = 4
                }

                else if (sum > 0) {                  // Iteration 1: -3 > 0 (false)
                    r--;                             // not taken in this dry run example
                }

                else {                               // Iteration 1: taken (-3 < 0)
                    l++;                             // Iteration 1: l = 1 + 1 = 2
                }
            }
        }

        return res;                                  // returns [[-1, -1, 2], [-1, 0, 1]]
    }
}
