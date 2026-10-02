class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        # Brute Force Approach
        # Time Complexity: O(n^2)
        # Space Complexity: O(1)
        # Example dry-run with prices = [7, 1, 5, 3, 6, 4]
        # Target: Find max diff prices[r] - prices[l] where r > l using nested loops
        # n = len(prices) # n = 6
        # m = 0 # max profit initialized to 0
        # for l in range(n): # Outer loop for buy day
        #     for r in range(l + 1, n): # Inner loop for sell day
        #         diff = prices[r] - prices[l] # Calculate profit for current pair (l, r)
        #         m = max(diff, m) # Update max profit if current diff is greater
        # return m # Returns final max profit = 5

        # Optimal Approach: Two Pointers / Basic Traversal
        # Time Complexity: O(n)
        # Space Complexity: O(1)
        
        n = len(prices)
        
        l = 0        # left pointer (buy day), initially index 0, prices[0] = 7
        r = l + 1    # right pointer (sell day), initially index 1, prices[1] = 1
        m = 0        # max profit initialized to 0
        
        # Example dry-run with prices = [7, 1, 5, 3, 6, 4]
        # Target: Find max diff prices[r] - prices[l] where r > l
        
        while r < n:   # Loop runs while right pointer is within array bounds (n = 6)
            diff = prices[r] - prices[l] # Calculate profit for current day pair
            
            if prices[r] < prices[l]:
                # Condition: Found a lower price at r than our current buy price at l
                # Action: Update l to r (e.g., prices[1]=1 < prices[0]=7 -> l becomes 1)
                l = r
            else:
                # Condition: Selling price at r is greater than or equal to buying price at l
                # Action: Update m to be the maximum of current max (m) and new profit (diff)
                m = max(diff, m)
            
            r += 1 # Increment right pointer to evaluate the next day (r becomes r + 1)
            
        # Step-by-step trace for prices = [7, 1, 5, 3, 6, 4]:
        # Initial: l = 0, r = 1, m = 0
        # r = 1: diff = prices[1] - prices[0] = 1 - 7 = -6. prices[1] < prices[0] (1 < 7) is true -> l = 1. r becomes 2. m = 0.
        # r = 2: diff = prices[2] - prices[1] = 5 - 1 = 4. prices[2] < prices[1] (5 < 1) is false -> m = max(4, 0) = 4. r becomes 3. m = 4.
        # r = 3: diff = prices[3] - prices[1] = 3 - 1 = 2. prices[3] < prices[1] (3 < 1) is false -> m = max(2, 4) = 4. r becomes 4. m = 4.
        # r = 4: diff = prices[4] - prices[1] = 6 - 1 = 5. prices[4] < prices[1] (6 < 1) is false -> m = max(5, 4) = 5. r becomes 5. m = 5.
        # r = 5: diff = prices[5] - prices[1] = 4 - 1 = 3. prices[5] < prices[1] (4 < 1) is false -> m = max(3, 5) = 5. r becomes 6. m = 5.
        # r = 6: r < n (6 < 6) is false. Loop terminates.
        
        return m  # Returns final max profit = 5