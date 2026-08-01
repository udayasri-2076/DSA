# 🔢 Pattern 4 – Inverted Number Triangle Pattern

## 📌 Problem Statement

Given an integer `n`, print an inverted right-angled triangle where each row contains the current row number.

---

## 📝 Approach

- Use an outer loop to iterate through each row.
- For every row, print the current row number (`i`).
- The number of times `i` is printed decreases by one in each row.
- After printing all the numbers in a row, move to the next line.

---

## 🔄 Algorithm

1. Read the value of `n`.
2. Run a loop from `1` to `n` for the rows.
3. For each row `i`, run another loop from `i` to `n`.
4. Print the current row number (`i`) followed by a space.
5. After the inner loop, print a new line.
6. Repeat until all rows are printed.

---

## ⏱️ Time Complexity

**O(n²)**

The total number of elements printed is:

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
1 1 1 1 1
2 2 2 2
3 3 3
4 4
5
```

---

## 📖 Dry Run

For `n = 5`

| Row (i) | Numbers Printed |
|---------|-----------------|
| 1 | 1 1 1 1 1 |
| 2 | 2 2 2 2 |
| 3 | 3 3 3 |
| 4 | 4 4 |
| 5 | 5 |

---

## 🎯 Key Takeaway

- The **outer loop** controls the current row number.
- The **inner loop** starts from the current row (`i`) and runs up to `n`.
- The value printed is always the **current row number (`i`)**.
- As the row number increases, the number of elements printed decreases by one.

---

## ⭐ Interview Tip

For number patterns, ask yourself two questions:

- **What value should be printed?** (`i` or `j`)
- **How many times should it be printed?**

In this pattern:

- **Value Printed → `i`**
- **Number of Times → `n - i + 1`**

Recognizing these two relationships makes solving most number patterns much easier.
