public class Solution {
    public boolean validPalindrome(String s) {
        // Brute Force Approach:
        // Check every possible substring formed by removing one character to see if it is a palindrome.
        // Time Complexity: O(n^2)
        // Space Complexity: O(n)
        // Example s = "abca"
        int bruteN = s.length(); // bruteN = 4 (length of string)
        for (int i = 0; i < bruteN; i++) { // i = 0, 1, 2, 3... index of character to remove
            StringBuilder bruteSb = new StringBuilder(s); // bruteSb = "abca" | bruteSb = "abca" | bruteSb = "abca" | bruteSb = "abca"
            bruteSb.deleteCharAt(i); // i = 0: bruteSb = "bca" | i = 1: bruteSb = "aca" | i = 2: bruteSb = "aba" | i = 3: bruteSb = "abc"
            String bruteCurr = bruteSb.toString(); // bruteCurr = "bca" | bruteCurr = "aca" | bruteCurr = "aba" | bruteCurr = "abc"
            if (isPalindromeHelper(bruteCurr)) { // i = 0: isPalindrome("bca") -> false | i = 1: isPalindrome("aca") -> true
                return true; // returns true when valid palindrome found after removing index 1
            }
        }
        // return false; // returns false if no single character removal yields a palindrome

        // Optimal Approach:
        // Use two pointers starting from both ends, and when a mismatch occurs, check both possibilities of removing either the left or right character.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example s = "abca"
        int l = 0;                // l = 0 (left pointer)
        int r = s.length() - 1;   // r = 4 - 1 = 3 (right pointer)

        while (l < r) {           // Condition: Iteration 1: 0 < 3 (true) | Iteration 2: 1 < 2 (true)
            if (s.charAt(l) != s.charAt(r)) { // Iteration 1: s.charAt(0) != s.charAt(3) ('a' != 'a' -> false) | Iteration 2: s.charAt(1) != s.charAt(2) ('b' != 'c' -> true)
                return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1); // Iteration 2: isPalindrome("abca", 2, 2) || isPalindrome("abca", 1, 1) -> false || true -> true
            }
            l++;                  // Iteration 1: l = 0 + 1 = 1
            r--;                  // Iteration 1: r = 3 - 1 = 2
        }
        return true;              // returns true if string is already a palindrome
    }

    private boolean isPalindromeHelper(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}