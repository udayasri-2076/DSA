import java.util.*;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}; //nums=1 1 1 0 0 0 1 1 1 1 0
        int n = nums.length; //n=11
        int k = 2; //k=2

        /*
        Brute Force Approach
        Check every possible subarray, count zeros in each subarray,
        and if zeros <= k, update maximum length.
        
        Time Complexity: O(n^2)
        Space Complexity: O(1)
        */
        int maxLenBrute = 0; //maxLenBrute=0
        for(int i = 0; i < n; i++) {
            int zeros = 0; //zeros=0
            for(int j = i; j < n; j++) {
                if(nums[j] == 0) {
                    zeros++; //count zeros
                }
                if(zeros <= k) {
                    maxLenBrute = Math.max(maxLenBrute, j - i + 1); //update max length
                } else {
                    break; //too many zeros, stop inner loop
                }
            }
        }
        System.out.println("Brute Force Max Consecutive Ones: " + maxLenBrute);

        /*
        Optimal Approach - Sliding Window
        Use left (l) and right (r) pointers to maintain a window
        that contains at most k zeros.
        
        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int l = 0; //l=0
        int zerocount = 0; //zerocount=0
        int maxLen = 0; //maxLen=0

        for(int r = 0; r < n; r++) { //r=0..10
            if(nums[r] == 0) { 
                zerocount++; //r=3 -> 0, zerocount=1
                            //r=4 -> 0, zerocount=2
                            //r=5 -> 0, zerocount=3
            }

            if(zerocount > k) { //r=5 -> 3>2 true
                if(nums[l] == 0) { //nums[0]=1 false
                    zerocount--; 
                }
                l++; //l=0->1->...->4
            }

            maxLen = Math.max(maxLen, r - l + 1); //track max window size
        }

        System.out.println("Optimal Sliding Window Max Consecutive Ones: " + maxLen);
    }
}
