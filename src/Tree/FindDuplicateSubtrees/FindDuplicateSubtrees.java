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
    //String for No Tree
    final String NT = "X";
    //Keep track of visited subtree string key
    Set<String> visited = new HashSet<>();
    //Keep track of duplicate subtree
    Map<String, TreeNode> res = new HashMap<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrderTraversal(root);
        return new LinkedList<>(res.values());
    }
    
    private String postOrderTraversal(TreeNode node){
        StringBuilder sb = new StringBuilder();
        String leftSubtree = NT, rightSubtree = NT;
        
        //Traverse the left
        if(node.left != null){
            leftSubtree = postOrderTraversal(node.left);
        }
         
        //Traverse the right
        if(node.right != null){
            rightSubtree = postOrderTraversal(node.right); 
        }
        
        //Deal with current Node
        sb.append(node.val);
        
        //Build the remaining nodes in the subtree
        sb.append(",");
        sb.append(leftSubtree);
        sb.append(",");
        sb.append(rightSubtree);

        String curSubtree = sb.toString();
        saveDuplicateSubtree(node, curSubtree);
        visited.add(curSubtree);
        return curSubtree;
    }
    private void saveDuplicateSubtree(TreeNode node, String key){
        if(visited.contains(key)){
            res.put(key, node);
        }
    }
}

/**
Important lesson when deal with tree problems:
1. Remember Tree Traversal
2. Serialize tree => string can be use as a key

**/
