//Find the Largest Element in Array
import java.util.*;
public class largestelemt {
    public static void main(String args[]){
    Scanner in=new Scanner(System.in);

    System.out.println("enter the size of the array:");
    int n=in.nextInt();

    System.out.println("enter the elements of the array:");
    int arr[]=new int[n];

    for(int i=0;i<n;i++){
        arr[i]=in.nextInt();
    }

    int max=0;
    for(int i=0;i<n;i++){
        if(arr[i]>max){
            max=arr[i];
        }
    }
    System.out.println("Largest element in the array is:"+max);
    }
}
