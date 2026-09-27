import java.util.*;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        /*
        Brute Force Approach

        Clean the string by removing all non-alphanumeric characters
        and converting everything to lowercase.
        Then check if the cleaned string reads the same forwards and backwards.

        Example:
        s = "A man, a plan, a canal: Panama"
        cleaned = "amanaplanacanalpanama"

        Time Complexity: O(n)
        Space Complexity: O(n)
        */

        StringBuilder sb = new StringBuilder(); //sb=""
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String cleaned = sb.toString(); //cleaned="amanaplanacanalpanama"
        String reversed = sb.reverse().toString(); //reversed="amanaplanacanalpanama"
        boolean bruteResult = cleaned.equals(reversed); //true

        System.out.println("Brute Force: " + bruteResult);

        /*
        Optimal Approach - Two Pointers

        Use two pointers, left at the beginning and right at the end.
        Move left forward if it's not a letter or digit.
        Move right backward if it's not a letter or digit.
        Compare characters case-insensitively when both point to valid characters.

        Example:
        s = "A man, a plan, a canal: Panama"
        left = 0, right = 29

        Time Complexity: O(n)
        Space Complexity: O(1)
        */

        int left = 0;                     //left=0 -> s.charAt(0)='A'
        int right = s.length() - 1;       //right=29 -> s.charAt(29)='a'
        boolean optimalResult = true;     //optimalResult=true

        while(left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if(!Character.isLetterOrDigit(l)) {
                // left=0 -> 'A' is letter/digit -> false
                // left=5 -> ',' is not letter/digit -> left=6
                left++;
            }
            else if(!Character.isLetterOrDigit(r)) {
                // right=29 -> 'a' is letter/digit -> false
                right--;
            }
            else {
                if(Character.toLowerCase(l) != Character.toLowerCase(r)) {
                    // compare 'a' and 'a' -> equal
                    optimalResult = false;
                    break;
                }
                left++;  // move left
                right--; // move right
            }
        }

        System.out.println("Optimal Approach: " + optimalResult);
    }
}
