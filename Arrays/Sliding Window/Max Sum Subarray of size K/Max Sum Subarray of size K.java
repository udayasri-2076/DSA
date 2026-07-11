//Optimal - O(n)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();                       //5
        int arr[] = new int[n];                       //0 0 0 0 0

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();                     //5 2 -1 0 3
        }

        int k = in.nextInt();                        //3

        int sum = 0;                                    //sum=0
        for(int i = 0; i < k; i++) {
            sum = sum + arr[i];                         //sum=5,7,6
        }

        int maxans = sum;                            //maxans=6

        for(int j = k; j < n; j++) {           //j=3              j=4
            sum = sum + arr[j];                 //sum=6+0=6        sum=1+3=4
            sum = sum - arr[j - k];             //sum=6-5=1        sum=4-2=2

            maxans = Math.max(sum, maxans);     //maxans=6         maxans=6
        }

        System.out.print(maxans);                //6
    }
}

//Brute- O(n*k)
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();                       //5
        int arr[] = new int[n];                       //0 0 0 0 0

        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();                     //5 2 -1 0 3
        }

        int k = in.nextInt();                        //3
        int maxans = Integer.MIN_VALUE;              //maxans=MIN

        for(int i = 0; i <= n - k; i++) {      //i=0              i=1              i=2
            int sum = 0;                        //sum=0            sum=0            sum=0
            for(int j = i; j < i + k; j++) {
                sum = sum + arr[j];              //sum=5,7,6        sum=2,1,1        sum=-1,-1,2
            }
            maxans = Math.max(maxans, sum);     //maxans=6         maxans=6         maxans=6
        }

        System.out.print(maxans);                //6
    }
}
