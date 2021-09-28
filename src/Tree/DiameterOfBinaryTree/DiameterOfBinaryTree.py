# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        #Base case
        if root is None:
            return 0
        
        diameter = 0
        
        def dfs(root): 
            left_height = 0
            right_height = 0
            
            if root.left is not None:
                left_height = dfs(root.left) + 1
            
            if root.right is not None:
                right_height = dfs(root.right) + 1
        
            
            nonlocal diameter
            diameter = max(left_height + right_height, diameter)
            
            return max(left_height, right_height)
        
        dfs(root)
        
        return diameter
            
