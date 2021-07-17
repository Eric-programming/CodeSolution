class Solution {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int[] cache = new int[arr.length];
        int n = cache.length;
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] == '0'){
                continue;
            }
            if(i == n - 1){
                cache[i] = 1;
                continue;
            }
            String str = s.substring(i, i + 2);
            if(Integer.parseInt(str) > 26){
                cache[i] = cache[i + 1];
            }else if(i == n - 2){
                cache[i] = cache[i + 1] + 1;
            }
            else{
                cache[i] = cache[i + 1] + cache[i + 2];
            }
        }
        return cache[0];
    }
}
