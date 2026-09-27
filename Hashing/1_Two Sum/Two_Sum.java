import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // Example: nums = [2, 7, 11, 15], target = 9
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {  // i = 0, i < 4 -> true | i = 1, i < 4 -> true
            int diff = target - nums[i];    // 9 - 2 = 7 | 9 - 7 = 2

            if(map.containsKey(diff)) {     // map does not have 7 yet | map contains key 2 at index 0
                return new int[]{map.get(diff), i};  // Returns [0, 1]
            }

            map.put(nums[i], i); // map stores: [2, 0]
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}