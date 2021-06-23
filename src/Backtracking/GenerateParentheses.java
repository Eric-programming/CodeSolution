class Solution {
    List<String> res = new LinkedList<>();
    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, n);
        return res;
    }
    private void dfs(StringBuilder sb, int close, int n){
        if(n == 0 && close == 0){
            res.add(sb.toString());
            return;
        }
        
        //Add open parenthese
        if(n > 0){
            sb.append('(');
            dfs(sb, close + 1, n - 1);
            sb.setLength(sb.length() - 1);
        }
        //Add close parenthese
        if(close > 0){
            sb.append(')');
            dfs(sb, close - 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
