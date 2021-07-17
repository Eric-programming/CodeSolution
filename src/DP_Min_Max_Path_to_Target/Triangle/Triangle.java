class Solution {
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
