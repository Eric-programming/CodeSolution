class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        //Set up the table
        for(char cur : t.toCharArray()){
            map[cur]++;
        }
        
        int countAllCharInT = 0;
        int left = 0, n = arr.length, right = 0;
        int minLen = Integer.MAX_VALUE;
        String minLenStr = "";
        
        while(right < n){
            //Expand the window
            map[arr[right]]--;
            if(0 <= map[arr[right]]){
                countAllCharInT++;         
            }
            
            //Shrink the window if current window contains all the char in t
            while(countAllCharInT == t.length()){
                //Update the minLen
                if(minLen > right - left + 1){
                    minLen = right - left + 1;
                    minLenStr = s.substring(left, right + 1);
                }
                
                //Shrink the window
                map[arr[left]]++;
                if(0 < map[arr[left]]){
                    countAllCharInT--;
                }
                left++;
            }
            
            right++;
        }
        
        return minLenStr;
    }
}


