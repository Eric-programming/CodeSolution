class Solution_Bottle_up {
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        for(int row = N - 2; row >= 0; row--){
            List<Integer> curRow = triangle.get(row);
            List<Integer> prevRow = triangle.get(row + 1);
            for(int col = 0; col < row + 1; col++){
                int downLeft = prevRow.get(col);
                int downRight = prevRow.get(col + 1);
                curRow.set(col, Math.min(downLeft, downRight) + curRow.get(col));
            }
        }
        return triangle.get(0).get(0);
    }
}
class Solution_Top_Down {
    List<List<Integer>> triangle;
    List<Map<Integer, Integer>> cache;
    
    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        //Define cache
        cache = new ArrayList<>();
        int N = triangle.size();
        for(int i = 0; i < N; i++){
            cache.add(new HashMap<>());
        }
        
        return helper(0, 0);
    }
    private int helper(int row, int col){
        int curVal = triangle.get(row).get(col);
        
        //Return current element if we are at the last row
        if(row == triangle.size() - 1) return curVal;
        
        Map<Integer, Integer> map = cache.get(row);
        
        //Check if we pre computed this column before
        if(map.containsKey(col)) return map.get(col);
        
        //Find the minimum path sum for next rows
        int path1 = helper(row + 1, col);
        int path2 = helper(row + 1, col + 1);
        
        //cache the computed result
        map.put(col, Math.min(path1, path2) + curVal);
        return map.get(col);
    }
}
