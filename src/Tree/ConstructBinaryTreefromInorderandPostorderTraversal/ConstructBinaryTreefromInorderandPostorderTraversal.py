# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        #1. Store all the value by index on to map to achieve O(1) in time when retrive inorder element's index
        map = dict()
        for i in range(len(inorder)):
            map[inorder[i]] = i
        
        #2. perform dfs to find build the tree
        index = len(postorder) - 1
        
        def dfs(start: int, end: int):
            if end < start:
                return None
            
            nonlocal index
            root_val = postorder[index]
            index -= 1
            
            inorder_index = map[root_val]
            
            right_node = dfs(inorder_index + 1, end)
            left_node = dfs(start, inorder_index - 1)
            
            
            return TreeNode(val=root_val, left=left_node, right=right_node)
        
        return dfs(0, len(inorder) - 1)
            
        
