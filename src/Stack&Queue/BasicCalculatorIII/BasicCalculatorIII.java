class Solution {
    char[] arr;
    int index = 0;

    public int calculate(String s) {
        arr = s.toCharArray();
        return dfs();
    }

    private int dfs() {
        Stack<Integer> stack = new Stack<>();
        char operator = '+';

        // Get rid of * and /
        while (index < arr.length) {
            if (arr[index] != ' ') {
                if (Character.isDigit(arr[index])) {
                    // build the number
                    StringBuilder buildNum = new StringBuilder();
                    while (index < arr.length && Character.isDigit(arr[index])) {
                        buildNum.append(arr[index++]);
                    }
                    index--;

                    int curNum = Integer.parseInt(buildNum.toString());
                    insertElement(stack, curNum, operator);
                } else if (arr[index] == '(') {
                    index++;
                    int curNum = dfs();
                    insertElement(stack, curNum, operator);
                } else if (arr[index] == ')') {
                    break;
                } else {
                    operator = arr[index];
                }
            }
            index++;
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }

    private void insertElement(Stack<Integer> stack, int curNum, char operator) {
        if (operator == '-') {
            curNum *= -1;
        } else if (operator == '*') {
            curNum *= stack.pop();
        } else if (operator == '/') {
            curNum = stack.pop() / curNum;
        }
        stack.push(curNum);
    }
}
