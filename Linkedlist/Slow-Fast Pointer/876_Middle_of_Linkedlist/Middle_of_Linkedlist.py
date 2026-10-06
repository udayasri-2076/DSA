class Solution:
    def middleNode(self, head):
        # Brute Force Approach:
        # Traverse the linked list completely to count the total number of nodes, then traverse again up to the middle index.
        # Time Complexity: O(n) where n is the number of nodes in the linked list.
        # Space Complexity: O(1).
        # Example head: [1, 2, 3, 4, 5]
        brute_curr = head  # brute_curr = node 1 (pointer to traverse and count nodes)
        brute_count = 0    # brute_count = 0 (stores total number of nodes)
        while brute_curr is not None:  # Condition: Iteration 1: node 1 is not None (True) | Iteration 2: node 2 is not None (True) | Iteration 3: node 3 is not None (True) | Iteration 4: node 4 is not None (True) | Iteration 5: node 5 is not None (True) | Iteration 6: None is not None (False)
            brute_count += 1  # Iteration 1: brute_count = 0 + 1 = 1 | Iteration 2: brute_count = 1 + 1 = 2 | Iteration 3: brute_count = 2 + 1 = 3 | Iteration 4: brute_count = 3 + 1 = 4 | Iteration 5: brute_count = 4 + 1 = 5
            brute_curr = brute_curr.next  # Iteration 1: brute_curr = node 2 | Iteration 2: brute_curr = node 3 | Iteration 3: brute_curr = node 4 | Iteration 4: brute_curr = node 5 | Iteration 5: brute_curr = None
        brute_mid_index = brute_count // 2  # brute_mid_index = 5 // 2 = 2 (middle index to reach)
        brute_curr = head  # brute_curr = node 1 (reset pointer to head)
        for i in range(brute_mid_index):  # i = 0, 1... looping until reaching middle index 2
            brute_curr = brute_curr.next  # Iteration 1: brute_curr = node 2 | Iteration 2: brute_curr = node 3
        return brute_curr  # returns node 3 as the middle node
        # return None

        # Optimal Approach:
        # Use slow and fast pointers where fast moves twice as fast as slow, reaching the end when slow hits the middle.
        # Time Complexity: O(n)
        # Space Complexity: O(1)

        # Example head: [1, 2, 3, 4, 5]
        slow = head        # slow = node 1 (slow pointer starts at head)
        fast = head        # fast = node 1 (fast pointer starts at head)

        while fast is not None and fast.next is not None:  # Condition: Iteration 1: node 1 is not None and node 2 is not None (True) | Iteration 2: node 3 is not None and node 4 is not None (True) | Iteration 3: node 5 is not None and node 5.next is None (False)
            slow = slow.next  # Iteration 1: slow = node 2 | Iteration 2: slow = node 3
            fast = fast.next.next  # Iteration 1: fast = node 3 | Iteration 2: fast = None

        return slow        # returns slow pointing to node 3
