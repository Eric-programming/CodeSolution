# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:
    X: str = "X"
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        list = []
        
        def dfs(root):
            if root is None:
                list.append(Codec.X)
                return
            
            list.append(str(root.val))
            
            dfs(root.left)
            
            dfs(root.right)
            
        dfs(root)
        
        res = ",".join(list)
        
        return res

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        list = data.split(",")
        index = 0
        
        def dfs():
            nonlocal index
            
            if list[index] == Codec.X:
                index += 1
                return None

            root_val = int(list[index])
            root = TreeNode(val=root_val)
            
            index+=1
            
            root.left = dfs()
            root.right = dfs()
            return root
        
        return dfs()
            

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))
