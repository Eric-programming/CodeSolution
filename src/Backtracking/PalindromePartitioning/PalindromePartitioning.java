class Solution {
    List<List<String>> res = new LinkedList<>();
    String s;
    char[] arr;
    public List<List<String>> partition(String s) {
        this.s = s;
        this.arr = s.toCharArray();
        helper(0, new LinkedList<String>());
        return res;
    }
    private void helper(int index, List<String> comb){ 
        if(index >= arr.length) {
            res.add(new LinkedList<>(comb));
            return;
        }
        
        for(int i = index; i < arr.length; i++){
            if(!isPalindrome(index, i)) continue;
            comb.add(s.substring(index, i + 1));
            helper(i + 1, comb);
            comb.remove(comb.size() - 1);
        }
    }
    private boolean isPalindrome(int L, int R){
        while(L < R){
            if(arr[L] != arr[R]) return false;
            L++;
            R--;
        }
        return true;
    }
}
