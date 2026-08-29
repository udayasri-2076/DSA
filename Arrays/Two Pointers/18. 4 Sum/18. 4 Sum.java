// 4Sum
/*
Brute Force
Check every combination of 4 indices (i, j, k, l) and see if they sum to target.
Use a Set to avoid duplicate quadruplets.
Time Complexity: O(n^4)
Space Complexity: O(n) for the result set
*/
import java.util.*;
class Solution {
    public List<List<Integer>> bruteForce(int[] nums, int target) {
        Arrays.sort(nums); //nums=[-2,-1,0,0,1,2]
        int n = nums.length; //n=6
        Set<List<Integer>> set = new HashSet<>(); //set={} -> avoids duplicate quadruplets

        for(int i=0; i<n; i++) { //i=0..5
            for(int j=i+1; j<n; j++) { //j=i+1..5
                for(int k=j+1; k<n; k++) { //k=j+1..5
                    for(int l=k+1; l<n; l++) { //l=k+1..5
                        long sum = (long) nums[i]+nums[j]+nums[k]+nums[l]; //check 4-sum
                        if(sum == target) {
                            set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l])); //add if match
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    /*
    Optimal Approach - Two Pointers
    Fix first two numbers with nested loops (i, j), 
    then use two pointers (l, r) to find the remaining pair -- 
    same trick as 3Sum but with one more fixed number.
    Skip duplicates at every level (i, j, l, r) to avoid duplicate quadruplets.
    Time Complexity: O(n^3) -- better than brute force's O(n^4)
    Space Complexity: O(1) extra (not counting output)
    */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>(); //result=[]
        int n = nums.length; //n=6
        Arrays.sort(nums); //nums=[-2,-1,0,0,1,2]

        for (int i = 0; i < n; i++) { //i=0..5
            if (i > 0 && nums[i] == nums[i - 1]) { //skip duplicate first number
                continue;
            }
            for (int j = i + 1; j < n; j++) { //j=i+1..5
                if (j > i + 1 && nums[j] == nums[j - 1]) { //skip duplicate second number
                    continue;
                }
                int l = j + 1; //left pointer starts right after j
                int r = n - 1; //right pointer starts at the end
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r]; //compute 4-sum
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r])); //found a match
                        l++; //move both pointers inward
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) { //skip duplicate l values
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) { //skip duplicate r values
                            r--;
                        }
                    }
                    else if (sum > target) { //sum too big -> need a smaller number
                        r--; //shrink from right
                    }
                    else { //sum too small -> need a bigger number
                        l++; //grow from left
                    }
                }
            }
        }
        return result; //e.g. [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    }
}
