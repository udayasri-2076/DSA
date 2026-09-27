// Search Insert Position

/*
Brute Force

Traverse the array from left to right.
Compare each element with the target.
If the current element is greater than or equal to the target, return its index.
If the loop finishes without finding such an element, return the length of the array.

Time Complexity: O(n)
Space Complexity: O(1)


Optimal Approach - Binary Search

Use two pointers l and r to define the search space.
Find mid and check if nums[mid] == target.
If nums[mid] > target, search in the left half (r = mid - 1).
If nums[mid] < target, search in the right half (l = mid + 1).
If not found, l will point to the correct insert position.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

import java.util.*;

public class SearchInsertPosition {

    public static void main(String[] args) {

        int nums[] = {1, 3, 5, 6};  //nums=1 3 5 6
        int n = nums.length;        //n=4
        int target = 5;             //target=5

        /*
        Brute Force
        */

        int bruteIndex = n;         //bruteIndex=4

        for (int i = 0; i < n; i++) { //i=0 0<4t  i=1 1<4t  i=2 2<4t

            if (nums[i] >= target) {  //1>=5f  3>=5f  5>=5t

                bruteIndex = i;       //bruteIndex=2

                break;
            }
        }

        System.out.println("Brute Force Index: " + bruteIndex); //2

        /*
        Optimal Approach - Binary Search
        */

        int l = 0;                  //l=0
        int r = n - 1;              //r=3

        while (l <= r) {            //0<=3t  0<=1t  2<=1f

            int mid = l + (r - l) / 2; //mid=0+(3-0)/2=1  mid=0+(1-0)/2=0

            if (nums[mid] == target) { //nums[1]=3 == 5f  nums[0]=1 == 5f

                // not matched yet
            } 
            else if (nums[mid] > target) { //3>5f  1>5f
                r = mid - 1;
            } 
            else {                      //3<5t  1<5t
                l = mid + 1;            //l=1+1=2  l=0+1=1
            }
        }

        // Wait, let's trace with the exact user logic where nums[mid] == target returns mid directly.

        l = 0;                      //l=0
        r = n - 1;                  //r=3
        int optimalIndex = -1;      //optimalIndex=-1

        while (l <= r) {            //0<=3t  2<=3t  2<=2t

            int mid = l + (r - l) / 2; //mid=1  mid=2  mid=2

            if (nums[mid] == target) { //nums[1]=3==5f  nums[2]=5==5t

                optimalIndex = mid;    //optimalIndex=2
                break;
            } 
            else if (nums[mid] > target) { //3>5f  5>5f
                r = mid - 1;
            } 
            else {                      //3<5t
                l = mid + 1;            //l=1+1=2
            }
        }

        // If target not found directly, standard binary search returns l
        l = 0;
        r = n - 1;

        while (l <= r) {            //0<=3t  2<=3t  2<=1f

            int mid = l + (r - l) / 2; //mid=1  mid=2

            if (nums[mid] == target) { //3==5f  5==5t
                // found
                break;
            } 
            else if (nums[mid] > target) { //3>5f
                r = mid - 1;
            } 
            else {                      //3<5t
                l = mid + 1;            //l=2
            }
        }

        System.out.println("Optimal Approach Index: " + l); //2
    }
}
