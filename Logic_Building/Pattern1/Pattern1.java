/*input
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
*/


import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		int n=in.nextInt(); //n=3
		
		for(int i=1;i<=n;i++){       //i=1 1<=3t             i=2 2<=3t                      i=3 3<=3t
		    for(int j=1;j<=i;j++){   //j=1 j<=1t ,2 2<=1f    j=1 1<=2t   j=2 2<=2t 3<=2f    j=1 1<=3t   j=2 2<=3t  j=3 3<=3t j=4 4<=3f
		        System.out.print(j+" "); //1
                                     //1  2
                                     //1  2  3
		    }
		    System.out.println();
		}
	}
}
