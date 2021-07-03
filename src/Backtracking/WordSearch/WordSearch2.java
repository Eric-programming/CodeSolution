class Solution {
    class TrieNode{
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
    }
    TrieNode trie = new TrieNode();
    List<String> res = new LinkedList<>();
    int m, n;
    char[][] board;
    boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        //Insert words onto the trie
        for(String word : words){
            insertAWord(word);
        }
        //For each character in board contains in trie, we dfs
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                char curChar = board[row][col];
                visited = new boolean[m][n];
                dfs(row, col, new StringBuilder(), trie);
            }
        }
        return res;
    }
    private void dfs(int row, int col, StringBuilder sb, TrieNode curTrie){
        //Base case
        if(row < 0 || row == m || col == n || col < 0) return;
        //Check if visited
        if(visited[row][col]) return;
        //Check if current character is in the trie
        char curChar = board[row][col];
        if(!curTrie.map.containsKey(curChar)) return;
        sb.append(curChar);
        curTrie = curTrie.map.get(curChar);
        visited[row][col] = true;
        //Add current string to the res if it is a word
        if(curTrie.isWord){
            res.add(sb.toString());
            curTrie.isWord = false;
        }
        
        //DFS all 4 directions
        dfs(row, col + 1, sb, curTrie);//right
        dfs(row + 1, col, sb, curTrie);//Down
        dfs(row - 1, col, sb, curTrie);//Up
        dfs(row, col - 1, sb, curTrie);//left
        //Remove last element: Backtracking
        sb.setLength(sb.length() - 1);
        visited[row][col] = false;
    }
    private void insertAWord(String word){
        char[] arr = word.toCharArray();
        TrieNode curNode = trie;
        for(char curChar : arr){
            if(!curNode.map.containsKey(curChar)){
                curNode.map.put(curChar, new TrieNode());
            }
            curNode = curNode.map.get(curChar);
        }
        curNode.isWord = true;
    }
}

/***
[["h","k"],["f","l"]]
["hklf","hf"]
***/
