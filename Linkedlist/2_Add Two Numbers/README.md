# Add Two Numbers - LeetCode Number 2

## Problem Statement
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

## Approach 1: Optimal
### Approach
We can traverse both linked lists from left to right (which represents least significant digit to most significant digit) while maintaining a carry variable. At each step, we sum the corresponding digits of both lists along with the carry from the previous operation. We then extract the units digit for the current result node and pass the tens digit as the carry for the next iteration.

### Algorithm
1. Initialize a `dummy` node with value 0 and a pointer `curr` pointing to `dummy`.
2. Initialize `carry` to 0.
3. Loop while `l1` is not null, `l2` is not null, or `carry` is not 0:
   - Set `sum` equal to `carry`.
   - If `l1` is not null, add `l1.val` to `sum` and advance `l1` to `l1.next`.
   - If `l2` is not null, add `l2.val` to `sum` and advance `l2` to `l2.next`.
   - Update `carry = sum / 10`.
   - Create a new node with value `sum % 10` and attach it to `curr.next`.
   - Advance `curr` to `curr.next`.
4. Return `dummy.next` as the head of the resultant linked list.

### Time Complexity
O(max(N, M)) where N and M are the lengths of the two linked lists. We iterate through both lists at most once.

### Space Complexity
O(max(N, M)) to hold the new result linked list of length at most max(N, M) + 1.

## Comparison of Approaches
- **Optimal Approach**: Processes both lists simultaneously in a single pass with O(max(N, M)) time and space complexities, handling carries efficiently on the fly without needing to convert linked lists to actual integers (which would overflow for large inputs).

## Concepts Used
- Linked List Traversal
- Elementary Math (Carry and Modulo Operations)
- Dummy Head Pointer Pattern

## Sample Input
l1 = [2, 4, 3], l2 = [5, 6, 4]

## Sample Output
[7, 0, 8]