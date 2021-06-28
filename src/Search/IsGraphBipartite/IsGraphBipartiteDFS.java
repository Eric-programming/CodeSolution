class Solution {
    Boolean[] color;
    final boolean RED = true;
    final boolean GREEN = false;
    int[][] graph;

    public boolean isBipartite(int[][] graph) {
        this.graph = graph;
        int n = graph.length;
        color = new Boolean[n];
        for(int i = 0; i < n; i++){
            if(color[i] == null){
                color[i] = RED;
                if(!dfs(i)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node) {
        int[] list = graph[node];
        for (int curNode : list) {
            if (color[curNode] == null) {
                color[curNode] = !color[node];
                if(!dfs(curNode)) return false;
            } else if (color[curNode] == color[node]) {
                return false;
            }
        }
        return true;
    }
}
