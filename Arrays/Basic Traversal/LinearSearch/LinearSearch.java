//Find the element using Linear Search

/*
Linear Search

Traverse the array from left to right
and compare every element with the target.

If target is found:
    print its index
    stop searching

If target is not found:
    print -1

Array: 3 2 1 5 2
Target: 5

Output: 3
*/

import java.util.*;

public class LinearSearch {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("enter the size of the array:");
        int n = in.nextInt();   //5

        System.out.println("enter the elements of the array:");
        int arr[] = new int[n]; //0 0 0 0 0

        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();  //3 2 1 5 2
        }

        System.out.println("enter the element to search:");
        int target = in.nextInt();  //5

        int index = -1;

        for(int i=0;i<n;i++){        //i=0 1 2 3 4
            if(arr[i] == target){    //3==5F 2==5F 1==5F 5==5T
                index = i;           //index=3
                break;               //stop searching
            }
        }

        System.out.println("element found at index: " + index);
    }
}
