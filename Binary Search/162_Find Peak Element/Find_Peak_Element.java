import java.util.*;

public class FindPeakElement {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1}; //nums=1 2 3 1
        int n = nums.length;      //n=4

        /*
        Brute Force
        Check every element to see if it is greater than or equal to its neighbors.
        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int brutePeak = -1; //brutePeak=-1
        for(int i=0; i<n; i++) { //i=0 0<4t  i=1 1<4t  i=2 2<4t  i=3 3<4t  i=4 4<4f
            boolean leftOk = (i == 0) || (nums[i] >= nums[i - 1]);   //i=0 -> true; i=1 -> 2>=1 true; i=2 -> 3>=2 true; i=3 -> 1>=3 false
            boolean rightOk = (i == n - 1) || (nums[i] >= nums[i + 1]); //i=0 -> 1>=2 false; i=1 -> 2>=3 false; i=2 -> 3>=1 true; i=3 -> true
            
            if(leftOk && rightOk) { //i=0 false; i=1 false; i=2 true
                brutePeak = i; //brutePeak=2
                break;
            }
        }
        System.out.println("Brute Force Peak Index: " + brutePeak); //2

        /*
        Optimal Approach - Binary Search
        Compare mid with mid+1. If nums[mid] > nums[mid+1], a peak must be on the left side (including mid).
        Otherwise, a peak must be on the right side.
        Time Complexity: O(log n)
        Space Complexity: O(1)
        */
        int l = 0;              //l=0
        int r = nums.length - 1; //r=4-1=3

        while(l < r) { //0<3t  1<3t  2<3t  3<3f
            int mid = l + (r - l) / 2; //mid=0+(3-0)/2=1  mid=2+(3-2)/2=2  mid=2+(2-2)/2=2

            if(nums[mid] > nums[mid + 1]) { //nums[1]>nums[2] -> 2>3 false  nums[2]>nums[3] -> 3>1 true
                r = mid;                  //r=2
            }
            else {
                l = mid + 1;              //l=1+1=2
            }
        }

        System.out.println("Optimal Peak Index: " + l); //2
    }
}
