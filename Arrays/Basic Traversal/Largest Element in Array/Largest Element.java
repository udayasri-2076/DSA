//Find the Largest Element in Array


/*Brute Force 
Sort the Array and then print the last element

Array: 3 2 1 5 2
Sorting : 1 2 2 3 5
print(last element) //5

*/

import java.util.*;
public class largestelemt {
    public static void main(String args[]){
    Scanner in=new Scanner(System.in);

    System.out.println("enter the size of the array:");
    int n=in.nextInt(); //5

    System.out.println("enter the elements of the array:");
    int arr[]=new int[n];//0 0 0 0 0

    for(int i=0;i<n;i++){
        arr[i]=in.nextInt();//3 2 1 5 2
    }

    int max=a[0]; //max=3
    for(int i=0;i<n;i++){ //i=0 0<5t   i=1 1<5t  i=2 2<5t   i=3 3<5t   i=4 4<5t  i=5 5<5f
        if(arr[i]>max){  //3>3f        2>3f      1>3f       5>3t      2>5f
            max=arr[i];  //max=5
        }
    }
    System.out.println("Largest element in the array is:"+max); //Largest Element in the array is: 5
    }
}
