class Solution {
    List<String> res = new LinkedList<>();
    char[] arr;
    public List<String> restoreIpAddresses(String s) {
        this.arr = s.toCharArray();
        //Base case
        if(12 < arr.length) return res;
        List<String> curCombination = new LinkedList<>();
        helper(curCombination, 0);
        return res;
    }
    private void helper(List<String> curComb, int index){
        //Check if finish all the target string with the right list size
        int size = curComb.size();
        if(size > 4) return;
        
        if(size == 4 && index == arr.length){
            String curCombString = convertString(curComb);
            res.add(curCombString);
            return;
        }
        //dfs for each combination search
        StringBuilder str = new StringBuilder();
        for(int i = index; i < arr.length && i < index + 3; i++){
            str.append(arr[i]);
            if(!checkValidDigits(str.toString())) break;
            curComb.add(str.toString());
            helper(curComb, i + 1);
            curComb.remove(curComb.size() - 1);
        }
    }
    private boolean checkValidDigits(String str){
        if(str.length() > 1 && str.charAt(0) == '0') return false;
        return Integer.parseInt(str) <= 255;
    }
    private String convertString(List<String> comb){
        StringBuilder sb = new StringBuilder();
        for(String str : comb){
            sb.append(str);
            sb.append('.');
        }
        return sb.substring(0, sb.length() - 1);
    }
}
