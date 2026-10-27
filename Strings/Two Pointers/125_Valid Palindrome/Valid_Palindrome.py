class Solution:
    def isPalindrome(self, s: str) -> bool:
        # Brute Force Approach:
        # Clean the string by keeping only alphanumeric characters and converting to lowercase, then check if it equals its reverse.
        # Time Complexity: O(n) where n is the length of the string.
        # Space Complexity: O(n) to store the filtered string and its reverse.
        # Example s: "A man, a plan, a canal: Panama"
        brute_filtered = []  # brute_filtered = []
        for i in range(len(s)):  # i = 0, 1, 2... checking each character
            c = s[i]  # Iteration 1: c = 'A' | Iteration 2: c = ' '
            if c.isalnum():  # Iteration 1: c.isalnum() -> True | Iteration 2: c.isalnum() -> False
                brute_filtered.append(c.lower())  # Iteration 1: brute_filtered = ['a']
        brute_filtered_str = "".join(brute_filtered)  # brute_filtered_str = "amanaplanacanalpanama"
        brute_reversed_str = brute_filtered_str[::-1]  # brute_reversed_str = "amanaplanacanalpanama"
        if brute_filtered_str == brute_reversed_str:  # "amanaplanacanalpanama" == "amanaplanacanalpanama" -> True
            return True  # returns True when match found
        # return False  # returns False if filtered string does not equal its reverse

        # Optimal Approach:
        # Use two pointers starting at both ends of the string, skipping non-alphanumeric characters, and comparing characters case-insensitively.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example s: "A man, a plan, a canal: Panama"
        left = 0  # left = 0 (left pointer)
        right = len(s) - 1  # right = 30 - 1 = 29 (right pointer)

        while left < right:  # Condition: Iteration 1: 0 < 29 (True) | Iteration 2: 1 < 29 (True)
            while left < right and not s[left].isalnum():  # Iteration 1: s[0].isalnum() is True (False) | Iteration 6: s[5].isalnum() is False (True)
                left += 1  # Iteration 6: left = 5 + 1 = 6

            while left < right and not s[right].isalnum():  # Iteration 1: s[29].isalnum() is True (False) | Iteration 7: s[28].isalnum() is True (False)
                right -= 1

            if s[left].lower() != s[right].lower():  # Iteration 1: s[0].lower() != s[29].lower() ('a' != 'a' -> False)
                return False  # returns False if characters do not match

            left += 1  # Iteration 1: left = 0 + 1 = 1
            right -= 1  # Iteration 1: right = 29 - 1 = 28

        return True
