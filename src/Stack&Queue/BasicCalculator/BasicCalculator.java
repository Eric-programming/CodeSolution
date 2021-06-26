import java.util.*;

class Solution {
    char[] arr;
    int index = 0;

    public int calculate(String s) {
        arr = s.toCharArray();
        return dfs();
    }

    private int dfs() {
        // Define variables
        int sum = 0, operator = 1;
        // Get the sum within current brackets
        while (index < arr.length) {
            if (arr[index] == ')') {
                break;
            } else if (arr[index] == '(') {
                index++;
                sum += operator * dfs();
            } else if (arr[index] == '-') {
                operator = -1;
            } else if (arr[index] == '+') {
                operator = 1;
            } else if (Character.isDigit(arr[index])) {
                // Form the number
                StringBuilder buildNum = new StringBuilder();
                while (index < arr.length && Character.isDigit(arr[index])) {
                    buildNum.append(arr[index++]);
                }
                index--;
                // Convert to number
                sum += Integer.parseInt(buildNum.toString()) * operator;
            }
            index++;
        }
        return sum;
    }
}
