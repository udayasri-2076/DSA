public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Brute Force Approach:
        // Iterate through every row and every column of the matrix to check if any element matches the target.
        // Time Complexity: O(m * n) where m is rows and n is columns.
        // Space Complexity: O(1).
        // Example matrix: [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target = 3
        int bruteM = matrix.length; // bruteM = 3 (number of rows)
        int bruteN = matrix[0].length; // bruteN = 4 (number of columns)
        for (int i = 0; i < bruteM; i++) { // i = 0, 1, 2... checking each row
            for (int j = 0; j < bruteN; j++) { // j = 0, 1, 2, 3... checking each column
                if (matrix[i][j] == target) { // matrix[0][0] == 3 (1 == 3 -> false), matrix[0][1] == 3 (3 == 3 -> true)
                    return true; // returns true when match found
                }
            }
        }
        // return false; // returns false if loop completes without finding target

        // Optimal Approach:
        // Treat the 2D matrix as a virtual 1D sorted array of size m * n.
        // Time Complexity: O(log(m * n))
        // Space Complexity: O(1)

        // Example matrix: [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], target = 3
        int m = matrix.length;    // m = 3 (number of rows)
        int n = matrix[0].length; // n = 4 (number of columns)

        int l = 0;                // l = 0 (left pointer)
        int r = m * n - 1;        // r = 3 * 4 - 1 = 11 (right pointer)

        while (l <= r) {                          // Condition: Iteration 1: 0 <= 11 (true) | Iteration 2: 0 <= 4 (true) | Iteration 3: 0 <= 1 (true) | Iteration 4: 1 <= 1 (true)
            int mid = l + (r - l) / 2;          // Iteration 1: mid = 5 | Iteration 2: mid = 2 | Iteration 3: mid = 0 | Iteration 4: mid = 1

            int row = mid / n;                  // Iteration 1: row = 1 | Iteration 2: row = 0 | Iteration 3: row = 0 | Iteration 4: row = 0
            int col = mid % n;                  // Iteration 1: col = 1 | Iteration 2: col = 2 | Iteration 3: col = 0 | Iteration 4: col = 1

            if (matrix[row][col] == target) {   // Iteration 1: matrix[1][1] == 3 (11 == 3 -> false) | Iteration 2: matrix[0][2] == 3 (5 == 3 -> false) | Iteration 3: matrix[0][0] == 3 (1 == 3 -> false) | Iteration 4: matrix[0][1] == 3 (3 == 3 -> true)
                return true;
            }

            else if (matrix[row][col] < target) {// Iteration 1: matrix[1][1] < 3 (11 < 3 -> false) | Iteration 2: matrix[0][2] < 3 (5 < 3 -> false) | Iteration 3: matrix[0][0] < 3 (1 < 3 -> true)
                l = mid + 1;                    // Iteration 3: l = 0 + 1 = 1
            }

            else {                              // Iteration 1: taken (11 > 3) | Iteration 2: taken (5 > 3)
                r = mid - 1;                    // Iteration 1: r = 5 - 1 = 4 | Iteration 2: r = 2 - 1 = 1
            }

        }
        return false;
    }
}