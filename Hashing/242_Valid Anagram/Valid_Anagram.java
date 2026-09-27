import java.util.*;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram"; //s=anagram
        String t = "nagaram"; //t=nagaram

        /*
        Brute Force Approach
        
        Check if both strings have the same length.
        Convert both strings to character arrays and sort them.
        Compare every character at corresponding indices.
        
        Time Complexity: O(n log n)
        Space Complexity: O(n)
        */

        boolean bruteResult = true; //bruteResult=true
        if (s.length() != t.length()) {
            bruteResult = false;
        } else {
            char[] sArr = s.toCharArray(); //sArr=a n a g r a m
            char[] tArr = t.toCharArray(); //tArr=n a g a r a m

            Arrays.sort(sArr); //sArr=a a a g m n r
            Arrays.sort(tArr); //tArr=a a a g m n r

            for (int i = 0; i < sArr.length; i++) { //i=0..6
                if (sArr[i] != tArr[i]) { //a==a t, a==a t, a==a t, g==g t, m==m t, n==n t, r==r t
                    bruteResult = false;
                    break;
                }
            }
        }

        System.out.println("Brute Force Approach: " + bruteResult); //true

        /*
        Optimal Approach - Hashing (Frequency Count)
        
        Use an array of size 26 to count character frequencies.
        Increment for characters in s, decrement for characters in t.
        If all counts are zero, it is an anagram.
        
        Time Complexity: O(n)
        Space Complexity: O(1) -- since fixed size 26 array is used
        */

        boolean optimalResult = true; //optimalResult=true

        if (s.length() != t.length()) {
            optimalResult = false;
        } else {
            int[] count = new int[26]; //count=0 0 0 ... 0

            for (int i = 0; i < s.length(); i++) { //i=0..6
                count[s.charAt(i) - 'a']++; //s="anagram" -> count frequencies
                count[t.charAt(i) - 'a']--; //t="nagaram" -> subtract frequencies
            }

            for (int i = 0; i < 26; i++) { //i=0..25
                if (count[i] != 0) { //check if all frequencies are 0
                    optimalResult = false; //optimalResult=false
                    break;
                }
            }
        }

        System.out.println("Optimal Approach: " + optimalResult); //true
    }
}
