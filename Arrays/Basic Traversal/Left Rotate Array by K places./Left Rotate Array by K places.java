import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();     //7
		int a[]=new int[n];    //0 0 0 0 0 0 0 
		
		for(int i=0;i<n;i++){
		    a[i]=in.nextInt(); //1 2 3 4 5 6 7
		}
		
		int d=in.nextInt();  //d=3
		
		d=d%n;                 //3%7=3
		int temp[]=new int[d];  //temp[]=int[3]
		
		for(int i=0;i<d;i++){    //i=0 0<3t       1<3t             2<3t
		    temp[i]=a[i];       //temp[0]=a[0]    temp[1]=a[1]     temp[2]=a[2]
		}                      //temp[0]=1        temp[1]=2        temp[2]=3


    //to shift
		for(int i=d;i<n;i++){      //i=3   3<7t   4<7t            5<7t          6<7t             7<7f
		    a[i-d]=a[i];          //a[3-3]=a[3]   a[4-3]=a[4]    a[5-3]=a[5]    a[6-3]=a[6]
		                         //a[0]=4         a[1]=5         a[2]=6         a[3]=7
		}
		
		for(int i=n-d;i<n;i++){    //i=7-3=4 i=4  4<7t      5<7t                 6<7t
		    a[i]=temp[i-(n-d)];    //a[4]=temp[4-(7-3)]    a[5]=temp[5-4]=1     a[6]=temp[6-4]=2
                               //a[4]=1                a[5]=2               a[6]=3
		}
		
		for(int i=0;i<n;i++){
		    System.out.print(a[i]+" ");  //4 5 6 7 1 2 3 
		}  
	}
}
