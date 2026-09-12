// 16. 3Sum Closest
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int[] nums = {-1, 2, 1, -4};
        int target = 1;


        /*
        Brute Force
        Check every possible combination of 3 numbers.
        Find the sum which is closest to target.

        Time Complexity: O(n^3)
        Space Complexity: O(1)
        */

        int closest = nums[0] + nums[1] + nums[2];
        //closest = -1+2+1
        //closest = 2


        for(int i=0; i<nums.length-2; i++){             //i=0->i=1

            for(int j=i+1; j<nums.length-1; j++){      //j=1->j=2

                for(int k=j+1; k<nums.length; k++){    //k=2->k=3

                    int sum = nums[i] + nums[j] + nums[k];

                    /*
                    i=0,j=1,k=2
                    sum = -1+2+1
                    sum = 2
                    */

                    if(Math.abs(sum-target) < Math.abs(closest-target)){

                        closest=sum;

                        //sum=2
                        //closest=2
                    }
                }
            }
        }


        System.out.println("Brute Force: "+closest);
        //Brute Force: 2



        /*
        Optimal Approach - Sorting + Two Pointer

        Sort the array first.

        Fix one element using i.
        Use two pointers:
        left  -> moves forward
        right -> moves backward

        If sum < target:
        move left++

        If sum > target:
        move right--

        Time Complexity: O(n^2)
        Space Complexity: O(1)
        */


        Arrays.sort(nums);

        /*
        Before sorting:

        nums = {-1,2,1,-4}

        After sorting:

        nums = {-4,-1,1,2}
        */


        int result = nums[0] + nums[1] + nums[2];

        //result = -4 + -1 + 1
        //result = -4


        for(int i=0; i<nums.length-2; i++){             //i=0->i=1

            int left = i+1;                             //i=0->left=1

            int right = nums.length-1;                 //right=3


            while(left < right){

                int sum = nums[i] + nums[left] + nums[right];

                /*
                i=0
                left=1
                right=3

                nums[i] = -4
                nums[left] = -1
                nums[right] = 2

                sum = -4 + -1 + 2
                sum = -3
                */


                if(Math.abs(sum-target) < Math.abs(result-target)){

                    result=sum;

                    /*
                    sum=-3
                    target=1

                    |sum-target|
                    =|-3-1|
                    =4

                    result=-4

                    |result-target|
                    =|-4-1|
                    =5

                    4 < 5

                    Therefore:

                    result=-3
                    */
                }


                /*
                If sum is exactly equal to target,
                we found the closest possible answer.

                Difference = 0

                Nothing can be closer than 0.
                */

                if(sum == target){

                    result=sum;

                    break;
                }


                /*
                If sum is smaller than target,
                we need to increase the sum.

                Since array is sorted,
                move left forward.
                */

                if(sum < target){

                    left++;

                    /*
                    sum=-3
                    target=1

                    -3 < 1

                    Therefore:

                    left++;
                    */
                }


                /*
                If sum is greater than target,
                we need to decrease the sum.

                Since array is sorted,
                move right backward.
                */

                else{

                    right--;

                    /*
                    sum>target

                    Therefore:

                    right--;
                    */
                }
            }
        }


        System.out.println("Optimal: "+result);
        //Optimal: 2
    }
}
