package DP;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Coin_Change_BFS {
    class Pair {
        public int a;
        public int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(amount, 0));
        boolean[] hasVisited = new boolean[amount + 1];
        Arrays.fill(hasVisited, false);
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
//            System.out.println(String.format("current : %s", current));
            for (int coin : coins) {
                int possible = current.a - coin;
                if (possible == 0) {
//                    System.out.println(String.format("ret : %s", ret));
                    return current.b + 1;
                } else {
                    if (possible > 0 && !hasVisited[possible]) {
                        queue.add(new Pair(possible, current.b + 1));
                        hasVisited[possible] = true;
                    }
                }
            }

        }

        return -1;
    }

}
