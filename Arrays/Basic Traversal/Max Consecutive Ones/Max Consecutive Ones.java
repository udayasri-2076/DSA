
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int arr[]=new int[n];  //9
		
		for(int i=0;i<n;i++){
		    arr[i]=in.nextInt();  //1 1 0 1 1 1 0 1 1
		}
		
		int cnt=0;
		int maxi=0;
		
		for(int i=0;i<n;i++){ //0<9t     1        2               3           4          5          6      7          8
		    if(arr[i]==1){    //1==1t   1==1t   0==1f            1==1t      1==1t      1==1       0==1f   1==1t      1==1t
		        cnt++;       //c=1      c=2                      c=1        c=2        c=3                c=1        c=2
		        maxi=Math.max(cnt,maxi); //max(1,0)=1 (2,1)=2   max(1,2)=2  max(2,2)=2 (3,2)=3           (1,3)=3     (2,3)=
		    }
		    else{   //0==1f
		        cnt=0;    //cnt=0    cnt=0
		    }
		}
		System.out.println(maxi); //3
	
	}
}
