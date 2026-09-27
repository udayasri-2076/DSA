import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        // Example: s = "leetcode"
        int n = s.length(); // n = 8

        // Create a HashMap to store character frequencies
        HashMap<Character, Integer> map = new HashMap<>();

        // First pass: Count frequencies of each character
        for (int i = 0; i < n; i++) { // i = 0 to 7
            char c = s.charAt(i); // i=0: c='l', i=1: c='e', i=2: c='e', etc.
            map.put(c, map.getOrDefault(c, 0) + 1);
            // map updates: {'l': 1}, {'l': 1, 'e': 1}, {'l': 1, 'e': 2}, etc.
        }
        // Final map for "leetcode": {'l': 1, 'e': 3, 't': 1, 'c': 1, 'o': 1, 'd': 1}

        // Second pass: Find first unique character with frequency 1
        for (int i = 0; i < n; i++) { // i = 0 to 7
            char c = s.charAt(i); // i=0: c='l'
            if (map.get(c) == 1) { // map.get('l') == 1 is true
                return i; // returns index 0
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int result = firstUniqChar(s);
        System.out.println("First unique character index: " + result);
    }
}
