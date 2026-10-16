# Remove Nth Node From End of List - 19

## Problem Statement
Given the head of a linked list, remove the nth node from the end of the list and return its head.

## Approach 1: Brute Force
### Approach
Traverse the entire linked list to compute its length L. Then compute the position from the start (L - n) and traverse a second time to delete the target node.
### Algorithm
1. Initialize a pointer to traverse and count the total number of nodes (bruteLen).
2. Calculate the exact index from the beginning where deletion must happen.
3. Traverse again up to the node right before the target node and update pointers to bypass it.
### Time Complexity
O(L) where L is the length of the linked list.
### Space Complexity
O(1)

## Approach 2: Optimal Approach
### Approach
Use a dummy head node combined with two pointers (slow and fast) to locate the target node in a single pass by maintaining a fixed gap of n nodes between them.
### Algorithm
1. Create a dummy node pointing to the head to safely handle edge cases like removing the first node.
2. Initialize both slow and fast pointers at the dummy node.
3. Advance the fast pointer by n + 1 steps so that a gap of n nodes is created between slow and fast.
4. Move both slow and fast pointers simultaneously until fast reaches the end of the list.
5. At this point, slow will be positioned right before the node that needs to be deleted.
6. Update slow.next to skip the target node and return dummy.next.
### Time Complexity
O(L) where L is the length of the linked list.
### Space Complexity
O(1)

## Comparison of Approaches
- Brute Force requires two separate passes over the linked list (one for length counting, one for locating and deleting).
- Optimal Approach achieves the solution in a single pass using the Slow-Fast Pointer pattern, optimizing traversal time while maintaining constant extra space.

## Concepts Used
- Linked List manipulation
- Two-pointer technique (Slow-Fast Pointer pattern)
- Dummy node sentinel technique

## Sample Input
head = [1, 2, 3, 4, 5], n = 2

## Sample Output
[1, 2, 3, 5]