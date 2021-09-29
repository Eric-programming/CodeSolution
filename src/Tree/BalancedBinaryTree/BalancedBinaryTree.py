# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    UNBALANCE = -1
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        
        def dfs(root):
            if root is None:
                return 0
            
            left_height = dfs(root.left)
            
            right_height = dfs(root.right)
            
            if left_height == self.UNBALANCE or right_height == self.UNBALANCE:
                return self.UNBALANCE
            
            if 1 < abs(left_height - right_height):
                return self.UNBALANCE
            
            return max(left_height, right_height) + 1
        
        return dfs(root) != self.UNBALANCE
