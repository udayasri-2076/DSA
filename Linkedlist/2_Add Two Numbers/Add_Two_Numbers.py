class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(0)            # dummy node to easily return head of result list
        curr = dummy                   # curr pointer tracks current node in result list, starts at dummy
        carry = 0                      # carry initialized to 0 for addition overflow

        # Loop runs as long as there are digits in l1, l2, or a remaining carry
        while l1 is not None or l2 is not None or carry != 0:
            sum_val = carry            # sum_val starts with the carry from previous addition

            if l1 is not None:
                sum_val += l1.val      # add value from l1: e.g., l1.val = 2, sum_val = 2
                l1 = l1.next           # move l1 pointer to next node

            if l2 is not None:
                sum_val += l2.val      # add value from l2: e.g., l2.val = 5, sum_val = 7
                l2 = l2.next           # move l2 pointer to next node

            carry = sum_val // 10      # calculate new carry: e.g., 7 // 10 = 0
            curr.next = ListNode(sum_val % 10) # create new node with digit value: 7 % 10 = 7
            curr = curr.next           # move curr pointer forward to the new node

        return dummy.next              # return head of the actual result list, skipping dummy