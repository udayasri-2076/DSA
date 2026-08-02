/* Output
    *
   * *
  * * *
 * * * *
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

        int n = in.nextInt();                  // n = 5

        // Top Half
        for(int i = 1; i <= n; i++) {          // i=1  i=2  i=3  i=4  i=5

            for(int k = 1; k <= n-i; k++) {    // i=1 -> 4 spaces
                                               // i=2 -> 3 spaces
                                               // i=3 -> 2 spaces
                                               // i=4 -> 1 space
                                               // i=5 -> 0 spaces

                System.out.print(" ");         // "    "
                                               // "   "
                                               // "  "
                                               // " "
                                               // ""
            }

            for(int j = 1; j <= i; j++) {      // i=1 -> j=1
                                               // i=2 -> j=1,2
                                               // i=3 -> j=1,2,3
                                               // i=4 -> j=1,2,3,4
                                               // i=5 -> j=1,2,3,4,5

                System.out.print("* ");        // *
                                               // * *
                                               // * * *
                                               // * * * *
                                               // * * * * *
            }

            System.out.println();
        }

        // Bottom Half
        for(int i = n-1; i >= 1; i--) {        // i=4  i=3  i=2  i=1

            for(int k = 1; k <= n-i; k++) {    // i=4 -> 1 space
                                               // i=3 -> 2 spaces
                                               // i=2 -> 3 spaces
                                               // i=1 -> 4 spaces

                System.out.print(" ");         // " "
                                               // "  "
                                               // "   "
                                               // "    "
            }

            for(int j = 1; j <= i; j++) {      // i=4 -> j=1,2,3,4
                                               // i=3 -> j=1,2,3
                                               // i=2 -> j=1,2
                                               // i=1 -> j=1

                System.out.print("* ");        // * * * *
                                               // * * *
                                               // * *
                                               // *
            }

            System.out.println();
        }
    }
}
