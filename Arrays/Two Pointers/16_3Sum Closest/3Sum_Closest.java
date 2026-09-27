import java.util.*;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int nums[] = {-1, 2, 1, -4}; //nums=-1 2 1 -4
        int n = nums.length; //n=4
        int target = 1; //target=1

        /*
        Brute Force Approach

        Check every triplet combination (i, j, k) and find the sum.
        Track the sum closest to the target.

        Time Complexity: O(n^3)
        Space Complexity: O(1)
        */

        int bruteClose = nums[0] + nums[1] + nums[2]; //bruteClose=-1+2+1=2

        for(int i=0; i<n; i++) { //i=0..3
            for(int j=i+1; j<n; j++) { //j=i+1..3
                for(int k=j+1; k<n; k++) { //k=j+1..3
                    int sum = nums[i] + nums[j] + nums[k]; //compute triplet sum
                    if(Math.abs(sum - target) < Math.abs(bruteClose - target)) {
                        bruteClose = sum; //update closest sum
                    }
                    if(sum == target) {
                        break;
                    }
                }
            }
        }

        System.out.println("Brute Force Closest Sum: " + bruteClose);

        /*
        Optimal Approach - Two Pointers

        Sort the array first.
        Fix one number using index i, then use two pointers (l and r)
        to find the remaining two numbers.
        Adjust pointers based on whether the sum is less than or greater than target.

        Time Complexity: O(n^2)
        Space Complexity: O(1)
        */

        Arrays.sort(nums); //nums=-4,-1,1,2

        int close = nums[0] + nums[1] + nums[2]; //close=-4+-1+1=-4

        for(int i=0; i<n-2; i++) { //i=0
            int l = i+1; //l=1
            int r = n-1; //r=3

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r]; //sum=-4+-1+2=-3

                if(Math.abs(sum - target) < Math.abs(close - target)) { //|-3-1|=4 < |-4-1|=5 -> true
                    close = sum; //close=-3
                }

                if(sum == target) {
                    close = sum;
                    break;
                } 
                else if(sum < target) { //-3 < 1 -> true
                    l++; //move l to increase sum
                } 
                else {
                    r--; //move r to decrease sum
                }
            }
        }

        System.out.println("Optimal Closest Sum: " + close);
    }
}
