/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] pre_arr;
    int[] post_arr;
    Map<Integer, Integer> map = new HashMap<>();
    int index = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        //Build the table
        pre_arr = pre;
        post_arr = post;
        for(int i = 0; i < post.length; i++){
            map.put(post[i], i);
        }
        return dfs(pre.length);
    }
    private TreeNode dfs(int preIdx){
        if(index >= pre_arr.length) return null;
        int curVal = pre_arr[index];
        int curIdx = map.get(curVal);
        if(preIdx < curIdx) return null;
        index++;
        TreeNode root = new TreeNode(curVal);
        root.left = dfs(curIdx);
        root.right = dfs(curIdx);
        return root;
    }
}
