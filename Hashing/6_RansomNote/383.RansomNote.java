// 383. Ransom Note
import java.util.*;

public class Main {
    public static void main(String[] args) {

        String ransomNote = "aa";
        String magazine = "aab";

        /*
        Brute Force
        Search every ransomNote character in magazine and remove after use.
        Time Complexity: O(n*m)
        Space Complexity: O(m)
        */

        StringBuilder str = new StringBuilder(magazine);    //str="aab"

        boolean possible = true;                            //possible=true

        for(int i=0; i<ransomNote.length(); i++){           //i=0->i=1

            char ch = ransomNote.charAt(i);                 //i=0->ch='a'
                                                            //i=1->ch='a'

            boolean found = false;                          //found=false

            for(int j=0; j<str.length(); j++){              //j=0->j=1->...

                if(str.charAt(j)==ch){

                    str.deleteCharAt(j);                    //i=0:'a' found->str="ab"
                                                            //i=1:'a' found->str="b"

                    found=true;                            //found=true
                    break;                                 //STOP searching
                }
            }

            if(!found){
                possible=false;                            //character not found
                break;
            }
        }

        System.out.println("Brute Force: "+possible);       //Brute Force: true


        /*
        Optimal Approach - HashMap
        Store frequency of magazine characters.
        Check ransomNote characters and decrease frequency after use.
        Time Complexity: O(n+m)
        Space Complexity: O(k)
        */

        HashMap<Character,Integer> map = new HashMap<>();   //map={}

        for(int i=0; i<magazine.length(); i++){              //i=0->i=1->i=2

            char ch = magazine.charAt(i);                   //i=0->ch='a'
                                                            //i=1->ch='a'
                                                            //i=2->ch='b'

            map.put(ch,map.getOrDefault(ch,0)+1);

            //i=0: ch='a'
            //map.getOrDefault('a',0) -> 0
            //map.put('a',0+1) -> {a=1}

            //i=1: ch='a'
            //map.getOrDefault('a',0) -> 1
            //map.put('a',1+1) -> {a=2}

            //i=2: ch='b'
            //map.getOrDefault('b',0) -> 0
            //map.put('b',0+1) -> {a=2,b=1}
        }


        boolean result=true;                                //result=true


        for(int i=0; i<ransomNote.length(); i++){            //i=0->i=1

            char ch=ransomNote.charAt(i);                   //i=0->ch='a'
                                                            //i=1->ch='a'


            if(!map.containsKey(ch) || map.get(ch)==0){

                result=false;                               //character unavailable
                break;                                      //STOP
            }


            map.put(ch,map.get(ch)-1);

            //i=0: ch='a'
            //map={a=2,b=1}
            //
            //map.put('a',map.get('a')-1)
            //map.put('a',2-1)
            //map.put('a',1)
            //map={a=1,b=1}
            //
            //One 'a' is used -> one 'a' remains


            //i=1: ch='a'
            //map={a=1,b=1}
            //
            //map.put('a',map.get('a')-1)
            //map.put('a',1-1)
            //map.put('a',0)
            //map={a=0,b=1}
            //
            //One more 'a' is used -> no 'a' remains
        }


        System.out.println("HashMap: "+result);              //HashMap: true
    }
}
