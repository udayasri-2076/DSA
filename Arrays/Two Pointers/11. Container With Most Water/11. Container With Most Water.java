import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();      //9
        int a[] = new int[n];      //0 0 0 0 0 0 0 0 0

        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();   //1 8 6 2 5 4 8 3 7
        }

        int l = 0;                 //l=0
        int r = n - 1;              //r=8
        int maximum = 0;            //maximum=0

        while(l < r) {              //l=0 r=8    l=1 r=8    l=1 r=7    l=1 r=6    l=1 r=5
            int width = r - l;      //width=8    width=7    width=6    width=5    width=4
            int h = Math.min(a[l], a[r]);   //min(1,7)=1  min(8,7)=7  min(8,6)=6  min(8,5)=5  min(8,4)=4
            int area = width * h;   //area=8     area=49    area=36    area=25    area=16
            maximum = Math.max(maximum, area);  //max=8      max=49     max=49     max=49     max=49

            if(a[l] < a[r]) {       //1<7 t      8<7 f      8<6 f      8<5 f      8<4 f
                l++;                //l=1
            } else {
                r--;                //           r=7        r=6        r=5        r=4
            }
        }

        System.out.print(maximum);  //49
    }
}

/*Output
9
1 8 6 2 5 4 8 3 7
49 
*/
