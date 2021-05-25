public class Codec {
    final String X = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return X;
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    String[] arr;
    int index = 0;

    // 1,2,x,x,3,4,5,x,x,x,x
    public TreeNode deserialize(String data) {
        arr = data.split(",");
        return dfs();
    }

    private TreeNode dfs() {
        // base case
        if (arr[index].equals(X)) {
            index++;
            return null;
        }
        // deserialize the current value
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        // build our left subtree and return its root
        root.left = dfs();
        // build our right subtree and return its root
        root.right = dfs();
        return root;
    }
}
