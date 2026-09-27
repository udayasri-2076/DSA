import java.util.*;

public class RansomNote {

    public static void main(String[] args) {
        String ransomNote = "a";     //ransomNote=a
        String magazine = "ab";      //magazine=ab

        /*
        Brute Force Approach
        
        For each character in the ransomNote, search for it in the magazine.
        If found, remove or mark that character in the magazine so it is not reused.
        If not found, return false.
        
        Time Complexity: O(m * n) where m is length of ransomNote and n is length of magazine
        Space Complexity: O(n) to store mutable magazine characters
        */

        boolean bruteResult = true;
        StringBuilder magCopy = new StringBuilder(magazine); //magCopy=ab

        for (int i = 0; i < ransomNote.length(); i++) { //i=0
            char ch = ransomNote.charAt(i); //ch=a
            int foundIndex = -1; //foundIndex=-1

            for (int j = 0; j < magCopy.length(); j++) { //j=0 j=1
                if (magCopy.charAt(j) == ch) { //magCopy[0]=='a' -> true
                    foundIndex = j; //foundIndex=0
                    break;
                }
            }

            if (foundIndex == -1) { //0==-1 false
                bruteResult = false;
                break;
            } else {
                magCopy.deleteCharAt(foundIndex); //magCopy becomes "b"
            }
        }

        System.out.println("Brute Force: " + bruteResult); //true


        /*
        Optimal Approach - Hashing (Frequency Map)
        
        Count the frequency of each character in the magazine using a HashMap.
        Then check each character in the ransomNote against the map.
        If a character is missing or its count is 0, return false.
        Otherwise, decrement its count.
        
        Time Complexity: O(m + n) where m is length of ransomNote and n is length of magazine
        Space Complexity: O(k) where k is number of unique characters in magazine (at most 26)
        */

        HashMap<Character, Integer> map = new HashMap<>(); //map={}
        boolean optimalResult = true; //optimalResult=true

        // count characters in magazine
        for (int i = 0; i < magazine.length(); i++) { //i=0 i=1
            char ch = magazine.charAt(i); //ch=a ch=b

            map.put(ch, map.getOrDefault(ch, 0) + 1); //i=0 -> map={a=1}  i=1 -> map={a=1, b=1}
        }

        // check characters in ransomNote
        for (int i = 0; i < ransomNote.length(); i++) { //i=0

            char ch = ransomNote.charAt(i); //ch=a

            if (!map.containsKey(ch) || map.get(ch) == 0) { //map.containsKey('a')=true, map.get('a')=1 != 0
                optimalResult = false;
                break;
            }

            map.put(ch, map.get(ch) - 1); //map.put('a', 1-1) -> map={a=0, b=1}

        }

        System.out.println("Optimal Approach: " + optimalResult); //true
    }
}
