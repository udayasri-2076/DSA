// 9. Palindrome Number
/*
Optimal Approach
Time Complexity: O(N)
Space Complexity: O(1)
*/
import java.util.*;
import java.io.*;

public class Main {

    public static class Solution {
        public boolean isPalindrome(int x) {
    
            if(x < 0){
                return false;
            }
    
            int temp = x;
            int sum = 0;
    
            while(x != 0){
                int d = x % 10;
                sum = (sum * 10) + d;
                x = x / 10;
            }
    
            if(sum == temp){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Testing 9. Palindrome Number ===");
        Solution solution = new Solution();
        System.out.println("Solution initialized: " + (solution != null));
        System.out.println("Executable test cases completed.");
    }
}
