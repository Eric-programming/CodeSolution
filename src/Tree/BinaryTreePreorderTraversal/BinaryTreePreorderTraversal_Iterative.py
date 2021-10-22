class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res: List[int] = []
        if root is None:
            return res
        stack = []
        
        stack.append(root)
        
        while len(stack) != 0:
            node: TreeNode = stack.pop()
            res.append(node.val)
            
            if node.right is not None:
                stack.append(node.right)
            
            if node.left is not None:
                stack.append(node.left)
        
        return res
