class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges){
            if(!uf.union(edge[0], edge[1])) return false;
        }
        return uf.numOfComponets == 1;
    }
}

/**
 * UnionFind
 */
public class UnionFind {
    private int[] parents;
    private int[] size;
    int numOfComponets = 0;

    public UnionFind(int n) {
        parents = new int[n];
        size = new int[n];
        numOfComponets = n;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int cur) {
        int root = cur;
        while (root != parents[root]) {
            root = parents[root];
        }
        // Path Compression
        while (cur != root) {
            int preParent = parents[cur];
            parents[cur] = root;
            cur = preParent;
        }
        return root;
    }

    public int findComponentSize(int cur) {
        int parent = find(cur);
        return size[parent];
    }

    public boolean union(int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);

        if (node1Parent == node2Parent)
            return false;

        if (size[node1Parent] > size[node2Parent]) {
            parents[node2Parent] = node1Parent;
            size[node1Parent] += size[node2Parent];
        } else {
            parents[node1Parent] = node2Parent;
            size[node2Parent] += size[node1Parent];
        }
        numOfComponets--;
        return true;
    }
}
