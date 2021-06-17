class Solution {
    public boolean checkInclusion(String t, String s) {
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        //Set up the table
        for(char cur : t.toCharArray()){
            map[cur]++;
        }
        
        int countAllCharInT = 0;
        int left = 0, n = arr.length, right = 0;
        
        while(right < n){
            //Expand the window
            map[arr[right]]--;
            if(0 <= map[arr[right]]){
                countAllCharInT++;         
            }
            
            //Shrink the window if current window contains all the char in t
            while(countAllCharInT == t.length()){
                //Update the minLen
                if(right - left + 1 == t.length()){
                    return true;
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
        
        return false;
    }
}
