class Solution:
    def sortColors(self, nums):
        # Brute Force Approach:
        # Count the number of 0s, 1s, and 2s using an auxiliary counting array or hash map, then overwrite the original array.
        # Time Complexity: O(n) where n is the number of elements in nums (two passes).
        # Space Complexity: O(1) as the counts take constant extra space.
        # Example nums: [2, 0, 2, 1, 1, 0]
        count0 = 0  # count0 = 0 (count of 0s)
        count1 = 0  # count1 = 0 (count of 1s)
        count2 = 0  # count2 = 0 (count of 2s)
        for i in range(len(nums)):  # i = 0, 1, 2, 3, 4, 5... counting each element
            if nums[i] == 0:  # nums[0] == 0 (2 == 0 -> False) | nums[1] == 0 (0 == 0 -> True) | nums[2] == 0 (2 == 0 -> False) | nums[3] == 0 (1 == 0 -> False) | nums[4] == 0 (1 == 0 -> False) | nums[5] == 0 (0 == 0 -> True)
                count0 += 1  # count0 = 0 + 1 = 1 | count0 = 1 + 1 = 2
            elif nums[i] == 1:  # nums[3] == 1 (1 == 1 -> True) | nums[4] == 1 (1 == 1 -> True)
                count1 += 1  # count1 = 0 + 1 = 1 | count1 = 1 + 1 = 2
            else:  # taken for nums[0] == 2 and nums[2] == 2
                count2 += 1  # count2 = 0 + 1 = 1 | count2 = 1 + 1 = 2
        for i in range(len(nums)):  # i = 0, 1, 2, 3, 4, 5... overwriting array
            if i < count0:  # i < 2 -> fill with 0
                nums[i] = 0  # nums[0] = 0, nums[1] = 0
            elif i < count0 + count1:  # i < 2 + 2 (4) -> fill with 1
                nums[i] = 1  # nums[2] = 1, nums[3] = 1
            else:  # fill remainder with 2
                nums[i] = 2  # nums[4] = 2, nums[5] = 2
        # return  # returns None after overwriting array in place

        # Optimal Approach:
        # Use the Dutch National Flag algorithm with three pointers (low, mid, high) to sort the array in a single pass.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example nums: [2, 0, 2, 1, 1, 0]
        n = len(nums)       # n = 6 (length of array)

        low = 0             # low = 0 (pointer for 0 boundary)
        mid = 0             # mid = 0 (scanning pointer)
        high = n - 1        # high = 6 - 1 = 5 (pointer for 2 boundary)

        while mid <= high:  # Condition: Iteration 1: 0 <= 5 (True) | Iteration 2: 0 <= 5 (True) | Iteration 3: 1 <= 5 (True) | Iteration 4: 1 <= 4 (True) | Iteration 5: 2 <= 4 (True) | Iteration 6: 2 <= 3 (True) | Iteration 7: 3 <= 3 (True) | Iteration 8: 4 <= 3 (False)
            if nums[mid] == 0:   # Iteration 1: nums[0] == 0 (2 == 0 -> False) | Iteration 2: nums[0] == 0 (2 == 0 -> False) | Iteration 3: nums[1] == 0 (0 == 0 -> True)
                nums[mid] = nums[low]  # Iteration 3: nums[1] = nums[0] (nums[1] = 2)
                nums[low] = 0   # Iteration 3: nums[0] = 0
                mid += 1        # Iteration 3: mid = 1 + 1 = 2
                low += 1        # Iteration 3: low = 0 + 1 = 1

            elif nums[mid] == 1: # Iteration 1: nums[0] == 1 (2 == 1 -> False) | Iteration 2: nums[0] == 1 (2 == 1 -> False) | Iteration 4: nums[2] == 1 (1 == 1 -> True) | Iteration 5: nums[3] == 1 (1 == 1 -> True)
                mid += 1        # Iteration 4: mid = 2 + 1 = 3 | Iteration 5: mid = 3 + 1 = 4

            else:            # Iteration 1: taken (2 == 2) | Iteration 2: taken (2 == 2) | Iteration 6: taken (2 == 2) | Iteration 7: taken (0 == 0 is False, falls to else since nums[mid] is 2)
                nums[mid] = nums[high]  # Iteration 1: nums[0] = nums[5] (nums[0] = 0) | Iteration 2: nums[0] = nums[4] (nums[0] = 1) | Iteration 6: nums[4] = nums[3] (nums[4] = 1) | Iteration 7: nums[3] = nums[2] (nums[3] = 2)
                nums[high] = 2  # Iteration 1: nums[5] = 2 | Iteration 2: nums[4] = 2 | Iteration 6: nums[3] = 2 | Iteration 7: nums[2] = 2
                high -= 1       # Iteration 1: high = 5 - 1 = 4 | Iteration 2: high = 4 - 1 = 3 | Iteration 6: high = 3 - 1 = 2 | Iteration 7: high = 2 - 1 = 1