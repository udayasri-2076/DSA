// 209. Minimum Size Subarray Sum
import java.util.*;
public class Main {
    public static void main(String[] args) {
        int nums[] = {2,3,1,2,4,3};   //nums=2 3 1 2 4 3
        int n = nums.length;          //n=6
        int target = 7;               //target=7

        /*
        Brute Force
        Time Complexity: O(n^2)
        Space Complexity: O(1)
        */
        int minsubBrute = Integer.MAX_VALUE;   //minsubBrute=MAX

        for(int i=0;i<n;i++){   //i=0  i=1  i=2  i=3  i=4  i=5
            int sum=0;           //sum reset for every new i

            for(int j=i;j<n;j++){   //j->i,i+1...n-1
                sum=sum+nums[j];    //ADD (grow window)  i=0:j=0->2 j=1->5 j=2->6 j=3->8
                                     //i=1:j=1->3 j=2->4 j=3->6 j=4->10
                                     //i=2:j=2->1 j=3->3 j=4->7
                                     //i=3:j=3->2 j=4->6 j=5->9
                                     //i=4:j=4->4 j=5->7
                                     //i=5:j=5->3

                if(sum>=target){    //i=0:j=3 8>=7t  i=1:j=4 10>=7t  i=2:j=4 7>=7t  i=3:j=5 9>=7t  i=4:j=5 7>=7t  i=5:never
                    minsubBrute=Math.min(minsubBrute,j-i+1);
                    //i=0:(MAX,4)=4  i=1:(4,4)=4  i=2:(4,3)=3  i=3:(3,3)=3  i=4:(3,2)=2

                    break;   //STOP here - once target met, extra elements only increase length
                }
            }
        }

        System.out.println("Brute Force: "+(minsubBrute==Integer.MAX_VALUE?0:minsubBrute)); //2

        /*
        Optimal Approach - Variable Size Sliding Window
        Time Complexity: O(n)
        Space Complexity: O(1)
        */
        int l=0;                              //l=0
        int sum=0;                            //sum=0
        int minsubOptimal=Integer.MAX_VALUE;  //minsubOptimal=MAX

        for(int r=0;r<n;r++){        //r=0->nums[0]=2  r=1->3  r=2->1  r=3->2  r=4->4  r=5->3
            sum=sum+nums[r];         //INCREASE sum (window grows right)  0+2=2  2+3=5  5+1=6  6+2=8  6+4=10  6+3=9

            while(sum>=target){      //2>=7f  5>=7f  6>=7f  8>=7t  10>=7t 7>=7t  9>=7t  7>=7t
                minsubOptimal=Math.min(minsubOptimal,r-l+1);
                //(MAX,3-0+1)=4  (4,4-1+1)=4  (4,4-2+1)=3  (3,5-3+1)=3  (3,5-4+1)=2

                sum=sum-nums[l];   //DECREASE sum (shrink window from left, since sum already met target)
                l++;               //8-2=6 l=0->1   10-3=7 l=1->2   7-1=6 l=2->3   9-2=7 l=3->4   7-4=3 l=4->5
            }
        }

        System.out.println("Optimal: "+(minsubOptimal==Integer.MAX_VALUE?0:minsubOptimal)); //2
    }
}
