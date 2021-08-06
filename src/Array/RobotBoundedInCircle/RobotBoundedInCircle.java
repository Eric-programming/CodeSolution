class Solution {
    final int UP = 0;
    final int LEFT = 1;
    final int DOWN = 2;
    final int RIGHT = 3;
    final int ORIGIN_DIRECTION = UP;
    public boolean isRobotBounded(String instructions) {
        int curDirection = ORIGIN_DIRECTION;
        int row = 0, col = 0;
        
        for(char curChar : instructions.toCharArray()){
            if(curChar == 'G'){
                if(curDirection == UP){
                    row--;
                }else if(curDirection == DOWN){
                    row++;
                }else if(curDirection == LEFT){
                    col--;
                }else if(curDirection == RIGHT){
                    col++;
                }
            }else if(curChar == 'L'){
                curDirection++;
                if(curDirection > RIGHT){
                    curDirection = UP;
                }
            }else if(curChar == 'R') {
                curDirection--;
                if(curDirection < UP){
                    curDirection = RIGHT;
                }
            }
        }
        boolean posChanged = row != 0 || col != 0;
        if(!posChanged) return true;
        if(curDirection != ORIGIN_DIRECTION) return true;
        return false;
    }
}
