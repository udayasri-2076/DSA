# 💎 Pattern 6 – Diamond Star Pattern

## 📌 Problem Statement

Given an integer `n`, print a diamond pattern using `*`.

The pattern consists of:

- An upper half (right-aligned increasing triangle).
- A lower half (right-aligned decreasing triangle).

---

## 📝 Approach

The pattern is divided into **two parts**:

### Upper Half

- Print `(n - i)` leading spaces.
- Print `i` stars.
- Repeat for all rows from `1` to `n`.

### Lower Half

- Print `(n - i)` leading spaces.
- Print `i` stars.
- Repeat for all rows from `n - 1` down to `1`.

Combining both halves forms the complete diamond.

---

## 🔄 Algorithm

1. Read the value of `n`.
2. Print the upper half:
   - Run the outer loop from `1` to `n`.
   - Print `(n - i)` spaces.
   - Print `i` stars.
3. Print the lower half:
   - Run the outer loop from `n - 1` down to `1`.
   - Print `(n - i)` spaces.
   - Print `i` stars.
4. Move to the next line after each row.

---

## ⏱️ Time Complexity

**O(n²)**

Both the upper and lower halves use nested loops.

---

## 💾 Space Complexity

**O(1)**

No extra space is used.

---

## 📚 Concepts Used

- Nested Loops
- Pattern Printing
- Spaces and Stars
- Symmetry
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
 * * * *
  * * *
   * *
    *
```

---

## 📖 Dry Run

For `n = 5`

### Upper Half

| Row (i) | Spaces | Stars |
|---------|--------|-------|
| 1 | 4 | * |
| 2 | 3 | * * |
| 3 | 2 | * * * |
| 4 | 1 | * * * * |
| 5 | 0 | * * * * * |

### Lower Half

| Row (i) | Spaces | Stars |
|---------|--------|-------|
| 4 | 1 | * * * * |
| 3 | 2 | * * * |
| 2 | 3 | * * |
| 1 | 4 | * |

---

## 🎯 Key Takeaway

- The diamond is formed by combining **two triangle patterns**.
- The **upper half** increases the number of stars.
- The **lower half** decreases the number of stars.
- Both halves use the same formulas for spaces and stars.

---

## ⭐ Interview Tip

Many complex patterns are built by combining simpler patterns.

For this diamond:

```text
Upper Half
Rows   → 1 to n
Spaces → n - i
Stars  → i

Lower Half
Rows   → n - 1 to 1
Spaces → n - i
Stars  → i
```

If you already know how to print an increasing and decreasing triangle, you can easily build the diamond pattern by combining them.
