/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    final String X = "X";
    final String COMMA = ",";
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return X;
        
        //BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        
        //Sb
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node cur = queue.poll();
                if(cur == null){
                    sb.append(X);
                    sb.append(COMMA);
                    break;
                }
                //Add children to the queue
                for(Node child: cur.children){
                    queue.add(child);
                }
                queue.add(null);
                //Append current node's value to the sb
                sb.append(cur.val);
                sb.append(COMMA);
            }
        }
        int size = sb.length();
        sb.deleteCharAt(size - 1);
        return sb.toString();
    }
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        String[] data_arr = data.split(COMMA);
        if(data_arr[0].equals(X)) return null;
        Node root = new Node(Integer.parseInt(data_arr[0]));
        //BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 2;
        while(i < data_arr.length){
            //Take the first element out
            Node first = queue.poll();
            
            //Add chilren and next level
            List<Node> children = new LinkedList<>();
            while(!data_arr[i].equals(X)){
                Node child = new Node(Integer.parseInt(data_arr[i++]));
                children.add(child);
                queue.add(child);
            }
            i++;
            first.children = children;
        }
 
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
