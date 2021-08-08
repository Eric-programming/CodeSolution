class Solution {
    Set<String> dict;
    Boolean[] cache;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dict = new HashSet<>(Arrays.asList(words));
        List<String> res = new LinkedList<>();
        for(String word: words){
            dict.remove(word);
            int n = word.length();
            cache = new Boolean[n];
            if(word.length() != 0 && isCancat(0, word.toCharArray())){
                res.add(word);
            }
            dict.add(word);
        }
        return res;
    }
    
    private boolean isCancat(int start, char[] arr){
        int end = arr.length - 1;
        if(start > end) return true;
        
        if(cache[start] != null) return cache[start];

        StringBuilder sb = new StringBuilder();
        
        cache[start] = false;
        for(int index = start; index <= end; index++){
            sb.append(arr[index]);
            if(dict.contains(sb.toString())){
                cache[start] = isCancat(index + 1, arr);
            }
            if(cache[start]) break;
        }
        return cache[start];
    }
    
}

/**
words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output = ["catsdogcats","dogcatsdog","ratcatdogcat"]


Solution 1: 
for each word, is this word cancat word (dfs backtracking)
**/
