public class Solution {
    public boolean isPalindrome(String s) {
        // Brute Force Approach:
        // Clean the string by keeping only alphanumeric characters and converting to lowercase, then check if it equals its reverse.
        // Time Complexity: O(n) where n is the length of the string.
        // Space Complexity: O(n) to store the filtered string and its reverse.
        // Example s: "A man, a plan, a canal: Panama"
        StringBuilder bruteFiltered = new StringBuilder(); // bruteFiltered = ""
        for (int i = 0; i < s.length(); i++) {            // i = 0, 1, 2... checking each character
            char c = s.charAt(i);                         // Iteration 1: c = 'A' | Iteration 2: c = ' '
            if (Character.isLetterOrDigit(c)) {           // Iteration 1: Character.isLetterOrDigit('A') -> true | Iteration 2: Character.isLetterOrDigit(' ') -> false
                bruteFiltered.append(Character.toLowerCase(c)); // Iteration 1: bruteFiltered = "a"
            }
        }
        String bruteReversed = new StringBuilder(bruteFiltered).reverse().toString(); // bruteReversed = "amanaplanacanalpanama"
        if (bruteFiltered.toString().equals(bruteReversed)) { // "amanaplanacanalpanama".equals("amanaplanacanalpanama") -> true
            return true;                                  // returns true when match found
        }
        // return false; // returns false if filtered string does not equal its reverse

        // Optimal Approach:
        // Use two pointers starting at both ends of the string, skipping non-alphanumeric characters, and comparing characters case-insensitively.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example s: "A man, a plan, a canal: Panama"
        int left = 0;             // left = 0 (left pointer)
        int right = s.length() - 1; // right = 30 - 1 = 29 (right pointer)

        while (left < right) {    // Condition: Iteration 1: 0 < 29 (true) | Iteration 2: 1 < 29 (true)
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) { // Iteration 1: s.charAt(0) is 'A' (false) | Iteration 6: s.charAt(5) is ' ' (true)
                left++;           // Iteration 6: left = 5 + 1 = 6
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) { // Iteration 1: s.charAt(29) is 'a' (false) | Iteration 7: s.charAt(28) is 'm' (false)
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) { // Iteration 1: Character.toLowerCase('A') != Character.toLowerCase('a') ('a' != 'a' -> false)
                return false;     // returns false if characters do not match
            }

            left++;               // Iteration 1: left = 0 + 1 = 1
            right--;              // Iteration 1: right = 29 - 1 = 28
        }

        return true;
    }
}
