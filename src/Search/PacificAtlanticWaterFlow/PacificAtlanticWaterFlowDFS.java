class Solution {
    int[][] heights;
    int M;
    int N;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        List<List<Integer>> res = new LinkedList<>();

        // DFS First row and first col
        this.M = heights.length;
        this.N = heights[0].length;
        boolean[][] pacificTable = new boolean[M][N];
        iterateRow(0, pacificTable);
        iterateCol(0, pacificTable);

        // DFS Last Row and last col
        boolean[][] atlanticTable = new boolean[M][N];
        iterateRow(M - 1, atlanticTable);
        iterateCol(N - 1, atlanticTable);

        // add coordinates that are both visited from two tables to the res list
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (atlanticTable[i][j] == true && pacificTable[i][j] == true) {
                    res.add(Arrays.asList(new Integer[] { i, j }));
                }
            }
        }
        // return the res list
        return res;
    }

    private void DFS(int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        int curCellVal = heights[row][col];

        // Top
        if (0 <= row - 1 && heights[row - 1][col] >= curCellVal && visited[row - 1][col] == false) {
            DFS(row - 1, col, visited);
        }
        // Left
        if (0 <= col - 1 && heights[row][col - 1] >= curCellVal && visited[row][col - 1] == false) {
            DFS(row, col - 1, visited);
        }
        // Right
        if (col + 1 < N && heights[row][col + 1] >= curCellVal && visited[row][col + 1] == false) {
            DFS(row, col + 1, visited);
        }
        // Down
        if (row + 1 < M && heights[row + 1][col] >= curCellVal && visited[row + 1][col] == false) {
            DFS(row + 1, col, visited);
        }
    }

    private void iterateRow(int row, boolean[][] visited) {
        int totalCols = N;
        for (int i = 0; i < totalCols; i++) {
            int col = i;
            DFS(row, col, visited);
        }
    }

    private void iterateCol(int col, boolean[][] visited) {
        int totalRows = M;
        for (int i = 0; i < totalRows; i++) {
            int row = i;
            DFS(row, col, visited);
        }
    }
}
