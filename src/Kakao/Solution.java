package Kakao;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void backTrack(int n, int k, int start,
                                 List<Integer> temp, List<List<Integer>> result) {

        System.out.printf("backTrack %d, %d, %d called\n", n, k, start);
        StringBuilder sb = new StringBuilder();
        sb.append("currently, temp has: ");
        for (int x : temp) {
            sb.append(x);
            sb.append(", ");
        }
        System.out.println(sb);
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp)); // 깊은 복사하여 저장
            return;
        }

        for (int i = start; i < n; i++) {
            temp.add(i);
            backTrack(n, k, i + 1, temp, result);
            temp.remove(temp.size() - 1); // 백트래킹

        }
    }

    public static Map<Integer, Integer> mergeMap(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        Map<Integer, Integer> mergedMap = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()) {
                int k1 = entry1.getKey();
                int k2 = entry2.getKey();
                int v1 = entry1.getValue();
                int v2 = entry2.getValue();
                if (mergedMap.containsKey(k1 + k2)) {
                    mergedMap.put(k1 + k2, mergedMap.get(k1 + k2) + v1 * v2);
                } else {
                    mergedMap.put(k1 + k2, v1 * v2);
                }
            }
        }
        return mergedMap;
    }

    public static int countVictory(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {

        List<Integer> map2Keys = new ArrayList<>(map2.keySet());

        Collections.sort(map2Keys);

        int[] prefixSumed = new int[map2Keys.size()];
        int sum = 0;
        for (int i = 0; i < map2Keys.size(); i++) {
            sum += map2.get(map2Keys.get(i));
            prefixSumed[i] = sum;
        }

        for (int i = 0; i < prefixSumed.length; i++) {
            System.out.printf("%d, %d, %d\n", map2Keys.get(i), map2.get(map2Keys.get(i)), prefixSumed[i]);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            int k1 = entry1.getKey();
            int v1 = entry1.getValue();
            int index = Collections.binarySearch(map2Keys, k1);
            if (index < 0) {
                index = -index - 1;
            }
            int victoryCount = count;
            if (index > 0 && index < map2Keys.size()) {
                if (map2Keys.get(index) == k1) {
                    count += v1 * prefixSumed[index - 1];
                } else {
                    count += v1 * prefixSumed[index];
                }
            } else if (index == map2Keys.size()) {
                count += v1 * prefixSumed[index - 1];
            }
            System.out.printf("current key : %d, idx : %d, victory Count : %d\n", k1, index, count - victoryCount);

        }
        System.out.printf("total count : %d\n", count);

        return count;
    }


    public static Map<Integer, Integer> constructMap(int[] dice) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int x : dice) {
//            System.out.printf("%d,",x);
            if (map1.containsKey(x)) {
                map1.put(x, map1.get(x) + 1);
            } else {
                map1.put(x, 1);

            }
        }
//        System.out.println();

        return map1;

    }

    public static Map<Integer, Integer> constructMapFromP(Map<Integer, Integer> map1,
                                                          List<Integer> permutation,
                                                          int[][] dice) {

        int firstIndex = permutation.get(0);
        map1 = constructMap(dice[firstIndex]);
        for (int i = 1; i < permutation.size(); i++) {
            Map<Integer, Integer> mapNext = constructMap(dice[permutation.get(i)]);
            map1 = mergeMap(map1, mapNext);
        }

        return map1;

    }

    public static int[] solution(int[][] dice) {
        int n = dice.length;
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] used = new boolean[n];
        backTrack(n, n / 2, 0, new ArrayList<>(), permutations);

        List<Integer> maxPermutation = new ArrayList<>();
        int maxVictory = -1;
//        System.out.println("here?");
        int size = 0;
        int maxSize = permutations.size() / 2;
        for (List<Integer> permutation : permutations) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            if (size == maxSize) break;
            boolean[] currentUsed = new boolean[n];
            Arrays.fill(currentUsed, false);
            for (int x : permutation) {
                currentUsed[x] = true;
            }
            List<Integer> otherPermutation = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (currentUsed[i]) continue;
                otherPermutation.add(i);
            }
            System.out.println("current p : ");
            for (int x : permutation) {
                System.out.printf("%d,", x);
            }
            System.out.println();
            System.out.println("other p : ");
            for (int x : otherPermutation) {
                System.out.printf("%d,", x);
            }
            System.out.println();
            map1 = constructMapFromP(map1, permutation, dice);
            map2 = constructMapFromP(map2, otherPermutation, dice);
            int currentVictory = countVictory(map1, map2);
            if (currentVictory > maxVictory) {
                maxVictory = currentVictory;
                maxPermutation = permutation;
            }
        }
        int[] answer = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            answer[i] = maxPermutation.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] dice1 =
                new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4},
                        {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5},
                        {1, 10, 20, 1, 30, 1, 5}, {3, 4, 5, 6, 7, 8}};
        solution(dice1);
    }
}