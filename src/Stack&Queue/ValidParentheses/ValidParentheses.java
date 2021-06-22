
class Solution {
    public boolean isValid(String s) {
        // Table set up
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        // Validate the string
        Stack<Character> stack = new Stack<>();
        for (Character curChar : s.toCharArray()) {
            // open parenthese
            if (!map.containsKey(curChar)) {
                stack.add(curChar);
            } else {
                if (!stack.isEmpty() && stack.peek() == map.get(curChar)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
