/**
Good questions to ask in the interview:
- what if there is only one distinct character in the string?
- Do we only have lowercase letters?
- Is 'A' the same as 'a' ?

**/

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        //Define pointers
        char[] arr = s.toCharArray();
        int left = 0, right = 0, n = arr.length;
        int longestLen = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        
        while(right < n){
            //Expand window
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            //Shrink the window if the window don't qualify the condition
            while(2 < map.size()){
                if(map.get(arr[left]) == 1){
                    map.remove(arr[left]);
                }else{
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
                left++;
            }
            
            //Keep track of the longest substring length
            longestLen = Math.max(longestLen, right - left + 1);
            
            right++;
        }        
        return longestLen;
    }
}
