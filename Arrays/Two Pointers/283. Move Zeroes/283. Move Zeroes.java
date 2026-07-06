import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();    //5
        int a[] = new int[n];    //0 0 0 0 0

        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();  //1 0 3 0 12
        }

        int l = 0;             //l=0

        for(int r = 0; r < n; r++) {  //r=0   r=1       r=2          r=3      r=4
            if(a[r] != 0) {          //1!=0   0!=0f     3!=0         0!=0f    12!=0t
                int temp = a[l];    //temp=1            temp=0                temp=0
                a[l] = a[r];        //1=1               0=3                   0=12
                a[r] = temp;       //1=1                3=0                   12=0
                l++;              //l=1                 l=2                   l=3
                                //1 0 3 0 12           1 3 0 0 12           1 3 12 0 0
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");    //1 3 12 0 0
        }
    }
}
