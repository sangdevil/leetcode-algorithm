package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Cheapest_Flights_Within_K_Stops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {


        int[] cost = new int[n];

        for (int i = 0; i < n; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] tmp = Arrays.copyOf(cost, n);
            for (int j = 0; j < tmp.length; j++) {
                System.out.printf("from %d to %d : %d\n", src, j, tmp[j]);
            };
            for (int[] flightInfo : flights) {
                int from = flightInfo[0];
                int to = flightInfo[1];
                int price = flightInfo[2];
//                System.out.printf("from %d to %d, cost: %d\n", from, to, cost);
                if (cost[from] != Integer.MAX_VALUE) {
                    tmp[to] = Math.min(cost[to], cost[from] + price);
                }
            }
            cost = tmp;
        }

        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[src];
    }
}
