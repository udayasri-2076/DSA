import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> letterCombinations(String digits) {
        // Brute Force Approach:
        // Iteratively build combinations using an explicit queue or list, appending characters for each digit.
        // Time Complexity: O(4^n * n) where n is the length of digits and 4 is the maximum number of letters mapped to a digit.
        // Space Complexity: O(4^n * n) to store all combinations in the queue.
        // Example digits: "23"
        List<String> bruteResult = new ArrayList<>(); // bruteResult = [] (stores all generated combinations iteratively)
        if (digits.length() == 0) { // digits.length() == 0 (2 == 0 -> false)
            return bruteResult;
        }
        String[] brutePhone = { // phone mapping array for digits 0 to 9
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        bruteResult.add(""); // bruteResult = [""] (initial starting point for iterative expansion)
        for (int i = 0; i < digits.length(); i++) { // i = 0, 1... looping through each digit in digits
            int bruteDigit = digits.charAt(i) - '0'; // Iteration 1: bruteDigit = '2' - '0' = 2 | Iteration 2: bruteDigit = '3' - '0' = 3
            String bruteLetters = brutePhone[bruteDigit]; // Iteration 1: bruteLetters = "abc" | Iteration 2: bruteLetters = "def"
            List<String> bruteNextLevel = new ArrayList<>(); // temporary list to store newly expanded combinations
            for (String currentStr : bruteResult) { // iterates through existing combinations in bruteResult
                for (int j = 0; j < bruteLetters.length(); j++) { // iterates through each letter mapped to current digit
                    char bruteCh = bruteLetters.charAt(j); // gets character, e.g., 'a', 'b', 'c'
                    bruteNextLevel.add(currentStr + bruteCh); // appends character to current combination
                }
            }
            bruteResult = bruteNextLevel; // updates bruteResult with newly expanded combinations
        }
        // return bruteResult; // returns bruteResult after iterative expansion completes

        // Optimal Approach (Backtracking):
        // Generate all possible letter combinations recursively by mapping each digit to its corresponding letters.
        // Time Complexity: O(4^n * n) where n is the length of digits and 4 is the maximum number of letters mapped to a digit.
        // Space Complexity: O(n) for the recursion stack and storing the current combination.
        // Example digits: "23"
        List<String> result = new ArrayList<>(); // result = [] (stores all generated combinations)

        if (digits.length() == 0) { // digits.length() == 0 (2 == 0 -> false)
            return result;
        }

        String[] phone = { // phone mapping array for digits 0 to 9
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", phone, result); // initiates backtracking with index = 0 and current = ""

        return result; // returns result containing all valid combinations
    }

    public void backtrack(String digits, int index, String current,
                          String[] phone, List<String> result) { // recursive method for backtracking
        if (index == digits.length()) { // Iteration 3 (leaf): index == 2 (2 == 2 -> true) | ...
            result.add(current); // adds current combination to result: "ad", "ae", "af", etc.
            return; // returns from base case
        }

        int digit = digits.charAt(index) - '0'; // Iteration 1: digit = '2' - '0' = 2 | Iteration 2: index = 1, digit = '3' - '0' = 3
        String letters = phone[digit]; // Iteration 1: letters = "abc" | Iteration 2: letters = "def"

        for (int i = 0; i < letters.length(); i++) { // Iteration 1: i = 0, 1, 2 for "abc" | Iteration 2: i = 0, 1, 2 for "def"
            char ch = letters.charAt(i); // Iteration 1: ch = 'a', 'b', 'c' | Iteration 2: ch = 'd', 'e', 'f'
            backtrack(digits, index + 1, current + ch, phone, result); // Iteration 1: backtrack("23", 1, "a", phone, result) | Iteration 2: backtrack("23", 2, "ad", phone, result)
        }
    }
}