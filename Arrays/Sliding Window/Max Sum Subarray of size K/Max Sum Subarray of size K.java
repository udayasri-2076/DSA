// Maximum Sum Subarray of Size K
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int arr[] = {100, 200, 300, 400}; //arr=100 200 300 400
        int n = arr.length; //n=4
        int k = 2; //k=2

        /*
        Brute Force
        For every starting index i, sum the next k elements. Track the max.
        Time Complexity: O(n*k)
        Space Complexity: O(1)
        */
        int maxansBrute = Integer.MIN_VALUE; //maxansBrute=MIN

        for(int i = 0; i <= n - k; i++) { //i=0 0<=2t  i=1 1<=2t  i=2 2<=2t
            int sum = 0; //i=0: sum=0     i=1: sum=0     i=2: sum=0

            for(int j = i; j < i + k; j++) { //i=0: j=0,1     i=1: j=1,2     i=2: j=2,3
                sum = sum + arr[j];
                //i=0: j=0: sum=0+100=100     j=1: sum=100+200=300  (window=[100,200])
                //i=1: j=1: sum=0+200=200     j=2: sum=200+300=500  (window=[200,300])
                //i=2: j=2: sum=0+300=300     j=3: sum=300+400=700  (window=[300,400])
            }

            maxansBrute = Math.max(maxansBrute, sum);
            //i=0: maxansBrute=max(MIN,300)=300
            //i=1: maxansBrute=max(300,500)=500
            //i=2: maxansBrute=max(500,700)=700
        }

        System.out.println("Brute Force: " + maxansBrute); //700

        /*
        Optimal Approach - Sliding Window (Fixed Size)
        Maintain a window of size k. Slide it one step at a time:
        add the new element entering, subtract the element leaving.
        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int sum = 0; //sum=0

        // Build sum of first window (i=0 to k-1)
        for(int i = 0; i < k; i++) { //i=0 0<2t  i=1 1<2t
            sum = sum + arr[i]; //i=0: sum=0+100=100
                                 //i=1: sum=100+200=300
        }
        // After loop: sum=300 (window=[100,200])

        int maxansOptimal = sum; //maxansOptimal=300

        // Slide window from j=k to n-1
        for(int j = k; j < n; j++) { //j=2 2<4t  j=3 3<4t
            sum = sum + arr[j]; //j=2: sum=300+arr[2]=300+300=600
                                 //j=3: sum=500+arr[3]=500+400=900
            sum = sum - arr[j - k]; //j=2: sum=600-arr[0]=600-100=500 (window=[200,300])
                                     //j=3: sum=900-arr[1]=900-200=700 (window=[300,400])

            maxansOptimal = Math.max(sum, maxansOptimal); //j=2: maxansOptimal=max(500,300)=500
                                                            //j=3: maxansOptimal=max(700,500)=700
        }

        System.out.println("Optimal: " + maxansOptimal); //700
    }
}
