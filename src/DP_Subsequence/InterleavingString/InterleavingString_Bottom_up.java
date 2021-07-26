class Solution {
    final char UNKNOWN = '0';
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] s1Arr = s1.toCharArray(), s2Arr = s2.toCharArray(), s3Arr = s3.toCharArray();
        boolean[][] cache = new boolean[s1Arr.length + 1][s2Arr.length + 1];
        
        //Base case
        if(s1Arr.length + s2Arr.length != s3Arr.length) return false;
        cache[s1Arr.length][s2Arr.length] = true;
        
        for(int ps1 = s1Arr.length; ps1 >= 0; ps1--){
            for(int ps2 = s2Arr.length; ps2 >= 0; ps2--){
                if(cache[ps1][ps2]) continue;
                int ps3 = ps1 + ps2;
                char s1Char = ps1 == s1Arr.length ? UNKNOWN : s1Arr[ps1];
                char s2Char = ps2 == s2Arr.length ? UNKNOWN : s2Arr[ps2];
                char s3Char = s3Arr[ps3];
                if(s1Char == s3Char && s2Char == s3Char){
                    cache[ps1][ps2] = cache[ps1][ps2 + 1] || cache[ps1 + 1][ps2]; 
                }else if(s1Char == s3Char){
                    cache[ps1][ps2] = cache[ps1 + 1][ps2];
                }else if(s2Char == s3Char){
                    cache[ps1][ps2] = cache[ps1][ps2 + 1];
                }else{
                    cache[ps1][ps2] = false;
                }
            }
        }
        
        return cache[0][0];
    }
}
