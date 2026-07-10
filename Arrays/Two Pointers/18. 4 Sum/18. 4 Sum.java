import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;                          //n=6

        Arrays.sort(nums);                             //nums=[-2,-1,0,0,1,2]

        for (int i = 0; i < n; i++) {                   //i=0  i=1  i=2  i=3  i=4  i=5

            if (i > 0 && nums[i] == nums[i - 1]) {      //i=2: nums[2]=0==nums[1]? no(-1)   i=3: nums[3]=0==nums[2]=0 -> skip
                continue;
            }

            for (int j = i + 1; j < n; j++) {            //i=0:j=1..5   i=1:j=2..5   i=2:j=3..5

                if (j > i + 1 && nums[j] == nums[j - 1]) { //i=0,j=3: nums[3]=0==nums[2]=0 -> skip
                    continue;
                }

                int l = j + 1;                            //i=0,j=1:l=2   i=1,j=2:l=3   i=1,j=3:l=4
                int r = n - 1;                             //i=0,j=1:r=5   i=1,j=2:r=5   i=1,j=3:r=5

                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r]; //i=0,j=1,l=2,r=5: -2-1+0+2=-1   i=1,j=2,l=3,r=5: -1+0+0+2=1   i=1,j=2,l=4,r=5:-1+0+1+2=2

                    if (sum == target) {                    //true when i=0,j=2,l=4,r=5: -2+0+1+2=1? no -> actual hits below
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r])); //adds [-2,-1,1,2] then [-2,0,0,2] then [-1,0,0,1]

                        l++;                                  //move in
                        r--;                                  //move in

                        while (l < r && nums[l] == nums[l - 1]) { //skip duplicate l
                            l++;
                        }

                        while (l < r && nums[r] == nums[r + 1]) { //skip duplicate r
                            r--;
                        }
                    }
                    else if (sum > target) {                 //sum too big
                        r--;                                   //shrink from right
                    }
                    else {                                    //sum too small
                        l++;                                   //grow from left
                    }
                }
            }
        }
        return result;                                     //result=[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }
}
