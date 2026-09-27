import java.util.*;

public class SqrtX {

    public static void main(String[] args) {
        
        int x = 8; //x=8

        /*
        Brute Force Approach

        Check every integer i starting from 0 upwards
        until i*i exceeds x.
        The answer will be i - 1.

        Time Complexity: O(sqrt(x))
        Space Complexity: O(1)
        */

        long bruteAns = 0; //bruteAns=0
        
        if (x >= 2) {
            for (long i = 1; i <= x / 2; i++) { //i=1 1<=4t  i=2 2<=4t  i=3 3<=4f
                long sq = i * i; //i=1 -> sq=1  i=2 -> sq=4  i=3 -> sq=9
                
                if (sq == x) { //1==8f  4==8f
                    bruteAns = i;
                    break;
                }
                if (sq > x) { //1>8f  4>8f  9>8t
                    bruteAns = i - 1; //bruteAns=3-1=2
                    break;
                }
                bruteAns = i;
            }
        } else {
            bruteAns = x;
        }

        System.out.println("Brute Force Approach: " + bruteAns); //2


        /*
        Optimal Approach - Binary Search

        Search space for square root of x lies between 0 and x/2 (for x >= 2).
        Use binary search to find the largest number whose square is <= x.

        Time Complexity: O(log x)
        Space Complexity: O(1)
        */

        int optAns = 0; //optAns=0

        if (x < 2) {
            optAns = x;
        } else {
            long left = 0; //left=0
            long right = x / 2; //right=8/2=4

            while (left <= right) { //0<=4t  2<=4t  2<=1f
                long mid = left + (right - left) / 2; //mid=0+(4-0)/2=2  mid=2+(4-3)/2=3
                long sq = mid * mid; //sq=2*2=4  sq=3*3=9

                if (sq == x) { //4==8f  9==8f
                    optAns = (int) mid;
                    break;
                }

                if (sq < x) { //4<8t -> left=2
                    left = mid + 1;
                } else { //9<8f -> right=3-1=2
                    right = mid - 1;
                }
            }

            if (optAns == 0) {
                optAns = (int) right; //optAns=2
            }
        }

        System.out.println("Optimal Approach: " + optAns); //2
    }
}