import java.util.*;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2}; // nums=4 5 6 7 0 1 2
        int n = nums.length;                // n=7
        int target = 0;                     // target=0

        /*
        Brute Force

        Traverse every element in the array and compare with target.

        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int bruteResult = -1;                 // bruteResult=-1
        for(int i=0; i<n; i++) {              // i=0 0<7t  i=1 1<7t  i=2 2<7t  i=3 3<7t  i=4 4<7t
            if(nums[i] == target) {           // 4==0f  5==0f  6==0f  7==0f  0==0t
                bruteResult = i;              // bruteResult=4
                break;
            }
        }
        System.out.println("Brute Force Index: " + bruteResult); // 4

        /*
        Optimal Approach - Binary Search

        Divide the array into halves. At least one half will always be sorted.
        Check if target lies in the sorted half, otherwise search in the other half.

        Time Complexity: O(log n)
        Space Complexity: O(1)
        */
        int l = 0;                            // l=0 -> nums[l]=4
        int r = n - 1;                        // r=6 -> nums[r]=2
        int optimalResult = -1;               // optimalResult=-1

        while(l <= r) {                       // 0<=6t  0<=2t  4<=2f
            int mid = l + (r - l) / 2;        // mid=0+(6-0)/2=3 -> nums[mid]=7
                                              // mid=4+(6-4)/2=5 -> nums[mid]=1

            if(nums[mid] == target) {         // 7==0f  1==0f
                optimalResult = mid;
                break;
            }

            else if(nums[mid] >= nums[l]) {   // left sorted array
                                              // 7>=4t
                if(nums[l] <= target && target < nums[mid]) { // 4<=0f && 0<7
                    r = mid - 1;
                }
                else {
                    l = mid + 1;              // l=3+1=4 -> l=4
                }
            }
            else {                            // right sorted array
                                              // 1>=0t
                if(nums[mid] < target && target <= nums[r]) { // 1<0f && 0<=2
                    l = mid + 1;
                }
                else {
                    r = mid - 1;              // r=5-1=4 -> r=4
                }
            }
        } // next loop: l=4, r=4 -> mid=4+0=4 -> nums[4]=0 == target -> optimalResult=4

        System.out.println("Optimal Approach Index: " + optimalResult); // 4
    }
}
