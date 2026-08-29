// Container With Most Water
/*
Brute Force
Check every pair (l, r) and calculate area = width * min(height[l], height[r]).
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
import java.util.*;
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int a[] = {1, 8, 6, 2, 5, 4, 8, 3, 7}; //a=1 8 6 2 5 4 8 3 7
        int n = a.length; //n=9

        /*
        Brute Force
        */
        int maxBrute = 0; //maxBrute=0
        for(int i=0; i<n; i++) { //i=0..8
            for(int j=i+1; j<n; j++) { //j=i+1..8
                int width = j - i; //e.g. i=0,j=8 -> width=8
                int h = Math.min(a[i], a[j]); //min(1,7)=1
                int area = width * h; //8*1=8
                maxBrute = Math.max(maxBrute, area); //compare and keep the largest
            }
        }
        System.out.println("Brute Force: " + maxBrute); //49

        /*
        Optimal Approach - Two Pointers
        l starts at left end, r starts at right end.
        Area = width (r-l) * shorter height (bottleneck).
        Move the pointer with the SMALLER height inward -- 
        because that shorter wall is the limiting factor, 
        moving the taller one can only shrink width without helping height.
        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int l = 0; //l=0
        int r = n - 1; //r=8
        int maximum = 0; //maximum=0
        while(l < r) { //l=0 r=8t  l=1 r=8t  l=1 r=7t  l=1 r=6t  l=1 r=5t
            int width = r - l; //width=8    width=7    width=6    width=5    width=4
            int h = Math.min(a[l], a[r]); //min(1,7)=1  min(8,7)=7  min(8,6)=6  min(8,5)=5  min(8,4)=4
            int area = width * h; //area=8     area=49    area=36    area=25    area=16
            maximum = Math.max(maximum, area); //max=8      max=49     max=49     max=49     max=49
            if(a[l] < a[r]) { //1<7 t      8<7 f      8<6 f      8<5 f      8<4 f
                l++; //l=1 -> shorter wall was on the left, move it in
            } else {
                r--; //r=7,6,5,4 -> shorter wall was on the right, move it in
            }
        }
        System.out.println("Optimal: " + maximum); //49
    }
}
