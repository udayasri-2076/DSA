# 🎯 4Sum
## 📌 Problem Statement
Given an array `nums` and an integer `target`, find all unique quadruplets `[nums[i], nums[j], nums[l], nums[r]]` such that `nums[i] + nums[j] + nums[l] + nums[r] == target`.
Note: The four indices used in each quadruplet must be distinct, and the solution set must not contain duplicate quadruplets.
---
## 📝 Approach
This problem can be solved efficiently using the **Two Pointer** technique (an extension of 3Sum).
- Sort the array first, so duplicates can be skipped and two pointers can be used.
- Fix two elements `nums[i]` and `nums[j]` using nested loops.
- Use two pointers `l` (starting right after `j`) and `r` (starting at the end) to find the remaining two numbers.
- Whenever a valid quadruplet is found:
  - Add it to the result.
  - Move `l` and `r` inward, skipping duplicates.
- If `sum > target`, move `r` left. If `sum < target`, move `l` right.
---
## 🔄 Algorithm
1. Read the size of the array and the target value.
2. Store all array elements.
3. Sort the array.
4. Initialize an empty result list.
5. Loop `i` from `0` to `n - 1`, skipping duplicate `i` values.
6. Loop `j` from `i + 1` to `n - 1`, skipping duplicate `j` values.
7. Set `l = j + 1` and `r = n - 1`.
8. While `l < r`:
   - If `nums[i] + nums[j] + nums[l] + nums[r] == target`, add the quadruplet, move `l++`, `r--`, and skip duplicates.
   - If the sum is greater than `target`, decrement `r`.
   - Otherwise, increment `l`.
9. Print the result list.
---
## 💻 Java Solution
```java
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
```
---
## ⏱️ Time Complexity
**O(n³)**
- Two nested loops for `i` and `j` give `O(n²)`, and the two-pointer scan takes `O(n)`.
---
## 💾 Space Complexity
**O(1)**
- No extra array or additional data structure is used, apart from the output list.
---
## 📚 Concepts Used
- Arrays
- Sorting
- Two Pointers
- Duplicate skipping
---
## 📥 Sample Input
```
6 0
1 0 -1 0 -2 2
```
## 📤 Sample Output
```
-2 -1 1 2
-2 0 0 2
-1 0 0 1
```
---
## 📖 Example
### Input
```
6 0
1 0 -1 0 -2 2
```
### Output
```
-2 -1 1 2
-2 0 0 2
-1 0 0 1
```
### Explanation
After sorting the array to [-2, -1, 0, 0, 1, 2], fixing i and j in turn and scanning with l and r finds three unique quadruplets that sum to 0, with duplicate values skipped along the way.
---
## 🎯 Key Takeaway
The **Two Pointer** technique reduces the brute-force **O(n⁴)** approach down to **O(n³)** by fixing two elements and scanning the rest with converging pointers, while duplicate-skipping keeps the result unique.
