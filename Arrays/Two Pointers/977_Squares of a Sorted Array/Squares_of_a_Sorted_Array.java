// Squares of a Sorted Array

/*
Brute Force Approach

Square every element in the array first, then sort the array.

Example:
nums = [-4,-1,0,3,10]

Square each element:
nums = [16,1,0,9,100]

Sort the array:
nums = [0,1,9,16,100]

Time Complexity: O(n log n)
Space Complexity: O(1) or O(n) depending on sorting algorithm


Optimal Approach - Two Pointers

Since the array is already sorted, the largest squared values
will always be at the extreme ends (either very large negative numbers
or very large positive numbers).

Use two pointers (l and r) starting at both ends of the array.
Compare absolute values, place the larger square at the end of the result array,
and move the corresponding pointer inward.

Example:
nums = [-4,-1,0,3,10]
n = 5
l = 0, r = 4

res = [0, 0, 0, 0, 0]

i = 4 -> |-4| > |10| (4 > 10) false -> res[4] = 10*10 = 100, r = 3
i = 3 -> |-4| > |3| (4 > 3) true -> res[3] = (-4)*(-4) = 16, l = 1
i = 2 -> |-1| > |3| (1 > 3) false -> res[2] = 3*3 = 9, r = 2
i = 1 -> |-1| > |0| (1 > 0) true -> res[1] = (-1)*(-1) = 1, l = 2
i = 0 -> |0| > |0| (0 > 0) false -> res[0] = 0*0 = 0, r = 1

Result = [0, 1, 9, 16, 100]

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

public class SquaresOfASortedArray {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("enter the size of the array:");
        int n = in.nextInt(); //n=5

        System.out.println("enter the elements of the array:");
        int nums[] = new int[n]; //nums=0 0 0 0 0

        for(int i=0; i<n; i++) {
            nums[i] = in.nextInt(); //nums=-4 -1 0 3 10
        }

        /*
        Brute Force
        */
        int bruteRes[] = nums.clone(); //bruteRes=-4 -1 0 3 10

        for(int i=0; i<n; i++) { //i=0..4
            bruteRes[i] = bruteRes[i] * bruteRes[i]; //bruteRes=16 1 0 9 100
        }

        Arrays.sort(bruteRes); //bruteRes=0 1 9 16 100

        System.out.print("Brute Force: ");
        for(int i=0; i<n; i++) {
            System.out.print(bruteRes[i] + " "); //0 1 9 16 100
        }
        System.out.println();

        /*
        Optimal Approach - Two Pointers
        */
        int l = 0; //l=0 -> nums[l]=-4
        int r = n - 1; //r=4 -> nums[r]=10

        int res[] = new int[n]; //res=0 0 0 0 0

        for(int i=n-1; i>=0; i--) { //i=4 i=3 i=2 i=1 i=0

            if(Math.abs(nums[l]) > Math.abs(nums[r])) { //|-4|>|10|f  |-4|>|3|t  |-1|>|3|f  |-1|>|0|t  |0|>|0|f

                res[i] = nums[l] * nums[l]; //i=3 -> res[3]=16  i=1 -> res[1]=1
                l++; //l=1+1=2  l=1+1=2
            }
            else {

                res[i] = nums[r] * nums[r]; //i=4 -> res[4]=100  i=2 -> res[2]=9  i=0 -> res[0]=0
                r--; //r=4-1=3  r=3-1=2  r=1-1=0
            }
        }

        System.out.print("Optimal Approach: ");
        for(int i=0; i<n; i++) {
            System.out.print(res[i] + " "); //0 1 9 16 100
        }
        System.out.println();
    }
}
