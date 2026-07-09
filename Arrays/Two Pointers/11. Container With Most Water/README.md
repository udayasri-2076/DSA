# 🌊 Container With Most Water

## 📌 Problem Statement
Given an array `height[]` where each element represents the height of a vertical line at that index, choose two lines that together with the x-axis form a container. Find two lines that hold the **maximum amount of water**.

Water fills up to the height of the **shorter** of the two chosen lines (it spills over the shorter side).

## 📝 Approach
This problem is efficiently solved using the **Two Pointer technique**.

- Use `l` starting at index `0` and `r` starting at index `n-1`.
- At each step, calculate the area formed between `l` and `r`:
  - `width = r - l`
  - `height = min(height[l], height[r])`
  - `area = width * height`
- Move the pointer pointing to the **shorter** wall inward, since:
  - Moving the taller wall inward can never increase the area (height is still capped by the same short wall, width only shrinks).
  - Moving the shorter wall inward gives a *chance* of finding a taller wall, which could increase the limiting height.
- Keep track of the maximum area seen throughout the traversal.

## 🔄 Algorithm
1. Read the size of the array.
2. Store all array elements (heights).
3. Initialize `l = 0`, `r = n - 1`, `maximum = 0`.
4. While `l < r`:
   - Calculate `width`, `height`, and `area`.
   - Update `maximum` if current `area` is larger.
   - Move the pointer with the smaller height inward.
5. Print `maximum`.

## 💻 Java Solution
\`\`\`java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] height = new int[n];

        for(int i = 0; i < n; i++) {
            height[i] = in.nextInt();
        }

        int l = 0;
        int r = n - 1;
        int maximum = 0;

        while(l < r) {
            int width = r - l;
            int h = Math.min(height[l], height[r]);
            maximum = Math.max(maximum, width * h);

            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        System.out.print(maximum);
    }
}
\`\`\`

## ⏱️ Time Complexity
O(n) — each pointer moves at most `n` times total, single traversal.

## 💾 Space Complexity
O(1) — no extra data structures used.

## 📚 Concepts Used
- Arrays
- Two Pointers (opposite-direction / converging)
- Greedy pointer movement

## 📥 Sample Input
\`\`\`
9
1 8 6 2 5 4 8 3 7
\`\`\`

## 📤 Sample Output
\`\`\`
49
\`\`\`

## 📖 Example
**Input**
\`\`\`
9
1 8 6 2 5 4 8 3 7
\`\`\`
**Output**
\`\`\`
49
\`\`\`
**Explanation**
The maximum water is trapped between index `1` (height 8) and index `8` (height 7). Width = 7, limiting height = 7 (shorter wall), so area = 7 × 7 = 49 — the largest possible among all pairs.

## 🎯 Key Takeaway
Brute force checks all O(n²) pairs. Two pointers exploit the fact that moving the taller wall inward can never help — only moving the shorter wall has potential to increase the area — bringing it down to O(n) time.
