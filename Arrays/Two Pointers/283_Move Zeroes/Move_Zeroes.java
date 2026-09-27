import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        // Brute Force Approach
        // Use a temporary array to store non-zero elements, then fill remaining with zeros.
        // Time Complexity: O(n)
        // Space Complexity: O(n)
        
        int numsBrute[] = {0, 1, 0, 3, 12}; //numsBrute=0 1 0 3 12
        int nBrute = numsBrute.length;       //nBrute=5
        int temp[] = new int[nBrute];       //temp=0 0 0 0 0
        int index = 0;                      //index=0

        for(int i = 0; i < nBrute; i++) {   //i=0 1 2 3 4
            if(numsBrute[i] != 0) {         //0!=0f 1!=0t 0!=0f 3!=0t 12!=0t
                temp[index] = numsBrute[i]; //temp[0]=1, temp[1]=3, temp[2]=12
                index++;                    //index=1 2 3
            }
        }

        for(int i = 0; i < nBrute; i++) {   //copy temp back to numsBrute
            numsBrute[i] = temp[i];         //numsBrute=1 3 12 0 0
        }

        System.out.println("Brute Force Result: " + Arrays.toString(numsBrute));


        /*
        Optimal Approach - Two Pointers
        
        Use two pointers: l and r.
        r scans through the array.
        l tracks the position to place the next non-zero element.
        When nums[r] != 0, swap nums[l] and nums[r], then increment l.

        Time Complexity: O(n)
        Space Complexity: O(1)
        */

        int nums[] = {0, 1, 0, 3, 12}; //nums=0 1 0 3 12
        int n = nums.length;           //n=5
        int l = 0;                     //l=0

        for(int r = 0; r < n; r++) {   //r=0 1 2 3 4

            if(nums[r] != 0) {         //r=0: 0!=0 false
                                       //r=1: 1!=0 true
                                       //r=2: 0!=0 false
                                       //r=3: 3!=0 true
                                       //r=4: 12!=0 true

                int tempVal = nums[l]; //r=1: tempVal=nums[0]=0
                                       //r=3: tempVal=nums[1]=0
                                       //r=4: tempVal=nums[2]=3

                nums[l] = nums[r];     //r=1: nums[0]=1
                                       //r=3: nums[1]=3
                                       //r=4: nums[2]=12

                nums[r] = tempVal;     //r=1: nums[1]=0
                                       //r=3: nums[3]=0
                                       //r=4: nums[4]=3

                l++;                   //r=1: l=0+1=1
                                       //r=3: l=1+1=2
                                       //r=4: l=2+1=3
            }
        }

        System.out.println("Optimal Two Pointers Result: " + Arrays.toString(nums)); //1 3 12 0 0
    }
}
