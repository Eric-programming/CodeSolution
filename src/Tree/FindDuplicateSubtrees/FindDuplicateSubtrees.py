# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findDuplicateSubtrees(self, root: Optional[TreeNode]) -> List[Optional[TreeNode]]:
        map = dict()
        unique_keys = set()
        list = []
        
        def dfs(root):
            if root is None:
                return ["X"]
            
            left_sub = dfs(root.left)
            right_sub = dfs(root.right)
            
            root_tree: List[str] = [str(root.val)]
            root_tree += left_sub + right_sub #combine 2 lists to serialize the current subtree
            
            key = ",".join(root_tree)
            
            if key in map and key not in unique_keys:
                list.append(root)
                unique_keys.add(key)
            
            map[key] = root
            
            return root_tree
        
        dfs(root)
        
        return list
