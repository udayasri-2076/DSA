# ⭐ Pattern 5 – Right-Aligned Star Triangle Pattern

## 📌 Problem Statement

Given an integer `n`, print a right-aligned triangle pattern using `*`.

---

## 📝 Approach

- Use an outer loop to iterate through each row.
- Before printing stars, print the required number of leading spaces.
- The number of spaces decreases by one in every row.
- The number of stars increases by one in every row.
- After printing each row, move to the next line.

---

## 🔄 Algorithm

1. Read the value of `n`.
2. Run a loop from `1` to `n` for the rows.
3. For each row `i`:
   - Print `(n - i)` spaces.
   - Print `i` stars.
4. Move to the next line.
5. Repeat until all rows are printed.

---

## ⏱️ Time Complexity

**O(n²)**

The pattern uses two nested loops for every row.

---

## 💾 Space Complexity

**O(1)**

No extra space is used.

---

## 📚 Concepts Used

- Nested Loops
- Pattern Printing
- Spaces and Stars
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

| Row (i) | Spaces | Stars |
|---------|--------|-------|
| 1 | 4 | * |
| 2 | 3 | * * |
| 3 | 2 | * * * |
| 4 | 1 | * * * * |
| 5 | 0 | * * * * * |

---

## 🎯 Key Takeaway

- The **first inner loop** prints the leading spaces.
- The **second inner loop** prints the stars.
- As the row number increases:
  - Spaces decrease by **1**.
  - Stars increase by **1**.

---

## ⭐ Interview Tip

Whenever you see a **right-aligned** pattern:

- **Spaces = `n - i`**
- **Stars = `i`**

A simple formula to remember is:

```text
Rows    → i = 1 to n
Spaces → n - i
Stars  → i
```

Most right-aligned triangle patterns follow this logic with only minor variations.
