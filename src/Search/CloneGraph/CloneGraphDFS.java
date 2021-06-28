/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        //Base case
        if(node == null) return null;
        if(map.containsKey(node)){
           return map.get(node); 
        }else{
            map.put(node, new Node(node.val));
        }
        Node newNode = map.get(node);
        
        List<Node> neighbors = node.neighbors;
        
        for(Node curNode : neighbors){
            Node newCurNode = cloneGraph(curNode);
            newNode.neighbors.add(newCurNode);
        }
        return newNode;
    }
}
