# 🔢 Pattern 1– Number Triangle Pattern

## 📌 Problem Statement

Given an integer `n`, print a right-angled triangle where each row contains numbers starting from `1` up to the current row number.

---

## 📝 Approach

- Use an outer loop to iterate through each row.
- For every row, print numbers from `1` to the current row number.
- After printing all the numbers in a row, move to the next line.

---

## 🔄 Algorithm

1. Read the value of `n`.
2. Run a loop from `1` to `n` for the rows.
3. For each row `i`, run another loop from `1` to `i`.
4. Print the value of `j` followed by a space.
5. After the inner loop, print a new line.
6. Repeat until all rows are printed.

---

## ⏱️ Time Complexity

**O(n²)**

The total number of numbers printed is:

```text
1 + 2 + 3 + ... + n
```

which is approximately `n²`.

---

## 💾 Space Complexity

**O(1)**

No extra space is used.

---

## 📚 Concepts Used

- Nested Loops
- Pattern Printing
- Iteration

---

## 📥 Sample Input

```text
5
```

## 📤 Sample Output

```text
1
1 2
1 2 3
1 2 3 4
1 2 3 4 5
```

---

## 📖 Dry Run

For `n = 5`

| Row (i) | Numbers Printed |
|---------|-----------------|
| 1 | 1 |
| 2 | 1 2 |
| 3 | 1 2 3 |
| 4 | 1 2 3 4 |
| 5 | 1 2 3 4 5 |

---

## 🎯 Key Takeaway

- The **outer loop** controls the number of rows.
- The **inner loop** controls the numbers printed in each row.
- The numbers always start from **1** and end at the current row number.

---

## ⭐ Interview Tip

Whenever you solve number pattern problems, identify:

- **Number of Rows** → Outer Loop
- **Starting Number** → Usually `1`
- **Ending Number** → Depends on the row (`i`)
- **Spaces (if any)** → Use another inner loop

Understanding the relationship between the row number and the values printed makes most number patterns easy to solve.
