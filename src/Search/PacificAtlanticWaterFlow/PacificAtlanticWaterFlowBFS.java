import java.util.*;

class Solution {
    int[][] heights;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        List<List<Integer>> res = new LinkedList<>();

        // Define Queue
        Queue<int[]> queue = new LinkedList<>();

        // Add coordinates from first row and first col to the queue
        int M = heights.length, N = heights[0].length;
        addRow(0, queue, N);
        addCol(0, queue, M);

        // return a visited table that BFS to visit coordinates in the queue
        boolean[][] pacificTable = BFS(queue, M, N);

        // Add coordinate from the last row and last col to the queue
        addRow(M - 1, queue, N);
        addCol(N - 1, queue, M);

        // return a visited table that BFS to visit coordinates in the queue
        boolean[][] atlanticTable = BFS(queue, M, N);

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

    private boolean[][] BFS(Queue<int[]> queue, int M, int N) {
        // Create a new table
        boolean[][] visited = new boolean[M][N];
        // BFS all 4 directions and make visited cell true in the table
        while (queue.isEmpty() == false) {
            int[] first = queue.poll();
            int row = first[0];
            int col = first[1];
            if (visited[row][col] == true)
                continue;
            visited[row][col] = true;
            int curCellVal = heights[row][col];
            // Top
            if (0 <= row - 1 && heights[row - 1][col] >= curCellVal && visited[row - 1][col] == false) {
                queue.add(new int[] { row - 1, col });
            }
            // Left
            if (0 <= col - 1 && heights[row][col - 1] >= curCellVal && visited[row][col - 1] == false) {
                queue.add(new int[] { row, col - 1 });
            }
            // Right
            if (col + 1 < N && heights[row][col + 1] >= curCellVal && visited[row][col + 1] == false) {
                queue.add(new int[] { row, col + 1 });
            }
            // Down
            if (row + 1 < M && heights[row + 1][col] >= curCellVal && visited[row + 1][col] == false) {
                queue.add(new int[] { row + 1, col });
            }
        }
        // return the table
        return visited;
    }

    private void addRow(int row, Queue<int[]> queue, int totalCols) {
        for (int i = 0; i < totalCols; i++) {
            int col = i;
            int[] coor = { row, col };
            queue.add(coor);
        }
    }

    private void addCol(int col, Queue<int[]> queue, int totalRows) {
        for (int i = 0; i < totalRows; i++) {
            int row = i;
            int[] coor = { row, col };
            queue.add(coor);
        }
    }
}
