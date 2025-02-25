package Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Roatate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose
        for (int y = 0; y < n; y++) {
            for (int x = y; x < n; x++) {
                int tmp = matrix[y][x];
                matrix[y][x] = matrix[x][y];
                matrix[x][y] = tmp;
            }
        }

        // change elements horizontally
        for (int y = 0; y < n; y++) {
            for (int x =0; x < n / 2; x++) {
                int tmp = matrix[y][n - x - 1];
                matrix[y][n - x - 1] = matrix[y][x];
                matrix[y][x] = tmp;
            }
        }
    }
}
