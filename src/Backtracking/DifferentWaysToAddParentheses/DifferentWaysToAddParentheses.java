class Solution {
    private final char MULTIPLICATION = '*';
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private char[] expressionArr;
    private String expression;
    private Set<Character> operatorSet = new HashSet<>();

    public List<Integer> diffWaysToCompute(String expression) {
        this.expression = expression;
        operatorSet.add(MULTIPLICATION);
        operatorSet.add(ADDITION);
        operatorSet.add(SUBTRACTION);
        expressionArr = expression.toCharArray();
        return dfs(0, expressionArr.length - 1);
    }

    private List<Integer> dfs(int start, int end) {
        List<Integer> res = new LinkedList<>();
        for (int i = start; i < end; i++) {
            if (operatorSet.contains(expressionArr[i])) {
                List<Integer> leftList = dfs(start, i - 1);
                List<Integer> rightList = dfs(i + 1, end);
                for (Integer num1 : leftList) {
                    for (Integer num2 : rightList) {
                        Integer totalVal = calculate(num1, num2, expressionArr[i]);
                        res.add(totalVal);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression.substring(start, end + 1)));
        }
        return res;
    }

    private Integer calculate(Integer num1, Integer num2, char operator) {
        switch (operator) {
            case MULTIPLICATION:
                return num1 * num2;
            case ADDITION:
                return num1 + num2;
            case SUBTRACTION:
                return num1 - num2;
            default:
                return -1;
        }
    }

}
