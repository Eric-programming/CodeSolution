class Solution {
    public String reorganizeString(String s) {
        // Store all the character freq
        Map<Character, Integer> bucket1 = new HashMap<>();
        int maxCount = 0;
        for (char curChar : s.toCharArray()) {
            bucket1.put(curChar, bucket1.getOrDefault(curChar, 0) + 1);
            maxCount = Math.max(maxCount, bucket1.get(curChar));
        }

        // Base case check
        if (maxCount > s.length() / 2 + 1)
            return "";
        // Make the freq as the key
        Map<Integer, List<Character>> bucket2 = new HashMap<>();
        for (Character curChar : bucket1.keySet()) {
            int freq = bucket1.get(curChar);
            if (!bucket2.containsKey(freq)) {
                bucket2.put(freq, new ArrayList<>());
            }
            bucket2.get(freq).add(curChar);
        }
        char[] res = new char[s.length()];
        int index = 0;
        for (int count = maxCount; count > 0; count--) {
            if (!bucket2.containsKey(count))
                continue;
            List<Character> list = bucket2.get(count);
            for (Character curChar : list) {
                for (int curCount = 0; curCount < count; curCount++) {
                    if (index == 1 && curChar == res[index - 1])
                        return "";
                    res[index] = curChar;
                    index += 2;
                    if (s.length() <= index) {
                        index = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }
        return sb.toString();
    }
}
