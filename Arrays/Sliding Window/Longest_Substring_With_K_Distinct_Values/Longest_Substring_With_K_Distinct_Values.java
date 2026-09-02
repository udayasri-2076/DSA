// Longest Substring with K Uniques
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String s = "aabacbebebe";   //s=a a b a c b e b e b e
        int n = s.length();         //n=11
        int k = 3;                  //k=3

        /*
        Brute Force
        Time Complexity: O(n^2)
        Space Complexity: O(k)
        */

        int maxLenBrute = -1;       //maxLenBrute=-1

        for(int i=0;i<n;i++){       //i=0  i=1  i=2  i=3  i=4  i=5  i=6  i=7  i=8  i=9  i=10
            HashSet<Character> set = new HashSet<>();
                                    //set reset for every new i

            for(int j=i;j<n;j++){   //j->i,i+1...n-1
                set.add(s.charAt(j));   //ADD (grow window)

                /*
                i=0:j=0->1 j=1->1 j=2->2 j=3->2 j=4->3 j=5->3 j=6->4
                i=1:j=1->1 j=2->2 j=3->2 j=4->3 j=5->3 j=6->4
                i=2:j=2->1 j=3->1 j=4->2 j=5->3 j=6->4
                i=3:j=3->1 j=4->2 j=5->3 j=6->4
                i=4:j=4->1 j=5->2 j=6->3 j=7->3 j=8->3 j=9->3 j=10->3
                */

                if(set.size()==k){     //i=0:j=4  i=1:j=4  i=2:j=5  i=3:j=5  i=4:j=6...j=10
                    maxLenBrute=Math.max(maxLenBrute,j-i+1);

                    //i=0:(-1,5)=5  i=1:(5,4)=5  i=2:(5,4)=5
                    //i=3:(5,3)=5
                    //i=4:(5,3)=5  j=7:(5,4)=5  j=8:(5,5)=5
                    //j=9:(5,6)=6  j=10:(6,7)=7
                }

                else if(set.size()>k){  //i=0:j=6  i=1:j=6  i=2:j=6  i=3:j=6
                    break;              //STOP here - more than k unique characters
                }
            }
        }

        System.out.println("Brute Force: "+maxLenBrute);   //7


        /*
        Optimal Approach - Variable Size Sliding Window + HashMap
        Time Complexity: O(n)
        Space Complexity: O(k)
        */

        HashMap<Character,Integer> freq = new HashMap<>();
                                                //freq={}

        int l=0;                                //l=0
        int maxLenOptimal=-1;                   //maxLenOptimal=-1

        for(int r=0;r<n;r++){                   //r=0->a  r=1->a  r=2->b  r=3->a  r=4->c
                                                //r=5->b  r=6->e  r=7->b  r=8->e  r=9->b  r=10->e

            char c=s.charAt(r);                 //current character entering window

            freq.put(c,freq.getOrDefault(c,0)+1);
                                                //INCREASE freq (window grows right)
                                                //r=0:{a:1}
                                                //r=1:{a:2}
                                                //r=2:{a:2,b:1}
                                                //r=3:{a:3,b:1}
                                                //r=4:{a:3,b:1,c:1}
                                                //r=5:{a:3,b:2,c:1}
                                                //r=6:{a:3,b:2,c:1,e:1}

            while(freq.size()>k){               //1>3f  1>3f  2>3f  2>3f  3>3f  3>3f  4>3t

                char leftChar=s.charAt(l);     //l=0->a  l=1->a  l=2->b  l=3->a

                freq.put(leftChar,freq.get(leftChar)-1);
                                                //DECREASE freq of leftChar

                if(freq.get(leftChar)==0){     //if frequency becomes 0
                    freq.remove(leftChar);     //REMOVE character completely
                }

                l++;                           //MOVE left pointer

                /*
                r=6:
                remove a -> {a:2,b:2,c:1,e:1} l=1
                remove a -> {a:1,b:2,c:1,e:1} l=2
                remove b -> {a:1,b:1,c:1,e:1} l=3
                remove a -> {b:1,c:1,e:1} l=4
                now size=3 -> STOP
                */

            }

            if(freq.size()==k){                 //exactly k unique characters

                maxLenOptimal=Math.max(maxLenOptimal,r-l+1);

                /*
                r=4:l=0 -> (MAX,4-0+1)=5
                r=5:l=0 -> (5,5-0+1)=6

                r=6:l=4 -> (6,6-4+1)=3

                r=7:l=4 -> (6,7-4+1)=4
                r=8:l=4 -> (6,8-4+1)=5
                r=9:l=4 -> (6,9-4+1)=6
                r=10:l=4 -> (6,10-4+1)=7
                */
            }
        }

        System.out.println("Optimal: "+maxLenOptimal);   //7
    }
}
