package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Pacific_Atlantic_Water_Flow
{
    public static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void dfs(int[][] heights, boolean[][] visited, int x, int y, int m, int n) {
        if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        System.out.printf("dfs for %d, %d\n", x, y);
        for (int[] d : dir) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX < 0 || nextX > m - 1 || nextY < 0 || nextY > n-1 || heights[x][y] <= heights[nextX][nextY]) {
                System.out.printf("next step for %d, %d\n", nextX, nextY);
                dfs(heights, visited, nextX, nextY, m, n);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtlantic = new boolean[m][n];
        for (int y = 0; y < n; y++) {
            dfs(heights, visitedPacific, 0, y, m, n);
            dfs(heights, visitedAtlantic, m - 1, y, m, n);
        }
        for (int x = 0; x < m; x++) {
            dfs(heights, visitedPacific, x, 0, m, n);
            dfs(heights, visitedAtlantic, x, n - 1, m, n);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (visitedPacific[x][y] && visitedAtlantic[x][y]) {
                    res.add(new ArrayList<>(List.of(x, y)));
                }
            }
        }
        return res;
    }
}
