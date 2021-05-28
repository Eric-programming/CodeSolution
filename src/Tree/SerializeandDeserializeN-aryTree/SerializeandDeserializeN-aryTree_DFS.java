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
    //"1,2,x,3,6,x,7,11,14,x,"
    StringBuilder sb = new StringBuilder();
    public String serialize(Node root) {
        if(root == null) return X;
        encode(root);
        int size = sb.length();
        sb.deleteCharAt(size - 1);
        return sb.toString();
    }
    private void encode(Node root){
        //Add current node
        sb.append(root.val);
        sb.append(COMMA);
        //Traverse children
        List<Node> children = root.children;
        if(children.size() > 0){
            for(Node child : root.children){
                encode(child);
            }
        } 
        sb.append(X);
        sb.append(COMMA);  
    }
	String[] data_arr;
    int index = 0;
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        System.out.println(data);
        data_arr = data.split(COMMA);
        return decode();
    }
    private Node decode(){
        String curItem = data_arr[index++];
        if(curItem.equals(X)) return null;
        //Build the children 
        List<Node> children = new LinkedList<>();
        while(index < data_arr.length){
            Node child = decode();
            if(child != null){
                children.add(child);
            }else{
                break;
            }
        }
        //Build the current node
        Node root = new Node(Integer.parseInt(curItem), children);
        //return the current node
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
