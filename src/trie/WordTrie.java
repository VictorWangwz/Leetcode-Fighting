package trie;
//720. Longest Word in Dictionary
public class WordTrie {
    private Node root;

    public WordTrie(){
        root = new Node(0);
    }

    private class Node{
        public Node[] children = new Node[26];
        public boolean isWord;
        public int depth;

        public Node(int depth){
            this.depth = depth;
        }
    }

    private int getIdx(char c){
        return c - 'a';
    }

    public void insert(String word){
        Node node = root;
        for( char c: word.toCharArray()){
            if(node.children[getIdx(c)] == null){
                node.children[getIdx(c)] = new Node(node.depth + 1);
            }
            node = node.children[getIdx(c)];
        }
        node.isWord = true;
    }

    public int searchWord(String word){
        Node node = root;
        for(char c: word.toCharArray()){
            if(node.children[getIdx(c)] == null || ! node.children[getIdx(c)].isWord) return  -1 ;
            node = node.children[getIdx(c)];
        }
        return node.depth;
    }
}
