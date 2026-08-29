// Remove Duplicates from Sorted Array
/*
Brute Force
Use a HashSet to collect unique values, then copy back into array.
Time Complexity: O(n)
Space Complexity: O(n)
*/
import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 3, 3}; //arr=1 1 2 2 2 3 3
        int n = arr.length; //n=7

        /*
        Brute Force
        */
        LinkedHashSet<Integer> set = new LinkedHashSet<>(); //set={}
        for(int i=0; i<n; i++) { //i=0 0<7t  i=1 1<7t  i=2 2<7t  i=3 3<7t  i=4 4<7t  i=5 5<7t  i=6 6<7t
            set.add(arr[i]); //i=0->add(1) set={1}
                            //i=1->add(1) set={1} (dup, ignored)
                            //i=2->add(2) set={1,2}
                            //i=3->add(2) set={1,2} (dup, ignored)
                            //i=4->add(2) set={1,2} (dup, ignored)
                            //i=5->add(3) set={1,2,3}
                            //i=6->add(3) set={1,2,3} (dup, ignored)
        }
        System.out.println("Brute Force: " + set.size()); //3

        /*
        Optimal Approach - Two Pointers
        i = last unique position, j = scanner
        Only works because array is SORTED (duplicates are adjacent)
        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int arr2[] = {1, 1, 2, 2, 2, 3, 3}; //arr2=1 1 2 2 2 3 3 (fresh copy)
        int i = 0; //i=0
        for(int j=1; j<n; j++) { //j=1 1<7t  j=2 2<7t  j=3 3<7t  j=4 4<7t  j=5 5<7t  j=6 6<7t
            if(arr2[i] != arr2[j]) { //j=1: arr2[0]=1,arr2[1]=1 -> 1!=1 f
                                     //j=2: arr2[0]=1,arr2[2]=2 -> 1!=2 t
                                     //j=3: arr2[1]=2,arr2[3]=2 -> 2!=2 f
                                     //j=4: arr2[1]=2,arr2[4]=2 -> 2!=2 f
                                     //j=5: arr2[1]=2,arr2[5]=3 -> 2!=3 t
                                     //j=6: arr2[2]=3,arr2[6]=3 -> 3!=3 f
                arr2[i+1] = arr2[j]; //j=2: arr2[1]=2         //j=5: arr2[2]=3
                i++; //j=2: i=1                                //j=5: i=2
            }
        }
        System.out.println("Optimal: " + (i+1)); //3
    }
}
