/*
Three Sum

Brute Force

Use three loops.

Take every possible combination of three numbers
and check whether their sum is equal to 0.

nums[i] + nums[j] + nums[k] == 0

Example:

[-1, 0, 1, 2, -1, -4]

-1 + -1 + 2 = 0  -> [-1,-1,2]
-1 + 0 + 1 = 0   -> [-1,0,1]

Time Complexity: O(n^3)
Space Complexity: O(1)


Optimal Approach

First sort the array.

Then fix one number using i.

Use two pointers:

l = i + 1
r = n - 1

Calculate:

nums[i] + nums[l] + nums[r]

If sum == 0:
    Add the triplet.

If sum < 0:
    Move l forward to increase the sum.

If sum > 0:
    Move r backward to decrease the sum.

Skip duplicate values to avoid duplicate triplets.

Time Complexity: O(n^2)
Space Complexity: O(1) excluding the output
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;                         //n=6

        Arrays.sort(nums);                           //nums=[-4,-1,-1,0,1,2]

        List<List<Integer>> result = new ArrayList<>(); //result=[]

        for(int i=0; i<n; i++) {                     //i=0  i=1  i=2  i=3  i=4  i=5

            if(i>0 && nums[i]==nums[i-1]) {          //i=2 -> nums[2]=-1 == nums[1]=-1 -> skip duplicate
                continue;
            }

            int l=i+1;                               //i=0 -> l=1   i=1 -> l=2

            int r=n-1;                               //i=0 -> r=5   i=1 -> r=5

            while(l<r) {

                int sum=nums[i]+nums[l]+nums[r];
                //i=0,l=1,r=5 -> -4 + -1 + 2 = -3
                //i=0,l=2,r=5 -> -4 + -1 + 2 = -3
                //i=0,l=3,r=5 -> -4 + 0 + 2 = -2
                //i=0,l=4,r=5 -> -4 + 1 + 2 = -1
                //i=1,l=2,r=5 -> -1 + -1 + 2 = 0

                if(sum==0) {                         //true -> -1 + -1 + 2 = 0

                    result.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //result=[[-1,-1,2]]

                    l++;                             //l=3

                    r--;                             //r=4

                    while(l<r && nums[l]==nums[l-1]) {
                        l++;                          //skip duplicate left values
                    }

                    while(l<r && nums[r]==nums[r+1]) {
                        r--;                          //skip duplicate right values
                    }

                }
                else if(sum>0) {

                    r--;                             //sum is too large -> decrease sum

                }
                else {

                    l++;                             //sum is too small -> increase sum
                }
            }
        }

        return result;                               //result=[[-1,-1,2],[-1,0,1]]
    }
}
