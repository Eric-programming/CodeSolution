class Solution {
    int[][] grid;
    int id = -1;
    Map<Integer, Integer> map = new HashMap<>();
    int m, n;
    final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public int largestIsland(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        //Find the size of each island and assign an id
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 1){
                    int size = dfs(row, col);
                    map.put(id, size);
                    id--;//Update the id because id should be unique
                }
            }
        }
        
        //Find the max area by visit each 0
        int maxIsland = 0;
        
        for (int id: map.keySet()) maxIsland = Math.max(map.get(id), maxIsland);
        
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(grid[row][col] == 0){
                    int curMaxIsland = calculateMaxIsland(row, col);
                    maxIsland = Math.max(maxIsland, curMaxIsland);
                }
            }
        }
        return maxIsland;
    }
    private int dfs(int row, int col){
        //Base case
        if(row < 0 || row == m || col < 0 || col == n) return 0;
        
        if(grid[row][col] != 1) return 0;
        
        grid[row][col] = id;
        
        //dfs all 4 directions
        int down = dfs(row + 1, col);
        int top = dfs(row - 1, col);
        int right = dfs(row, col + 1);
        int left = dfs(row, col - 1);
        
        return down + top + right + left + 1;
    }
    private int calculateMaxIsland(int row, int col){
        Set<Integer> set = new HashSet<>();
        for(int[] direction : DIRECTIONS){
            int curRow = direction[0] + row;
            int curCol = direction[1] + col;
            if(curCol < 0 || curRow == m || curRow < 0 || curCol == n) continue;
            if(grid[curRow][curCol] == 0) continue;
            int curId = grid[curRow][curCol];
            set.add(curId);
        }
        int sum = 0;
        for(Integer curId : set){
            sum += map.get(curId);
        }
        return sum + 1;
    }
}
