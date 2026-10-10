class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        # Brute Force Approach:
        # Iteratively build combinations using a queue-like list, appending characters for each digit.
        # Time Complexity: O(4^n * n) where n is the length of digits and 4 is the maximum number of letters mapped to a digit.
        # Space Complexity: O(4^n * n) to store all combinations in memory.
        # Example digits: "23"
        brute_result = []  # brute_result = [] (stores all generated combinations iteratively)
        if len(digits) == 0:  # len(digits) == 0 (2 == 0 -> False)
            return brute_result
        brute_phone = [  # phone mapping array for digits 0 to 9
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        ]
        brute_result.append("")  # brute_result = [""] (initial starting point for iterative expansion)
        for i in range(len(digits)):  # i = 0, 1... looping through each digit in digits
            brute_digit = int(digits[i])  # Iteration 1: brute_digit = int('2') = 2 | Iteration 2: brute_digit = int('3') = 3
            brute_letters = brute_phone[brute_digit]  # Iteration 1: brute_letters = "abc" | Iteration 2: brute_letters = "def"
            brute_next_level = []  # temporary list to store newly expanded combinations
            for current_str in brute_result:  # iterates through existing combinations in brute_result
                for j in range(len(brute_letters)):
                    brute_ch = brute_letters[j]  # gets character, e.g., 'a', 'b', 'c'
                    brute_next_level.append(current_str + brute_ch)  # appends character to current combination
            brute_result = brute_next_level  # updates brute_result with newly expanded combinations
        # return brute_result  # returns brute_result after iterative expansion completes

        # Optimal Approach (Backtracking):
        # Generate all possible letter combinations recursively by mapping each digit to its corresponding letters.
        # Time Complexity: O(4^n * n) where n is the length of digits and 4 is the maximum number of letters mapped to a digit.
        # Space Complexity: O(n) for the recursion stack and storing the current combination.
        # Example digits: "23"
        result = []  # result = [] (stores all generated combinations)

        if len(digits) == 0:  # len(digits) == 0 (2 == 0 -> False)
            return result

        phone = [  # phone mapping array for digits 0 to 9
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        ]

        def backtrack(index, current):  # recursive helper function for backtracking
            if index == len(digits):  # Iteration 3 (leaf): index == 2 (2 == 2 -> True) | ...
                result.append(current)  # adds current combination to result: "ad", "ae", "af", etc.
                return  # returns from base case

            digit = int(digits[index])  # Iteration 1: digit = int('2') = 2 | Iteration 2: index = 1, digit = int('3') = 3
            letters = phone[digit]  # Iteration 1: letters = "abc" | Iteration 2: letters = "def"

            for i in range(len(letters)):  # Iteration 1: i = 0, 1, 2 for "abc" | Iteration 2: i = 0, 1, 2 for "def"
                ch = letters[i]  # Iteration 1: ch = 'a', 'b', 'c' | Iteration 2: ch = 'd', 'e', 'f'
                backtrack(index + 1, current + ch)  # Iteration 1: backtrack(1, "a") | Iteration 2: backtrack(2, "ad")

        backtrack(0, "")  # initiates backtracking with index = 0 and current = ""

        return result  # returns result containing all valid combinations