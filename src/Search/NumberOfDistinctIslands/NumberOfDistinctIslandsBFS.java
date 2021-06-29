class Solution {
    final int WATER = 0, LAND = 1;
    int m, n;
    int baseRow, baseCol;
    int[][] grid;
    final int[][] DIRECTIONS = {{1,0}, {-1, 0}, {0, 1}, {0,-1}};
    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        Set<String> shapes = new HashSet<>();
        this.grid = grid;
        
        //Find each islands
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == WATER) continue;
                baseRow = row;
                baseCol = col;
                StringBuilder sb = new StringBuilder();
                bfs(row, col, sb);
                shapes.add(sb.toString());
            }
        }
        
        //return unique islands
        return shapes.size();
    }
    private void bfs(int row, int col, StringBuilder sb){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = WATER;
        
        //Perform BFS
        while(!queue.isEmpty()){
            //Get first position
            int[] curPos = queue.poll();
            sb.append(curPos[0] - baseRow);
            sb.append(curPos[1] - baseCol);
            //Add all its neighbors (all 4 directions)
            for(int[] direction : DIRECTIONS){
                int curRow = curPos[0] + direction[0];
                int curCol = curPos[1] + direction[1];
                if(validPosition(curRow, curCol)){
                    queue.add(new int[]{curRow, curCol});
                    grid[curRow][curCol] = WATER;
                }
            }
        }
    }
    private boolean validPosition(int row, int col){
        if(row < 0 || col < 0 || row == m || col == n) return false;
        
        if(grid[row][col] == WATER) return false;
        
        return true;
    }
}
