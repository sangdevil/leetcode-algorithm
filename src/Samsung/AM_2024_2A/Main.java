package Samsung.AM_2024_2A;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {


    public enum Face {
        H, L, N, E, S, W, M
    }

    public static class Coordinate {
        int x;
        int y;
        int time;
        Face face;
        int cubeSize;
        int mapSize;

        public Coordinate(int x, int y, int time, Face face, int cubeSize, int mapSize) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.face = face;
            this.cubeSize = cubeSize;
            this.mapSize = mapSize;
        }

    }

    public static class MyMap {
        int mapSize;
        int cubeSize;
        int[][] map;
        Face face;

        public MyMap(int mapSize, int[][] map, Face face) {
            this.mapSize = mapSize;
            map = new int[mapSize][mapSize];
            this.map = map;
            this.face = face;
        }
    }

    public static class Fire {
        int x;
        int y;
        int turn;
        int[] direction;

        public Fire(int x, int y, int[] direction, int turn) {
            this.x = x;
            this.y = y;
            this.turn = turn;
            this.direction = direction;
        }
    }


    public static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int cubeStartX;
    public static int cubeStartY;

    public static MyMap highMap;
    public static MyMap northMap;
    public static MyMap southMap;
    public static MyMap eastMap;
    public static MyMap westMap;
    public static MyMap groundMap;
    public static Fire[] fires;


    public static Coordinate changeFace(Coordinate curC) {

        int x = curC.x;
        int y = curC.y;
        int nextX = curC.x;
        int nextY = curC.y;
        Face nextFace = curC.face;
        int cubeSize = curC.cubeSize;
        switch (curC.face) {
            case E -> {
                // DOWN, goto Map.
                if (nextY == cubeSize) {
                    nextFace = Face.M;
                    nextX = cubeStartX + cubeSize;
                    nextY = cubeStartY + cubeSize - 1 - x;
                    //
                } else if (nextY == -1) {
                    // UP, goto H.
                    nextFace = Face.H;
                    nextX = cubeSize - 1 - x;
                    nextY = cubeSize - 1;
                } else if (nextX == cubeSize) {
                    // RIGHT
                    nextFace = Face.N;
                    nextX = 0;
                    nextY = y;
                } else if (nextX == -1) {
                    // LEFT
                    nextFace = Face.S;
                    nextX = cubeSize - 1;
                    nextY = y;
                }
            }
            case S -> {
                // DOWN, goto Map.
                if (nextY == cubeSize) {
                    nextFace = Face.M;
                    nextX = cubeStartX + x;
                    nextY = cubeStartY + cubeSize;
                    //
                } else if (nextY == -1) {
                    // UP, goto H.
                    nextFace = Face.H;
                    nextX = x;
                    nextY = cubeSize - 1;
                } else if (nextX == cubeSize) {
                    // RIGHT
                    nextFace = Face.E;
                    nextX = 0;
                    nextY = y;
                } else if (nextX == -1) {
                    // LEFT
                    nextFace = Face.S;
                    nextX = cubeSize - 1;
                    nextY = y;
                }
            }
            case W -> {
                // DOWN, goto Map.
                if (nextY == cubeSize) {
                    nextFace = Face.M;
                    nextX = cubeStartX - 1;
                    nextY = cubeStartY + x;
                    //
                } else if (nextY == -1) {
                    // UP, goto H.
                    nextFace = Face.H;
                    nextX = x;
                    nextY = 0;
                } else if (nextX == cubeSize) {
                    // RIGHT
                    nextFace = Face.S;
                    nextX = 0;
                    nextY = y;
                } else if (nextX == -1) {
                    // LEFT
                    nextFace = Face.N;
                    nextX = cubeSize - 1;
                    nextY = y;
                }
            }
            case N -> {
                // DOWN, goto Map.
                if (nextY == cubeSize) {
                    nextFace = Face.M;
                    nextX = cubeStartX + cubeSize - 1 - x;
                    nextY = cubeStartY - 1;
                    //
                } else if (nextY == -1) {
                    // UP, goto H.
                    nextFace = Face.H;
                    nextX = cubeSize - 1 - x;
                    nextY = 0;
                } else if (nextX == cubeSize) {
                    // RIGHT
                    nextFace = Face.W;
                    nextX = 0;
                    nextY = y;
                } else if (nextX == -1) {
                    // LEFT
                    nextFace = Face.E;
                    nextX = cubeSize - 1;
                    nextY = y;
                }
            }
            case H -> {
                // DOWN, goto S.
                if (nextY == cubeSize) {
                    nextFace = Face.N;
                    nextX = x;
                    nextY = 0;
                    //
                } else if (nextY == -1) {
                    // UP, goto N.
                    nextFace = Face.N;
                    nextX = cubeSize - 1 - x;
                    nextY = 0;
                } else if (nextX == cubeSize) {
                    // RIGHT
                    nextFace = Face.E;
                    nextX = cubeSize - 1 - y;
                    nextY = 0;
                } else if (nextX == -1) {
                    // LEFT
                    nextFace = Face.W;
                    nextX = y;
                    nextY = 0;
                }
            }
        }

        Coordinate nextC = new Coordinate(nextX, nextY, curC.time, nextFace, curC.cubeSize, curC.mapSize);
        return nextC;
    }

    public static Coordinate nextCoordinate(Coordinate curC, int[] direction) {

        curC.x += direction[0];
        curC.y += direction[1];
        curC = changeFace(curC);
        curC.time += 1;
        return curC;

    }

    public static MyMap getMap(Face face) {
        switch (face) {
            case H -> {
                return highMap;
            }
            case N -> {
                return northMap;
            }
            case S -> {
                return southMap;
            }
            case E -> {
                return eastMap;
            }
            case W -> {
                return westMap;
            }
            default -> {
                return groundMap;
            }
        }

    }

    public static boolean checkPossible(Coordinate curC) {
        // First, check if currentFace is map and out of map.
        if (curC.face == Face.M) {
            int mapSize = curC.mapSize;
            if (curC.x < 0 || curC.x >= mapSize || curC.y < 0 || curC.y >= mapSize) {
                return false;
            }
        }

        // Next, check if current location is valid.
        MyMap currentMap = getMap(curC.face);
        int currentValue = currentMap.map[curC.y][curC.x];
        if (currentValue > 0 && currentValue < 4) {
            return false;
        }

        return true;

    }

    public static void updateFire() {

    }

    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);
        int[] firstLine = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int mapSize = firstLine[0];
        int cubeSize = firstLine[1];
        int fireNumber = firstLine[2];
        int[][] mapH = new int[cubeSize][cubeSize];
        int[][] mapN = new int[cubeSize][cubeSize];
        int[][] mapS = new int[cubeSize][cubeSize];
        int[][] mapE = new int[cubeSize][cubeSize];
        int[][] mapW = new int[cubeSize][cubeSize];
        int[][] mapG = new int[mapSize][mapSize];

        fires = new Fire[fireNumber];


        // fill groundMap
        for (int i = 0; i < mapSize; i++) {
            mapG[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // fill eastMap;
        for (int i = 0; i < cubeSize; i++) {
            mapE[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // fill westMap;
        for (int i = 0; i < cubeSize; i++) {
            mapW[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // fill southMap;
        for (int i = 0; i < cubeSize; i++) {
            mapS[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        // fill northMap;
        for (int i = 0; i < cubeSize; i++) {
            mapN[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        // fill highMap;
        for (int i = 0; i < cubeSize; i++) {
            mapH[i] = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int curX = 0;
        int curY = 0;
        int retX = 0;
        int retY = 0;
        for (int y = 0; y < cubeSize; y++) {
            for (int x = 0; x < cubeSize; x++) {
                if (mapH[y][x] == 2) {
                    curX = x;
                    curY = y;
                    break;
                }
            }
        }
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (mapG[y][x] == 4) {
                    retX = x;
                    retY = y;
                    break;
                }
            }
        }
        Coordinate curC = new Coordinate(curX, curY, 0, Face.H, cubeSize, mapSize);

        // make Fires;
        for (int i = 0; i < fireNumber; i++) {
            int[] line = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            fires[i] = new Fire(line[0], line[1], directions[line[2]], line[3]);
        }

        highMap = new MyMap(mapSize, mapH, Face.H);
        northMap = new MyMap(mapSize, mapN, Face.N);
        southMap = new MyMap(mapSize, mapS, Face.S);
        eastMap = new MyMap(mapSize, mapE, Face.E);
        westMap = new MyMap(mapSize, mapW, Face.W);
        groundMap = new MyMap(mapSize, mapG, Face.M);


        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(curC);

        while (!queue.isEmpty()) {
            curC = queue.poll();
            updateFire();
            if (curC.x == retX && curC.y == retY) {
                break;
            }
            for (int[] dir : directions) {
                Coordinate nextC = nextCoordinate(curC, dir);
                if (checkPossible(nextC)) {
                    queue.add(nextC);
                }
            }
        }

        System.out.println(curC.time);

    }
}


