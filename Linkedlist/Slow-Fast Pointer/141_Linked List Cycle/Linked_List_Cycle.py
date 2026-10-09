class Solution:
    def hasCycle(self, head):
        # Brute Force Approach:
        # Use a HashSet to store visited nodes and check if we encounter a node that is already in the set.
        # Time Complexity: O(n) where n is the number of nodes in the linked list.
        # Space Complexity: O(n) for storing nodes in the set.
        # Example linked list: 3 -> 2 -> 0 -> -4 (pointing back to 2)
        brute_set = set()      # brute_set initialized to track visited nodes
        brute_curr = head      # brute_curr = 3 (starting at head)
        while brute_curr is not None:  # Condition: Iteration 1: 3 is not None (True) | Iteration 2: 2 is not None (True) | Iteration 3: 0 is not None (True) | Iteration 4: -4 is not None (True) | Iteration 5: 2 is not None (True)
            if brute_curr in brute_set:  # Iteration 1: 3 in set (False) | Iteration 2: 2 in set (False) | Iteration 3: 0 in set (False) | Iteration 4: -4 in set (False) | Iteration 5: 2 in set (True)
                return True            # Iteration 5: returns True when cycle detected
            brute_set.add(brute_curr)  # Iteration 1: added 3 | Iteration 2: added 2 | Iteration 3: added 0 | Iteration 4: added -4
            brute_curr = brute_curr.next  # Iteration 1: brute_curr = 2 | Iteration 2: brute_curr = 0 | Iteration 3: brute_curr = -4 | Iteration 4: brute_curr = 2
        # return False  # returns False if loop completes and no cycle is found

        # Optimal Approach:
        # Use two pointers (slow and fast) moving at different speeds to detect a cycle.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example linked list: 3 -> 2 -> 0 -> -4 (pointing back to 2)
        slow = head  # slow = 3 (starting at head)
        fast = head  # fast = 3 (starting at head)

        while fast is not None and fast.next is not None:  # Condition: Iteration 1: 3 is not None and 3.next is not None (True) | Iteration 2: 0 is not None and 0.next is not None (True) | Iteration 3: 2 is not None and 2.next is not None (True)
            slow = slow.next  # Iteration 1: slow = 2 | Iteration 2: slow = 0 | Iteration 3: slow = -4
            fast = fast.next.next  # Iteration 1: fast = 0 | Iteration 2: fast = 2 | Iteration 3: fast = -4

            if slow == fast:  # Iteration 1: 2 == 0 (False) | Iteration 2: 0 == 2 (False) | Iteration 3: -4 == -4 (True)
                return True   # Iteration 3: returns True when slow meets fast

        return False