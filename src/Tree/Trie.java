class Trie {

    Trie[] children;

    boolean isWord;

    public Trie() {
        children = new Trie[26];
        isWord = false;
    }

    public void insert(String word) {


        Trie current = this;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Trie();
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {

        Trie current = this;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        Trie current = this;
        for (char c : prefix.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */