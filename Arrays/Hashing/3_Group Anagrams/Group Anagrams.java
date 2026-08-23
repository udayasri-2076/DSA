// Group Anagrams

/*
Brute Force

Take i at index 0 and j at index i+1.
Compare one string with every other string.

To check whether two strings are anagrams,
count the frequency of every character.

Array: eat tea tan ate nat bat

i=0 -> strs[0]="eat"

j=1 -> strs[1]="tea"

eat -> a=1 e=1 t=1
tea -> a=1 e=1 t=1

Both have same frequency.
So they are anagrams.

Group: [eat, tea, ate]

Next group:
[tan, nat]

Next group:
[bat]

Time Complexity: O(n^2 * k)
Space Complexity: O(n * k)

n = number of strings
k = average length of a string
*/


import java.util.*;

public class GroupAnagrams {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("enter the size of the array:");
        int n = in.nextInt(); //n=6

        System.out.println("enter the strings:");
        String strs[] = new String[n]; //strs={null,null,null,null,null,null}

        for(int i=0; i<n; i++) { //i=0 0<6t  i=1 1<6t  i=2 2<6t  i=3 3<6t  i=4 4<6t  i=5 5<6t  i=6 6<6f

            strs[i] = in.next(); //strs={"eat","tea","tan","ate","nat","bat"}
        }


        /*
        Brute Force
        */

        List<List<String>> bruteForce = new ArrayList<>(); //bruteForce=[]

        boolean visited[] = new boolean[n]; //visited={false,false,false,false,false,false}

        for(int i=0; i<n; i++) { //i=0 -> "eat"

            if(visited[i]) { //visited[0]=false

                continue;
            }

            List<String> group = new ArrayList<>(); //group=[]

            group.add(strs[i]); //group=[eat]

            visited[i] = true; //visited={true,false,false,false,false,false}

            for(int j=i+1; j<n; j++) { //j=1 -> tea  j=2 -> tan  j=3 -> ate  j=4 -> nat  j=5 -> bat

                if(visited[j]) { //visited[1]=false

                    continue;
                }

                int count1[] = new int[26]; //count1={0,0,0,...}

                int count2[] = new int[26]; //count2={0,0,0,...}


                for(char c : strs[i].toCharArray()) { //strs[i]="eat"

                    count1[c-'a']++; //"e" -> count1[4]=1  "a" -> count1[0]=1  "t" -> count1[19]=1
                }


                for(char c : strs[j].toCharArray()) { //j=1 -> strs[j]="tea"

                    count2[c-'a']++; //"t" -> count2[19]=1  "e" -> count2[4]=1  "a" -> count2[0]=1
                }


                if(Arrays.equals(count1,count2)) { //eat and tea -> true

                    group.add(strs[j]); //group=[eat, tea]

                    visited[j] = true; //visited={true,true,false,false,false,false}
                }
            }

            bruteForce.add(group); //bruteForce=[[eat,tea,ate]]
                                  //then [[eat,tea,ate],[tan,nat]]
                                  //then [[eat,tea,ate],[tan,nat],[bat]]
        }

        System.out.println("Brute Force: " + bruteForce);


        /*
        Better Approach

        Use HashMap.

        First sort every string.

        Example:

        eat -> aet
        tea -> aet
        ate -> aet

        Since all sorted strings are equal,
        they are anagrams.

        Store the sorted string as the key.

        aet -> [eat, tea, ate]

        ant -> [tan, nat]

        abt -> [bat]

        Time Complexity: O(n * k log k)
        Space Complexity: O(n * k)
        */

        HashMap<String,List<String>> map = new HashMap<>(); //map={}

        for(int i=0; i<n; i++) { //i=0 -> eat  i=1 -> tea  i=2 -> tan ...

            char arr[] = strs[i].toCharArray(); //i=0 -> arr={'e','a','t'}

            Arrays.sort(arr); //arr={'a','e','t'}

            String key = new String(arr); //key="aet"

            if(!map.containsKey(key)) { //containsKey("aet")=false

                map.put(key,new ArrayList<>()); //map={aet=[]}
            }

            map.get(key).add(strs[i]); //i=0 -> aet=[eat]
                                       //i=1 -> aet=[eat,tea]
                                       //i=3 -> aet=[eat,tea,ate]
                                       //i=2 -> ant=[tan]
                                       //i=4 -> ant=[tan,nat]
                                       //i=5 -> abt=[bat]
        }

        List<List<String>> betterApproach = new ArrayList<>(map.values());

        System.out.println("Better Approach: " + betterApproach);


        /*
        Optimal Approach

        Use HashMap.

        Instead of sorting every string,
        count the frequency of characters.

        Create an array of size 26.

        index 0 -> a
        index 1 -> b
        index 2 -> c
        ...
        index 25 -> z

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

        So use the frequency array as the key.

        eat -> [1,0,0,0,1,0,...,1,...]
        tea -> [1,0,0,0,1,0,...,1,...]

        Same key.

        Time Complexity: O(n * k)
        Space Complexity: O(n * k)
        */

        HashMap<String,List<String>> frequencyMap = new HashMap<>(); //frequencyMap={}

        for(int i=0; i<n; i++) { //i=0 -> eat  i=1 -> tea  i=2 -> tan ...

            int count[] = new int[26]; //count={0,0,0,...}

            for(char c : strs[i].toCharArray()) { //i=0 -> "eat"

                count[c-'a']++; //"e" -> count[4]=1
                                //"a" -> count[0]=1
                                //"t" -> count[19]=1
            }

            String key = Arrays.toString(count); //key="[1, 0, 0, 0, 1, ..., 1, ...]"

            if(!frequencyMap.containsKey(key)) { //first eat -> false

                frequencyMap.put(key,new ArrayList<>()); //frequencyMap={key=[]}
            }

            frequencyMap.get(key).add(strs[i]); //eat -> [eat]
                                                //tea -> [eat,tea]
                                                //ate -> [eat,tea,ate]
        }

        List<List<String>> optimalApproach =
                new ArrayList<>(frequencyMap.values());

        System.out.println("Optimal Approach: " + optimalApproach);
    }
}
