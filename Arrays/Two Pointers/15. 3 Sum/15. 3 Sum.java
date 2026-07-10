import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;                       //n=6
        Arrays.sort(nums);                          //nums=[-4,-1,-1,0,1,2]
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {                //i=0  i=1  i=2  i=3  i=4  i=5

            if (i > 0 && nums[i] == nums[i - 1]) {   //i=2: nums[2]=-1==nums[1]=-1 -> skip
                continue;
            }

            int l = i + 1;                           //i=0:l=1   i=1:l=2   i=3:l=4
            int r = n - 1;                            //i=0:r=5   i=1:r=5   i=3:r=5

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r]; //i=0,l=1,r=5: -4-1+2=-3   i=0,l=4,r=5: -4+1+2=-1   i=1,l=2,r=5: -1-1+2=0

                if (sum == 0) {                        //true when i=1,l=2,r=5 and i=1,l=3,r=4
                    result.add(Arrays.asList(nums[i], nums[l], nums[r])); //adds [-1,-1,2] then [-1,0,1]

                    l++;                                //l=3        l=4
                    r--;                                 //r=4        r=3

                    while (l < r && nums[l] == nums[l - 1]) { //skip duplicate l
                        l++;
                    }

                    while (l < r && nums[r] == nums[r + 1]) { //skip duplicate r
                        r--;
                    }
                }
                else if (sum > 0) {                     //i=3,l=4,r=5: 0+1+2=3>0
                    r--;                                  //r=4
                }
                else {                                   //i=0,l=1,r=5: -3<0
                    l++;                                  //l=2
                }
            }
        }
        return result;                                  //result=[[-1,-1,2],[-1,0,1]]
    }
}
