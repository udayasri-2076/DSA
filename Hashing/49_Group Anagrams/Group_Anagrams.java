// Group Anagrams

/*
Optimal Approach - Hashing with Sorted String Key

Use a HashMap to group anagrams together.
Sort each string to create a canonical key for its anagram group.

Example:
strs = ["eat","tea","tan","ate","nat","bat"]

"eat" -> sort -> "aet" -> map.get("aet") -> add "eat"
"tea" -> sort -> "aet" -> map.get("aet") -> add "tea"
"tan" -> sort -> "ant" -> map.get("ant") -> add "tan"
"ate" -> sort -> "aet" -> map.get("aet") -> add "ate"
"nat" -> sort -> "ant" -> map.get("ant") -> add "nat"
"bat" -> sort -> "abt" -> map.get("abt") -> add "bat"

Result:
[["eat","tea","ate"],["tan","nat"],["bat"]

Time Complexity: O(n * k log k), where n is the number of strings and k is the maximum length of a string
Space Complexity: O(n * k)
*/

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("enter the number of strings:");
        int n = in.nextInt(); //n=6

        String[] strs = new String[n];
        System.out.println("enter the strings:");
        for(int i=0; i<n; i++) {
            strs[i] = in.next(); //strs=["eat","tea","tan","ate","nat","bat"]
        }

        HashMap<String, List<String>> map = new HashMap<>(); //map={}

        for(int i=0; i<n; i++) { //i=0..5

            String str = strs[i]; //i=0 -> str="eat"  i=1 -> str="tea"  i=2 -> str="tan"

            char[] arr = str.toCharArray(); //i=0 -> ['e','a','t']  i=1 -> ['t','e','a']

            Arrays.sort(arr); //i=0 -> ['a','e','t']  i=1 -> ['a','e','t']

            String key = new String(arr); //i=0 -> "aet"  i=1 -> "aet"

            if(!map.containsKey(key)) { //containsKey("aet")=false(i=0), true(i=1)

                map.put(key, new ArrayList<>()); //map={"aet":[]}
            }

            map.get(key).add(str); //map={"aet":["eat","tea"]}...
        }

        List<List<String>> result = new ArrayList<>(map.values()); //result=[["eat","tea","ate"],["tan","nat"],["bat"]]

        System.out.println("Grouped Anagrams: " + result);
    }
}
