class Solution {
    Integer[][] cache;
    char[] sArr, tArr;
    int sLen, tLen;
    public int numDistinct(String s, String t) {
        sArr = s.toCharArray();
        tArr = t.toCharArray();
        sLen = sArr.length;
        tLen = tArr.length;
        
        //Base case 
        if(sLen < tLen) return 0;
        
        cache = new Integer[tLen][sLen];
        
        return dfs(tLen - 1, sLen - 1);
    }
    private int dfs(int tIndex, int sIndex){
        //Base case
        if(0 <= sIndex && tIndex < 0) return 1;// s="a" t=""
        if(sIndex < 0 && tIndex < 0) return 1; //s="" t=""
        if(sIndex < 0 && 0 <= tIndex) return 0; // s="" t="a"
        
        if(cache[tIndex][sIndex] != null) return cache[tIndex][sIndex];
        
        if(sArr[sIndex] == tArr[tIndex]){
            cache[tIndex][sIndex] = dfs(tIndex - 1, sIndex - 1) + dfs(tIndex, sIndex - 1);
        }else{
            cache[tIndex][sIndex] = dfs(tIndex, sIndex - 1);
        }
        
        return cache[tIndex][sIndex];
    }
}
