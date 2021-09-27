class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        # 1. Save each inorder element's value and index onto map
        map = dict()

        for i in range(len(inorder)):
            map[inorder[i]] = i

        # 2. perform dfs to build tree
        idx = 0

        def dfs(start: int, end: int):
            # base check
            if end < start:
                return None
            
            nonlocal idx
            root_val = preorder[idx]
            idx += 1

            inorder_index = map[root_val]

            left_node = dfs(start, inorder_index - 1)
            right_node = dfs(inorder_index + 1, end)

            root = TreeNode(val=root_val, left=left_node, right=right_node)

            return root

        return dfs(0, len(inorder) - 1)
