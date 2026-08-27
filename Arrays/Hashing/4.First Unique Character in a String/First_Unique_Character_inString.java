// First Unique Character in a String
/*
Brute Force
For each character, scan the whole string and count how many times it appears.
The first character with a total count of 1 is the answer.
Example:
String: s w i s s
i=0 -> current='s' -> count s in "swiss" -> s,s,s -> count=3 -> not unique
i=1 -> current='w' -> count w in "swiss" -> w -> count=1 -> unique! return 'w'
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
import java.util.*;
public class FirstUniqueChar {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("enter the string:");
        String s = in.next(); //s="swiss"
        int n = s.length(); //n=5

        /*
        Brute Force
        */
        char resultBrute = '-'; //resultBrute='-'
        for(int i=0; i<n; i++) { //i=0 0<5t
            char current = s.charAt(i); //current='s'
            int count = 0; //count=0
            for(int j=0; j<n; j++) { //j=0 0<5t j=1..4
                if(s.charAt(j) == current) { //s==s t, w==s f, i==s f, s==s t, s==s t
                    count++; //count=1,2,3
                }
            }
            if(count == 1) { //3==1 f (for 's')
                resultBrute = current;
                break;
            }
        }
        System.out.println("Brute Force: " + resultBrute); //w

        /*
        Better Approach
        Use an int array of size 256 as a counting array (ASCII characters).
        Index = character's ASCII value, value at that index = count.
        Example:
        's' -> ascii 115 -> freq[115]++
        First pass builds counts, second pass finds first count==1.
        Time Complexity: O(n)
        Space Complexity: O(1) -> fixed size 256, not dependent on input size
        */
        int freq[] = new int[256]; //freq=[0,0,...,0]
        for(int i=0; i<n; i++) { //i=0..4
            freq[s.charAt(i)]++; //freq['s']=1,2,3  freq['w']=1  freq['i']=1
        }
        char resultBetter = '-'; //resultBetter='-'
        for(int i=0; i<n; i++) { //i=0 0<5t
            if(freq[s.charAt(i)] == 1) { //freq['s']=3 -> f  freq['w']=1 -> t
                resultBetter = s.charAt(i); //resultBetter='w'
                break;
            }
        }
        System.out.println("Better Approach: " + resultBetter); //w

        /*
        Optimal Approach
        Use a HashMap<Character,Integer> instead of a fixed array.
        Works for ANY characters, not just ASCII (e.g. unicode/emojis).
        Example:
        's' -> map.put('s', 1) -> then 2 -> then 3
        'w' -> map.put('w', 1)
        Time Complexity: O(n)
        Space Complexity: O(n) -> depends on number of distinct characters
        */
        HashMap<Character,Integer> map = new HashMap<>(); //map={}
        for(int i=0; i<n; i++) { //i=0..4
            char c = s.charAt(i); //c='s','w','i','s','s'
            map.put(c, map.getOrDefault(c,0)+1); //s:1,2,3  w:1  i:1
        }
        char resultOptimal = '-'; //resultOptimal='-'
        for(int i=0; i<n; i++) { //i=0 0<5t
            char c = s.charAt(i); //c='s'
            if(map.get(c) == 1) { //map.get('s')=3 -> f, map.get('w')=1 -> t
                resultOptimal = c; //resultOptimal='w'
                break;
            }
        }
        System.out.println("Optimal Approach: " + resultOptimal); //w
    }
}
