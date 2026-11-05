class Solution:
    def minSubArrayLen(self, target: int, nums: list[int]) -> int:
        # Brute Force Approach:
        # Check every possible subarray to find the minimum length whose sum is greater than or equal to target.
        # Time Complexity: O(n^2)
        # Space Complexity: O(1)
        # Example nums: [2, 3, 1, 2, 4, 3], target = 7
        brute_n = len(nums)                       # brute_n = 6 (number of elements)
        brute_ans = float('inf')                  # brute_ans = inf (initial max value)
        for i in range(brute_n):                  # i = 0, 1, 2, 3, 4, 5... starting index of subarray
            brute_sum = 0                         # brute_sum = 0 (sum of current subarray)
            for j in range(i, brute_n):           # j = 0, 1, 2... ending index of subarray
                brute_sum += nums[j]              # Iteration i=0: brute_sum = 0 + 2 = 2, 5, 6, 8... | Iteration i=1: brute_sum = 0 + 3 = 3, 4, 6, 10...
                if brute_sum >= target:           # Iteration i=0, j=3: 8 >= 7 (True) | Iteration i=1, j=4: 10 >= 7 (True)
                    brute_ans = min(brute_ans, j - i + 1)  # Iteration i=0, j=3: brute_ans = min(inf, 3 - 0 + 1) = 4 | Iteration i=1, j=4: brute_ans = min(4, 4 - 1 + 1) = 4
                    break                         # break inner loop once target is met for current starting index
        # return 0 if brute_ans == float('inf') else brute_ans  # returns 2 if brute force completes

        # Optimal Approach:
        # Use a sliding window with two pointers (l and r) to dynamically adjust the window size.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example nums: [2, 3, 1, 2, 4, 3], target = 7
        n = len(nums)                             # n = 6 (number of elements)

        ans = float('inf')                        # ans = inf (minimum length found)
        sum_val = 0                               # sum_val = 0 (current window sum)

        l = 0                                     # l = 0 (left pointer of sliding window)
        for r in range(n):                        # r = 0, 1, 2, 3, 4, 5 (right pointer expanding window)

            sum_val = sum_val + nums[r]           # Iteration 1: sum_val = 0 + 2 = 2 | Iteration 2: sum_val = 2 + 3 = 5 | Iteration 3: sum_val = 5 + 1 = 6 | Iteration 4: sum_val = 6 + 2 = 8 | Iteration 5: sum_val = 3 + 4 = 7 | Iteration 6: sum_val = 3 + 3 = 6

            while sum_val >= target:              # Condition: Iteration 4: 8 >= 7 (True) | Iteration 5: 7 >= 7 (True)

                ans = min(ans, r - l + 1)         # Iteration 4: ans = min(inf, 3 - 0 + 1) = 4 | Iteration 5: ans = min(4, 4 - 1 + 1) = 4
                sum_val = sum_val - nums[l]       # Iteration 4: sum_val = 8 - nums[0] (8 - 2 = 6) | Iteration 5: sum_val = 7 - nums[1] (7 - 3 = 4)
                l = l + 1                         # Iteration 4: l = 0 + 1 = 1 | Iteration 5: l = 1 + 1 = 2

        return 0 if ans == float('inf') else ans  # returns 2