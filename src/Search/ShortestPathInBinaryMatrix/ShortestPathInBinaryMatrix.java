class Solution {
    final int[][] DIRECTIONS = {{1,1}, {1,0}, {1,-1}, {0, 1}, {0, 0}, {0,-1}, {-1, 1}, {-1, 0}, {-1, -1}};
    int[][] grid;
    boolean[][] visited;
    public int shortestPathBinaryMatrix(int[][] grid) {
        //Base Case
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        
        visited = new boolean[n][n];
        this.grid = grid;
        int level = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        
        //Perform BFS
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] curPos = queue.poll();
                int row = curPos[0], col = curPos[1];
                //Check if current position is bottom right
                if(row == n - 1 && col == n - 1) return level;
                
                //Add neighbor cells on to the queue
                addNeighborCells(row, col, queue);
            }
            level++;
        }
        return -1;
    }
    private void addNeighborCells(int row, int col, Queue<int[]> queue){
        int n = grid.length;
        for(int[] direction : DIRECTIONS){
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            //Make sure not out of bound
            if(newRow < 0 || newRow == n || newCol == n || newCol < 0) continue;
            //Make sure it's not visitied
            if(visited[newRow][newCol]) continue;
            //Make sure it's not 1
            if(grid[newRow][newCol] == 1) continue;
            
            visited[newRow][newCol] = true;
            
            queue.add(new int[]{newRow, newCol});
        }
    }
}
