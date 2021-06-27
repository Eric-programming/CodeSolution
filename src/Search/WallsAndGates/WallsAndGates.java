import java.util.*;

class Solution {
    private static final int ROOM = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n || rooms[nextRow][nextCol] != ROOM) {
                    continue;
                }
                rooms[nextRow][nextCol] = rooms[row][col] + 1;
                q.add(new int[] { nextRow, nextCol });
            }
        }
    }
}
