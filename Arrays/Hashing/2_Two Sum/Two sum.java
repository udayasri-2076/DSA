// Two Sum
/*
Brute Force
Take i at index 0 and j at index i+1.
Check every possible pair's sum against the target.
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
import java.util.*;
public class TwoSum {
    public static void main(String args[]) {
        int arr[] = {2, 1, 5, 3}; //arr=2 1 5 3
        int target = 4; //target=4

        /*
        Brute Force
        */
        boolean found = false; //found=false
        int idx1 = -1, idx2 = -1; //idx1=-1 idx2=-1
        for(int i=0; i<arr.length; i++) { //i=0 0<4t  i=1 1<4t
            for(int j=i+1; j<arr.length; j++) { //i=0 -> j=1 1<4t, j=2 2<4t, j=3 3<4t
                if(arr[i] + arr[j] == target) { //2+1=3f  2+5=7f  2+3=5f
                                                //i=1 -> j=2: 1+5=6f  j=3: 1+3=4t
                    idx1 = i; idx2 = j; //idx1=1 idx2=3
                    found = true; //found=true
                    break;
                }
            }
            if(found) { //true
                break;
            }
        }
        System.out.println("Brute Force: [" + idx1 + ", " + idx2 + "]"); //[1,3]

        /*
        Optimal Approach - HashMap
        Store: value -> index, as we scan left to right.
        For each number, compute difference = target - arr[i].
        If difference already exists in map -> we found our pair.
        Time Complexity: O(n)
        Space Complexity: O(n)
        */
        HashMap<Integer,Integer> map = new HashMap<>(); //map={}
        boolean foundOptimal = false; //foundOptimal=false
        int oidx1 = -1, oidx2 = -1; //oidx1=-1 oidx2=-1
        for(int i=0; i<arr.length; i++) { //i=0 0<4t  i=1 1<4t  i=2 2<4t  i=3 3<4t
            int difference = target - arr[i]; //i=0 -> 4-2=2
                                             //i=1 -> 4-1=3
                                             //i=2 -> 4-5=-1
                                             //i=3 -> 4-3=1
            if(map.containsKey(difference)) { //i=0 -> containsKey(2)=false
                                             //i=1 -> containsKey(3)=false
                                             //i=2 -> containsKey(-1)=false
                                             //i=3 -> containsKey(1)=true
                oidx1 = map.get(difference); //oidx1=1 (index stored for value 1)
                oidx2 = i; //oidx2=3
                foundOptimal = true; //foundOptimal=true
                break;
            }
            map.put(arr[i], i); //i=0 -> map={2=0}
                               //i=1 -> map={2=0, 1=1}
                               //i=2 -> map={2=0, 1=1, 5=2}
        }
        System.out.println("Optimal: [" + oidx1 + ", " + oidx2 + "]"); //[1,3]
    }
}
