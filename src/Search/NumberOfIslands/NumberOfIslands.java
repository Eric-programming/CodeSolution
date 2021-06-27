import java.util.*;

class Solution {
    final char WATER = '0';
    final char LAND = '1';
    int m, n;
    char[][] grid;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == LAND) {
                    res++;
                    exploreCurrentIsland(i, j);
                }
            }
        }
        return res;
    }

    private void exploreCurrentIsland(int i, int j) {
        // Base checking
        if (m == i || i < 0 || j < 0 || n == j)
            return;

        if (grid[i][j] == WATER)
            return;

        // Make current cell visited
        grid[i][j] = WATER;

        // search all 4 directions
        exploreCurrentIsland(i + 1, j);
        exploreCurrentIsland(i - 1, j);
        exploreCurrentIsland(i, j + 1);
        exploreCurrentIsland(i, j - 1);

    }

    public static void main(String[] args) {
        char[][] arr = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' } };
        Solution sl = new Solution();

        int res = sl.numIslands(arr);
        System.out.println(res);

    }
}
