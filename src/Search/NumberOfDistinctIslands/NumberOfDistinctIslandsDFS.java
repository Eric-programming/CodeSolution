class Solution {
    final int WATER = 0, LAND = 1;
    int m, n;
    int baseRow, baseCol;
    int[][] grid;
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
                dfs(row, col, sb);
                shapes.add(sb.toString());
            }
        }
        
        //return unique islands
        return shapes.size();
    }
    private void dfs(int row, int col, StringBuilder sb){
        //Check out of bound
        if(row < 0 || col < 0 || row == m || col == n) return;
        
        //Check if WATER
        if(grid[row][col] == WATER) return;
        
        //Append current position onto sb
        sb.append(row - baseRow);
        sb.append(','); //Optional
        sb.append(col - baseCol);
        sb.append('|'); //Optional
        
        //Sink the island to mark it visited
        grid[row][col] = WATER;
        
        //Search top
        dfs(row - 1, col, sb);
        
        //Search right
        dfs(row, col + 1, sb);
        
        //Search left
        dfs(row, col - 1, sb);
        
        //Search down
        dfs(row + 1, col, sb);
        
    }
}
