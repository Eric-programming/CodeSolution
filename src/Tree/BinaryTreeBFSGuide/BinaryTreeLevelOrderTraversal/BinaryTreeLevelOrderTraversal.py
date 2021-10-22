from collections import deque

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        
        if root is None:
            return res
        
        queue = deque([root])
        
        while len(queue) != 0:
            
            level_size = len(queue)
            
            level_list = []
            
            for idx in range(level_size):
                cur_node = queue.popleft()
                
                level_list.append(cur_node.val)
                
                if cur_node.left is not None:
                    queue.append(cur_node.left)
                    
                if cur_node.right is not None:
                    queue.append(cur_node.right)
                
            res.append(level_list)
                
        return res
                
