class Trie{
    Map<Character, Trie> children = new HashMap<>();
    int val = 0;
}
class MapSum {
    Trie root;
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Trie();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        Trie temp = root;
        char[] arr = key.toCharArray();
        for(char cur : arr){
            if(!temp.children.containsKey(cur)){
                temp.children.put(cur, new Trie());
            }
            temp = temp.children.get(cur);
            temp.val += val;
            if(map.containsKey(key)){
                temp.val -= map.get(key);
            }
        }
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        Trie temp = root;
        char[] arr = prefix.toCharArray();
        for(char cur : arr){
            if(!temp.children.containsKey(cur)){
                return 0;
            }
            temp = temp.children.get(cur);
        }
        return temp.val;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
