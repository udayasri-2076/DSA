// Valid Anagram
/*
Brute Force
Convert both strings into char arrays and sort them.
If two strings are anagrams, sorting will make them identical.
Example:
s = "anagram" -> sorted -> a a a g m n r
t = "nagaram" -> sorted -> a a a g m n r
Both match -> true

Time Complexity: O(n log n) -> because of sorting
Space Complexity: O(n) -> for the char arrays
*/
import java.util.*;
public class ValidAnagram {
    public static boolean bruteForce(String s, String t) {
        if(s.length() != t.length()) { //different lengths can never be anagrams
            return false;
        }

        char[] sArr = s.toCharArray(); //sArr=[a,n,a,g,r,a,m]
        char[] tArr = t.toCharArray(); //tArr=[n,a,g,a,r,a,m]

        Arrays.sort(sArr); //sArr=[a,a,a,g,m,n,r]
        Arrays.sort(tArr); //tArr=[a,a,a,g,m,n,r]

        for(int i=0; i<sArr.length; i++) { //i=0..6
            if(sArr[i] != tArr[i]) { //compare position by position
                return false; //mismatch found -> not anagram
            }
        }
        return true; //all positions matched -> anagram
    }

    /*
    Optimal Approach
    Use ONE HashMap instead of two.
    Step 1: count every character of s -> +1 for each
    Step 2: for every character of t -> -1 for each
    If s and t are true anagrams, every count should return to exactly 0.
    Example:
    s="anagram" -> map: a:3, n:1, g:1, r:1, m:1
    t="nagaram" -> subtract: n:0, a:2, g:0, a:1, r:0, a:0, m:0
    All counts end at 0 -> true

    Time Complexity: O(n)
    Space Complexity: O(n) -> for the hashmap (at most 26 lowercase letters)
    */
    public static boolean optimal(String s, String t) {
        if(s.length() != t.length()) { //different lengths can never be anagrams
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>(); //map={}

        for(int i=0; i<s.length(); i++) { //build counts from s
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1); //a:1,2,3  n:1  g:1  r:1  m:1
        }

        for(int i=0; i<t.length(); i++) { //subtract counts using t
            char c = t.charAt(i);
            if(!map.containsKey(c)) { //t has a letter s never had
                return false;
            }
            map.put(c, map.get(c) - 1); //decrease count
            if(map.get(c) < 0) { //t has MORE of this letter than s did
                return false;
            }
        }

        return true; //if we never returned false, all counts balanced out
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println("Brute Force: " + bruteForce(s, t));
        System.out.println("Optimal: " + optimal(s, t));
    }
}
