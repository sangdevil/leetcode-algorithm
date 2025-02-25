package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course_Schedule {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] degree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            degree[pair[0]]++;
            adj[pair[1]].add(pair[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int canTake = 0;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.add(i);
                canTake++;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neighbor : adj[cur]) {
                degree[neighbor]--;
                if (degree[neighbor] == 0) {
                    queue.add(neighbor);
                    canTake++;
                }
            }
        }

        return canTake == numCourses;
    }
}
