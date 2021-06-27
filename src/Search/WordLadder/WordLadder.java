import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        // Base case
        if (!set.contains(endWord))
            return 0;

        int level = 1;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] curStrArr = queue.poll().toCharArray();
                // Try all combination and save correct word onto the queue
                for (int j = 0; j < curStrArr.length; j++) {
                    char oldChar = curStrArr[j];
                    for (char character = 'a'; character <= 'z'; character++) {
                        curStrArr[j] = character;
                        String curStr = new String(curStrArr);
                        if (curStr.equals(endWord))
                            return level + 1;// because curStr is for next level
                        if (set.contains(curStr)) {
                            queue.add(curStr);
                            set.remove(curStr);
                        }
                    }
                    curStrArr[j] = oldChar; // Change back to the old char
                }
            }
            level++;
        }
        return 0;
    }
}
