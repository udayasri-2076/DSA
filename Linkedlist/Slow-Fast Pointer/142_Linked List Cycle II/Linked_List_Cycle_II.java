public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Brute Force Approach:
        // Use a HashSet to store visited nodes, traversing the linked list and returning the first node already present in the set.
        // Time Complexity: O(n) where n is the number of nodes in the linked list.
        // Space Complexity: O(n) to store nodes in the hash set.
        // Example linked list: 3 -> 2 -> 0 -> -4, where -4 points back to 2 (pos = 1)
        java.util.HashSet<ListNode> bruteVisited = new java.util.HashSet<>(); // bruteVisited = [] (empty set)
        ListNode bruteCurr = head;                                            // bruteCurr = Node(3)
        while (bruteCurr != null) {                                           // Condition: Iteration 1: Node(3) != null (true) | Iteration 2: Node(2) != null (true) | Iteration 3: Node(0) != null (true) | Iteration 4: Node(-4) != null (true) | Iteration 5: Node(2) != null (true)
            if (bruteVisited.contains(bruteCurr)) {                           // Iteration 1: set.contains(3) (false) | Iteration 2: set.contains(2) (false) | Iteration 3: set.contains(0) (false) | Iteration 4: set.contains(-4) (false) | Iteration 5: set.contains(2) (true)
                return bruteCurr;                                             // Iteration 5: returns Node(2)
            }
            bruteVisited.add(bruteCurr);                                      // Iteration 1: set = [3] | Iteration 2: set = [3, 2] | Iteration 3: set = [3, 2, 0] | Iteration 4: set = [3, 2, 0, -4]
            bruteCurr = bruteCurr.next;                                       // Iteration 1: bruteCurr = Node(2) | Iteration 2: bruteCurr = Node(0) | Iteration 3: bruteCurr = Node(-4) | Iteration 4: bruteCurr = Node(2)
        }
        // return null; // returns null if loop completes without finding cycle

        // Optimal Approach:
        // Use Floyd's Cycle-Finding Algorithm with two pointers (slow and fast) moving at different speeds to detect the cycle and find its start.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example linked list: 3 -> 2 -> 0 -> -4, where -4 points back to 2 (pos = 1)
        ListNode slow = head; // slow = Node(3)
        ListNode fast = head; // fast = Node(3)

        while (fast != null && fast.next != null) { // Condition: Iteration 1: Node(3) != null && Node(2) != null (true) | Iteration 2: Node(0) != null && Node(-4) != null (true) | Iteration 3: Node(2) != null && Node(0) != null (true)
            slow = slow.next;                       // Iteration 1: slow = Node(2) | Iteration 2: slow = Node(0) | Iteration 3: slow = Node(-4)
            fast = fast.next.next;                  // Iteration 1: fast = Node(0) | Iteration 2: fast = Node(2) | Iteration 3: fast = Node(2)

            if (slow == fast) {                     // Iteration 1: Node(2) == Node(0) (false) | Iteration 2: Node(0) == Node(2) (false) | Iteration 3: Node(-4) == Node(-4) (true)
                slow = head;                        // Iteration 3: slow = Node(3)

                while (slow != fast) {              // Condition: Iteration 1: Node(3) != Node(-4) (true) | Iteration 2: Node(2) != Node(-4) (true)
                    slow = slow.next;               // Iteration 1: slow = Node(2) | Iteration 2: slow = Node(0)
                    fast = fast.next;               // Iteration 1: fast = Node(2) | Iteration 2: fast = Node(-4)
                }

                return slow;                        // Iteration 2: returns Node(2)
            }
        }

        return null;
    }
}