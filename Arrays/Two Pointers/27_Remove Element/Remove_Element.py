class Solution:
    def removeElement(self, nums, val):
        # Brute Force Approach:
        # Create a temporary list to store elements not equal to val, then copy them back to nums.
        # Time Complexity: O(n) where n is the number of elements in the array.
        # Space Complexity: O(n) due to extra storage for elements.
        # Example nums: [3, 2, 2, 3], val = 3
        brute_temp = []                           # brute_temp = [] (temporary storage)
        brute_k = 0                               # brute_k = 0 (count of non-val elements)
        for i in range(len(nums)):                # i = 0, 1, 2, 3... checking each element in the array
            if nums[i] != val:                    # Iteration 1: nums[0] != 3 (3 != 3 -> False) | Iteration 2: nums[1] != 3 (2 != 3 -> True) | Iteration 3: nums[2] != 3 (2 != 3 -> True) | Iteration 4: nums[3] != 3 (3 != 3 -> False)
                brute_temp.append(nums[i])        # Iteration 2: brute_temp = [2] | Iteration 3: brute_temp = [2, 2]
                brute_k += 1                      # Iteration 2: brute_k = 1 | Iteration 3: brute_k = 2
        for i in range(brute_k):                  # i = 0, 1... copying back valid elements
            nums[i] = brute_temp[i]               # Iteration 1: nums[0] = 2 | Iteration 2: nums[1] = 2
        # return brute_k # returns brute_k = 2

        # Optimal Approach:
        # Use a two-pointer approach where one pointer iterates through the array and another pointer keeps track of the position to place the next non-val element.
        # Time Complexity: O(n) where n is the number of elements in the array.
        # Space Complexity: O(1).
        # Example nums: [3, 2, 2, 3], val = 3
        k = 0                                     # k = 0 (pointer for the next valid element position)
        for i in range(len(nums)):                # i = 0, 1, 2, 3... checking each element in the array
            if nums[i] != val:                    # Iteration 1: nums[0] != 3 (3 != 3 -> False) | Iteration 2: nums[1] != 3 (2 != 3 -> True) | Iteration 3: nums[2] != 3 (2 != 3 -> True) | Iteration 4: nums[3] != 3 (3 != 3 -> False)
                nums[k] = nums[i]                 # Iteration 2: nums[0] = nums[1] ([2, 2, 2, 3]) | Iteration 3: nums[1] = nums[2] ([2, 2, 2, 3])
                k += 1                            # Iteration 2: k = 0 + 1 = 1 | Iteration 3: k = 1 + 1 = 2
        return k                                  # returns k = 2 (number of elements not equal to val)