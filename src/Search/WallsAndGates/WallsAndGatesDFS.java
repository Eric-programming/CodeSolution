class Solution {
    final int WALL = -1;
    final int GATE = 0;
    final int ROOM = Integer.MAX_VALUE;
    int[][] arr;
    public void wallsAndGates(int[][] rooms) {
        arr = rooms;
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == GATE){
                    dfs(i, j, 0);
                }
            }
        }
    }
    private void dfs(int rows, int cols, int distance){
        //rows is out bound
        if(rows < 0 || rows >= arr.length) return;
        if(cols < 0 || cols >= arr[0].length) return;
        //if cur distance is smaller than distance
        if(arr[rows][cols] < distance) return;
        arr[rows][cols] = distance;
        dfs(rows + 1, cols, distance + 1);
        dfs(rows - 1, cols, distance + 1);
        dfs(rows, cols + 1, distance + 1);
        dfs(rows, cols - 1, distance + 1);
    }
}
