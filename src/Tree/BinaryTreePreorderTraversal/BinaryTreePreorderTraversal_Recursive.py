class Solution:
    def preorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        list: List[int] = []

        def dfs(node: Optional[TreeNode]):
            if node is None:
                return
            list.append(node.val)
            dfs(node.left)
            dfs(node.right)

        dfs(root)

        return list
