# ⭐ Pattern 2 – Right Triangle Star Pattern

## 📌 Problem Statement

Given an integer `n`, print a right-angled triangle pattern using `*`.

---

## 📝 Approach

- Use an outer loop to iterate through each row.
- For every row, print stars equal to the current row number.
- After printing all stars in a row, move to the next line.

---

## 🔄 Algorithm

1. Read the value of `n`.
2. Run a loop from `1` to `n` for the rows.
3. For each row `i`, run another loop from `1` to `i`.
4. Print `"* "` inside the inner loop.
5. After the inner loop, print a new line.
6. Repeat until all rows are printed.

---

## ⏱️ Time Complexity

**O(n²)**

The total number of stars printed is:

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
*
* *
* * *
* * * *
* * * * *
```

---

## 📖 Dry Run

For `n = 5`

| Row (i) | Stars Printed |
|---------|---------------|
| 1 | * |
| 2 | * * |
| 3 | * * * |
| 4 | * * * * |
| 5 | * * * * * |

---

## 🎯 Key Takeaway

- The **outer loop** controls the number of rows.
- The **inner loop** controls the number of stars printed in each row.
- The number of stars is always equal to the current row number.

---

## ⭐ Interview Tip

Whenever you solve pattern problems, first identify:

- **Number of Rows** → Outer Loop
- **Number of Columns (Stars/Numbers)** → Inner Loop
- **Spaces (if any)** → Another Inner Loop

Most pattern problems are based on these three loops.
