class Solution {
    public int numDistinct(String s, String t) {
        char[] sArr = s.toCharArray(), tArr = t.toCharArray();
        int sLen = sArr.length, tLen = tArr.length;
        
        //Base case 
        if(sLen < tLen) return 0;
        
        int[][] cache = new int[tLen + 1][sLen + 1];
        
        //Build the first row
        Arrays.fill(cache[0], 1);
        
        for(int row = 1; row <= tLen; row++){
            for(int col = 1; col <= sLen; col++){
                if(sArr[col - 1] == tArr[row - 1]){
                    cache[row][col] = cache[row - 1][col - 1] + cache[row][col - 1];
                }else{
                    cache[row][col] = cache[row][col - 1];
                }
            }
        }
        return cache[tLen][sLen];
    }
}
