# Linked List Cycle II - 142

## Problem Statement
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

## Approach 1: Brute Force
### Approach
Traverse the linked list and use a Hash Set to track the visited nodes. If we encounter a node that is already present in the set, it means we have found the start of the cycle.
### Algorithm
1. Initialize an empty hash set (or set in Python) and a pointer at the head of the linked list.
2. Iterate through each node in the list.
3. If the current node is already in the set, return the current node.
4. Otherwise, add the current node to the set and advance to the next node.
5. If the end of the list is reached, return null (or None).
### Time Complexity
O(n) where n is the number of nodes in the linked list.
### Space Complexity
O(n) to store the visited nodes in the hash set.

## Approach 2: Optimal Approach
### Approach
Use Floyd's Cycle-Finding Algorithm (Tortoise and Hare) with two pointers. The slow pointer moves one step at a time, while the fast pointer moves two steps at a time. Once they meet inside the cycle, reset the slow pointer to the head and move both pointers one step at a time until they meet again at the start of the cycle.
### Algorithm
1. Initialize two pointers, slow and fast, pointing to the head of the linked list.
2. Traverse the list: slow moves 1 step (`slow = slow.next`) and fast moves 2 steps (`fast = fast.next.next`).
3. If fast reaches null or fast.next is null, there is no cycle; return null.
4. If slow equals fast, a cycle is detected.
5. Reset the slow pointer to the head of the list.
6. Move both slow and fast pointers 1 step at a time until they meet again.
7. Return the node where they meet as the starting node of the cycle.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches

| Approach | Time Complexity | Space Complexity |
| --- | --- | --- |
| Brute Force (HashSet) | O(n) | O(n) |
| Optimal (Slow-Fast Pointer) | O(n) | O(1) |

## Concepts Used
- Linked List
- Hash Set
- Two Pointers
- Slow-Fast Pointer Pattern (Floyd's Tortoise and Hare Algorithm)

## Sample Input
head = [3,2,0,-4], pos = 1

## Sample Output
tail connects to node index 1