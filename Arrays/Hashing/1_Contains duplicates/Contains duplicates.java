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
        int n = in.nextInt();

        System.out.println("enter the elements of the array:");
        int arr[] = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }


        /*
        Brute Force
        */

        boolean duplicate = false;

        for(int i=0; i<n; i++) {

            for(int j=i+1; j<n; j++) {

                if(arr[i] == arr[j]) {
                    duplicate = true;
                    break;
                }
            }

            if(duplicate) {
                break;
            }
        }

        System.out.println("Brute Force: " + duplicate);


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

        Arrays.sort(arr);

        boolean duplicateBetter = false;

        for(int i=0; i<n-1; i++) {

            if(arr[i] == arr[i+1]) {
                duplicateBetter = true;
                break;
            }
        }

        System.out.println("Better Approach: " + duplicateBetter);


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

        HashSet<Integer> set = new HashSet<>();

        boolean duplicateOptimal = false;

        for(int i=0; i<n; i++) {

            if(set.contains(arr[i])) {
                duplicateOptimal = true;
                break;
            }

            set.add(arr[i]);
        }

        System.out.println("Optimal Approach: " + duplicateOptimal);
    }
}
