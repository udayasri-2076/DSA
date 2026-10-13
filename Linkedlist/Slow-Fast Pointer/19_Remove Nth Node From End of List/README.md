# Remove Nth Node From End of List - LeetCode 19

## Problem Statement
Given the head of a linked list, remove the nth node from the end of the list and return its head.

## Approach 1: Brute Force
### Approach
Traverse the linked list once to count the total number of nodes (L). Calculate the exact position from the beginning of the list (L - n) where the target node resides. Traverse a second time up to the node right before the target and update its pointer to bypass and remove the target node.
### Algorithm
1. Initialize a pointer to traverse the list and a length counter to 0.
2. Iterate through all nodes until the end, incrementing the length counter.
3. Compute the target removal index from the start as `length - n`.
4. Handle the edge case where the target index is 0 (meaning the head itself needs to be removed) by returning `head.next`.
5. Reset the traversal pointer to the head and iterate `target - 1` times to reach the predecessor of the node to be deleted.
6. Update the predecessor's `next` pointer to skip the target node.
7. Return the head of the modified list.
### Time Complexity
O(L) where L is the number of nodes in the linked list, as it requires two passes.
### Space Complexity
O(1)

## Approach 2: Optimal Approach (Slow-Fast Pointer)
### Approach
Use a two-pointer approach (slow and fast pointers) to accomplish the removal in a single pass. By advancing the fast pointer n + 1 steps ahead of the slow pointer, maintaining a fixed gap between them, both pointers can traverse the list concurrently. When the fast pointer reaches the end of the list, the slow pointer will be positioned exactly at the node preceding the target node, allowing for efficient deletion in O(1) pointer updates.
### Algorithm
1. Create a dummy node with value 0 and point its `next` field to the list `head`. This simplifies edge cases such as removing the actual head node.
2. Initialize both `slow` and `fast` pointers to point to the `dummy` node.
3. Advance the `fast` pointer `n + 1` times so that a gap of `n` nodes is established between `slow` and `fast`.
4. Traverse both `slow` and `fast` pointers simultaneously until `fast` reaches `null` (end of the list).
5. At this point, `slow.next` is the target node to be removed. Update `slow.next = slow.next.next` to remove the node.
6. Return `dummy.next` as the new head of the linked list.
### Time Complexity
O(L) where L is the number of nodes in the linked list, achieved in a single traversal pass.
### Space Complexity
O(1)

## Comparison of Approaches
| Approach | Time Complexity | Space Complexity | Passes | Notes |
| --- | --- | --- | --- | --- |
| Brute Force | O(L) | O(1) | 2 | Requires calculating length first |
| Optimal (Slow-Fast) | O(L) | O(1) | 1 | Single pass using pointer gap |

## Concepts Used
- Linked List Traversal
- Two-Pointer Technique (Slow and Fast Pointers)
- Dummy Head Node Pattern

## Sample Input
head = [1, 2, 3, 4, 5], n = 2

## Sample Output
[1, 2, 3, 5]