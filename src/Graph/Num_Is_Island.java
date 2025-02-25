package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num_Is_Island {

    public static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public void bfs(char[][] grid, boolean[][] visited, Queue<int[]> queue) {
        int m = grid.length;
        int n = grid[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            System.out.printf("current : %d, %d\n", cur[0], cur[1]);
            for (int[] d : dir) {
                int nextX = cur[0] + d[0];
                int nextY = cur[1] + d[1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextY][nextX] && grid[nextY][nextX] == '1') {
                    System.out.printf("added : %d, %d\n", nextX, nextY);
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    System.out.printf("bfs for %d, %d\n", j, i);
                    queue.offer(new int[]{j, i});
                    bfs(grid, visited, queue);
                    count++;
                }
            }
        }


        return count;

    }
}
