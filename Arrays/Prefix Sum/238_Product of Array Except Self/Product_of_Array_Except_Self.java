public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Brute Force Approach:
        // Iterate through each element and calculate the product of all other elements using nested loops.
        // Time Complexity: O(n^2) where n is the number of elements in the array.
        // Space Complexity: O(n) to store the result array.
        // Example nums: [1, 2, 3, 4]
        int bruteN = nums.length; // bruteN = 4 (number of elements)
        int[] bruteRes = new int[bruteN]; // bruteRes = [0, 0, 0, 0]
        for (int i = 0; i < bruteN; i++) { // i = 0, 1, 2, 3 (outer loop index)
            int bruteProd = 1; // bruteProd = 1 (product accumulator)
            for (int j = 0; j < bruteN; j++) { // j = 0, 1, 2, 3 (inner loop index)
                if (i != j) { // i != j (skipping self index)
                    bruteProd = bruteProd * nums[j]; // Iteration 1: bruteProd = 1 * 2 = 2 | Iteration 2: bruteProd = 2 * 3 = 6 | Iteration 3: bruteProd = 6 * 4 = 24
                }
            }
            bruteRes[i] = bruteProd; // bruteRes[0] = 24 | bruteRes[1] = 12 | bruteRes[2] = 8 | bruteRes[3] = 6
        }
        // return bruteRes; // returns result array if brute force is used

        // Optimal Approach:
        // Compute prefix products in a forward pass and multiply by suffix products in a backward pass.
        // Time Complexity: O(n)
        // Space Complexity: O(1) auxiliary space (excluding result array)

        // Example nums: [1, 2, 3, 4]
        int n = nums.length;      // n = 4 (number of elements)
        int[] res = new int[n];   // res = [0, 0, 0, 0]

        res[0] = 1;               // res[0] = 1 (base case for prefix product)
        for (int i = 1; i < n; i++) { // Condition: Iteration 1: 1 < 4 (true) | Iteration 2: 2 < 4 (true) | Iteration 3: 3 < 4 (true)
            res[i] = res[i - 1] * nums[i - 1]; // Iteration 1: res[1] = 1 * 1 = 1 | Iteration 2: res[2] = 1 * 2 = 2 | Iteration 3: res[3] = 2 * 3 = 6
        }

        int suffix = 1;           // suffix = 1 (base case for suffix product)
        for (int i = n - 1; i >= 0; i--) { // Condition: Iteration 1: 3 >= 0 (true) | Iteration 2: 2 >= 0 (true) | Iteration 3: 1 >= 0 (true) | Iteration 4: 0 >= 0 (true)
            res[i] = res[i] * suffix; // Iteration 1: res[3] = 6 * 1 = 6 | Iteration 2: res[2] = 2 * 4 = 8 | Iteration 3: res[1] = 1 * 12 = 12 | Iteration 4: res[0] = 1 * 24 = 24
            suffix = suffix * nums[i]; // Iteration 1: suffix = 1 * 4 = 4 | Iteration 2: suffix = 4 * 3 = 12 | Iteration 3: suffix = 12 * 2 = 24 | Iteration 4: suffix = 24 * 1 = 24
        }

        return res;               // returns res = [24, 12, 8, 6]
    }
}