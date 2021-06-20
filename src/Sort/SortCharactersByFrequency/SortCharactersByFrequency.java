class Solution {
    public String frequencySort(String s) {
        // Save each character freq
        Map<Character, Integer> bucket1 = new HashMap<>();
        for (char cur : s.toCharArray()) {
            bucket1.put(cur, bucket1.getOrDefault(cur, 0) + 1);
        }
        // create bucket 2 with freq as the key
        Map<Integer, List<Character>> bucket2 = new HashMap<>();
        for (Character cur : bucket1.keySet()) {
            Integer freq = bucket1.get(cur);
            if (!bucket2.containsKey(freq)) {
                bucket2.put(freq, new ArrayList<>());
            }
            bucket2.get(freq).add(cur);
        }

        // Sort by freq
        StringBuilder sb = new StringBuilder();
        for (int n = s.length(); n >= 1; n--) {
            if (bucket2.containsKey(n)) {
                List<Character> list = bucket2.get(n);
                for (Character character : list) {
                    for (int i = 0; i < n; i++) {
                        sb.append(character);
                    }
                }
            }
        }
        return sb.toString();
    }
}
