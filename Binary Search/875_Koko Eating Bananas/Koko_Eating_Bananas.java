class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Brute Force Approach:
        // Try every possible eating speed k starting from 1 up to the max pile size.
        // Time Complexity: O(M * N) where M is max pile size and N is number of piles.
        // Space Complexity: O(1)
        // Example piles: [3, 6, 7, 11], h = 8
        int bruteMax = 0;           // bruteMax = 0 (stores max pile size)
        for (int i = 0; i < piles.length; i++) { // i = 0, 1, 2, 3... finding maximum pile
            bruteMax = Math.max(bruteMax, piles[i]); // bruteMax = 11 after checking all piles
        }
        for (int bruteK = 1; bruteK <= bruteMax; bruteK++) { // bruteK = 1, 2, 3, 4... trying each speed
            long bruteHrs = 0;      // bruteHrs = 0 (hours needed at speed bruteK)
            for (int i = 0; i < piles.length; i++) { // i = 0, 1, 2, 3... calculating total hours
                bruteHrs += (piles[i] + bruteK - 1) / bruteK; // bruteK=1: hrs=27 | bruteK=2: hrs=14 | bruteK=3: hrs=10 | bruteK=4: hrs=8
            }
            if (bruteHrs <= h) {    // bruteK=4: 8 <= 8 (true)
                return bruteK;      // returns first valid eating speed 4
            }
        }
        // return 1; // returns 1 if loop completes without returning

        // Optimal Approach:
        // Use binary search on the answer range of eating speeds from 1 to max pile size.
        // Time Complexity: O(N log M) where M is max pile size and N is number of piles.
        // Space Complexity: O(1)
        // Example piles: [3, 6, 7, 11], h = 8
        int maxPile = 0;            // maxPile = 0 (stores max pile size)
        for (int i = 0; i < piles.length; i++) { // i = 0, 1, 2, 3... finding maximum pile
            maxPile = Math.max(maxPile, piles[i]); // maxPile = 11
        }

        int l = 1;                  // l = 1 (left pointer, minimum possible speed)
        int r = maxPile;            // r = 11 (right pointer, maximum possible speed)
        int ans = r;                // ans initialized to max speed 11

        while (l <= r) {            // Condition: Iteration 1: 1 <= 11 (true) | Iteration 2: 1 <= 5 (true) | Iteration 3: 4 <= 5 (true) | Iteration 4: 4 <= 4 (true)
            int mid = l + (r - l) / 2; // Iteration 1: mid = 6 | Iteration 2: mid = 3 | Iteration 3: mid = 4 | Iteration 4: mid = 4
            long hrs = 0;           // hrs to finish all piles at speed mid

            for (int i = 0; i < piles.length; i++) { // i = 0, 1, 2, 3... calculating total hours for speed mid
                hrs = hrs + (piles[i] + mid - 1) / mid; // Iteration 1: hrs = 6 | Iteration 2: hrs = 10 | Iteration 3: hrs = 8 | Iteration 4: hrs = 8
            }

            if (hrs <= h) {         // Iteration 1: 6 <= 8 (true) | Iteration 2: 10 <= 8 (false) | Iteration 3: 8 <= 8 (true) | Iteration 4: 8 <= 8 (true)
                ans = mid;          // Iteration 1: ans = 6 | Iteration 3: ans = 4 | Iteration 4: ans = 4
                r = mid - 1;        // Iteration 1: r = 6 - 1 = 5 | Iteration 3: r = 4 - 1 = 3 | Iteration 4: r = 4 - 1 = 3
            }

            else {                  // Iteration 2: taken (10 > 8)
                l = mid + 1;        // Iteration 2: l = 3 + 1 = 4
            }
        }

        return ans;                 // returns minimum eating speed 4 after binary search completes
    }
}