package vopreparation0530;

//208. Implement Trie (Prefix Tree)
class Trie {
    private class Node{
        Node[] children = new Node[26];
        boolean isWord;

        public Node findChild(char c){
            int idx = getIdx(c);
            return children[idx];
        }

        public int getIdx(char c){
            return c - 'a';
        }

        public Node setChild(char c, Node child){
            children[getIdx(c)] = child;
            return child;
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        for(char c: word.toCharArray()){
            if(cur.findChild(c) == null){
                cur.setChild(c, new Node());
            }
            cur = cur.findChild(c);
        }
        cur.isWord = true;
        return;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        for(char c: word.toCharArray()){
            if(cur.findChild(c) == null) return false;
            cur = cur.findChild(c);
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char c: prefix.toCharArray()){
            if(cur.findChild(c) == null) return false;
            cur = cur.findChild(c);
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
