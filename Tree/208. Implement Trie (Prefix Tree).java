class Trie {

    /** Initialize your data structure here. */
    class Node {
        char c;
        HashMap<Character, Node> curChildren = new HashMap<>();
        boolean isWord = false;
        Node() {

        }
        Node(char c) {
            this.c = c;
        }
    }
    private Node root;
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        HashMap<Character, Node> curChildren = cur.curChildren;
        char[] wordLetter = word.toCharArray();
        for (int i = 0; i < wordLetter.length; i++) {
            char letter = wordLetter[i];
            if (curChildren.containsKey(letter)) {
                cur = curChildren.get(letter);
            } else {
                Node node = new Node(letter);
                curChildren.put(letter, node);
                cur = node;
            }
            curChildren = cur.curChildren;
            if (i == wordLetter.length - 1) {
                cur.isWord = true;
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        char[] wordLetter = word.toCharArray();
        HashMap<Character, Node> curChildren = cur.curChildren;
        for (int i = 0; i < wordLetter.length; i++) {
            char letter = wordLetter[i];
            if (curChildren.containsKey(letter)) {
                cur = curChildren.get(letter);
            } else {
                return false;
            }
            curChildren = cur.curChildren;
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        char[] wordLetter = prefix.toCharArray();
        HashMap<Character, Node> curChildren = cur.curChildren;
        for (int i = 0; i < wordLetter.length; i++) {
            char letter = wordLetter[i];
            if (curChildren.containsKey(letter)) {
                cur = curChildren.get(letter);
            } else {
                return false;
            }
            curChildren = cur.curChildren;
            if (i == wordLetter.length - 1) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
