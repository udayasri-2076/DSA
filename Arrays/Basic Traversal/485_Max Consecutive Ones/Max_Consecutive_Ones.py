class Solution:
    def findMaxConsecutiveOnes(self, nums: list[int]) -> int:
        # Brute Force Approach:
        # Check all possible subarrays or nested loops to find the maximum consecutive 1s by testing each starting position.
        # Time Complexity: O(n^2)
        # Space Complexity: O(1)
        # Example nums: [1, 1, 0, 1]
        brute_n = len(nums)  # brute_n = 4 (number of elements)
        brute_maxans = 0     # brute_maxans = 0 (stores max consecutive ones)
        for i in range(brute_n):  # i = 0, 1, 2, 3... checking start of subarrays
            brute_count = 0  # brute_count = 0 (current streak)
            for j in range(i, brute_n):  # j = 0, 1, 2, 3... extending subarray
                if nums[j] == 1:  # Iteration 1: nums[0] == 1 (1 == 1 -> True) | Iteration 2: nums[1] == 1 (1 == 1 -> True) | Iteration 3: nums[2] == 1 (0 == 1 -> False)
                    brute_count += 1  # Iteration 1: brute_count = 0 + 1 = 1 | Iteration 2: brute_count = 1 + 1 = 2
                else:
                    break  # breaks streak on 0
            brute_maxans = max(brute_maxans, brute_count)  # brute_maxans = max(0, 2) = 2
        # return brute_maxans  # returns max consecutive ones

        # Optimal Approach:
        # Iterate through the array, counting consecutive 1s. When a 0 is encountered, update the maximum count and reset the current count.
        # Time Complexity: O(n) where n is the number of elements in the array.
        # Space Complexity: O(1).
        # Example nums: [1, 1, 0, 1]
        n = len(nums)       # n = 4 (number of elements)

        maxans = 0          # maxans = 0 (stores maximum consecutive ones)
        count = 0           # count = 0 (stores current consecutive ones)

        for j in range(n):  # j = 0, 1, 2, 3... checking each element
            if nums[j] == 1:  # Iteration 1: nums[0] == 1 (1 == 1 -> True) | Iteration 2: nums[1] == 1 (1 == 1 -> True) | Iteration 3: nums[2] == 1 (0 == 1 -> False) | Iteration 4: nums[3] == 1 (1 == 1 -> True)
                count += 1  # Iteration 1: count = 0 + 1 = 1 | Iteration 2: count = 1 + 1 = 2 | Iteration 4: count = 0 + 1 = 1

            else:           # Iteration 3: taken (0 != 1)
                maxans = max(maxans, count)  # Iteration 3: maxans = max(0, 2) = 2
                count = 0   # Iteration 3: count = 0

        return max(maxans, count)  # returns max(2, 1) = 2