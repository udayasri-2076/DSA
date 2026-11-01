public class Solution {
    public int maxArea(int[] height) {
        // Brute Force Approach:
        // Iterate through every possible pair of lines and calculate the area formed by them, keeping track of the maximum.
        // Time Complexity: O(n^2) where n is the number of elements in the height array.
        // Space Complexity: O(1).
        // Example height: [1, 8, 6, 2, 5, 4, 8, 3, 7]
        int bruteN = height.length; // bruteN = 9 (number of elements)
        int bruteMaxArea = 0; // bruteMaxArea = 0 (stores max area)
        for (int i = 0; i < bruteN; i++) { // i = 0, 1, 2... checking left line
            for (int j = i + 1; j < bruteN; j++) { // j = 1, 2, 3... checking right line
                int bruteH = Math.min(height[i], height[j]); // height[0] vs height[1] = Math.min(1, 8) = 1
                int bruteWidth = j - i; // bruteWidth = 1 - 0 = 1
                int bruteArea = bruteH * bruteWidth; // bruteArea = 1 * 1 = 1
                bruteMaxArea = Math.max(bruteMaxArea, bruteArea); // bruteMaxArea = Math.max(0, 1) = 1
            }
        }
        // return bruteMaxArea; // returns max area found by brute force

        // Optimal Approach:
        // Use two pointers starting at both ends and move the pointer pointing to the shorter line inward to maximize area.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example height: [1, 8, 6, 2, 5, 4, 8, 3, 7]
        int n = height.length;    // n = 9 (number of elements)

        int l = 0;                // l = 0 (left pointer)
        int r = n - 1;            // r = 9 - 1 = 8 (right pointer)
        int maxarea = 0;          // maxarea = 0 (maximum area found so far)

        while (l <= r) {          // Condition: Iteration 1: 0 <= 8 (true) | Iteration 2: 1 <= 8 (true) | Iteration 3: 1 <= 7 (true)
            int h = Math.min(height[l], height[r]);   // Iteration 1: Math.min(height[0], height[8]) = Math.min(1, 7) = 1 | Iteration 2: Math.min(height[1], height[8]) = Math.min(8, 7) = 7 | Iteration 3: Math.min(height[1], height[7]) = Math.min(8, 3) = 3
            int width = r - l;    // Iteration 1: width = 8 - 0 = 8 | Iteration 2: width = 8 - 1 = 7 | Iteration 3: width = 7 - 1 = 6
            int area = h * width; // Iteration 1: area = 1 * 8 = 8 | Iteration 2: area = 7 * 7 = 49 | Iteration 3: area = 3 * 6 = 18
            maxarea = Math.max(maxarea, area);   // Iteration 1: maxarea = Math.max(0, 8) = 8 | Iteration 2: maxarea = Math.max(8, 49) = 49 | Iteration 3: maxarea = Math.max(49, 18) = 49

            if (height[l] < height[r]) {   // Iteration 1: height[0] < height[8] (1 < 7 -> true) | Iteration 2: height[1] < height[8] (8 < 7 -> false) | Iteration 3: height[1] < height[7] (8 < 3 -> false)
                l++;              // Iteration 1: l = 0 + 1 = 1
            }

            else {                // Iteration 2: taken (8 >= 7) | Iteration 3: taken (8 >= 3)
                r--;              // Iteration 2: r = 8 - 1 = 7 | Iteration 3: r = 7 - 1 = 6
            }
        }

        return maxarea;           // returns the maximum area found
    }
}