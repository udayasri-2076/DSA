class Solution:
    def threeSum(self, nums):
        # Brute Force Approach:
        # Generate all possible triplets using three nested loops and check if their sum is zero, filtering duplicates.
        # Time Complexity: O(n^3)
        # Space Complexity: O(1) (excluding space for output)
        # Example nums: [-1, 0, 1, 2, -1, -4]
        brute_res = []  # brute_res = [] (stores all valid triplets)
        brute_n = len(nums)  # brute_n = 6 (length of the array)
        for i in range(brute_n):  # i = 0, 1, 2... checking first element
            for j in range(i + 1, brute_n):  # j = 1, 2, 3... checking second element
                for k in range(j + 1, brute_n):  # k = 2, 3, 4... checking third element
                    if nums[i] + nums[j] + nums[k] == 0:  # nums[0]+nums[1]+nums[2] == 0 (-1+0+1 == 0 -> True) | ...
                        triplet = [nums[i], nums[j], nums[k]]  # triplet = [-1, 0, 1]
                        # (Duplicate checking omitted for brevity in brute force description)
        # return brute_res  # returns all valid unique triplets found by brute force

        # Optimal Approach:
        # Sort the array, fix one number, and use two pointers for the remaining two numbers to find sums equal to zero efficiently.
        # Time Complexity: O(n^2)
        # Space Complexity: O(1) auxiliary space (excluding output list)

        # Example nums: [-1, 0, 1, 2, -1, -4]
        res = []  # res = [] (stores final result)
        n = len(nums)  # n = 6 (length of array)
        nums.sort()  # nums becomes [-4, -1, -1, 0, 1, 2] (sorted array)

        for i in range(n - 2):  # i = 0, 1, 2... fixing the first element
            if i > 0 and nums[i] == nums[i - 1]:  # i = 2: nums[2] == nums[1] (-1 == -1 -> True, skips duplicate)
                continue

            l = i + 1  # l = 1 | Iteration 2: l = 2 | Iteration 3: l = 4 (left pointer)
            r = n - 1  # r = 5 | Iteration 2: r = 5 | Iteration 3: r = 5 (right pointer)

            while l < r:  # Condition: Iteration 1: 1 < 5 (True) | Iteration 2: 2 < 5 (True) | Iteration 3: 4 < 5 (True)
                total_sum = nums[i] + nums[l] + nums[r]  # Iteration 1: total_sum = -4 + (-1) + 2 = -3 | Iteration 2: total_sum = -1 + (-1) + 2 = 0 | Iteration 3: total_sum = -1 + 0 + 1 = 0

                if total_sum == 0:  # Iteration 1: -3 == 0 (False) | Iteration 2: 0 == 0 (True) | Iteration 3: 0 == 0 (True)
                    res.append([nums[i], nums[l], nums[r]])  # Iteration 2: res = [[-1, -1, 2]] | Iteration 3: res = [[-1, -1, 2], [-1, 0, 1]]

                    while l < r and nums[l] == nums[l + 1]:  # Iteration 2: nums[1] == nums[2] (-1 == -1), l increments to 2 | Iteration 3: nums[4] == nums[1] (0 == 1 -> False)
                        l += 1

                    while l < r and nums[r] == nums[r - 1]:  # Iteration 2: nums[5] == nums[4] (2 == 1 -> False) | Iteration 3: nums[5] == nums[4] (1 == 0 -> False)
                        r -= 1

                    l += 1  # Iteration 2: l = 2 + 1 = 3 | Iteration 3: l = 4 + 1 = 5
                    r -= 1  # Iteration 2: r = 5 - 1 = 4 | Iteration 3: r = 5 - 1 = 4

                elif total_sum > 0:  # Iteration 1: -3 > 0 (False)
                    r -= 1  # not taken in this dry run example

                else:  # Iteration 1: taken (-3 < 0)
                    l += 1  # Iteration 1: l = 1 + 1 = 2

        return res  # returns [[-1, -1, 2], [-1, 0, 1]]
