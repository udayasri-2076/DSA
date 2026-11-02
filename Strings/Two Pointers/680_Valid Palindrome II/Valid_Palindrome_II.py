class Solution:
    def validPalindrome(self, s: str) -> bool:
        # Brute Force Approach:
        # Check every possible substring formed by removing one character to see if it is a palindrome.
        # Time Complexity: O(n^2)
        # Space Complexity: O(n)
        # Example s = "abca"
        brute_n = len(s)  # brute_n = 4 (length of string)
        for i in range(brute_n):  # i = 0, 1, 2, 3... index of character to remove
            brute_curr = s[:i] + s[i + 1:]  # i = 0: brute_curr = "bca" | i = 1: brute_curr = "aca" | i = 2: brute_curr = "aba" | i = 3: brute_curr = "abc"
            if brute_curr == brute_curr[::-1]:  # i = 0: "bca" == "acb" (False) | i = 1: "aca" == "aca" (True)
                return True  # returns True when valid palindrome found after removing index 1
        # return False  # returns False if no single character removal yields a palindrome

        # Optimal Approach:
        # Use two pointers starting from both ends, and when a mismatch occurs, check both possibilities of removing either the left or right character.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example s = "abca"
        l = 0               # l = 0 (left pointer)
        r = len(s) - 1      # r = 4 - 1 = 3 (right pointer)

        while l < r:        # Condition: Iteration 1: 0 < 3 (True) | Iteration 2: 1 < 2 (True)
            if s[l] != s[r]:  # Iteration 1: s[0] != s[3] ('a' != 'a' -> False) | Iteration 2: s[1] != s[2] ('b' != 'c' -> True)
                sub1 = s[l + 1:r + 1]  # Iteration 2: sub1 = s[2:4] = "ca"
                sub2 = s[l:r]     # Iteration 2: sub2 = s[1:3] = "bc"
                return sub1 == sub1[::-1] or sub2 == sub2[::-1]  # Iteration 2: "ca" == "ac" (False) or "aba" == "aba" (True) -> True
            l += 1          # Iteration 1: l = 0 + 1 = 1
            r -= 1          # Iteration 1: r = 3 - 1 = 2

        return True         # returns True if string is already a palindrome