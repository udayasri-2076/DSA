class Solution:
    def moveZeroes(self, nums: list[int]) -> None:
        # Brute Force Approach:
        # Use a temporary list to store all non-zero elements, then copy them back and fill the rest with zeros.
        # Time Complexity: O(n)
        # Space Complexity: O(n)
        # Example nums: [0, 1, 0, 3, 12]
        brute_n = len(nums)  # brute_n = 5 (number of elements)
        brute_temp = []  # brute_temp = []
        for i in range(brute_n):  # i = 0, 1, 2, 3, 4... checking each element
            if nums[i] != 0:  # nums[0] != 0 (0 != 0 -> False), nums[1] != 0 (1 != 0 -> True), nums[2] != 0 (0 != 0 -> False), nums[3] != 0 (3 != 0 -> True), nums[4] != 0 (12 != 0 -> True)
                brute_temp.append(nums[i])  # Iteration 1: brute_temp = [1] | Iteration 2: brute_temp = [1, 3] | Iteration 3: brute_temp = [1, 3, 12]
        for i in range(brute_n):  # i = 0, 1, 2, 3, 4... copying back
            if i < len(brute_temp):  # i < 3: copying non-zero elements
                nums[i] = brute_temp[i]  # nums[0] = 1, nums[1] = 3, nums[2] = 12
            else:  # i >= 3: filling remaining with zeros
                nums[i] = 0  # nums[3] = 0, nums[4] = 0
        # return  # returns modified nums list: [1, 3, 12, 0, 0]

        # Optimal Approach:
        # Use a two-pointer approach where 'l' tracks the insertion position for non-zero elements and 'r' iterates through the array.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example nums: [0, 1, 0, 3, 12]
        n = len(nums)     # n = 5 (number of elements)

        l = 0             # l = 0 (left pointer for non-zero placement)

        for r in range(n):  # Condition: Iteration 1: 0 < 5 (True) | Iteration 2: 1 < 5 (True) | Iteration 3: 2 < 5 (True) | Iteration 4: 3 < 5 (True) | Iteration 5: 4 < 5 (True)
            if nums[r] != 0:   # Iteration 1: nums[0] != 0 (0 != 0 -> False) | Iteration 2: nums[1] != 0 (1 != 0 -> True) | Iteration 3: nums[2] != 0 (0 != 0 -> False) | Iteration 4: nums[3] != 0 (3 != 0 -> True) | Iteration 5: nums[4] != 0 (12 != 0 -> True)
                temp = nums[r]   # Iteration 2: temp = 1 | Iteration 4: temp = 3 | Iteration 5: temp = 12
                nums[r] = nums[l]  # Iteration 2: nums[1] = nums[0] (0) | Iteration 4: nums[3] = nums[1] (0) | Iteration 5: nums[4] = nums[2] (0)
                nums[l] = temp     # Iteration 2: nums[0] = 1 | Iteration 4: nums[1] = 3 | Iteration 5: nums[2] = 12

                l += 1           # Iteration 2: l = 0 + 1 = 1 | Iteration 4: l = 1 + 1 = 2 | Iteration 5: l = 2 + 1 = 3