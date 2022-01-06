class TrieNode{
    public Map<Character, TrieNode> children = new HashMap<>();
    public boolean isWord = false;
}
class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        char[] arr = word.toCharArray();
        for(char curChar : arr){
            if(curNode.children.containsKey(curChar) == false){
                curNode.children.put(curChar, new TrieNode());
            }
            curNode = curNode.children.get(curChar);
        }
        curNode.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        char[] arr = word.toCharArray();
        for(char curChar : arr){
            if(curNode.children.containsKey(curChar) == false){
               return false;
            }
            curNode = curNode.children.get(curChar);
        }
        return curNode.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        char[] arr = prefix.toCharArray();
        for(char curChar : arr){
            if(curNode.children.containsKey(curChar) == false){
               return false;
            }
            curNode = curNode.children.get(curChar);
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
