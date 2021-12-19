class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Build the graph table
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] time : times){
            int src = time[0], tar = time[1], weight = time[2];
            if(!graph.containsKey(src)){
                graph.put(src, new LinkedList<int[]>());
            }
            graph.get(src).add(new int[]{tar, weight});
        }
        //Define min heap
        Queue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1] - b[1]);
        
        //Define a hashset to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();
        
        minHeap.add(new int[]{k, 0});
        
        int res = 0;
        
        //Perform BFS
        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int src = top[0], srcWeight = top[1];
            if(visited.contains(src)) continue;
            res = srcWeight;
            visited.add(src);
            if(!graph.containsKey(src)) continue;
            for(int[] edge : graph.get(src)){
                int tar = edge[0], tarWeight = edge[1];
                minHeap.add(new int[]{tar, srcWeight + tarWeight });
            }
        }
        return visited.size() == n ? res : -1;
    }
}
