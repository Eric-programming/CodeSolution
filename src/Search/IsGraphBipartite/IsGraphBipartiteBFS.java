class Solution {
    int RED = 1;
    int GREEN = 2;
    int UN_VISITED = 0;
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        //Define a table
        int[] table = new int[N];
        
        //Define Queue
        Queue<Integer> queue = new LinkedList<>();
        
        
        for(int i = 0; i < N; i++){
            if(table[i] != UN_VISITED) continue;
            //Add first node to the queue
            queue.add(i);
            table[i] = GREEN;
            //BFS
            while(!queue.isEmpty()){
                //Take the first element
                Integer first = queue.poll();
                //Get neighbor nodes
                int[] connectNodes = graph[first];

                int curNodeColor = table[first];
                //Target nodes color must be different compare to the current node's color
                int targetNodeColor = curNodeColor == RED ? GREEN : RED;

                for(int node : connectNodes){
                    //If neighbor node has the same color as the current color then return false
                    if(table[node] == curNodeColor) return false;
                    
                    if(table[node] == UN_VISITED){
                        queue.add(node);
                        table[node] = targetNodeColor;
                    }
                }
            }
        }
        //return true if bi-graph
        return true;
    }
}
