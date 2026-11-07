class Solution:
    def numSubarrayProductLessThanK(self, nums, k):
        # Brute Force Approach:
        # Generate all possible subarrays, compute their product, and count if it is strictly less than k.
        # Time Complexity: O(n^2)
        # Space Complexity: O(1)
        # Example nums: [10, 5, 2, 6], k = 100
        brute_count = 0             # brute_count = 0 (total valid subarrays)
        brute_n = len(nums)         # brute_n = 4 (length of array)
        for i in range(brute_n):  # i = 0, 1, 2, 3 (starting index of subarray)
            brute_prod = 1          # brute_prod = 1 (product of current subarray)
            for j in range(i, brute_n):  # j = 0..3, 1..3, 2..3, 3..3 (ending index of subarray)
                brute_prod = brute_prod * nums[j]  # Iteration 1: 1 * 10 = 10 | Iteration 2: 10 * 5 = 50 | Iteration 3: 50 * 2 = 100
                if brute_prod < k:  # Iteration 1: 10 < 100 (True) | Iteration 2: 50 < 100 (True) | Iteration 3: 100 < 100 (False)
                    brute_count += 1  # Iteration 1: brute_count = 0 + 1 = 1 | Iteration 2: brute_count = 1 + 1 = 2
                else:
                    break           # Iteration 3: break out of inner loop since product reached or exceeded k
        # return brute_count  # returns brute-force result if chosen

        # Optimal Approach:
        # Use a sliding window to maintain a product strictly less than k, adding valid subarray counts dynamically.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example nums: [10, 5, 2, 6], k = 100
        n = len(nums)               # n = 4 (length of array)

        if k <= 1: 
            return 0                # k <= 1 (100 <= 1 -> False)

        l = 0                       # l = 0 (left pointer)
        count = 0                   # count = 0 (valid subarrays count)

        prod = 1                    # prod = 1 (current window product)
        for r in range(n):          # Condition: Iteration 1: 0 < 4 (True) | Iteration 2: 1 < 4 (True) | Iteration 3: 2 < 4 (True) | Iteration 4: 3 < 4 (True)
            prod = prod * nums[r]   # Iteration 1: 1 * 10 = 10 | Iteration 2: 10 * 5 = 50 | Iteration 3: 50 * 2 = 100 | Iteration 4: 20 * 6 = 120

            while prod >= k:        # Iteration 1: 10 >= 100 (False) | Iteration 2: 50 >= 100 (False) | Iteration 3: 100 >= 100 (True) | Iteration 4: 120 >= 100 (True)
                prod = prod // nums[l]  # Iteration 3: 100 // 10 = 10 | Iteration 4: 120 // 5 = 24
                l += 1              # Iteration 3: l = 0 + 1 = 1 | Iteration 4: l = 1 + 1 = 2
            
            count += r - l + 1      # Iteration 1: count = 0 + (0 - 0 + 1) = 1 | Iteration 2: count = 1 + (1 - 0 + 1) = 3 | Iteration 3: count = 3 + (2 - 1 + 1) = 5 | Iteration 4: count = 5 + (3 - 2 + 1) = 8

        return count                # returns final count = 8