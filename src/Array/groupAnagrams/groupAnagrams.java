//O(n*k)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Keep a table to group all the anagrams together
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            //Sort the string to get the key
            String key = generateKey(str);
            //Add the current string to the current table
            if(!map.containsKey(key)){
                map.put(key, new LinkedList<>());
            }
            List<String> list = map.get(key);
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
    private String generateKey(String str){
        int[] map = new int[26];
        char[] arr = str.toCharArray();
        //O(k) to convert to map {a: 1, b: 0 ....}
        for(char curChar : arr){
            map[curChar - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        //O(26) to convert to "1#0#..."
        for(int num : map){
            sb.append(num);
            sb.append("#");
        }
        return sb.toString();
    }
}
