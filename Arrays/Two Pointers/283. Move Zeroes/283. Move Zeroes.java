// Move Zeroes
/*
Brute Force
Create a new array, copy all non-zero elements first, 
then fill the rest with zeroes. Copy it back into original array.
Time Complexity: O(n)
Space Complexity: O(n) -> extra array used
*/
import java.util.*;
public class MoveZeroes {
    public static void main(String[] args) {
        int a[] = {1, 0, 3, 0, 12}; //a=1 0 3 0 12
        int n = a.length; //n=5

        /*
        Brute Force
        */
        int temp[] = new int[n]; //temp=0 0 0 0 0
        int idx = 0; //idx=0
        for(int i=0; i<n; i++) { //i=0..4
            if(a[i] != 0) { //1!=0t  0!=0f  3!=0t  0!=0f  12!=0t
                temp[idx] = a[i]; //temp[0]=1          temp[1]=3          temp[2]=12
                idx++; //idx=1              idx=2              idx=3
            }
        } //temp = 1 3 12 0 0 (remaining slots already 0 by default)
        System.out.print("Brute Force: ");
        for(int i=0; i<n; i++) System.out.print(temp[i] + " "); //1 3 12 0 0

        /*
        Optimal Approach - Two Pointers
        l = position where the next non-zero element should go
        r = scanner moving through the array
        Whenever a[r] is non-zero, swap it into position l, then advance l.
        This pushes all non-zero elements to the front IN ORDER,
        and all zeroes naturally end up at the back.
        Time Complexity: O(n)
        Space Complexity: O(1) -> in-place, no extra array
        */
        int a2[] = {1, 0, 3, 0, 12}; //a2=1 0 3 0 12 (fresh copy)
        int l = 0; //l=0
        for(int r = 0; r < n; r++) { //r=0 1!=0t   r=1 0!=0f   r=2 3!=0t   r=3 0!=0f   r=4 12!=0t
            if(a2[r] != 0) {
                int t = a2[l]; //r=0: t=a2[0]=1        r=2: t=a2[1]=0        r=4: t=a2[3]=0
                a2[l] = a2[r]; //a2[0]=1               a2[1]=3               a2[3]=12
                a2[r] = t; //a2[0]=1                   a2[2]=0               a2[4]=0
                l++; //l=1                             l=2                   l=3
            }
        }
        System.out.print("\nOptimal: ");
        for(int i=0; i<n; i++) System.out.print(a2[i] + " "); //1 3 12 0 0
    }
}
