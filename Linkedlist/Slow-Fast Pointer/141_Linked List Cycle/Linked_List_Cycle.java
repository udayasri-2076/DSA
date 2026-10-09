public class Solution {
    public boolean hasCycle(ListNode head) {
        // Brute Force Approach:
        // Use a HashSet to store visited nodes and check if we encounter a node that is already in the set.
        // Time Complexity: O(n) where n is the number of nodes in the linked list.
        // Space Complexity: O(n) for storing nodes in the HashSet.
        // Example linked list: 3 -> 2 -> 0 -> -4 (pointing back to 2)
        java.util.HashSet<ListNode> bruteSet = new java.util.HashSet<>(); // bruteSet initialized to track visited nodes
        ListNode bruteCurr = head;                                         // bruteCurr = 3 (starting at head)
        while (bruteCurr != null) {                                        // Condition: Iteration 1: 3 != null (true) | Iteration 2: 2 != null (true) | Iteration 3: 0 != null (true) | Iteration 4: -4 != null (true) | Iteration 5: 2 != null (true)
            if (bruteSet.contains(bruteCurr)) {                            // Iteration 1: set contains 3 (false) | Iteration 2: set contains 2 (false) | Iteration 3: set contains 0 (false) | Iteration 4: set contains -4 (false) | Iteration 5: set contains 2 (true)
                return true;                                               // Iteration 5: returns true when cycle detected
            }
            bruteSet.add(bruteCurr);                                       // Iteration 1: added 3 | Iteration 2: added 2 | Iteration 3: added 0 | Iteration 4: added -4
            bruteCurr = bruteCurr.next;                                    // Iteration 1: bruteCurr = 2 | Iteration 2: bruteCurr = 0 | Iteration 3: bruteCurr = -4 | Iteration 4: bruteCurr = 2
        }
        // return false; // returns false if loop completes and no cycle is found

        // Optimal Approach:
        // Use two pointers (slow and fast) moving at different speeds to detect a cycle.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example linked list: 3 -> 2 -> 0 -> -4 (pointing back to 2)
        ListNode slow = head; // slow = 3 (starting at head)
        ListNode fast = head; // fast = 3 (starting at head)

        while (fast != null && fast.next != null) { // Condition: Iteration 1: 3 != null && 3.next != null (true) | Iteration 2: 0 != null && 0.next != null (true) | Iteration 3: 2 != null && 2.next != null (true)
            slow = slow.next;                       // Iteration 1: slow = 2 | Iteration 2: slow = 0 | Iteration 3: slow = -4
            fast = fast.next.next;                  // Iteration 1: fast = 0 | Iteration 2: fast = 2 | Iteration 3: fast = 0

            if (slow == fast) {                     // Iteration 1: 2 == 0 (false) | Iteration 2: 0 == 2 (false) | Iteration 3: -4 == -4 (true)
                return true;                        // Iteration 3: returns true when slow meets fast
            }
        }
        return false;
    }
}