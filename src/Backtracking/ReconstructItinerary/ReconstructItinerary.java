class Solution {
    Map<String, List<String>> graph = new HashMap<>();
    List<String> path = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        //Create the graph lexical order
        for(List<String> ticket : tickets){
            String start = ticket.get(0);
            String end = ticket.get(1);
            if(!graph.containsKey(start)){
                graph.put(start, new LinkedList<>());
            }
            if(!graph.containsKey(end)){
                graph.put(end, new LinkedList<>());
            }
            graph.get(start).add(end);
        }
        
        for(String key: graph.keySet()){
            Collections.sort(graph.get(key));
        }
        
        //Find itinerary path
        String start = "JFK";
        findItinerary(start, tickets.size());
        return path;
    }
    private boolean findItinerary(String start, int edgesCount){
        List<String> list = graph.get(start);
        path.add(start);
        //Base Case
        if(list.size() == 0){
            if(edgesCount == 0) return true;
            return false;
        }       
        
        for(int i = 0; i < list.size(); i++){
            String top = list.remove(i);
            if(findItinerary(top, edgesCount - 1)) return true;
            list.add(i, top);
            path.remove(path.size() - 1);
        }
        return false;
    }
}
