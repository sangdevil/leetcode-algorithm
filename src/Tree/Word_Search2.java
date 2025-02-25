package Tree;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Word_Search2 {

    class Trie {

        Trie[] children;
        boolean isWord;
        boolean isComplete;

        public Trie() {
            children = new Trie[26];
            isWord = false;
        }

        public Trie insert(String word) {

            Trie current = this;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new Trie();
                }
                current = current.children[c - 'a'];
            }
            current.isWord = true;
            return current;
        }

        public boolean search(String word) {
            Trie current = this;
            for (char c : word.toCharArray()) {
                System.out.println("current trie has " + c + (current.children[c - 'a'] != null));
                if (current.children[c - 'a'] == null) {
                    return false;
                }
                current = current.children[c - 'a'];
            }
            return current.isComplete;
        }
    }

    static final int[][] direcionts = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited = new boolean[12][12];

    public void dfs(char[][] board, Trie current, int x, int y) {

        if (current == null) {
            System.out.println("x, y" + x + "," + y + "," + board[y][x] + " is not on the path");
            return;
        }
        System.out.println("from x: " + x + " y: " + y + " c : " + board[y][x] + ", dfs started");
        if (current.isWord) {
            System.out.println("word completed");
            current.isComplete = true;
        }

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + direcionts[i][0];
            int newY = y + direcionts[i][1];
            if (newX < 0 || newX >= board[0].length || newY < 0 || newY >= board.length || visited[newY][newX]) {
                continue;
            }
            dfs(board, current.children[board[newY][newX] - 'a'], newX, newY);
        }
        visited[y][x] = false;
        System.out.println("from x: " + x + " y: " + y + " c : " + board[y][x] + ", dfs end");

    }


    public List<String> findWords(char[][] board, String[] words) {

        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                dfs(board, root.children[board[y][x] - 'a'], x, y);
            }
        }

        List<String> result = new LinkedList<>();
        for (String word : words) {
            if (root.search(word)) {
                result.add(word);
            }
        }
        return result;

    }


}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */