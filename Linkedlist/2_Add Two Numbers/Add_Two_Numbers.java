public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // dummy node to easily return head of result list
        ListNode curr = curr = dummy;    // curr pointer tracks the current node in result list, starts at dummy
        int carry = 0;                  // carry initialized to 0 for addition overflow

        // Loop runs as long as there are digits in l1, l2, or a remaining carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;            // sum starts with the carry from previous addition

            if (l1 != null) {
                sum += l1.val;          // add value from l1: e.g., l1.val = 2, sum = 2
                l1 = l1.next;           // move l1 pointer to next node
            }

            if (l2 != null) {
                sum += l2.val;          // add value from l2: e.g., l2.val = 5, sum = 7
                l2 = l2.next;           // move l2 pointer to next node
            }

            carry = sum / 10;           // calculate new carry: e.g., 7 / 10 = 0
            curr.next = new ListNode(sum % 10); // create new node with digit value: 7 % 10 = 7
            curr = curr.next;           // move curr pointer forward to the new node
        }

        return dummy.next;              // return head of the actual result list, skipping dummy
    }
}