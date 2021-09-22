"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Node') -> 'Node':
        cur_node = root

        while cur_node is not None:
            dummy = Node()
            temp = dummy

            while cur_node is not None:
                if cur_node.left is not None:
                    temp.next = cur_node.left
                    temp = cur_node.left

                if cur_node.right is not None:
                    temp.next = cur_node.right
                    temp = cur_node.right

                cur_node = cur_node.next

            cur_node = dummy.next

        return root
