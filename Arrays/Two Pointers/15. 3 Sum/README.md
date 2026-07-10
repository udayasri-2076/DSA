# 🎯 3Sum

## 📌 Problem Statement
Given an array `nums[]`, find all unique triplets `[nums[i], nums[j], nums[k]]` such that `i != j != k` and `nums[i] + nums[j] + nums[k] == 0`. The solution set must not contain **duplicate** triplets.

## 📝 Approach
This problem is efficiently solved using **Sorting + Two Pointer technique**.

- Sort the array first — this makes it easy to skip duplicates and use two pointers.
- Fix one element `nums[i]` and use two pointers `l` and `r` to find the remaining two numbers that sum to `-nums[i]`.
- `l` starts right after `i`, `r` starts at the end of the array.
- If `sum == 0`, record the triplet and move both pointers inward, skipping duplicates.
- If `sum > 0`, move `r` left (need a smaller sum).
- If `sum < 0`, move `l` right (need a bigger sum).
- Skip duplicate values for `i` so the same triplet isn't picked twice.

## 🔄 Algorithm
1. Sort the array.
2. Loop `i` from `0` to `n-1`:
   - Skip `i` if `nums[i] == nums[i-1]` (avoids duplicate triplets).
   - Set `l = i+1`, `r = n-1`.
   - While `l < r`:
     - Calculate `sum = nums[i] + nums[l] + nums[r]`.
     - If `sum == 0`: add triplet, move `l++`, `r--`, skip duplicates on both sides.
     - If `sum > 0`: move `r--`.
     - Else: move `l++`.
3. Return the result list.

## 💻 Java Solution
\`\`\`java
import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;

            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while(l < r && nums[l] == nums[l-1]) {
                        l++;
                    }
                    while(l < r && nums[r] == nums[r+1]) {
                        r--;
                    }
                }
                else if(sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
\`\`\`

## ⏱️ Time Complexity
O(n²) — sorting takes `O(n log n)`, and for each `i` the two-pointer scan takes `O(n)`.

## 💾 Space Complexity
O(1) extra space, excluding the output list.

## 📚 Concepts Used
- Arrays
- Sorting
- Two Pointers (opposite-direction / converging)
- Duplicate skipping

## 📥 Sample Input
\`\`\`
6
-4 -1 -1 0 1 2
\`\`\`

## 📤 Sample Output
\`\`\`
[-1, -1, 2]
[-1, 0, 1]
\`\`\`

## 📖 Example
**Input**
\`\`\`
6
-4 -1 -1 0 1 2
\`\`\`
**Output**
\`\`\`
[[-1,-1,2],[-1,0,1]]
\`\`\`
**Explanation**
Fixing `i=1` (`nums[i]=-1`), the two-pointer scan finds `-1+(-1)+2=0` and `-1+0+1=0`. `i=2` is skipped since it duplicates `i=1`. No other `i` produces a valid triplet.

## 🎯 Key Takeaway
Brute force checks all O(n³) triplets. Sorting + two pointers reduces this to O(n²) by fixing one element and reusing the converging-pointer trick — while duplicate-skipping keeps every triplet in the result unique.
