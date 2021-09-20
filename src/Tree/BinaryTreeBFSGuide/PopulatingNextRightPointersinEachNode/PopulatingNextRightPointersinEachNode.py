from collections import deque

class Solution:
    def connect(self, root: 'Node') -> 'Node':
    
        if root is None:
            return root
        
        queue = deque([root])
        
        while len(queue) != 0:
            size = len(queue)
            
            dummy = Node()
            pre = dummy
            
            for idx in range(size):
                cur = queue.popleft()
                pre.next = cur
                pre = cur
                
                if cur.left is not None:
                    queue.append(cur.left)
                if cur.right is not None:
                    queue.append(cur.right)
        
        return root
