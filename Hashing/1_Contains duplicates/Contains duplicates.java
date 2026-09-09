
// Contains Duplicate

/*
Brute Force

Take i at index 0 and j at index i+1.
Compare every element with every other element.

Array: 1 2 3 1

i=0 -> arr[0]=1
j=1 -> arr[1]=2  // 1 != 2
j=2 -> arr[2]=3  // 1 != 3
j=3 -> arr[3]=1  // 1 == 1 -> duplicate found

Time Complexity: O(n^2)
Space Complexity: O(1)
*/


import java.util.*;

public class ContainsDuplicate {

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);

        System.out.println("enter the size of the array:");
        int n = in.nextInt(); //n=4

        System.out.println("enter the elements of the array:");
        int arr[] = new int[n]; //arr=0 0 0 0

        for(int i=0; i<n; i++) { //i=0 0<4t  i=1 1<4t  i=2 2<4t  i=3 3<4t  i=4 4<4f

            arr[i] = in.nextInt(); //arr=1 2 3 1
        }


        /*
        Brute Force
        */

        boolean duplicate = false; //duplicate=false

        for(int i=0; i<n; i++) { //i=0 0<4t

            for(int j=i+1; j<n; j++) { //j=1 1<4t  j=2 2<4t  j=3 3<4t

                if(arr[i] == arr[j]) { //1==2f  1==3f  1==1t

                    duplicate = true; //duplicate=true

                    break;
                }
            }

            if(duplicate) { //true

                break;
            }
        }

        System.out.println("Brute Force: " + duplicate); //true


        /*
        Better Approach

        First sort the array.

        Example:
        Array: 3 1 2 1

        Sorting:
        1 1 2 3

        Now compare arr[i] with arr[i+1].

        If both are equal, duplicate is present.

        Time Complexity: O(n log n)
        Space Complexity: O(1)
        */

        Arrays.sort(arr); //arr=1 1 2 3

        boolean duplicateBetter = false; //duplicateBetter=false

        for(int i=0; i<n-1; i++) { //i=0 0<3t  i=1 1<3t  i=2 2<3t  i=3 3<3f

            if(arr[i] == arr[i+1]) { //1==1t

                duplicateBetter = true; //duplicateBetter=true

                break;
            }
        }

        System.out.println("Better Approach: " + duplicateBetter); //true


        /*
        Optimal Approach

        Use HashSet.

        HashSet contains only unique values.

        Example:

        Array: 1 2 3 1

        1 -> not present -> add 1
        2 -> not present -> add 2
        3 -> not present -> add 3
        1 -> already present -> duplicate found

        Time Complexity: O(n) average
        Space Complexity: O(n)
        */

        HashSet<Integer> set = new HashSet<>(); //set={}

        boolean duplicateOptimal = false; //duplicateOptimal=false

        for(int i=0; i<n; i++) { //i=0 0<4t  i=1 1<4t  i=2 2<4t  i=3 3<4t

            if(set.contains(arr[i])) { //contains(1)=false  contains(2)=false  contains(3)=false  contains(1)=true

                duplicateOptimal = true; //duplicateOptimal=true

                break;
            }

            set.add(arr[i]); //i=0 -> set={1}
                            //i=1 -> set={1,2}
                            //i=2 -> set={1,2,3}
        }

        System.out.println("Optimal Approach: " + duplicateOptimal); //true
    }
}
```
