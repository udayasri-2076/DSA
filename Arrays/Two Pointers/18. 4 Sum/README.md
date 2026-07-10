# 🎯 4Sum

## 📌 Problem Statement
Given an array `nums[]` and an integer `target`, find all unique quadruplets `[nums[i], nums[j], nums[l], nums[r]]` such that `i, j, l, r` are distinct indices and `nums[i] + nums[j] + nums[l] + nums[r] == target`. The solution set must not contain **duplicate** quadruplets.

## 📝 Approach
This problem is efficiently solved using **Sorting + Two Pointer technique** (an extension of 3Sum with an extra fixed pointer).

- Sort the array first — makes duplicate skipping and two pointers possible.
- Fix two elements `nums[i]` and `nums[j]`, then use two pointers `l` and `r` to find the remaining two numbers that make the sum equal to `target`.
- `l` starts right after `j`, `r` starts at the end of the array.
- If `sum == target`, record the quadruplet and move both pointers inward, skipping duplicates.
- If `sum > target`, move `r` left (need a smaller sum).
- If `sum < target`, move `l` right (need a bigger sum).
- Skip duplicate values for both `i` and `j` so the same quadruplet isn't picked twice.
- Use `long` for the sum to avoid integer overflow.

## 🔄 Algorithm
1. Sort the array.
2. Loop `i` from `0` to `n-1`:
   - Skip `i` if `nums[i] == nums[i-1]`.
   - Loop `j` from `i+1` to `n-1`:
     - Skip `j` if `nums[j] == nums[j-1]` (and `j > i+1`).
     - Set `l = j+1`, `r = n-1`.
     - While `l < r`:
       - Calculate `sum = nums[i] + nums[j] + nums[l] + nums[r]`.
       - If `sum == target`: add quadruplet, move `l++`, `r--`, skip duplicates on both sides.
       - If `sum > target`: move `r--`.
       - Else: move `l++`.
3. Return the result list.

## 💻 Java Solution
\`\`\`java
import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {

            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i+1; j < n; j++) {

                if(j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int l = j+1;
                int r = n-1;

                while(l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if(sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;

                        while(l < r && nums[l] == nums[l-1]) {
                            l++;
                        }
                        while(l < r && nums[r] == nums[r+1]) {
                            r--;
                        }
                    }
                    else if(sum > target) {
                        r--;
                    }
                    else {
                        l++;
                    }
                }
            }
        }
        return result;
    }
}
\`\`\`

## ⏱️ Time Complexity
O(n³) — two nested loops for `i` and `j` (O(n²)), and for each pair the two-pointer scan takes O(n).

## 💾 Space Complexity
O(1) extra space, excluding the output list.

## 📚 Concepts Used
- Arrays
- Sorting
- Two Pointers (opposite-direction / converging)
- Duplicate skipping
- Overflow handling with `long`

## 📥 Sample Input
\`\`\`
6 0
1 0 -1 0 -2 2
\`\`\`

## 📤 Sample Output
\`\`\`
[-2, -1, 1, 2]
[-2, 0, 0, 2]
[-1, 0, 0, 1]
\`\`\`

## 📖 Example
**Input**
\`\`\`
nums = [1, 0, -1, 0, -2, 2], target = 0
\`\`\`
**Output**
\`\`\`
[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
\`\`\`
**Explanation**
After sorting: `[-2,-1,0,0,1,2]`. Fixing `i` and `j` in turn and running the two-pointer scan on the rest finds exactly three unique quadruplets that sum to `0`, with duplicate `i`/`j`/`l`/`r` values skipped along the way.

## 🎯 Key Takeaway
Brute force checks all O(n⁴) quadruplets. Sorting + two pointers reduces this to O(n³) by fixing two elements and reusing the same converging-pointer trick from 3Sum on the remaining window — while duplicate-skipping at every level keeps the result quadruplet-unique.
\`\`\`
