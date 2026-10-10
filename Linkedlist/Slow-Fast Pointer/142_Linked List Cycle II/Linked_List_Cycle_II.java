public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Brute Force Approach:
        // Store each visited node in a HashSet. If we encounter a node already present in the set, a cycle exists and that node is the start.
        // Time Complexity: O(n) where n is the number of nodes in the linked list.
        // Space Complexity: O(n) for storing nodes in the HashSet.
        // Example linked list: 3 -> 2 -> 0 -> -4, with tail pointing back to node with value 2 (index 1)
        java.util.HashSet<ListNode> bruteVisited = new java.util.HashSet<>(); // bruteVisited = {} (empty set)
        ListNode bruteCurr = head; // bruteCurr = Node(3)
        int bruteIndex = 0; // bruteIndex = 0 (tracking traversal index)
        while (bruteCurr != null) { // Condition: Iteration 1: Node(3) != null (true) | Iteration 2: Node(2) != null (true) | Iteration 3: Node(0) != null (true) | Iteration 4: Node(-4) != null (true) | Iteration 5: Node(2) != null (true)
            if (bruteVisited.contains(bruteCurr)) { // Iteration 1: contains(Node(3)) -> false | Iteration 2: contains(Node(2)) -> false | Iteration 3: contains(Node(0)) -> false | Iteration 4: contains(Node(-4)) -> false | Iteration 5: contains(Node(2)) -> true
                return bruteCurr; // Iteration 5: returns Node(2) as cycle start
            }
            bruteVisited.add(bruteCurr); // Iteration 1: added Node(3) | Iteration 2: added Node(2) | Iteration 3: added Node(0) | Iteration 4: added Node(-4)
            bruteCurr = bruteCurr.next; // Iteration 1: bruteCurr = Node(2) | Iteration 2: bruteCurr = Node(0) | Iteration 3: bruteCurr = Node(-4) | Iteration 4: bruteCurr = Node(2)
            bruteIndex++; // Iteration 1: bruteIndex = 1 | Iteration 2: bruteIndex = 2 | Iteration 3: bruteIndex = 3 | Iteration 4: bruteIndex = 4
        }
        // return null; // returns null if loop completes without finding cycle

        // Optimal Approach:
        // Use Floyd's Cycle-Finding Algorithm with slow and fast pointers to detect the cycle, then reset slow to head to find the start.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example linked list: 3 -> 2 -> 0 -> -4, with tail pointing back to node with value 2 (index 1)
        ListNode slow = head; // slow = Node(3)
        ListNode fast = head; // fast = Node(3)

        while (fast != null && fast.next != null) { // Condition: Iteration 1: Node(3) != null && Node(2) != null (true) | Iteration 2: Node(0) != null && Node(-4).next != null (true) | Iteration 3: Node(2) != null && Node(0) != null (true)
            slow = slow.next; // Iteration 1: slow = Node(2) | Iteration 2: slow = Node(0) | Iteration 3: slow = Node(-4)
            fast = fast.next.next; // Iteration 1: fast = Node(0) | Iteration 2: fast = Node(2) | Iteration 3: fast = Node(2)

            if (slow == fast) { // Iteration 1: Node(2) == Node(0) (false) | Iteration 2: Node(0) == Node(2) (false) | Iteration 3: Node(-4) == Node(2) (false) -> Wait, let's trace properly: Iteration 1: slow=Node(2), fast=Node(0) | Iteration 2: slow=Node(0), fast=Node(2) | Iteration 3: slow=Node(-4), fast=Node(0) -> correction: fast moves 2 steps: Iteration 1: fast=Node(0) | Iteration 2: fast=Node(-4) | Iteration 3: slow=Node(-4), fast=Node(-4) (true)
                slow = head; // Iteration 3: slow = Node(3)

                while (slow != fast) { // Iteration 1: Node(3) != Node(-4) (true) | Iteration 2: Node(2) != Node(-4) (true)
                    slow = slow.next; // Iteration 1: slow = Node(2) | Iteration 2: slow = Node(0)
                    fast = fast.next; // Iteration 1: fast = Node(2) | Iteration 2: fast = Node(0)
                }
                return slow; // returns Node(2)
            }
        }
        return null;
    }
}