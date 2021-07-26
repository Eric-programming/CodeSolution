class Solution {
    Set<String> wordDict;
    Map<String, List<String>> cache = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        return DFS(s);
    }

    private List<String> DFS(String s) {
        if (cache.containsKey(s))
            return cache.get(s);

        LinkedList<String> res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()));
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        cache.put(s, res);
        return res;
    }
}
