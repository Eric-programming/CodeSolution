# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def constructFromPrePost(self, preorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        map = dict()
        for i in range(len(postorder)):
            map[postorder[i]] = i
            
        index = 0 # point to the index in preorder array
        
        def dfs(preIndex: int):
            nonlocal index
            if index == len(preorder):
                return None
            
            root_val = preorder[index]
            
            cur_postorder_index = map[root_val]
            
            if preIndex < cur_postorder_index:
                return None
            
            index += 1
            
            left = dfs(cur_postorder_index)
            right = dfs(cur_postorder_index)
            
            root = TreeNode(val=root_val, left=left, right=right)
            
            return root
            
            
        return dfs(len(postorder))
