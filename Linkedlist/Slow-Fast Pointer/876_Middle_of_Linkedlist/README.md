# Middle of the Linked List - 876

## Problem Statement
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

## Approach 1: Brute Force
### Approach
Traverse the linked list once to count the total number of nodes. Calculate the middle index by dividing the total count by 2. Traverse the list a second time from the head up to the middle index to find the exact middle node.
### Algorithm
1. Initialize a pointer `bruteCurr` to `head` and a counter `bruteCount` to 0.
2. Iterate through the linked list until `bruteCurr` becomes null, incrementing `bruteCount` and advancing `bruteCurr` at each step.
3. Compute `bruteMidIndex` as `bruteCount / 2`.
4. Reset `bruteCurr` to `head` and advance it `bruteMidIndex` times.
5. Return `bruteCurr`.
### Time Complexity
O(n) where n is the number of nodes in the linked list.
### Space Complexity
O(1)

## Approach 2: Optimal Approach
### Approach
Use the Tortoise and Hare (two-pointer) technique with a `slow` pointer and a `fast` pointer. Both pointers start at the head. The `fast` pointer moves two steps for every single step the `slow` pointer takes. When the `fast` pointer reaches the end of the list, the `slow` pointer will be positioned exactly at the middle node.
### Algorithm
1. Initialize `slow` pointer to `head` and `fast` pointer to `head`.
2. Loop while `fast` is not null and `fast.next` is not null.
3. Move `slow` forward by one step: `slow = slow.next`.
4. Move `fast` forward by two steps: `fast = fast.next.next`.
5. When the loop terminates, return `slow` as the middle node.
### Time Complexity
O(n) where n is the number of nodes in the linked list.
### Space Complexity
O(1)

## Comparison of Approaches
- **Brute Force Approach** requires two complete passes over the linked list (one for counting nodes and one for finding the middle node).
- **Optimal Approach** completes the task in a single pass using two pointers moving at different speeds, achieving optimal O(n) time and O(1) space complexity without requiring node counts.

## Concepts Used
- Linked List
- Two Pointers (Tortoise and Hare Algorithm)
- Fast and Slow Pointer Pattern

## Sample Input
head = [1, 2, 3, 4, 5]

## Sample Output
[3, 4, 5]
