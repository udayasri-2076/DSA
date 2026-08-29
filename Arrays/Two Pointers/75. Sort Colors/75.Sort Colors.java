// Sort Colors (Dutch National Flag)
/*
Brute Force
Count how many 0s, 1s, and 2s exist, then overwrite the array
in that order.
Time Complexity: O(n)
Space Complexity: O(1) -> just 3 counters
*/
import java.util.*;
public class SortColors {
    public static void main(String[] args) {
        int a[] = {2, 0, 2, 1, 1, 0}; //a=2 0 2 1 1 0
        int n = a.length; //n=6

        /*
        Brute Force
        */
        int count0 = 0, count1 = 0, count2 = 0; //count0=0 count1=0 count2=0
        for(int i=0; i<n; i++) { //i=0..5
            if(a[i] == 0) count0++;      //a[1]=0 -> count0=1   a[5]=0 -> count0=2
            else if(a[i] == 1) count1++; //a[3]=1 -> count1=1   a[4]=1 -> count1=2
            else count2++;                //a[0]=2 -> count2=1   a[2]=2 -> count2=2
        }
        int idx = 0; //idx=0
        for(int i=0; i<count0; i++) { a[idx++] = 0; } //fills a[0],a[1]=0,0
        for(int i=0; i<count1; i++) { a[idx++] = 1; } //fills a[2],a[3]=1,1
        for(int i=0; i<count2; i++) { a[idx++] = 2; } //fills a[4],a[5]=2,2
        System.out.print("Brute Force: ");
        for(int i=0; i<n; i++) System.out.print(a[i] + " "); //0 0 1 1 2 2

        /*
        Optimal Approach - Three Pointers (Dutch National Flag)
        low = boundary for 0s (everything before low is 0)
        high = boundary for 2s (everything after high is 2)
        mid = current element being examined
        - a[mid]==0 -> swap with low, advance BOTH low and mid (safe: swapped-in value from low is already processed/0 or 1)
        - a[mid]==1 -> already in correct middle zone, just advance mid
        - a[mid]==2 -> swap with high, advance ONLY high (the swapped-in value from high is unexamined, so mid must recheck it)
        Time Complexity: O(n) -- single pass
        Space Complexity: O(1) -- in-place, no extra array
        */
        int a2[] = {2, 0, 2, 1, 1, 0}; //a2=2 0 2 1 1 0 (fresh copy)
        int low = 0;  //low=0
        int mid = 0;  //mid=0
        int high = n-1; //high=5

        while(mid <= high) { //mid=0<=5t  mid=0<=4t(after high--)  mid=1<=4t  mid=2<=4t  mid=2<=3t(after high--)  mid=3<=3t
            if(a2[mid] == 0) { //mid=1: a2[1]=0 -> t     mid=2: a2[2]=2 -> f (handled below)
                int t = a2[low]; a2[low] = a2[mid]; a2[mid] = t; //swap low<->mid: a2=0 0 2 1 1 2 wait trace below
                low++;  //low=1
                mid++;  //mid=2
            }
            else if(a2[mid] == 1) { //mid=3: a2[3]=1 -> t   mid=4 doesn't run, loop exits at mid=4>high=3
                mid++; //mid=4
            }
            else { //mid=0: a2[0]=2 -> t     mid=2: a2[2]=2 -> t
                int t = a2[mid]; a2[mid] = a2[high]; a2[high] = t; //swap mid<->high
                high--; //high=4 (first time)   high=3 (second time)
            }
        }
        System.out.print("\nOptimal: ");
        for(int i=0; i<n; i++) System.out.print(a2[i] + " "); //0 0 1 1 2 2
    }
}
