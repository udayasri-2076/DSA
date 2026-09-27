import java.util.*;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7}; //height=1 8 6 2 5 4 8 3 7
        int n = height.length; //n=9

        /*
        Brute Force

        Check every possible pair of lines (i, j) to find the container
        that holds the most water.
        Area = width * min height = (j - i) * min(height[i], height[j])

        Time Complexity: O(n^2)
        Space Complexity: O(1)
        */

        int maxiBF = 0; //maxiBF=0

        for (int i = 0; i < n; i++) { //i=0..8
            for (int j = i + 1; j < n; j++) { //j=i+1..8
                int width = j - i;
                int h = Math.min(height[i], height[j]);
                int area = width * h;
                maxiBF = Math.max(area, maxiBF); //update max area
            }
        }

        System.out.println("Brute Force Max Area: " + maxiBF); //49


        /*
        Optimal Approach - Two Pointers

        l -> left pointer at index 0
        r -> right pointer at index n-1

        Width starts at maximum (n-1).
        To maximize area, we need taller heights. Since the area is limited by
        the shorter line, move the pointer pointing to the shorter line inward.

        Time Complexity: O(n)
        Space Complexity: O(1)
        */

        int l = 0; //l=0 -> height[l]=1
        int r = n - 1; //r=8 -> height[r]=7
        int maxi = 0; //maxi=0

        while (l < r) { //0<8t  1<8t  ...  1<7t

            int width = r - l; //8-0=8  8-1=7  ...  7-1=6
            int h = Math.min(height[l], height[r]); //min(1,7)=1  min(8,7)=7  ...
            int area = width * h; //8*1=8  7*7=49  ...
            maxi = Math.max(area, maxi); //max(8,0)=8  max(49,8)=49  ...

            if (height[l] < height[r]) { //1<7t  8<7f  ...
                l++; //l=0+1=1
            } else {
                r--;
            }
        }

        System.out.println("Optimal Approach Max Area: " + maxi); //49
    }
}
