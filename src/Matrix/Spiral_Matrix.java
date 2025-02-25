package Matrix;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirNum = 0;
        int x = 0;
        int y = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int index = 0;
        List<Integer> list = new ArrayList<Integer>();
        while (index < size) {
            list.add(matrix[y][x]);
            matrix[y][x] = 101;
            x += direction[dirNum][0];
            y += direction[dirNum][1];
            if (x < 0 || x > n - 1 || y < 0 || y > m - 1 || matrix[y][x] == 101) {
                x -= direction[dirNum][0];
                y -= direction[dirNum][1];
                dirNum = dirNum == 3 ? 0 : dirNum + 1;
                x += direction[dirNum][0];
                x += direction[dirNum][1];
            }
            index++;

        }
        return list;
    }
}
