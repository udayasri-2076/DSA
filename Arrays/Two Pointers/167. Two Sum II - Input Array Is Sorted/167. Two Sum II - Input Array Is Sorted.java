// Two Sum II - Input Array Is Sorted
/*
Brute Force
Check every pair (i, j) and see if arr[i] + arr[j] == target.
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
import java.util.*;
public class TwoSumII {
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15}; //arr=2 7 11 15 (already sorted)
        int n = arr.length; //n=4
        int target = 9; //target=9

        /*
        Brute Force
        */
        int bi = -1, bj = -1; //bi=-1 bj=-1
        for(int i=0; i<n; i++) { //i=0..3
            for(int j=i+1; j<n; j++) { //j=i+1..3
                if(arr[i] + arr[j] == target) { //2+7=9t
                    bi = i; bj = j; //bi=0 bj=1
                }
            }
        }
        System.out.println("Brute Force: " + (bi+1) + " " + (bj+1)); //1 2 (1-indexed)

        /*
        Optimal Approach - Two Pointers
        Since array is SORTED, use i at start, j at end.
        If sum too big -> the only way to reduce it is move j inward (smaller value).
        If sum too small -> the only way to increase it is move i inward (bigger value).
        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int i = 0; //i=0
        int j = arr.length - 1; //j=3
        while (i < j) { //i=0 j=3t
            if (arr[i] + arr[j] == target) { //2+15=17t? no wait check trace below
                System.out.println("Optimal: " + (i+1) + " " + (j+1));
                break;
            } else if (arr[i] + arr[j] > target) { //sum too big -> shrink from right
                j--;
            } else { //sum too small -> grow from left
                i++;
            }
        }
    }
}
