class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        """
        Brute Force Approach:
        Iterate through every row and every column of the matrix to check if any element matches the target.
        Time Complexity: O(m * n) where m is rows and n is columns.
        Space Complexity: O(1).
        """
        # Example matrix: [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target = 3
        brute_m = len(matrix) # brute_m = 3 (number of rows)
        brute_n = len(matrix[0]) # brute_n = 4 (number of columns)
        for i in range(brute_m): # i = 0, 1, 2... checking each row
            for j in range(brute_n): # j = 0, 1, 2, 3... checking each column
                if matrix[i][j] == target: # matrix[0][0] == 3 (1 == 3 -> False), matrix[0][1] == 3 (3 == 3 -> True)
                    return True # returns True when match found
        # return False # returns False if loop completes without finding target

        # Optimal Approach:
        # Treat the 2D matrix as a virtual 1D sorted array of size m * n.
        # Time Complexity: O(log(m * n))
        # Space Complexity: O(1)

        # Example matrix: [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target = 3
        m = len(matrix)    # m = 3 (number of rows)
        n = len(matrix[0]) # n = 4 (number of columns)

        l = 0              # l = 0 (left pointer)
        r = m * n - 1      # r = 3 * 4 - 1 = 11 (right pointer)

        while l <= r:                          # Condition: Iteration 1: 0 <= 11 (True) | Iteration 2: 0 <= 4 (True) | Iteration 3: 0 <= 1 (True) | Iteration 4: 1 <= 1 (True)
            mid = l + (r - l) // 2             # Iteration 1: mid = 5 | Iteration 2: mid = 2 | Iteration 3: mid = 0 | Iteration 4: mid = 1

            row = mid // n                     # Iteration 1: row = 1 | Iteration 2: row = 0 | Iteration 3: row = 0 | Iteration 4: row = 0
            col = mid % n                      # Iteration 1: col = 1 | Iteration 2: col = 2 | Iteration 3: col = 0 | Iteration 4: col = 1

            if matrix[row][col] == target:     # Iteration 1: matrix[1][1] == 3 (11 == 3 -> False) | Iteration 2: matrix[0][2] == 3 (5 == 3 -> False) | Iteration 3: matrix[0][0] == 3 (1 == 3 -> False) | Iteration 4: matrix[0][1] == 3 (3 == 3 -> True)
                return True

            elif matrix[row][col] < target:    # Iteration 1: matrix[1][1] < 3 (11 < 3 -> False) | Iteration 2: matrix[0][2] < 3 (5 < 3 -> False) | Iteration 3: matrix[0][0] < 3 (1 < 3 -> True)
                l = mid + 1                    # Iteration 3: l = 0 + 1 = 1

            else:                              # Iteration 1: taken (11 > 3) | Iteration 2: taken (5 > 3)
                r = mid - 1                    # Iteration 1: r = 5 - 1 = 4 | Iteration 2: r = 2 - 1 = 1

        return False
