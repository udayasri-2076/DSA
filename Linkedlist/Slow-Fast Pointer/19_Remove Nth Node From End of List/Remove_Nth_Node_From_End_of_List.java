public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Brute Force Approach:
        // Count total nodes first, then traverse a second time to reach and delete the (L - n + 1)-th node.
        // Time Complexity: O(L) where L is the length of the linked list.
        // Space Complexity: O(1).
        // Example head: [1, 2, 3, 4, 5], n = 2
        ListNode bruteCurr = head;          // bruteCurr = [1, 2, 3, 4, 5] (pointer for counting length)
        int bruteLen = 0;                 // bruteLen = 0 (total node count)
        while (bruteCurr != null) {       // Condition: Iteration 1: [1..5] != null (true) | Iteration 2: [2..5] != null (true) | Iteration 3: [3..5] != null (true) | Iteration 4: [4..5] != null (true) | Iteration 5: [5] != null (true) | Iteration 6: null != null (false)
            bruteLen++;                   // Iteration 1: bruteLen = 1 | Iteration 2: bruteLen = 2 | Iteration 3: bruteLen = 3 | Iteration 4: bruteLen = 4 | Iteration 5: bruteLen = 5
            bruteCurr = bruteCurr.next;   // Iteration 1: bruteCurr = [2, 3, 4, 5] | Iteration 2: bruteCurr = [3, 4, 5] | Iteration 3: bruteCurr = [4, 5] | Iteration 4: bruteCurr = [5] | Iteration 5: bruteCurr = null
        }
        int bruteTarget = bruteLen - n;   // bruteTarget = 5 - 2 = 3 (index from start, 0-indexed, before the node to remove)
        if (bruteTarget == 0) {           // bruteTarget == 0 (3 == 0 -> false)
            return head.next;
        }
        ListNode brutePrev = head;        // brutePrev = [1, 2, 3, 4, 5]
        for (int i = 0; i < bruteTarget - 1; i++) { // i = 0, 1... traversing to node before target
            brutePrev = brutePrev.next;   // Iteration 1: brutePrev = [2, 3, 4, 5] | Iteration 2: brutePrev = [3, 4, 5]
        }
        brutePrev.next = brutePrev.next.next; // brutePrev.next updated to skip node 4, list becomes [1, 2, 3, 5]
        // return head; // returns head after brute force deletion

        // Optimal Approach:
        // Use a dummy node and a two-pointer (slow and fast) approach with a gap of n nodes to remove the Nth node in one pass.
        // Time Complexity: O(L)
        // Space Complexity: O(1)

        // Example head: [1, 2, 3, 4, 5], n = 2
        ListNode dummy = new ListNode(0); // dummy = 0 -> [1, 2, 3, 4, 5]
        dummy.next = head;                // dummy.next points to head

        ListNode slow = dummy;            // slow = dummy (starts at dummy)
        ListNode fast = dummy;            // fast = dummy (starts at dummy)

        for (int i = 0; i <= n; i++) {    // i = 0, 1, 2... advancing fast pointer by n + 1 steps
            fast = fast.next;             // Iteration 1: fast = [1, 2, 3, 4, 5] | Iteration 2: fast = [2, 3, 4, 5] | Iteration 3: fast = [3, 4, 5]
        }

        while (fast != null) {            // Condition: Iteration 1: [3, 4, 5] != null (true) | Iteration 2: [4, 5] != null (true) | Iteration 3: [5] != null (true) | Iteration 4: null != null (false)
            slow = slow.next;             // Iteration 1: slow = [1, 2, 3, 4, 5] | Iteration 2: slow = [2, 3, 4, 5] | Iteration 3: slow = [3, 4, 5]
            fast = fast.next;             // Iteration 1: fast = [4, 5] | Iteration 2: fast = [5] | Iteration 3: fast = null
        }

        slow.next = slow.next.next;       // slow.next updated to skip node 4, list becomes [1, 2, 3, 5]
        return dummy.next;                // returns updated head starting at dummy.next ([1, 2, 3, 5])
    }
}