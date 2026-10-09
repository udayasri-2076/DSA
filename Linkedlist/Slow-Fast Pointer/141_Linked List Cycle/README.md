# Linked List Cycle - 141

## Problem Statement
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.

## Approach 1: Brute Force
### Approach
Traverse the linked list and keep track of all visited nodes using a hash set. If we encounter a node that is already present in the set, a cycle exists.
### Algorithm
1. Initialize an empty hash set and set a current pointer to the head.
2. Traverse the list node by node.
3. Check if the current node is already in the hash set. If yes, return true.
4. Otherwise, add the current node to the set and move to the next node.
5. If the pointer reaches null, return false.
### Time Complexity
O(n)
### Space Complexity
O(n)

## Approach 2: Optimal (Slow-Fast Pointer)
### Approach
Use two pointers, slow and fast. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. If there is a cycle, the fast pointer will eventually meet the slow pointer.
### Algorithm
1. Initialize both slow and fast pointers at the head of the linked list.
2. Traverse the list with a loop running as long as fast and fast.next are not null.
3. Move slow by one step and fast by two steps.
4. If slow equals fast, return true indicating a cycle.
5. If the loop terminates, return false.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches
- Brute Force uses extra space (O(n)) to store visited nodes.
- Optimal approach uses Floyd's Cycle-Finding Algorithm with two pointers, achieving O(1) space complexity.

## Concepts Used
- Linked List
- Hash Set
- Slow-Fast Pointer Pattern

## Sample Input
head = [3, 2, 0, -4], pos = 1

## Sample Output
true