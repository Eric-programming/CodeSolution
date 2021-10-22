from collections import deque
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        
        if root is None:
            return res
        
        queue = deque([root])
        
        is_left_to_right = True
        
        while len(queue) != 0:
            size = len(queue)
            
            level_list = []
            
            for idx in range(size):
                cur_node = queue.popleft()
                
                if is_left_to_right:
                    level_list.append(cur_node.val)
                else:
                    level_list.insert(0, cur_node.val)
                
                if cur_node.left is not None:
                    queue.append(cur_node.left)
                
                if cur_node.right is not None:
                    queue.append(cur_node.right)
            
            is_left_to_right = not is_left_to_right
            
            res.append(level_list)
        
        return res
