import java.util.*;

public class ReverseString {
    public static void main(String[] args) {
        char s[] = {'h','e','l','l','o'}; //s=h e l l o
        int n = s.length;                 //n=5

        /*
        Optimal Approach - Two Pointers
        
        l -> left pointer starting at index 0
        r -> right pointer starting at the last index (n-1)

        Swap characters at l and r, then move l forward and r backward
        until they meet in the middle.

        Time Complexity: O(n)
        Space Complexity: O(1)
        */

        int l = 0;       // l=0 -> s[l]=h
        int r = n - 1;   // r=4 -> s[r]=o

        while (l < r) {  // 0<4t  1<3t  2<2f
            char temp = s[l]; // temp=h  // temp=e
            s[l] = s[r];      // s[0]=o  // s[1]=l
            s[r] = temp;      // s[4]=h  // s[3]=e

            l++;             // l=0+1=1  // l=1+1=2
            r--;             // r=4-1=3  // r=3-1=2
        }

        System.out.print("Reversed String: ");
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " "); // o l l e h
        }
        System.out.println();
    }
}