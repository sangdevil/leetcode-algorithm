import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class Pacific_Atlantic_Water_Flow_Mine {

    public static HashMap<Integer, boolean[]> map;
    static {
        map = new HashMap<>();
    }

    public boolean[] dfs(int[][] heights, int x, int y, int m, int n) {
        // System.out.printf("dfs, x,y = %d,%d\n", x, y);

        if (x == -1 || y == -1) {
            return new boolean[]{true, false};
        }
        if (x == m || y == n) {
            return new boolean[]{false, true};
        }
        int key = m > n ? m * x + y : n * y + x;
        if (map.containsKey(key)) {
            // System.out.printf("map has %d, %d\n", x, y);

            return map.get(key);
        }
        map.put(key, new boolean[]{false, false});
        boolean[] up = new boolean[]{false, false};
        boolean[] left = new boolean[]{false, false};
        boolean[] down = new boolean[]{false, false};
        boolean[] right = new boolean[]{false, false};
        if (x == 0 || heights[x][y] >= heights[x - 1][y]) {
            up = dfs(heights,x - 1, y, m, n);
        }
        if (y == 0 || heights[x][y] >= heights[x][y - 1]) {
            left = dfs(heights, x, y - 1, m, n);
        }
        if (x == m-1 || heights[x][y] >= heights[x + 1][y]) {
            down = dfs(heights, x + 1, y, m, n);
        }
        if (y == n-1|| heights[x][y] >= heights[x][y + 1]) {
            right = dfs(heights, x, y + 1, m, n);
        }

        boolean[] canFlow = new boolean[]{up[0] | left[0] | down[0] | right[0], up[1] |  left[1] | down[1] | right[1]};
        map.put(key, canFlow);
        // System.out.printf("dfs completed for x,y = %d,%d : (%b,%b)\n", x, y, canFlow[0], canFlow[1]);
        return canFlow;
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                // System.out.printf("search for x,y = %d,%d\n", x, y);

                boolean[] canFlow = dfs(heights, x, y, m, n);
                if (canFlow[0] && canFlow[1]) {
                    res.add(new ArrayList<>(List.of(x, y)));
                }
                map = new HashMap<>();
            }
        }
        return res;
    }
}