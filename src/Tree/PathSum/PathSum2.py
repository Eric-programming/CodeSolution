# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        res = []
        
        def dfs(root, cur_list, cur_sum):
            if root is None:
                return
            
            cur_sum += root.val
            cur_list.append(root.val)
            
            if root.left is None and root.right is None and cur_sum == targetSum:
                res.append(list(cur_list))
            else:
                dfs(root.left, cur_list, cur_sum)
                dfs(root.right, cur_list, cur_sum)
            
            cur_list.pop()
            
        dfs(root, [], 0)
        
        return res
            
