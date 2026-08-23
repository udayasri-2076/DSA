// Group Anagrams

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};


        /*
        Brute Force

        Take one word and compare it with every other word.

        Example:

        eat

        Compare with:

        tea
        tan
        ate
        nat
        bat

        To check whether two words are anagrams,
        sort both words.

        eat -> aet
        tea -> aet

        Both are equal.

        So they are anagrams.

        Time Complexity: O(n^2 * k log k)

        Space Complexity: O(n * k)
        */

        List<List<String>> bruteForce = new ArrayList<>();

        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (visited[i]) {
                continue;
            }

            List<String> group = new ArrayList<>();

            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {

                char[] first = strs[i].toCharArray();
                char[] second = strs[j].toCharArray();

                Arrays.sort(first);
                Arrays.sort(second);

                if (Arrays.equals(first, second)) {

                    group.add(strs[j]);
                    visited[j] = true;
                }
            }

            bruteForce.add(group);
        }

        System.out.println("Brute Force: " + bruteForce);


        /*
        Better Approach

        Use HashMap.

        Sort each word and use the sorted word as the key.

        Example:

        eat -> aet
        tea -> aet
        ate -> aet

        All have the same key.

        HashMap:

        aet -> [eat, tea, ate]

        ant -> [tan, nat]

        abt -> [bat]

        Time Complexity: O(n * k log k)

        Space Complexity: O(n * k)
        */

        HashMap<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] arr = word.toCharArray();

            Arrays.sort(arr);

            String key = new String(arr);

            if (!map.containsKey(key)) {

                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        List<List<String>> betterApproach =
                new ArrayList<>(map.values());

        System.out.println("Better Approach: " + betterApproach);


        /*
        Optimal Approach

        Instead of sorting each word,
        count the frequency of characters.

        Create an array of size 26.

        Example:

        eat

        a -> 1
        e -> 1
        t -> 1


        tea

        a -> 1
        e -> 1
        t -> 1

        Both have the same frequency.

        Use the frequency as the HashMap key.

        Time Complexity: O(n * k)

        Space Complexity: O(n * k)
        */

        HashMap<String, List<String>> frequencyMap =
                new HashMap<>();

        for (String word : strs) {

            int[] count = new int[26];

            for (char c : word.toCharArray()) {

                count[c - 'a']++;
            }

            String key = Arrays.toString(count);

            if (!frequencyMap.containsKey(key)) {

                frequencyMap.put(key, new ArrayList<>());
            }

            frequencyMap.get(key).add(word);
        }

        List<List<String>> optimalApproach =
                new ArrayList<>(frequencyMap.values());

        System.out.println("Optimal Approach: " + optimalApproach);
    }
}
