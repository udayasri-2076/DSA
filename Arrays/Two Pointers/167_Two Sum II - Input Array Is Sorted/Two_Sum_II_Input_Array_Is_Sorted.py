class Solution:
    def twoSum(self, numbers, target):
        # Brute Force Approach:
        # Iterate through every possible pair of numbers to find two numbers that add up to the target.
        # Time Complexity: O(n^2) where n is the number of elements in the array.
        # Space Complexity: O(1).
        # Example numbers: [2, 7, 11, 15], target = 9
        brute_n = len(numbers)  # brute_n = 4 (number of elements)
        for brute_i in range(brute_n):  # brute_i = 0, 1, 2... checking first number
            for brute_j in range(brute_i + 1, brute_n):  # brute_j = 1, 2, 3... checking second number
                if numbers[brute_i] + numbers[brute_j] == target:  # numbers[0] + numbers[1] == 9 (2 + 7 == 9 -> True)
                    return [brute_i + 1, brute_j + 1]  # returns 1-based indices [1, 2]
        # return [-1, -1]  # returns [-1, -1] if no pair is found

        # Optimal Approach:
        # Use two pointers starting at both ends of the sorted array and move them inward based on the sum.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example numbers: [2, 7, 11, 15], target = 9
        n = len(numbers)     # n = 4 (number of elements)

        l = 0                # l = 0 (left pointer starting at index 0)
        r = n - 1            # r = 4 - 1 = 3 (right pointer starting at index 3)

        while l < r:         # Condition: Iteration 1: 0 < 3 (True) | Iteration 2: 0 < 2 (True)
            sum_val = numbers[l] + numbers[r]  # Iteration 1: sum_val = numbers[0] + numbers[3] = 2 + 15 = 17 | Iteration 2: sum_val = numbers[0] + numbers[2] = 2 + 11 = 13

            if sum_val == target:  # Iteration 1: 17 == 9 (False) | Iteration 2: 13 == 9 (False)
                return [l + 1, r + 1]
            elif sum_val > target:  # Iteration 1: taken (17 > 9) | Iteration 2: taken (13 > 9)
                r -= 1             # Iteration 1: r = 3 - 1 = 2 | Iteration 2: r = 2 - 1 = 1
            else:                  # Iteration 3: taken (9 < 9 -> False)
                l += 1             # Iteration 3: l = 0 + 1 = 1

        return [-1, -1]