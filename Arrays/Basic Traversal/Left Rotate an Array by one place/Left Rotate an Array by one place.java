import java.util.*;  
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();  //5
		int a[]=new int[n];  //0 0 0 0 0
		
		for(int i=0;i<n;i++){
		    a[i]=in.nextInt();  //1 2 3 4 5
		}
		
		int temp=a[0];           //temp=1
		for(int i=1;i<n;i++){   //i=1 1<5t     2<5t               3<5t       4<5t         5<5f
		    a[i-1]=a[i];        //a[0]=a[1]    a[1]=a[2]        a[2]=a[3]   a[3]=a[4]
                           //a[0]=2        a[1]=3          a[2]=4       a[3]=5
		}
		a[n-1]=temp;           //a[4]=1
		
		for(int i=0;i<n;i++){
		    System.out.print(a[i]+" ");  //2 3 4 5 1
		}
	}
}
