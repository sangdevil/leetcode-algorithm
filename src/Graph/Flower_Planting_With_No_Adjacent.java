package Graph;

import java.util.Arrays;

public class Flower_Planting_With_No_Adjacent {



    public int[] gardenNoAdj(int n, int[][] paths) {

        int[] colors = new int[n + 1];
        int[][] adj = new int[n+1][3];

        for (int i = 0; i < n + 1; i++) {
            colors[i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            adj[i] = new int[]{0,0,0};
        }

        for (int[] path : paths) {
            int x = path[0];
            int y = path[1];
            for (int i = 0; i < 3; i++) {
                if (adj[x][i] == 0) {
                    adj[x][i] = y;
                    break;
                }
            }
            for (int i = 0; i < 3; i++) {
                if (adj[y][i] == 0) {
                    adj[y][i] = x;
                    break;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.printf("node %d has neighbors : %d, %d, %d\n", i, adj[i][0], adj[i][1], adj[i][2]);
        }

        for (int node = 1; node <= n; node++) {

            System.out.printf("current node : %d\n", node);
            // 0 for default, 1, 2, 3, 4 is color.
            boolean[] usedColors = new boolean[]{true, false, false, false, false};

            for (int neighbor : adj[node]) {
                System.out.printf("check neighbor %d's color : %d\n", neighbor, colors[neighbor]);
                // no more neighbors.
                if (neighbor == 0) break;
                usedColors[colors[neighbor]] = true;
            }
            for (int color = 1; color <= 4; color++) {
                if (!usedColors[color]) {
                    colors[node] = color;
                    break;
                }
            }
            System.out.printf("colored as %d\n", colors[node]);
        }

        return Arrays.copyOfRange(colors, 1, n+1);
    }



}
