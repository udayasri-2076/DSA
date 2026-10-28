class Solution:
    def productExceptSelf(self, nums):
        # Brute Force Approach:
        # Iterate through each element and calculate the product of all other elements using nested loops.
        # Time Complexity: O(n^2) where n is the number of elements in the array.
        # Space Complexity: O(n) to store the result array.
        # Example nums: [1, 2, 3, 4]
        brute_n = len(nums)  # brute_n = 4 (number of elements)
        brute_res = [0] * brute_n  # brute_res = [0, 0, 0, 0]
        for i in range(brute_n):  # i = 0, 1, 2, 3 (outer loop index)
            brute_prod = 1  # brute_prod = 1 (product accumulator)
            for j in range(brute_n):  # j = 0, 1, 2, 3 (inner loop index)
                if i != j:  # i != j (skipping self index)
                    brute_prod = brute_prod * nums[j]  # Iteration 1: brute_prod = 1 * 2 = 2 | Iteration 2: brute_prod = 2 * 3 = 6 | Iteration 3: brute_prod = 6 * 4 = 24
            brute_res[i] = brute_prod  # brute_res[0] = 24 | brute_res[1] = 12 | brute_res[2] = 8 | brute_res[3] = 6
        # return brute_res  # returns result array if brute force is used

        # Optimal Approach:
        # Compute prefix products in a forward pass and multiply by suffix products in a backward pass.
        # Time Complexity: O(n)
        # Space Complexity: O(1) auxiliary space (excluding result array)

        # Example nums: [1, 2, 3, 4]
        n = len(nums)       # n = 4 (number of elements)
        res = [0] * n       # res = [0, 0, 0, 0]

        res[0] = 1          # res[0] = 1 (base case for prefix product)
        for i in range(1, n):  # Condition: Iteration 1: 1 < 4 (True) | Iteration 2: 2 < 4 (True) | Iteration 3: 3 < 4 (True)
            res[i] = res[i - 1] * nums[i - 1]  # Iteration 1: res[1] = 1 * 1 = 1 | Iteration 2: res[2] = 1 * 2 = 2 | Iteration 3: res[3] = 2 * 3 = 6

        suffix = 1          # suffix = 1 (base case for suffix product)
        for i in range(n - 1, -1, -1):  # Condition: Iteration 1: 3 >= 0 (True) | Iteration 2: 2 >= 0 (True) | Iteration 3: 1 >= 0 (True) | Iteration 4: 0 >= 0 (True)
            res[i] = res[i] * suffix  # Iteration 1: res[3] = 6 * 1 = 6 | Iteration 2: res[2] = 2 * 4 = 8 | Iteration 3: res[1] = 1 * 12 = 12 | Iteration 4: res[0] = 1 * 24 = 24
            suffix = suffix * nums[i]  # Iteration 1: suffix = 1 * 4 = 4 | Iteration 2: suffix = 4 * 3 = 12 | Iteration 3: suffix = 12 * 2 = 24 | Iteration 4: suffix = 24 * 1 = 24

        return res          # returns res = [24, 12, 8, 6]