class Solution:
    def pivotIndex(self, nums):
        # Brute Force Approach:
        # Iterate through each index, calculating the left sum and right sum separately by scanning the array.
        # Time Complexity: O(n^2)
        # Space Complexity: O(1)
        # Example nums: [1, 7, 3, 6, 5, 6]
        brute_n = len(nums)  # brute_n = 6 (number of elements)
        for i in range(brute_n):  # i = 0, 1, 2, 3, 4, 5... checking each index
            brute_left_sum = 0  # brute_left_sum = 0 (sum of elements to the left)
            brute_right_sum = 0  # brute_right_sum = 0 (sum of elements to the right)
            
            for j in range(i):  # j = 0... calculating left sum for index i
                brute_left_sum += nums[j]  # Iteration 1: i=3, j=0,1,2 -> brute_left_sum = 1 + 7 + 3 = 11
            
            for k in range(i + 1, brute_n):  # k = i+1... calculating right sum for index i
                brute_right_sum += nums[k]  # Iteration 1: i=3, k=4,5 -> brute_right_sum = 5 + 6 = 11
            
            if brute_left_sum == brute_right_sum:  # Iteration 1: i=3 -> 11 == 11 (True)
                return i  # returns 3 when pivot index found
        # return -1  # returns -1 if loop completes without finding pivot index

        # Optimal Approach:
        # Calculate total sum first, then maintain left sum while deriving right sum in a single pass.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example nums: [1, 7, 3, 6, 5, 6]
        totalsum = 0      # totalsum = 0 (total sum of all elements)

        for i in range(len(nums)):  # i = 0, 1, 2, 3, 4, 5... computing total sum
            totalsum = totalsum + nums[i]  # Iteration 1: 0+1=1 | Iteration 2: 1+7=8 | Iteration 3: 8+3=11 | Iteration 4: 11+6=17 | Iteration 5: 17+5=22 | Iteration 6: 22+6=28

        leftsum = 0       # leftsum = 0 (cumulative sum of elements to the left)

        for i in range(len(nums)):  # i = 0, 1, 2, 3... iterating to find pivot index
            rightsum = totalsum - leftsum - nums[i]  # Iteration 1: 28-0-1=27 | Iteration 2: 28-0-7=21 | Iteration 3: 28-7-3=18 | Iteration 4: 28-11-6=11

            if leftsum == rightsum:  # Iteration 1: 0==27 (False) | Iteration 2: 1==21 (False) | Iteration 3: 8==18 (False) | Iteration 4: 11==11 (True)
                return i  # Iteration 4: returns 3
            leftsum = leftsum + nums[i]  # Iteration 1: leftsum = 0+1=1 | Iteration 2: leftsum = 1+7=8 | Iteration 3: leftsum = 8+3=11

        return -1
