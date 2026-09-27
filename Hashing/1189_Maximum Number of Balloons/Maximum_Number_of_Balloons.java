import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {
        // Example: text = "nlaebolko"
        HashMap<Character, Integer> map = new HashMap<>();

        // Traverse through each character in the string to build frequency map
        for (int i = 0; i < text.length(); i++) { // i = 0, ch = 'n', map = {n=1}
            char ch = text.charAt(i);             // i = 1, ch = 'l', map = {n=1, l=1}
                                                 // i = 2, ch = 'a', map = {n=1, l=1, a=1}
            map.put(ch, map.getOrDefault(ch, 0) + 1); // Updates frequency for each char
        }

        // We need 'b', 'a', 'l', 'o', 'n' to form the word "balloon"
        // 'l' and 'o' appear twice in "balloon", so their counts must be divided by 2
        int b = map.getOrDefault('b', 0); // b = 1
        int a = map.getOrDefault('a', 0); // a = 1
        int l = map.getOrDefault('l', 0) / 2; // l = 1 / 2 = 0
        int o = map.getOrDefault('o', 0) / 2; // o = 1 / 2 = 0
        int n = map.getOrDefault('n', 0); // n = 1

        // The number of times we can form "balloon" is limited by the bottleneck character
        int result = Math.min(b,
                   Math.min(a,
                   Math.min(l,
                   Math.min(o, n)))); // result = min(1, 1, 0, 0, 1) = 0

        return result; // Returns 0
    }
}