public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Brute Force Approach:
        // Iterate through every possible pair of numbers to find two numbers that add up to the target.
        // Time Complexity: O(n^2) where n is the number of elements in the array.
        // Space Complexity: O(1).
        // Example numbers: [2, 7, 11, 15], target = 9
        int bruteN = numbers.length; // bruteN = 4 (number of elements)
        for (int bruteI = 0; bruteI < bruteN; bruteI++) { // bruteI = 0, 1, 2... checking first number
            for (int bruteJ = bruteI + 1; bruteJ < bruteN; bruteJ++) { // bruteJ = 1, 2, 3... checking second number
                if (numbers[bruteI] + numbers[bruteJ] == target) { // numbers[0] + numbers[1] == 9 (2 + 7 == 9 -> true)
                    return new int[]{bruteI + 1, bruteJ + 1}; // returns 1-based indices [1, 2]
                }
            }
        }
        // return new int[]{-1, -1}; // returns [-1, -1] if no pair is found

        // Optimal Approach:
        // Use two pointers starting at both ends of the sorted array and move them inward based on the sum.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example numbers: [2, 7, 11, 15], target = 9
        int n = numbers.length;    // n = 4 (number of elements)

        int l = 0;                 // l = 0 (left pointer starting at index 0)
        int r = n - 1;             // r = 4 - 1 = 3 (right pointer starting at index 3)

        while (l < r) {            // Condition: Iteration 1: 0 < 3 (true) | Iteration 2: 0 < 2 (true)
            int sum = numbers[l] + numbers[r]; // Iteration 1: sum = numbers[0] + numbers[3] = 2 + 15 = 17 | Iteration 2: sum = numbers[0] + numbers[2] = 2 + 11 = 13

            if (sum == target) {   // Iteration 1: 17 == 9 (false) | Iteration 2: 13 == 9 (false) 
                return new int[]{l + 1, r + 1};
            }
            else if (sum > target) { // Iteration 1: taken (17 > 9) | Iteration 2: taken (13 > 9)
                r--;               // Iteration 1: r = 3 - 1 = 2 | Iteration 2: r = 2 - 1 = 1
            }
            else {                 // Iteration 3: taken (9 < 9 -> false)
                l++;               // Iteration 3: l = 0 + 1 = 1 (and then numbers[1] + numbers[1] check -> 7 + 7 = 14 > 9 -> r=0 -> loop terminates)
            }
        }

        return new int[]{-1, -1};
    }
}