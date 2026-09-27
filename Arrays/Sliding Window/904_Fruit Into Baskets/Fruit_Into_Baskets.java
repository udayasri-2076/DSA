import java.util.*;

public class FruitIntoBaskets {
    public static void main(String[] args) {
        
        int fruits[] = {1, 2, 1, 2, 3}; //fruits=1 2 1 2 3
        int n = fruits.length;          //n=5

        /*
        Brute Force Approach

        Check every possible subarray and count the number of distinct elements.
        If the number of distinct elements is <= 2, update the maximum length.

        Time Complexity: O(n^3)
        Space Complexity: O(n)
        */

        int maxlenBrute = 0; //maxlenBrute=0

        for (int i = 0; i < n; i++) { //i=0..4
            for (int j = i; j < n; j++) { //j=i..4
                Set<Integer> set = new HashSet<>(); //set={}
                for (int k = i; k <= j; k++) { //k=i..j
                    set.add(fruits[k]);
                }
                if (set.size() <= 2) { //<=2 valid basket
                    maxlenBrute = Math.max(maxlenBrute, j - i + 1);
                }
            }
        }

        System.out.println("Brute Force Max Length: " + maxlenBrute); //3


        /*
        Optimal Approach - Sliding Window

        Use a hash map to keep track of the count of each fruit in the current window [l, r].
        If the map size exceeds 2, shrink the window from the left (increment l)
        until the map size is <= 2.
        At each step, update the maximum length.

        Time Complexity: O(n)
        Space Complexity: O(1) - since map can hold at most 3 elements at any time
        */

        int l = 0;          //l=0
        int maxlen = 0;     //maxlen=0
        HashMap<Integer, Integer> freq = new HashMap<>(); //freq={}

        for (int r = 0; r < n; r++) { //r=0..4

            freq.put(fruits[r], freq.getOrDefault(fruits[r], 0) + 1); 
            //r=0 -> freq={1:1}
            //r=1 -> freq={1:1, 2:1}
            //r=2 -> freq={1:2, 2:1}
            //r=3 -> freq={1:2, 2:2}
            //r=4 -> freq={1:2, 2:2, 3:1}

            while (freq.size() > 2) { //freq.size() > 2 check

                int leftFruit = fruits[l]; //get fruit at left pointer

                freq.put(leftFruit, freq.get(leftFruit) - 1); //decrement count

                if (freq.get(leftFruit) == 0) {
                    freq.remove(leftFruit); //remove if count is 0
                }

                l++; //shrink window
            }

            maxlen = Math.max(maxlen, r - l + 1); 
            //r=0 -> max(0, 0-0+1)=1
            //r=1 -> max(1, 1-0+1)=2
            //r=2 -> max(2, 2-0+1)=3
            //r=3 -> max(3, 3-0+1)=4
            //r=4 -> freq.size()>2 -> l moves, max(4, 4-2+1)=3
        }

        System.out.println("Optimal Sliding Window Max Length: " + maxlen); //4
    }
}
