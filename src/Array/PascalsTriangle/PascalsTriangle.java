class Solution {
    public List<List<Integer>> generate(int numRows) {
        //define list
        List<List<Integer>> res = new LinkedList<>();
        
        //add 1 to the first row
        List<Integer> firstRow = new LinkedList<>();
        firstRow.add(1);
        res.add(firstRow);
        //iterate from row index 1 to row index numRows - 1
        for(int i = 1; i < numRows; i++){
            List<Integer> curRow = new LinkedList<>();
            //1. add the left border 1
            curRow.add(1);
            List<Integer> preRow = res.get(i - 1);
            //2. iterate 1 to current row index to add each sum
            for(int j = 1; j < i; j++){
                int val = preRow.get(j) + preRow.get(j - 1);
                curRow.add(val);
            }
            //3. Add the right border 1
            curRow.add(1);
            
            res.add(curRow);
        }        
        //return the list
        return res;
    }
}
