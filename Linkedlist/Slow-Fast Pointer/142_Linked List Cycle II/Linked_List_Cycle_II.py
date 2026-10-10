class Solution:
    def detectCycle(self, head):
        # Brute Force Approach:
        # Store each visited node in a set. If we encounter a node already present in the set, a cycle exists and that node is the start.
        # Time Complexity: O(n) where n is the number of nodes in the linked list.
        # Space Complexity: O(n) for storing nodes in the set.
        # Example linked list: 3 -> 2 -> 0 -> -4, with tail pointing back to node with value 2 (index 1)
        brute_visited = set()  # brute_visited = set()
        brute_curr = head      # brute_curr = Node(3)
        brute_index = 0        # brute_index = 0
        while brute_curr is not None:  # Condition: Iteration 1: Node(3) is not None (True) | Iteration 2: Node(2) is not None (True) | Iteration 3: Node(0) is not None (True) | Iteration 4: Node(-4) is not None (True) | Iteration 5: Node(2) is not None (True)
            if brute_curr in brute_visited:  # Iteration 1: Node(3) in set (False) | Iteration 2: Node(2) in set (False) | Iteration 3: Node(0) in set (False) | Iteration 4: Node(-4) in set (False) | Iteration 5: Node(2) in set (True)
                return brute_curr  # Iteration 5: returns Node(2) as cycle start
            brute_visited.add(brute_curr)  # Iteration 1: added Node(3) | Iteration 2: added Node(2) | Iteration 3: added Node(0) | Iteration 4: added Node(-4)
            brute_curr = brute_curr.next   # Iteration 1: brute_curr = Node(2) | Iteration 2: brute_curr = Node(0) | Iteration 3: brute_curr = Node(-4) | Iteration 4: brute_curr = Node(2)
            brute_index += 1  # Iteration 1: brute_index = 1 | Iteration 2: brute_index = 2 | Iteration 3: brute_index = 3 | Iteration 4: brute_index = 4
        # return None  # returns None if loop completes without finding cycle

        # Optimal Approach:
        # Use Floyd's Cycle-Finding Algorithm with slow and fast pointers to detect the cycle, then reset slow to head to find the start.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example linked list: 3 -> 2 -> 0 -> -4, with tail pointing back to node with value 2 (index 1)
        slow = head  # slow = Node(3)
        fast = head  # fast = Node(3)

        while fast is not None and fast.next is not None:  # Condition: Iteration 1: Node(3) != None and Node(2) != None (True) | Iteration 2: Node(0) != None and Node(-4).next != None (True) | Iteration 3: Node(2) != None and Node(0) != None (True)
            slow = slow.next       # Iteration 1: slow = Node(2) | Iteration 2: slow = Node(0) | Iteration 3: slow = Node(-4)
            fast = fast.next.next  # Iteration 1: fast = Node(0) | Iteration 2: fast = Node(-4) | Iteration 3: fast = Node(-4)

            if slow == fast:       # Iteration 1: Node(2) == Node(0) (False) | Iteration 2: Node(0) == Node(-4) (False) | Iteration 3: Node(-4) == Node(-4) (True)
                slow = head        # Iteration 3: slow = Node(3)

                while slow != fast:  # Condition: Iteration 1: Node(3) != Node(-4) (True) | Iteration 2: Node(2) != Node(-4) (True)
                    slow = slow.next  # Iteration 1: slow = Node(2) | Iteration 2: slow = Node(0)
                    fast = fast.next  # Iteration 1: fast = Node(2) | Iteration 2: fast = Node(0)

                return slow        # returns Node(2)

        return None