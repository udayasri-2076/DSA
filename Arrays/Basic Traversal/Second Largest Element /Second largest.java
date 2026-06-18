
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
		
		int max=0;
		int smax=-1;
		
		for(int i=0;i<n;i++){  //i=0 0<6t 1<6t    2<6t      3<6t    4<6t   5<6t
		    if(arr[i]>max){   //1>0t      2>1t    4>2t      7>4t    7>7f   5>7f
		        smax=max;     //smax=0    smax=1  smax=2    smax=4  
		        max=arr[i];  //max=1      max=2   max=4     max=7
		    }
		    
		    else if(arr[i]>smax && arr[i]!=max){ //7>4t && 7!=7f   5>4t && 5!=7t
		        smax=arr[i];                     //smax=5
		    }
		}
		System.out.println(smax);  //5
	}
}
