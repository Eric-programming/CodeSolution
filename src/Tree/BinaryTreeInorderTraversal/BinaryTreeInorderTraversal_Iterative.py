class Solution:
    def inorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if root is None:
            return res
        
        cur_node = root
        stack = []
        
        while True:
            while cur_node is not None:
                stack.append(cur_node)
                cur_node = cur_node.left
            
            if len(stack) == 0:
                break
                
            cur_node = stack.pop()
            
            res.append(cur_node.val)
            
            cur_node = cur_node.right
        
        
        return res
