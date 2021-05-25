class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    int[] preorder_arr;
    int[] inorder_arr;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Define variables
        preorder_arr = preorder;
        inorder_arr = inorder;
        //Define the table
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        //Pass the boundaries
        return dfs(0, inorder.length - 1);
    }
    private TreeNode dfs(int left, int right){
        int curVal = preorder_arr[index++];
        int curIdx = map.get(curVal);
        //Build current node
        TreeNode root = new TreeNode(curVal);
            
        //Build left subtree
        if(left < curIdx){
            root.left = dfs(left, curIdx - 1);
        }
        //Build right subtree
        if(curIdx < right){
            root.right = dfs(curIdx + 1, right);
        }
        //Return current root node
        return root;
    }
}
