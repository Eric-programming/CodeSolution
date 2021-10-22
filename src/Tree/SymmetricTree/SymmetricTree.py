class Solution:
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        
        def dfs(left: Optional[TreeNode], right: Optional[TreeNode]):
            if left is None and right is None:
                return True
            
            if left is None or right is None:
                return False
            
            if left.val != right.val:
                return False
            
            return dfs(left.left, right.right) and dfs(left.right, right.left)
        
        return dfs(root.left, root.right)
