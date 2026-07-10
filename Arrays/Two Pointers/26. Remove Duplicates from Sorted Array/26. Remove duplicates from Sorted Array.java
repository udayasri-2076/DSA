import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++){
		    arr[i]=in.nextInt();  //1 1 2 2 2 3 3
		}
		
		int i=0;                //i=0         
		for(int j=1;j<n;j++){  //j=1 1<7t j=2    j=3    j=4    j=5    j=6
		    if(arr[i]!=arr[j]){ //1!=1f  1!=2t  2!=2f   2!=2f  3!=2t  3!=3f
		        arr[i+1]=arr[j]; //a[1]=2                     a[2]=3
		        i++;            //i=0+1=1                     i=1+1=2
		    }
		}
		
		System.out.println(i+1);  //3 unique elements (2+1)=3
	
	}
}
