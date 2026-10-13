public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Brute Force Approach:
        // Count total nodes first, then traverse again to find and remove the (length - n + 1)th node from the start.
        // Time Complexity: O(L) where L is the number of nodes in the linked list (two passes).
        // Space Complexity: O(1).
        // Example head = [1, 2, 3, 4, 5], n = 2
        ListNode bruteCurr = head;          // bruteCurr = [1, 2, 3, 4, 5] (pointer to traverse for length)
        int bruteLen = 0;                  // bruteLen = 0 (stores total length)
        while (bruteCurr != null) {        // Condition: Iteration 1: not null (true) | ... | Iteration 6: null (false)
            bruteLen++;                    // Iteration 1: bruteLen = 1 | Iteration 2: bruteLen = 2 | Iteration 3: bruteLen = 3 | Iteration 4: bruteLen = 4 | Iteration 5: bruteLen = 5
            bruteCurr = bruteCurr.next;    // Iteration 1: bruteCurr = [2, 3, 4, 5] | ... | Iteration 5: bruteCurr = null
        }
        int bruteTarget = bruteLen - n;    // bruteTarget = 5 - 2 = 3 (index from start, 0-indexed)
        if (bruteTarget == 0) {            // bruteTarget == 0 (3 == 0 -> false)
            return head.next;
        }
        ListNode brutePrev = null;         // brutePrev = null (tracks node before target)
        bruteCurr = head;                  // bruteCurr = [1, 2, 3, 4, 5] (reset to head)
        for (int i = 0; i < bruteTarget; i++) { // i = 0, 1, 2... traversing to target
            brutePrev = bruteCurr;         // Iteration 1: brutePrev = [1, 2, 3, 4, 5] | Iteration 2: brutePrev = [2, 3, 4, 5] | Iteration 3: brutePrev = [3, 4, 5]
            bruteCurr = bruteCurr.next;    // Iteration 1: bruteCurr = [2, 3, 4, 5] | Iteration 2: bruteCurr = [3, 4, 5] | Iteration 3: bruteCurr = [4, 5]
        }
        brutePrev.next = bruteCurr.next;   // links node before target to node after target: [3, 4, 5].next = [5], removing [4]
        // return head;                    // returns modified head [1, 2, 3, 5]

        // Optimal Approach:
        // Use two pointers (slow and fast) separated by n steps to remove the Nth node from the end in a single pass.
        // Time Complexity: O(L) where L is the number of nodes in the linked list.
        // Space Complexity: O(1).
        // Example head = [1, 2, 3, 4, 5], n = 2
        ListNode dummy = new ListNode(0);  // dummy = 0 -> [1, 2, 3, 4, 5] (dummy node to handle edge cases like removing head)
        dummy.next = head;                 // dummy.next points to actual head
        
        ListNode slow = dummy;             // slow = dummy (slow pointer starts at dummy)
        ListNode fast = dummy;             // fast = dummy (fast pointer starts at dummy)

        for (int i = 0; i <= n; i++) {     // i = 0, 1, 2... advancing fast pointer by n + 1 steps
            fast = fast.next;              // Iteration 0: fast = [1, 2, 3, 4, 5] | Iteration 1: fast = [2, 3, 4, 5] | Iteration 2: fast = [3, 4, 5]
        }

        while (fast != null) {             // Condition: Iteration 1: [3, 4, 5] != null (true) | Iteration 2: [4, 5] != null (true) | Iteration 3: [5] != null (true) | Iteration 4: null != null (false)
            slow = slow.next;              // Iteration 1: slow = [1, 2, 3, 4, 5] | Iteration 2: slow = [2, 3, 4, 5] | Iteration 3: slow = [3, 4, 5]
            fast = fast.next;              // Iteration 1: fast = [4, 5] | Iteration 2: fast = [5] | Iteration 3: fast = null
        }

        slow.next = slow.next.next;        // slow.next = [3, 4, 5].next.next = [5] (bypasses node [4], removing it)
        return dummy.next;                 // returns head of the modified list [1, 2, 3, 5]
    }
}