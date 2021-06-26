class Solution {
    public int calculate(String s) {
        char[] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        char operator = '+';

        // Get rid of * and /
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ')
                continue;
            if (Character.isDigit(arr[i])) {
                // build the number
                StringBuilder buildNum = new StringBuilder();
                while (i < arr.length && Character.isDigit(arr[i])) {
                    buildNum.append(arr[i++]);
                }
                i--;

                int curNum = Integer.parseInt(buildNum.toString());
                if (operator == '-') {
                    curNum *= -1;
                } else if (operator == '*') {
                    curNum *= stack.pop();
                } else if (operator == '/') {
                    curNum = stack.pop() / curNum;
                }
                stack.push(curNum);
            } else {
                operator = arr[i];
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }
}
