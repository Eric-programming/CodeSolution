class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Define pointers
        char[] arr = s.toCharArray();
        int n = arr.length, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int longestLen = Integer.MIN_VALUE;
        
        while(right < n){
            //Expand window
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            //Shrink the window if this is repeating characters
            while(map.size() < right - left + 1){
                if(map.get(arr[left]) == 1){
                    map.remove(arr[left]);
                }else{
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
                left++;
            }
            
            longestLen = Math.max(longestLen, right - left + 1);
            
            right++;
        }
        if(longestLen == Integer.MIN_VALUE) return 0;
        
        return longestLen;
    }
}
