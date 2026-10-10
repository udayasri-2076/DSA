# Linked List Cycle II - 142

## Problem Statement
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.

## Approach 1: Brute Force
### Approach
Store each visited node in a HashSet or set during traversal. If we encounter a node that is already present in our collection, a cycle exists and that exact node is the starting point of the cycle.
### Algorithm
1. Initialize an empty HashSet `bruteVisited` and a pointer `bruteCurr` starting at `head`.
2. Traverse through the linked list node by node.
3. Check if `bruteCurr` is already in `bruteVisited`. If yes, return `bruteCurr`.
4. Otherwise, add `bruteCurr` to `bruteVisited` and advance to the next node.
5. If the traversal finishes without finding any duplicate node, return `null`.
### Time Complexity
O(n) where n is the number of nodes in the linked list.
### Space Complexity
O(n) for storing the visited nodes in the hash set.

## Approach 2: Optimal Approach (Slow-Fast Pointer)
### Approach
Use Floyd's Tortoise and Hare (Slow-Fast Pointer) algorithm. A slow pointer moves 1 step at a time while a fast pointer moves 2 steps at a time. If they meet, a cycle is guaranteed to exist. Resetting one pointer to the head and advancing both 1 step at a time will cause them to meet precisely at the start of the cycle.
### Algorithm
1. Initialize two pointers `slow` and `fast` pointing to `head`.
2. Traverse the list: `slow` moves 1 step (`slow = slow.next`), and `fast` moves 2 steps (`fast = fast.next.next`).
3. If `fast` or `fast.next` becomes `null`, there is no cycle; return `null`.
4. If `slow == fast`, a cycle is detected. Reset `slow` to `head`.
5. Move both `slow` and `fast` 1 step at a time until they meet again. The meeting node is the start of the cycle; return it.
### Time Complexity
O(n)
### Space Complexity
O(1)

## Comparison of Approaches
- Brute Force uses extra space (O(n)) to keep track of visited nodes using a Hash Set.
- Optimal Approach uses constant extra space (O(1)) by leveraging mathematical properties of cycle lengths with two pointers.

## Concepts Used
- Linked List
- Hash Set
- Slow-Fast Pointer (Floyd's Cycle-Finding Algorithm)

## Sample Input
Head = [3, 2, 0, -4], pos = 1 (tail connects to node index 1)

## Sample Output
Node with value 2