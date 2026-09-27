import java.util.*;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; //nums=0 0 1 1 1 2 2 3 3 4
        int n = nums.length; //n=10

        /*
        Brute Force Approach

        Use a HashSet to store unique elements.
        Then put unique elements back into the array.

        Time Complexity: O(n log n) due to sorting or set insertion + O(n) to rewrite
        Space Complexity: O(n)
        */
        int numsBF[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int nBF = numsBF.length; //nBF=10

        Set<Integer> set = new LinkedHashSet<>(); //set={}
        for(int i=0; i<nBF; i++) { //i=0..9
            set.add(numsBF[i]); //add unique elements
        }

        int index = 0; //index=0
        for(int val : set) { //val=0,1,2,3,4
            numsBF[index] = val; //numsBF updated with unique elements
            index++; //index=1 2 3 4 5
        }

        System.out.println("Brute Force Unique Count: " + index); //5

        /*
        Optimal Approach - Two Pointers

        l -> points to the last unique element found
        r -> scans the array to find new unique elements

        If nums[r] != nums[l], we found a new unique element.
        Move l forward and store nums[r] at nums[l].

        Time Complexity: O(n)
        Space Complexity: O(1)
        */

        int l = 0; //l=0 -> nums[l]=0
        for(int r = 1; r < n; r++) { //r=1..9

            if(nums[r] != nums[l]) { //nums[1]!=nums[0](0!=0f), nums[2]!=nums[0](1!=0t), ...

                nums[l + 1] = nums[r]; //nums[1]=nums[2]->1
                l++; //l=1
            }
        }

        System.out.println("Optimal Approach Unique Count: " + (l + 1)); //l+1=5
    }
}