class Solution:
    def removeNthFromEnd(self, head, n):
        # Brute Force Approach:
        # Count total nodes first, then traverse again to find and remove the (length - n + 1)th node from the start.
        # Time Complexity: O(L) where L is the number of nodes in the linked list (two passes).
        # Space Complexity: O(1).
        # Example head = [1, 2, 3, 4, 5], n = 2
        brute_curr = head                  # brute_curr = [1, 2, 3, 4, 5] (pointer to traverse for length)
        brute_len = 0                      # brute_len = 0 (stores total length)
        while brute_curr is not None:      # Condition: Iteration 1: not None (True) | ... | Iteration 6: None (False)
            brute_len += 1                 # Iteration 1: brute_len = 1 | Iteration 2: brute_len = 2 | Iteration 3: brute_len = 3 | Iteration 4: brute_len = 4 | Iteration 5: brute_len = 5
            brute_curr = brute_curr.next   # Iteration 1: brute_curr = [2, 3, 4, 5] | ... | Iteration 5: brute_curr = None
        brute_target = brute_len - n       # brute_target = 5 - 2 = 3 (index from start, 0-indexed)
        if brute_target == 0:              # brute_target == 0 (3 == 0 -> False)
            return head.next
        brute_prev = None                  # brute_prev = None (tracks node before target)
        brute_curr = head                  # brute_curr = [1, 2, 3, 4, 5] (reset to head)
        for i in range(brute_target):      # i = 0, 1, 2... traversing to target
            brute_prev = brute_curr        # Iteration 1: brute_prev = [1, 2, 3, 4, 5] | Iteration 2: brute_prev = [2, 3, 4, 5] | Iteration 3: brute_prev = [3, 4, 5]
            brute_curr = brute_curr.next   # Iteration 1: brute_curr = [2, 3, 4, 5] | Iteration 2: brute_curr = [3, 4, 5] | Iteration 3: brute_curr = [4, 5]
        brute_prev.next = brute_curr.next  # links node before target to node after target: [3, 4, 5].next = [5], removing [4]
        # return head                      # returns modified head [1, 2, 3, 5]

        # Optimal Approach:
        # Use two pointers (slow and fast) separated by n steps to remove the Nth node from the end in a single pass.
        # Time Complexity: O(L) where L is the number of nodes in the linked list.
        # Space Complexity: O(1).
        # Example head = [1, 2, 3, 4, 5], n = 2
        dummy = ListNode(0)                # dummy = 0 -> [1, 2, 3, 4, 5] (dummy node to handle edge cases like removing head)
        dummy.next = head                  # dummy.next points to actual head
        
        slow = dummy                       # slow = dummy (slow pointer starts at dummy)
        fast = dummy                       # fast = dummy (fast pointer starts at dummy)

        for i in range(n + 1):             # i = 0, 1, 2... advancing fast pointer by n + 1 steps
            fast = fast.next               # Iteration 0: fast = [1, 2, 3, 4, 5] | Iteration 1: fast = [2, 3, 4, 5] | Iteration 2: fast = [3, 4, 5]

        while fast is not None:            # Condition: Iteration 1: [3, 4, 5] is not None (True) | Iteration 2: [4, 5] is not None (True) | Iteration 3: [5] is not None (True) | Iteration 4: None is not None (False)
            slow = slow.next               # Iteration 1: slow = [1, 2, 3, 4, 5] | Iteration 2: slow = [2, 3, 4, 5] | Iteration 3: slow = [3, 4, 5]
            fast = fast.next               # Iteration 1: fast = [4, 5] | Iteration 2: fast = [5] | Iteration 3: fast = None

        slow.next = slow.next.next         # slow.next = [3, 4, 5].next.next = [5] (bypasses node [4], removing it)
        return dummy.next                  # returns head of the modified list [1, 2, 3, 5]