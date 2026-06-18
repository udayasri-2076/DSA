import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int arr[]=new int[n];  //5
		
		for(int i=0;i<n;i++){
		    arr[i]=in.nextInt();  //1 2 4 5 6
		}
		
		int sum1=(n*(n+1))/2;   //(5*6)/2=15
		int sum2=0;             //sum2=0
		for(int i=0;i<n;i++){
		     
		    sum2=sum2+arr[i];   //sum2=0+1=1+2=3+4=7+5+6=18
		    
		}
		
		int miss=sum2-sum1;   //18-15=3
		
		System.out.println(miss); //3
	
	}
}
