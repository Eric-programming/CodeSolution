from collections import deque
class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        res = []
        
        if root is None:
            return res
        
        queue = deque([root])
        
        while len(queue) != 0:
            size = len(queue)
            
            total = 0
            
            for idx in range(size):
                cur_node = queue.popleft()
                
                total += cur_node.val
                
                if cur_node.left is not None:
                    queue.append(cur_node.left)
                
                if cur_node.right is not None:
                    queue.append(cur_node.right)
                
            res.append(float(total / float(size * 1.0)))
            
        return res
