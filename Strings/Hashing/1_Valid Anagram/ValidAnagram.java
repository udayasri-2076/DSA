// Valid Anagram

/*
Brute Force

Use two HashMaps.

Count the frequency of every character
in both strings.

Example:

S = anagram
T = nagaram

HashMap 1:
a -> 3
n -> 1
g -> 1
r -> 1
m -> 1

HashMap 2:
n -> 1
a -> 3
g -> 1
r -> 1
m -> 1

Both HashMaps contain the same characters
with the same frequency.

Therefore, return true.

Time Complexity: O(n)
Space Complexity: O(n)
*/


import java.util.*;

public class ValidAnagram {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("enter the first string:");
        String s = in.nextLine(); //s="anagram"

        System.out.println("enter the second string:");
        String t = in.nextLine(); //t="nagaram"


        /*
        Brute Force

        Using two HashMaps to count
        the frequency of characters.
        */

        if(s.length() != t.length()) { //7!=7f

            System.out.println("Brute Force: false");

            return;
        }


        HashMap<Character,Integer> map1 = new HashMap<>(); //map1={}

        HashMap<Character,Integer> map2 = new HashMap<>(); //map2={}


        for(int i=0; i<s.length(); i++) { //i=0 0<7t  i=1 1<7t  i=2 2<7t  i=3 3<7t  i=4 4<7t  i=5 5<7t  i=6 6<7t  i=7 7<7f

            char ch = s.charAt(i); //a  n  a  g  r  a  m

            map1.put(ch, map1.getOrDefault(ch,0)+1);

            //i=0 -> a=1        map1={a=1}
            //i=1 -> n=1        map1={a=1,n=1}
            //i=2 -> a=2        map1={a=2,n=1}
            //i=3 -> g=1        map1={a=2,n=1,g=1}
            //i=4 -> r=1        map1={a=2,n=1,g=1,r=1}
            //i=5 -> a=3        map1={a=3,n=1,g=1,r=1}
            //i=6 -> m=1        map1={a=3,n=1,g=1,r=1,m=1}
        }


        for(int i=0; i<t.length(); i++) { //i=0 0<7t  i=1 1<7t  i=2 2<7t  i=3 3<7t  i=4 4<7t  i=5 5<7t  i=6 6<7t  i=7 7<7f

            char ch = t.charAt(i); //n  a  g  a  r  a  m

            map2.put(ch, map2.getOrDefault(ch,0)+1);

            //i=0 -> n=1        map2={n=1}
            //i=1 -> a=1        map2={n=1,a=1}
            //i=2 -> g=1        map2={n=1,a=1,g=1}
            //i=3 -> a=2        map2={n=1,a=2,g=1}
            //i=4 -> r=1        map2={n=1,a=2,g=1,r=1}
            //i=5 -> a=3        map2={n=1,a=3,g=1,r=1}
            //i=6 -> m=1        map2={n=1,a=3,g=1,r=1,m=1}
        }


        boolean anagram = true; //anagram=true


        if(!map1.equals(map2)) { //map1.equals(map2)=true

            anagram = false;
        }


        System.out.println("Brute Force: " + anagram); //true



        /*
        Optimal / Sorting Approach

        Convert both strings into character arrays.

        Then sort both arrays.

        Example:

        S = anagram
        T = nagaram

        After sorting:

        S = aaagmnr
        T = aaagmnr

        Both are same.

        Therefore, return true.

        Time Complexity: O(n log n)
        Space Complexity: O(n)
        */


        char arr1[] = s.toCharArray(); //arr1=a n a g r a m

        char arr2[] = t.toCharArray(); //arr2=n a g a r a m


        Arrays.sort(arr1); //arr1=a a a g m n r

        Arrays.sort(arr2); //arr2=a a a g m n r


        boolean anagramOptimal = true; //anagramOptimal=true


        for(int i=0; i<arr1.length; i++) { //i=0 0<7t  i=1 1<7t  i=2 2<7t  i=3 3<7t  i=4 4<7t  i=5 5<7t  i=6 6<7t  i=7 7<7f

            if(arr1[i] != arr2[i]) {

                //a!=a f
                //a!=a f
                //a!=a f
                //g!=g f
                //m!=m f
                //n!=n f
                //r!=r f

                anagramOptimal = false;

                break;
            }
        }


        System.out.println("Sorting Approach: " + anagramOptimal); //true
    }
}
