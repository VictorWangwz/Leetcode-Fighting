package trie;
//648. Replace Words
public class WordTrie2 {
    private Node root;

    public WordTrie2(){
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

    public int searchPrefix(String word){
        Node node = root;
        int i = 0;
        for( char c: word.toCharArray()){
            if(node.children[getIdx(c)] == null) return -1;
            if(node.children[getIdx(c)].isWord ) return i;
            node = node.children[getIdx(c)];
            i++;
        }
        return -1;
    }

}
