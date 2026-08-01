/* Output
* * * * *
* * * *
* * *
* *
*
*/

import java.util.*;

public class Main
{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();               // n = 5

        for(int i = 1; i <= n; i++) {       // i=1  i=2  i=3  i=4  i=5

            for(int j = i; j <= n; j++) {   // i=1 -> j=1,2,3,4,5
                                            // i=2 -> j=2,3,4,5
                                            // i=3 -> j=3,4,5
                                            // i=4 -> j=4,5
                                            // i=5 -> j=5

                System.out.print("* ");     // * * * * *
                                            // * * * *
                                            // * * *
                                            // * *
                                            // *

            }

            System.out.println();
        }
    }
}
