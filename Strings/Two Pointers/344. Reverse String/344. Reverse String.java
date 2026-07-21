import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();       //5
        char s[] = new char[n];     //h e l l o

        for(int i = 0; i < n; i++) {
            s[i] = in.next().charAt(0);   //h e l l o
        }

        int l = 0;                  //l=0
        int r = s.length - 1;       //r=4

        while(l < r) {              //l=0 r=4   l=1 r=3   l=2 r=2(stop)
            char temp = s[l];       //temp=h        temp=e
            s[l] = s[r];            //s[0]=o        s[1]=l
            s[r] = temp;            //s[4]=h        s[3]=e
            l++;                    //l=1           l=2
            r--;                    //r=3           r=2
        }
        //result: o l l e h

        for(int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");   //o l l e h
        }
    }
}

/*
Input:
5
h e l l o

Output:
o l l e h
*/
