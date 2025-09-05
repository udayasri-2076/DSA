import java.util.*;
class definearr{
public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int size=sc.nextInt();
    int age[]=new int[size];

    //input
    for(int i=0;i<size;i++){
        age[i]=sc.nextInt();
    }
    
    //output
    for(int i=0;i<size;i++){
        System.out.println(age[i]);
    }
}
}