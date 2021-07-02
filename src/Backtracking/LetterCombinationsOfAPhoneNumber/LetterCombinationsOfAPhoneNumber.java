class Solution {
    Map<Character, String> phone = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
      }};
    char[] digitsArr;
    List<String> res = new LinkedList<>();
    public List<String> letterCombinations(String digits) {
        digitsArr = digits.toCharArray();
        //Base case
        if(digitsArr.length != 0){
            dfs(0, new StringBuilder());
        }
        return res;
    }
    private void dfs(int index, StringBuilder sb){
        //Base case
        if(index == digitsArr.length) {
            res.add(sb.toString());
            return;
        }
        String characters = phone.get(digitsArr[index]);
        for(char curChar : characters.toCharArray()){
            sb.append(curChar);
            dfs(index + 1, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}
