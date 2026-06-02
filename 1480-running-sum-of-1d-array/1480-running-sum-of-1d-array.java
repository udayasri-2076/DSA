class Solution {
    public int[] runningSum(int[] nums) {
        int n=nums.length;
        int prefix[]=new int[n]; //new array to store sum

        prefix[0]=nums[0]; //first element is always same

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+ nums[i]; //each prefix= previous prefix+current element
        }

        return prefix;


    }
}