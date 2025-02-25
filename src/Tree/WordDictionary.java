package Tree;


class WordDictionary {

    WordNode node;
    public WordDictionary() {
        this.node = new WordNode();

    }

    public void addWord(String word) {

        this.node.insert(word);
    }

    public boolean search(String word) {

        return this.node.search(word);
    }
}
class WordNode {

    WordNode[] children;

    boolean isWord;

    public WordNode() {
        children = new WordNode[26];
        isWord = false;
    }

    public void insert(String word) {


        WordNode current = this;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new WordNode();
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {

        if (word.isEmpty()) {
            return isWord;
        }
        char c = word.charAt(0);
        if (c == '.') {
            for (WordNode child : children) {
                if (child != null) {
                    if (child.search(word.substring(1))) return true;
                }
            }
            return false;
        } else {
            if (children[c - 'a'] == null) return false;
            return children[c - 'a'].search(word.substring(1));
        }
    }

}