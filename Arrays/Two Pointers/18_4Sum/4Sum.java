import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int nums[] = {1, 0, -1, 0, -2, 2}; //nums=1 0 -1 0 -2 2
        int n = nums.length; //n=6
        int target = 0; //target=0

        /*
        Brute Force
        Check every combination of 4 indices (i, j, k, l) and see if they sum to target.
        Use a Set to avoid duplicate quadruplets.
        Time Complexity: O(n^4)
        Space Complexity: O(n) for the result set
        */
        Arrays.sort(nums); //nums=-2 -1 0 0 1 2
        Set<List<Integer>> set = new HashSet<>(); //set={}

        for (int i = 0; i < n; i++) { //i=0 1 2 3 4 5
            for (int j = i + 1; j < n; j++) { //j=i+1..5
                for (int k = j + 1; k < n; k++) { //k=j+1..5
                    for (int l = k + 1; l < n; l++) { //l=k+1..5
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l]; //compute 4-sum
                        if (sum == target) {
                            set.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l])); //add if match
                        }
                    }
                }
            }
        }
        List<List<Integer>> bruteResult = new ArrayList<>(set);
        System.out.println("Brute Force Result: " + bruteResult);

        /*
        Optimal Approach - Two Pointers
        Fix first two numbers with nested loops (i, j),
        then use two pointers (l, r) to find the remaining pair.
        Skip duplicates at every level (i, j, l, r) to avoid duplicate quadruplets.
        Time Complexity: O(n^3)
        Space Complexity: O(1) extra (not counting output)
        */
        List<List<Integer>> result = new ArrayList<>(); //result=[]

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

                    if (sum == target) { //target found
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++; //move l
                        r--; //move r

                        while (l < r && nums[l] == nums[l - 1]) { //skip duplicate l values
                            l++;
                        }

                        while (l < r && nums[r] == nums[r + 1]) { //skip duplicate r values
                            r--;
                        }
                    } else if (sum > target) { //sum too big -> need smaller number
                        r--; //shrink from right
                    } else { //sum too small -> need bigger number
                        l++; //grow from left
                    }
                }
            }
        }
        System.out.println("Optimal Approach Result: " + result);
    }
}
