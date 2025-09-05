import java.util.*;

class largest{
    public static void main(String args[]){
      Scanner s=new Scanner(System.in);
      int size=s.nextInt();
      int num[]=new int[size];

      for(int i=0;i<size;i++){
        num[i]=s.nextInt();
      }
      int largest=num[0];
      for(int i=0;i<size;i++){
        if(num[i]>largest){
            largest=num[i];
        }
      }
      System.out.println("the largest element is "+largest);
    }
}