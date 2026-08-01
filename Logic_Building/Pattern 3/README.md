# ⭐ Pattern 3 – Inverted Right Triangle Star Pattern

## 📌 Problem Statement

Given an integer `n`, print an inverted right-angled triangle pattern using `*`.

---

## 📝 Approach

- Use an outer loop to iterate through each row.
- For every row, print stars starting from the current row number up to `n`.
- After printing all the stars in a row, move to the next line.

---

## 🔄 Algorithm

1. Read the value of `n`.
2. Run a loop from `1` to `n` for the rows.
3. For each row `i`, run another loop from `i` to `n`.
4. Print `"* "` inside the inner loop.
5. After the inner loop, print a new line.
6. Repeat until all rows are printed.

---

## ⏱️ Time Complexity

**O(n²)**

The total number of stars printed is:

```text
n + (n-1) + (n-2) + ... + 1
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
* * * * *
* * * *
* * *
* *
*
```

---

## 📖 Dry Run

For `n = 5`

| Row (i) | Stars Printed |
|---------|---------------|
| 1 | * * * * * |
| 2 | * * * * |
| 3 | * * * |
| 4 | * * |
| 5 | * |

---

## 🎯 Key Takeaway

- The **outer loop** controls the number of rows.
- The **inner loop** starts from the current row number (`i`) and runs up to `n`.
- As the row number increases, the number of stars decreases by one.

---

## ⭐ Interview Tip

For inverted patterns, instead of increasing the number of columns, think about **decreasing** them.

A simple trick is:

- **Increasing Triangle:** `j = 1 → i`
- **Decreasing Triangle:** `j = i → n`

This small change is enough to convert an increasing pattern into a decreasing one.
