class Solution:
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        
        if root is None:
            return res
        
        stack = []
        
        cur = root
        pre = None
        
        while cur is not None or len(stack) != 0:
            if cur is not None:
                stack.append(cur)
                cur = cur.left
            else:
                top = stack[-1] # peek the last element
                if top.right is None or top.right is pre:
                    res.append(top.val)
                    stack.pop()
                    pre = top
                    cur = None # Don't traverse the left again
                else:
                    cur = top.right #Ready to traverse the right subtree
                    
        return res
        
