/*input
* 
* * 
* * * 
* * * * 
* * * * *
*/


import java.util.*;

public class Main
{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();          // n = 5

        for(int i = 1; i <= n; i++) {  // i=1  i=2  i=3  i=4  i=5

            for(int j = 1; j <= i; j++) { // i=1 -> j=1
                                          // i=2 -> j=1  j=2
                                          // i=3 -> j=1  j=2  j=3
                                          // i=4 -> j=1  j=2  j=3  j=4

                System.out.print("* ");   // Print one star *
                                          //                *  *
                                         //                 *  *   *
            }

            System.out.println();         // Move to next line
        }
    }
}
