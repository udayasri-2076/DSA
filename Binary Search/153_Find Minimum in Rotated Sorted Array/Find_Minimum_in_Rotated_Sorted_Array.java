import java.util.*;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {3, 4, 5, 1, 2}; //nums=3 4 5 1 2
        int n = nums.length; //n=5

        /*
        Brute Force Approach

        Traverse through all elements of the array and find the minimum value.

        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int minBrute = nums[0]; //minBrute=3
        for(int i = 0; i < n; i++) { //i=0 0<5t  i=1 1<5t  i=2 2<5t  i=3 3<5t  i=4 4<5t  i=5 5<5f
            if(nums[i] < minBrute) { //3<3f  4<3f  5<3f  1<3t  2<1f
                minBrute = nums[i]; //minBrute=1
            }
        }

        System.out.println("Brute Force Minimum: " + minBrute); //1

        /*
        Optimal Approach - Binary Search

        Initialize two pointers l=0 and r=n-1.
        Find mid and compare nums[mid] with nums[r].
        If nums[mid] <= nums[r], the minimum must be in the left half including mid, so set r = mid.
        Otherwise, the minimum is in the right half, so set l = mid + 1.

        Time Complexity: O(log n)
        Space Complexity: O(1)
        */
        int l = 0; //l=0
        int r = n - 1; //r=4 -> nums[r]=2

        while(l < r) { //0<4t  0<2t  3<2f
            int mid = l + (r - l) / 2; //mid=0+(4-0)/2=2 -> nums[mid]=5
                                       //mid=0+(2-0)/2=1 -> nums[mid]=4

            if(nums[mid] <= nums[r]) { //5<=2f  4<=2f
                r = mid;
            } else {
                l = mid + 1; //l=2+1=3 -> nums[l]=1
                             //l=1+1=2 -> nums[l]=5
            }
        }

        int minOptimal = nums[l]; //minOptimal=1

        System.out.println("Optimal Approach Minimum: " + minOptimal); //1
    }
}