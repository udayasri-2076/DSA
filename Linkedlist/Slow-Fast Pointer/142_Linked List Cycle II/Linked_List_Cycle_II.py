class Solution:
    def detectCycle(self, head):
        # Brute Force Approach:
        # Use a set to store visited nodes, traversing the linked list and returning the first node already present in the set.
        # Time Complexity: O(n) where n is the number of nodes in the linked list.
        # Space Complexity: O(n) to store nodes in the set.
        # Example linked list: 3 -> 2 -> 0 -> -4, where -4 points back to 2 (pos = 1)
        brute_visited = set()  # brute_visited = set()
        brute_curr = head      # brute_curr = Node(3)
        while brute_curr is not None:  # Condition: Iteration 1: Node(3) is not None (True) | Iteration 2: Node(2) is not None (True) | Iteration 3: Node(0) is not None (True) | Iteration 4: Node(-4) is not None (True) | Iteration 5: Node(2) is not None (True)
            if brute_curr in brute_visited:  # Iteration 1: 3 in set (False) | Iteration 2: 2 in set (False) | Iteration 3: 0 in set (False) | Iteration 4: -4 in set (False) | Iteration 5: 2 in set (True)
                return brute_curr  # Iteration 5: returns Node(2)
            brute_visited.add(brute_curr)  # Iteration 1: set = {3} | Iteration 2: set = {3, 2} | Iteration 3: set = {3, 2, 0} | Iteration 4: set = {3, 2, 0, -4}
            brute_curr = brute_curr.next  # Iteration 1: brute_curr = Node(2) | Iteration 2: brute_curr = Node(0) | Iteration 3: brute_curr = Node(-4) | Iteration 4: brute_curr = Node(2)
        # return None  # returns None if loop completes without finding cycle

        # Optimal Approach:
        # Use Floyd's Cycle-Finding Algorithm with two pointers (slow and fast) moving at different speeds to detect the cycle and find its start.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example linked list: 3 -> 2 -> 0 -> -4, where -4 points back to 2 (pos = 1)
        slow = head  # slow = Node(3)
        fast = head  # fast = Node(3)

        while fast is not None and fast.next is not None:  # Condition: Iteration 1: Node(3) and Node(2) (True) | Iteration 2: Node(0) and Node(-4) (True) | Iteration 3: Node(2) and Node(0) (True)
            slow = slow.next  # Iteration 1: slow = Node(2) | Iteration 2: slow = Node(0) | Iteration 3: slow = Node(-4)
            fast = fast.next.next  # Iteration 1: fast = Node(0) | Iteration 2: fast = Node(2) | Iteration 3: fast = Node(-4)

            if slow == fast:  # Iteration 1: Node(2) == Node(0) (False) | Iteration 2: Node(0) == Node(2) (False) | Iteration 3: Node(-4) == Node(-4) (True)
                slow = head  # Iteration 3: slow = Node(3)

                while slow != fast:  # Condition: Iteration 1: Node(3) != Node(-4) (True) | Iteration 2: Node(2) != Node(-4) (True)
                    slow = slow.next  # Iteration 1: slow = Node(2) | Iteration 2: slow = Node(0)
                    fast = fast.next  # Iteration 1: fast = Node(2) | Iteration 2: fast = Node(-4)

                return slow  # Iteration 2: returns Node(2)

        return None