class Solution {
    // Brute Force Approach
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    // Explanation: Traverse the array from left to right to find the first occurrence
    // and from right to left to find the last occurrence.
    public int[] searchRangeBruteForce(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (first == -1) first = i;
                last = i;
            }
        }
        return new int[]{first, last};
    }

    // Optimal Approach
    // Example: nums = [5, 7, 7, 8, 8, 10], target = 8
    public int[] searchRange(int[] nums, int target) {
        // Step 1: Find the first (leftmost) occurrence of the target
        int first = findFirst(nums, target); // first = 3
        
        // Step 2: Find the last (rightmost) occurrence of the target
        int last = findLast(nums, target);   // last = 4
        
        // Step 3: Return both positions as a new array
        return new int[]{first, last};       // returns [3, 4]
    }

    // Helper method to locate the first occurrence
    private int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1; // l = 0, r = 5
        int ans = -1;

        while (l <= r) { // Loop 1: l = 0, r = 5, mid = 2
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) { // nums[2] = 7 == 8 is false
                ans = mid;
                r = mid - 1;
            }
            else if (nums[mid] < target) { // 7 < 8 is true
                l = mid + 1; // l becomes 3, r remains 5
            }
            else {
                r = mid - 1;
            }
        }
        
        // Continuing dry run for findFirst:
        // Loop 2: l = 3, r = 5, mid = 4, nums[4] = 8 == 8 (true) -> ans = 4, r = 3
        // Loop 3: l = 3, r = 3, mid = 3, nums[3] = 8 == 8 (true) -> ans = 3, r = 2
        // Loop 4: l = 3, r = 2 -> l <= r is false, exits loop.
        return ans; // returns 3
    }

    // Helper method to locate the last occurrence
    private int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1; // l = 0, r = 5
        int ans = -1;

        while (l <= r) { // Loop 1: l = 0, r = 5, mid = 2
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) { // nums[2] = 7 == 8 is false
                ans = mid;
                l = mid + 1;
            }
            else if (nums[mid] < target) { // 7 < 8 is true
                l = mid + 1; // l becomes 3, r remains 5
            }
            else {
                r = mid - 1;
            }
        }
        
        // Continuing dry run for findLast:
        // Loop 2: l = 3, r = 5, mid = 4, nums[4] = 8 == 8 (true) -> ans = 4, l = 5
        // Loop 3: l = 5, r = 5, mid = 5, nums[5] = 10 < 8 (false), 10 > 8 -> r = 4
        // Loop 4: l = 5, r = 4 -> l <= r is false, exits loop.
        return ans; // returns 4
    }
}
// Optimal Time Complexity: O(log N) for two separate binary searches
// Optimal Space Complexity: O(1) constant auxiliary space