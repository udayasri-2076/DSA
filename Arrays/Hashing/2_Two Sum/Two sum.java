```java
// Two Sum

/*
Brute Force

Take i at index 0 and j at index i+1.
Check every possible pair.

Example:

Array: 2 1 5 3
Target: 4

i=0 -> arr[0]=2

j=1 -> arr[0] + arr[1] = 2 + 1 = 3
j=2 -> arr[0] + arr[2] = 2 + 5 = 7
j=3 -> arr[0] + arr[3] = 2 + 3 = 5

i=1 -> arr[1]=1

j=2 -> arr[1] + arr[2] = 1 + 5 = 6
j=3 -> arr[1] + arr[3] = 1 + 3 = 4

4 == target

Return indexes [1,3]

Time Complexity: O(n^2)
Space Complexity: O(1)
*/


import java.util.*;

public class TwoSum {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("enter the size of the array:");
        int n = in.nextInt(); //n=4

        System.out.println("enter the elements of the array:");
        int arr[] = new int[n]; //arr=0 0 0 0

        for(int i=0; i<n; i++) { //i=0 0<4t  i=1 1<4t  i=2 2<4t  i=3 3<4t  i=4 4<4f

            arr[i] = in.nextInt(); //arr=2 1 5 3
        }

        System.out.println("enter the target:");
        int target = in.nextInt(); //target=4


        /*
        Brute Force
        */

        boolean found = false; //found=false

        for(int i=0; i<n; i++) { //i=0 0<4t  i=1 1<4t

            for(int j=i+1; j<n; j++) { //i=0 -> j=1 1<4t, j=2 2<4t, j=3 3<4t
                                      //i=1 -> j=2 2<4t, j=3 3<4t

                if(arr[i] + arr[j] == target) { //2+1=3f  2+5=7f  2+3=5f
                                                //1+5=6f  1+3=4t

                    System.out.println("Brute Force: [" + i + ", " + j + "]"); //[1,3]

                    found = true; //found=true

                    break;
                }
            }

            if(found) { //true

                break;
            }
        }


        /*
        Optimal Approach - HashMap

        Store:

        value -> index

        Example:

        Array: 2 1 5 3
        Target: 4

        i=0 -> value=2
        difference = target - value
        difference = 4 - 2 = 2

        2 is not present in HashMap.

        Store:
        2 -> 0


        i=1 -> value=1
        difference = 4 - 1 = 3

        3 is not present in HashMap.

        Store:
        1 -> 1


        i=2 -> value=5
        difference = 4 - 5 = -1

        -1 is not present in HashMap.

        Store:
        5 -> 2


        i=3 -> value=3
        difference = 4 - 3 = 1

        1 is present in HashMap.

        1 -> index 1

        Current index = 3

        Therefore:
        [1,3]

        Time Complexity: O(n)
        Space Complexity: O(n)
        */


        HashMap<Integer,Integer> map = new HashMap<>(); //map={}

        boolean foundOptimal = false; //foundOptimal=false

        for(int i=0; i<n; i++) { //i=0 0<4t  i=1 1<4t  i=2 2<4t  i=3 3<4t  i=4 4<4f

            int difference = target - arr[i]; //i=0 -> 4-2=2
                                             //i=1 -> 4-1=3
                                             //i=2 -> 4-5=-1
                                             //i=3 -> 4-3=1

            if(map.containsKey(difference)) { //i=0 -> containsKey(2)=false
                                             //i=1 -> containsKey(3)=false
                                             //i=2 -> containsKey(-1)=false
                                             //i=3 -> containsKey(1)=true

                System.out.println("Optimal: [" + map.get(difference) + ", " + i + "]"); //[1,3]

                foundOptimal = true; //foundOptimal=true

                break;
            }

            map.put(arr[i], i); //i=0 -> map={2=0}
                               //i=1 -> map={2=0, 1=1}
                               //i=2 -> map={2=0, 1=1, 5=2}
                               //i=3 -> not executed because duplicate pair found
        }

        if(!foundOptimal) { //false

            System.out.println("Optimal: [-1, -1]");
        }
    }
}
```
