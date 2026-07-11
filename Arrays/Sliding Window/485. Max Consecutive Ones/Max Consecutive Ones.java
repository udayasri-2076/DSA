

//Optimal - O(n)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();                       //6
        int a[] = new int[n];                         //0 0 0 0 0 0

        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();                       //1 1 0 1 1 1
        }

        int cnt = 0;                                    //cnt=0
        int maxcnt = 0;                                //maxcnt=0

        for(int j = 0; j < n; j++) {           //j=0      j=1      j=2      j=3      j=4      j=5
            if(a[j] == 1) {                     //1==1     1==1     0!=1     1==1     1==1     1==1
                cnt++;                          //cnt=1    cnt=2             cnt=1    cnt=2    cnt=3
                maxcnt = Math.max(maxcnt, cnt); //max=1    max=2             max=2    max=2    max=3
            } else {
                cnt = 0;                                          //cnt=0
            }
        }

        System.out.print(maxcnt);                //3
    }
}

//Brute Force - O(n^3)

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();                      //6
        int a[] = new int[n];                        //0 0 0 0 0 0

        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();                      //1 1 0 1 1 1
        }

        int maxcnt = 0;                               //maxcnt=0

        for(int i = 0; i < n; i++) {           //i=0      i=1      i=2      i=3      i=4      i=5
            int cnt = 0;                        //cnt=0    cnt=0    cnt=0    cnt=0    cnt=0    cnt=0
            for(int j = i; j < n; j++) {
                if(a[j] == 1) {
                    cnt++;                      //cnt=1,2  cnt=1             cnt=1,2,3 cnt=1,2  cnt=1
                } else {
                    break;                      //break@j=2 break@j=2        (a[2]=0, breaks before entering)
                }
            }
            maxcnt = Math.max(maxcnt, cnt);     //max=2    max=2    max=2    max=3    max=3    max=3
        }

        System.out.print(maxcnt);                //3
    }
}
