# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        max_path_sum = -1001
        
        def dfs(root):
            if root is None:
                return 0
            
            left_path = dfs(root.left)
            right_path = dfs(root.right)
            
            cur_max_path_sum = root.val
            
            if 0 < left_path:
                cur_max_path_sum += left_path
            
            if 0 < right_path:
                cur_max_path_sum += right_path
            
            nonlocal max_path_sum
            max_path_sum = max(max_path_sum, cur_max_path_sum)
            
            return max(left_path + root.val, right_path + root.val, root.val) 
        
        dfs(root)
        
        return max_path_sum
            
