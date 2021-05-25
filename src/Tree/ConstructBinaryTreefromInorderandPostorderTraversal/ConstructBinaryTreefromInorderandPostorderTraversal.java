class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int index;
    int[] postorder_arr;
    int[] inorder_arr;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //Define variables
        postorder_arr = postorder;
        inorder_arr = inorder;
        
        int n = postorder.length;
        //Define the table
        for(int i = 0; i < n; i++){
            map.put(inorder[i], i);
        }
        index = n - 1;
        //Pass the boundaries
        return dfs(0, n - 1);
    }
    private TreeNode dfs(int left, int right){
        int curVal = postorder_arr[index--];
        int curIdx = map.get(curVal);
        //Build current node
        TreeNode root = new TreeNode(curVal);

        //Build right subtree
        if(curIdx < right){
            root.right = dfs(curIdx + 1, right);
        }
        //Build left subtree
        if(left < curIdx){
            root.left = dfs(left, curIdx - 1);
        }
        //Return current root node
        return root;
    }
}
