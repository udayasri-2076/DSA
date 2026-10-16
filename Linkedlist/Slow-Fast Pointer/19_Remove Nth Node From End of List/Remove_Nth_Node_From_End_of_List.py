class Solution:
    def removeNthFromEnd(self, head, n):
        # Brute Force Approach:
        # Count total nodes first, then traverse a second time to reach and delete the (L - n + 1)-th node.
        # Time Complexity: O(L) where L is the length of the linked list.
        # Space Complexity: O(1).
        # Example head: [1, 2, 3, 4, 5], n = 2
        brute_curr = head                 # brute_curr = [1, 2, 3, 4, 5] (pointer for counting length)
        brute_len = 0                     # brute_len = 0 (total node count)
        while brute_curr is not None:     # Condition: Iteration 1: [1..5] is not None (True) | Iteration 2: [2..5] is not None (True) | Iteration 3: [3..5] is not None (True) | Iteration 4: [4..5] is not None (True) | Iteration 5: [5] is not None (True) | Iteration 6: None is not None (False)
            brute_len += 1                # Iteration 1: brute_len = 1 | Iteration 2: brute_len = 2 | Iteration 3: brute_len = 3 | Iteration 4: brute_len = 4 | Iteration 5: brute_len = 5
            brute_curr = brute_curr.next  # Iteration 1: brute_curr = [2, 3, 4, 5] | Iteration 2: brute_curr = [3, 4, 5] | Iteration 3: brute_curr = [4, 5] | Iteration 4: brute_curr = [5] | Iteration 5: brute_curr = None
        brute_target = brute_len - n      # brute_target = 5 - 2 = 3 (index from start, 0-indexed, before the node to remove)
        if brute_target == 0:             # brute_target == 0 (3 == 0 -> False)
            return head.next
        brute_prev = head                 # brute_prev = [1, 2, 3, 4, 5]
        for i in range(brute_target - 1): # i = 0, 1... traversing to node before target
            brute_prev = brute_prev.next  # Iteration 1: brute_prev = [2, 3, 4, 5] | Iteration 2: brute_prev = [3, 4, 5]
        brute_prev.next = brute_prev.next.next # brute_prev.next updated to skip node 4, list becomes [1, 2, 3, 5]
        # return head # returns head after brute force deletion

        # Optimal Approach:
        # Use a dummy node and a two-pointer (slow and fast) approach with a gap of n nodes to remove the Nth node in one pass.
        # Time Complexity: O(L)
        # Space Complexity: O(1)

        # Example head: [1, 2, 3, 4, 5], n = 2
        dummy = ListNode(0)               # dummy = 0 -> [1, 2, 3, 4, 5]
        dummy.next = head                 # dummy.next points to head

        slow = dummy                      # slow = dummy (starts at dummy)
        fast = dummy                      # fast = dummy (starts at dummy)

        for i in range(n + 1):            # i = 0, 1, 2... advancing fast pointer by n + 1 steps
            fast = fast.next              # Iteration 1: fast = [1, 2, 3, 4, 5] | Iteration 2: fast = [2, 3, 4, 5] | Iteration 3: fast = [3, 4, 5]

        while fast is not None:           # Condition: Iteration 1: [3, 4, 5] is not None (True) | Iteration 2: [4, 5] is not None (True) | Iteration 3: [5] is not None (True) | Iteration 4: None is not None (False)
            slow = slow.next              # Iteration 1: slow = [1, 2, 3, 4, 5] | Iteration 2: slow = [2, 3, 4, 5] | Iteration 3: slow = [3, 4, 5]
            fast = fast.next              # Iteration 1: fast = [4, 5] | Iteration 2: fast = [5] | Iteration 3: fast = None

        slow.next = slow.next.next        # slow.next updated to skip node 4, list becomes [1, 2, 3, 5]
        return dummy.next                 # returns updated head starting at dummy.next ([1, 2, 3, 5])