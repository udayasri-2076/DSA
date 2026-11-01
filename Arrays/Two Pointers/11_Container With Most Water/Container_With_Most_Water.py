class Solution:
    def maxArea(self, height):
        # Brute Force Approach:
        # Iterate through every possible pair of lines and calculate the area formed by them, keeping track of the maximum.
        # Time Complexity: O(n^2) where n is the number of elements in the height array.
        # Space Complexity: O(1).
        # Example height: [1, 8, 6, 2, 5, 4, 8, 3, 7]
        brute_n = len(height)  # brute_n = 9 (number of elements)
        brute_max_area = 0  # brute_max_area = 0 (stores max area)
        for i in range(brute_n):  # i = 0, 1, 2... checking left line
            for j in range(i + 1, brute_n):  # j = 1, 2, 3... checking right line
                brute_h = min(height[i], height[j])  # height[0] vs height[1] = min(1, 8) = 1
                brute_width = j - i  # brute_width = 1 - 0 = 1
                brute_area = brute_h * brute_width  # brute_area = 1 * 1 = 1
                brute_max_area = max(brute_max_area, brute_area)  # brute_max_area = max(0, 1) = 1
        # return brute_max_area  # returns max area found by brute force

        # Optimal Approach:
        # Use two pointers starting at both ends and move the pointer pointing to the shorter line inward to maximize area.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example height: [1, 8, 6, 2, 5, 4, 8, 3, 7]
        n = len(height)     # n = 9 (number of elements)

        l = 0               # l = 0 (left pointer)
        r = n - 1           # r = 9 - 1 = 8 (right pointer)
        maxarea = 0         # maxarea = 0 (maximum area found so far)

        while l <= r:       # Condition: Iteration 1: 0 <= 8 (True) | Iteration 2: 1 <= 8 (True) | Iteration 3: 1 <= 7 (True)
            h = min(height[l], height[r])   # Iteration 1: min(height[0], height[8]) = min(1, 7) = 1 | Iteration 2: min(height[1], height[8]) = min(8, 7) = 7 | Iteration 3: min(height[1], height[7]) = min(8, 3) = 3
            width = r - l   # Iteration 1: width = 8 - 0 = 8 | Iteration 2: width = 8 - 1 = 7 | Iteration 3: width = 7 - 1 = 6
            area = h * width  # Iteration 1: area = 1 * 8 = 8 | Iteration 2: area = 7 * 7 = 49 | Iteration 3: area = 3 * 6 = 18
            maxarea = max(maxarea, area)   # Iteration 1: maxarea = max(0, 8) = 8 | Iteration 2: maxarea = max(8, 49) = 49 | Iteration 3: maxarea = max(49, 18) = 49

            if height[l] < height[r]:   # Iteration 1: height[0] < height[8] (1 < 7 -> True) | Iteration 2: height[1] < height[8] (8 < 7 -> False) | Iteration 3: height[1] < height[7] (8 < 3 -> False)
                l += 1      # Iteration 1: l = 0 + 1 = 1

            else:           # Iteration 2: taken (8 >= 7) | Iteration 3: taken (8 >= 3)
                r -= 1      # Iteration 2: r = 8 - 1 = 7 | Iteration 3: r = 7 - 1 = 6

        return maxarea      # returns the maximum area found