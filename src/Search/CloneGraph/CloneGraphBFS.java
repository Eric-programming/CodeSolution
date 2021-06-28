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
    Map<Node, Node> table = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        //Base case
        if(node == null) return null;
        //Define a queue
        Queue<Node> queue = new LinkedList<>();
        
        //Define a visited set to keep track visited nodes
        
        Set<Node> visited = new HashSet<>();
        
        //Add current node to the queue
        
        queue.add(node);
        
        //BFS
        while(!queue.isEmpty()){
            //Take the first from queue
            Node first = queue.poll();
            
            if(visited.contains(first)) continue;
            
            //Mark this node as visited
            visited.add(first);
            
            //If this node is not create in the table, create it
            Node newFirst = getNewNode(first);
            
            List<Node> neighbors = first.neighbors;
            //Iterate all the connect nodes from this node
            for(Node cur : neighbors){
                //For each node, if not created, then create it in the table
                Node newCurNode = getNewNode(cur);
                
                newFirst.neighbors.add(newCurNode);
                
                //If this node is not visited, add to the queue
                if(!visited.contains(cur)){
                    queue.add(cur);
                }
            }
        }
        return table.get(node);
    }
    private Node getNewNode(Node node){
        if(table.containsKey(node)) return table.get(node);
        int val = node.val;
        Node newNode = new Node(val);
        table.put(node, newNode);
        return newNode;
    }
}
