// 904. Fruit Into Baskets
import java.util.*;

public class Main {
    public static void main(String[] args) {

        int fruits[] = {1,2,1,2,3,2,2};   //fruits=1 2 1 2 3 2 2
        int n = fruits.length;            //n=7

        /*
        Brute Force
        Time Complexity: O(n^2)
        Space Complexity: O(1)
        */

        int maxlenBrute=0;                //maxlenBrute=0

        for(int i=0;i<n;i++){              //i=0  i=1  i=2  i=3  i=4  i=5  i=6
            HashSet<Integer> set=new HashSet<>();   //set reset for every new i

            for(int j=i;j<n;j++){          //j->i,i+1...n-1
                set.add(fruits[j]);        //ADD (grow window)  i=0:j=0->{1} j=1->{1,2} j=2->{1,2} j=3->{1,2} j=4->{1,2,3}

                if(set.size()<=2){         //i=0:j=0 1<=2t  j=1 2<=2t  j=2 2<=2t  j=3 2<=2t  j=4 3<=2f
                    maxlenBrute=Math.max(maxlenBrute,j-i+1);   //i=0:(0,1)=1  (1,2)=2  (2,3)=3  (3,4)=4
                                                               //i=1:j=1->(4,1)=4  j=2->(4,2)=4  j=3->(4,3)=4
                                                               //i=2:j=2->(4,1)=4  j=3->(4,2)=4
                                                               //i=3:j=3->(4,1)=4  j=4->(4,2)=4  j=5->(4,3)=4  j=6->(4,4)=4
                }

                else{                       //set.size()>2 -> more than 2 fruit types
                    break;                  //STOP here - cannot have more than 2 types
                }
            }
        }

        System.out.println("Brute Force: "+maxlenBrute);   //4


        /*
        Optimal Approach - Variable Size Sliding Window + HashMap
        Time Complexity: O(n)
        Space Complexity: O(1)
        */

        int l=0;                              //l=0
        int maxlen=0;                         //maxlen=0

        HashMap<Integer,Integer> freq=new HashMap<>();   //freq={}

        for(int r=0;r<n;r++){        //r=0->fruits[0]=1  r=1->2  r=2->1  r=3->2  r=4->3  r=5->2  r=6->2
            freq.put(fruits[r],freq.getOrDefault(fruits[r],0)+1);   //INCREASE freq (window grows right)  r=0:{1:1}  r=1:{1:1,2:1}  r=2:{1:2,2:1}  r=3:{1:2,2:2}  r=4:{1:2,2:2,3:1}

            while(freq.size()>2){      //1>2f  2>2f  2>2f  2>2f  3>2t

                int leftFruit=fruits[l];   //leftFruit=1

                freq.put(leftFruit,freq.get(leftFruit)-1);   //DECREASE freq  r=4:1->0?  freq={1:1,2:2,3:1}

                if(freq.get(leftFruit)==0){   //frequency 0 -> remove that fruit type
                    freq.remove(leftFruit);   //freq={2:2,3:1}
                }

                l++;                           //l=0->1

                //r=4: l=0 -> remove fruits[0]=1 -> freq={1:1,2:2,3:1} -> l=1
                //      l=1 -> remove fruits[1]=2 -> freq={1:1,2:1,3:1} -> l=2
                //      l=2 -> remove fruits[2]=1 -> freq={2:1,3:1} -> l=3
                //      now freq.size()=2 -> STOP
            }

            maxlen=Math.max(maxlen,r-l+1);   //r=0:(0-0+1)=1 -> maxlen=1  r=1:(1-0+1)=2 -> maxlen=2
                                             //r=2:(2-0+1)=3 -> maxlen=3  r=3:(3-0+1)=4 -> maxlen=4
                                             //r=4:l=3 -> (4-3+1)=2 -> maxlen=4
                                             //r=5:l=3 -> (5-3+1)=3 -> maxlen=4
                                             //r=6:l=3 -> (6-3+1)=4 -> maxlen=4
        }

        System.out.println("Optimal: "+maxlen);   //4
    }
}
 
