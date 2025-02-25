package Matrix;

import java.util.HashSet;

public class Word_Search {

    public static int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public boolean dfs(char[][] board, boolean[][] visited, int x, int y, int depth, String word) {
        System.out.printf("x, y, depth : %d,%d,%d\n", x, y, depth);
        if (word.charAt(depth) != board[y][x])
            return false;
        if (depth == word.length() - 1)
            return true;
        visited[y][x] = true;
        for (int[] d : direction) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            if (nextX >= 0 && nextX < board[0].length && nextY >= 0 && nextY < board.length
                    && !visited[nextY][nextX] && depth < word.length() - 1) {
                if (dfs(board, visited, nextX, nextY, depth + 1, word))
                    return true;
            }
        }
        visited[y][x] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, visited, j, i, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
