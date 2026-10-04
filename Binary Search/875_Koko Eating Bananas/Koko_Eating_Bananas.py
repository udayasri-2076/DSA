class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        # Brute Force Approach:
        # Try every possible eating speed k starting from 1 up to the max pile size.
        # Time Complexity: O(M * N) where M is max pile size and N is number of piles.
        # Space Complexity: O(1)
        # Example piles: [3, 6, 7, 11], h = 8
        brute_max = max(piles)      # brute_max = 11 (stores max pile size)
        for brute_k in range(1, brute_max + 1):  # brute_k = 1, 2, 3, 4... trying each speed
            brute_hrs = 0           # brute_hrs = 0 (hours needed at speed brute_k)
            for pile in piles:
                brute_hrs += (pile + brute_k - 1) // brute_k  # brute_k=1: hrs=27 | brute_k=2: hrs=14 | brute_k=3: hrs=10 | brute_k=4: hrs=8
            if brute_hrs <= h:      # brute_k=4: 8 <= 8 (True)
                return brute_k      # returns first valid eating speed 4
        # return 1 # returns 1 if loop completes without returning

        # Optimal Approach:
        # Use binary search on the answer range of eating speeds from 1 to max pile size.
        # Time Complexity: O(N log M) where M is max pile size and N is number of piles.
        # Space Complexity: O(1)
        # Example piles: [3, 6, 7, 11], h = 8
        max_pile = max(piles)       # max_pile = 11 (stores max pile size)

        l = 1                       # l = 1 (left pointer, minimum possible speed)
        r = max_pile                # r = 11 (right pointer, maximum possible speed)
        ans = r                     # ans initialized to max speed 11

        while l <= r:               # Condition: Iteration 1: 1 <= 11 (True) | Iteration 2: 1 <= 5 (True) | Iteration 3: 4 <= 5 (True) | Iteration 4: 4 <= 4 (True)
            mid = l + (r - l) // 2  # Iteration 1: mid = 6 | Iteration 2: mid = 3 | Iteration 3: mid = 4 | Iteration 4: mid = 4
            hrs = 0                 # hrs to finish all piles at speed mid

            for pile in piles:
                hrs += (pile + mid - 1) // mid  # Iteration 1: hrs = 6 | Iteration 2: hrs = 10 | Iteration 3: hrs = 8 | Iteration 4: hrs = 8

            if hrs <= h:            # Iteration 1: 6 <= 8 (True) | Iteration 2: 10 <= 8 (False) | Iteration 3: 8 <= 8 (True) | Iteration 4: 8 <= 8 (True)
                ans = mid           # Iteration 1: ans = 6 | Iteration 3: ans = 4 | Iteration 4: ans = 4
                r = mid - 1         # Iteration 1: r = 6 - 1 = 5 | Iteration 3: r = 4 - 1 = 3 | Iteration 4: r = 4 - 1 = 3

            else:                   # Iteration 2: taken (10 > 8)
                l = mid + 1         # Iteration 2: l = 3 + 1 = 4

        return ans                  # returns minimum eating speed 4 after binary search completes