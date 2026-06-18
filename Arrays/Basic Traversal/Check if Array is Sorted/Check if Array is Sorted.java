import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++){
		    arr[i]=in.nextInt();  //1 2 4 7 7 5
		}
		
		boolean sorted=true;
		for(int i=1;i<n;i++){   //i=1 1<6t 2<6t  3<6t   4<6t     5<6t
		    if(arr[i]>=arr[i-1]){//2>1t    4>2t   7>4t   7>=7t   5>7f
		        sorted=true;   //true    true    true
		    }
		    else{
		        sorted=false;  //false
		    }
		}
		
		System.out.println(sorted); //false
		
	
	}
}
