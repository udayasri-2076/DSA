import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();          //6
        int a[] = new int[n];          //0 0 0 0 0 0

        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();       //2 0 2 1 1 0
        }

        int low = 0;                   //low=0
        int mid = 0;                   //mid=0
        int high = n-1;                //high=5

        while(mid <= high) {           //mid=0 high=5   mid=0 high=4   mid=1 high=4   mid=2 high=4   mid=2 high=3   mid=3 high=3   mid=4 high=3(exit)

            if(a[mid] == 0) {          //a[0]=2f                a[0]=0t         a[1]=0t
                a[mid] = a[low];       //                       a[0]=a[0]=0     a[1]=a[1]=0
                a[low] = 0;            //                       a[0]=0          a[1]=0
                mid++;                 //                       mid=1           mid=2
                low++;                 //                       low=1           low=2
            }

            else if(a[mid] == 1) {     //                                                       a[2]=1t        a[3]=1t
                mid++;                 //                                                       mid=3          mid=4
            }

            else {                     //a[0]=2t                                a[2]=2t
                a[mid] = a[high];      //a[0]=a[5]=0                            a[2]=a[4]=1
                a[high] = 2;           //a[5]=2                                 a[4]=2
                high--;                //high=4                                 high=3
            }
                                        //[0,0,2,1,1,2]  [0,0,2,1,1,2]  [0,0,2,1,1,2]  [0,0,1,1,2,2]  [0,0,1,1,2,2]  [0,0,1,1,2,2]
        }

        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");   //0 0 1 1 2 2
        }
    }
}
