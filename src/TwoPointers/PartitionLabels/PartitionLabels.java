class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new LinkedList<>();
        char[] arr = S.toCharArray();
        //1. Last appear character index save onto a table
        int[] map = new int[26];
        for(int i = 0; i < arr.length; i++){
            map[arr[i] - 'a'] = i;
        }
        
        //2. Define L and R
        int L = 0;
        int maxLastAppearIndex = 0;
        
        for(int R = 0; R < arr.length; R++){
            //Current Character Last appear index
            int curLastAppearIndex = map[arr[R] - 'a'];

            //Update the max last appear char index
            maxLastAppearIndex = Math.max(maxLastAppearIndex, curLastAppearIndex);

            if(maxLastAppearIndex == R){
                int len = R - L + 1;
                res.add(len);
                L = R + 1;
            }
        }
        
        return res;
    }
}
