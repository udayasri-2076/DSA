public class Solution {
    public ListNode middleNode(ListNode head) {
        // Brute Force Approach:
        // Traverse the linked list completely to count the total number of nodes, then traverse again up to the middle index.
        // Time Complexity: O(n) where n is the number of nodes in the linked list.
        // Space Complexity: O(1).
        // Example head: [1, 2, 3, 4, 5]
        ListNode bruteCurr = head; // bruteCurr = node 1 (pointer to traverse and count nodes)
        int bruteCount = 0;        // bruteCount = 0 (stores total number of nodes)
        while (bruteCurr != null) { // Condition: Iteration 1: node 1 != null (true) | Iteration 2: node 2 != null (true) | Iteration 3: node 3 != null (true) | Iteration 4: node 4 != null (true) | Iteration 5: node 5 != null (true) | Iteration 6: null != null (false)
            bruteCount++;          // Iteration 1: bruteCount = 0 + 1 = 1 | Iteration 2: bruteCount = 1 + 1 = 2 | Iteration 3: bruteCount = 2 + 1 = 3 | Iteration 4: bruteCount = 3 + 1 = 4 | Iteration 5: bruteCount = 4 + 1 = 5
            bruteCurr = bruteCurr.next; // Iteration 1: bruteCurr = node 2 | Iteration 2: bruteCurr = node 3 | Iteration 3: bruteCurr = node 4 | Iteration 4: bruteCurr = node 5 | Iteration 5: bruteCurr = null
        }
        int bruteMidIndex = bruteCount / 2; // bruteMidIndex = 5 / 2 = 2 (middle index to reach)
        bruteCurr = head;          // bruteCurr = node 1 (reset pointer to head)
        for (int i = 0; i < bruteMidIndex; i++) { // i = 0, 1... looping until reaching middle index 2
            bruteCurr = bruteCurr.next; // Iteration 1: bruteCurr = node 2 | Iteration 2: bruteCurr = node 3
        }
        return bruteCurr;          // returns node 3 as the middle node
        // return null;

        // Optimal Approach:
        // Use slow and fast pointers where fast moves twice as fast as slow, reaching the end when slow hits the middle.
        // Time Complexity: O(n)
        // Space Complexity: O(1)

        // Example head: [1, 2, 3, 4, 5]
        ListNode slow = head;      // slow = node 1 (slow pointer starts at head)
        ListNode fast = head;      // fast = node 2 (fast pointer starts at head)

        while (fast != null && fast.next != null) { // Condition: Iteration 1: node 1 != null && node 2 != null (true) | Iteration 2: node 3 != null && node 4 != null (true) | Iteration 3: node 5 != null && node 5.next == null (false)
            slow = slow.next;      // Iteration 1: slow = node 2 | Iteration 2: slow = node 3
            fast = fast.next.next; // Iteration 1: fast = node 3.next = node 3 (wait, fast.next.next for node 1 is node 3) -> fast = node 3 | Iteration 2: fast = node 5.next = null -> fast = null
        }

        return slow;               // returns slow pointing to node 3
    }
}
