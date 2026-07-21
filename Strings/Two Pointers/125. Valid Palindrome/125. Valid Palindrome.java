
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        // A man, a plan, a canal: Panama

        int l = 0;                  // l = 0
        int r = s.length() - 1;     // r = length - 1

        boolean palindrome = true;  // palindrome = true

        while (l < r) {             // l = 0   r = last

            char left = s.charAt(l);
            char right = s.charAt(r);

            // Skip special characters from left
            if (!Character.isLetterOrDigit(left)) {
                l++;                // move left pointer
            }

            // Skip special characters from right
            else if (!Character.isLetterOrDigit(right)) {
                r--;                // move right pointer
            }

            else {

                left = Character.toLowerCase(left);
                right = Character.toLowerCase(right);
                // A -> a
                // P -> p

                if (left != right) {
                    palindrome = false;
                    break;          // Not a palindrome
                }

                l++;                // l++
                r--;                // r--
            }
        }

        System.out.println(palindrome);   // true
    }
}

/*
Input:
A man, a plan, a canal: Panama

Output:
true
*/
