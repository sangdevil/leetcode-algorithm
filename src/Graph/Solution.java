package Graph;

import java.util.*;

class Solution {



    static int[] degree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];
        List<Integer> canTake = new ArrayList<>();
        degree = new int[numCourses];
        Arrays.fill(degree, 0);
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            int preCourse = prerequisite[1];
            int mainCourse = prerequisite[0];
            degree[mainCourse]++;
            adj[preCourse].add(mainCourse);
        }

//        for (List<Integer> integers : adj) {
//            String s = "";
//            for (int i : integers) {
//                s += String.valueOf(i);
//            }
//            System.out.println(s);
//        }


        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0){
                queue.add(i);
            }
        }

        System.out.println(queue.size());

        while (queue.size() > 0) {
            int cur = queue.poll();
//            System.out.println(String.format("cur : %d", cur));
            canTake.add(cur);
            for (Integer n : adj[cur]) {
//                System.out.println(String.format("adj : %d", n));

                degree[n]--;
                if (degree[n] == 0) {
                    queue.add(n);
                }
            }

        }

//        System.out.println(String.format("canTake size : %d", canTake.size()));
        return canTake.size() == numCourses;

    }
}