import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int a[]=new int[n];
		
		for(int i=0;i<n;i++){
		    a[i]=in.nextInt();   //1 0 2 3  0
		}
		
		int l=0;                 //l=0
		for(int j=1;j<n;j++){    //j=1 1<5   2<5t
		    if(a[j]!=0){         //0!=0f     2!=0t
		        int temp=a[l];   //temp=a[0]=1
		        a[l]=a[j];       //1=2
		        a[j]=temp;       //
		        l++;
		        
		    }
		}
		
		for(int i=0;i<n;i++){
		    System.out.print(a[i]+" ");
		}
	}
}
