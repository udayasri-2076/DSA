# 🚀 Move Zeroes

## 📌 Problem Statement

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.

**Note:** The operation must be performed **in-place** without making a copy of the array.

---

## 📝 Approach

This problem can be solved efficiently using the **Two Pointer** technique.

- Use one pointer (`left`) to track the position where the next non-zero element should be placed.
- Use another pointer (`right`) to traverse the array.
- Whenever a non-zero element is encountered:
  - Swap `nums[left]` and `nums[right]`.
  - Increment `left`.
- After one complete traversal, all non-zero elements will be placed at the beginning while all zeros automatically move to the end.

---

## 🔄 Algorithm

1. Read the size of the array.
2. Store all array elements.
3. Initialize a pointer `left = 0`.
4. Traverse the array using pointer `right` from `0` to `n - 1`.
5. If `nums[right]` is not `0`:
   - Swap `nums[left]` and `nums[right]`.
   - Increment `left`.
6. Print the modified array.

---

## 💻 Java Solution

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int left = 0;

        for(int right = 0; right < n; right++) {
            if(nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
        }

        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
```

---

## ⏱️ Time Complexity

**O(n)**

- The array is traversed only once.

---

## 💾 Space Complexity

**O(1)**

- No extra array or additional data structure is used.

---

## 📚 Concepts Used

- Arrays
- Two Pointers
- Swapping
- In-place Algorithm

---

## 📥 Sample Input

```
5
0 1 0 3 12
```

## 📤 Sample Output

```
1 3 12 0 0
```

---

## 📖 Example

### Input

```
5
0 1 0 3 12
```

### Output

```
1 3 12 0 0
```

### Explanation

The non-zero elements (`1`, `3`, `12`) maintain their original relative order, while all the zeros are moved to the end of the array. The operation is performed **in-place**, requiring no extra space.

---

## 🎯 Key Takeaway

The **Two Pointer** technique allows us to solve this problem in **O(n)** time and **O(1)** space by efficiently placing non-zero elements at the beginning of the array while pushing zeros to the end.
