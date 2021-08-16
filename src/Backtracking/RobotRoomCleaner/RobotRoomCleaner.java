/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    //Up, Right, Down, Left
    final int[][] DIRECTIONS = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    Set<String> visited = new HashSet<>();
    public void cleanRoom(Robot robot) {
        dfs(0, 0, robot, 0);
    }
    private void dfs(int row, int col, Robot robot, int arrow){
        String key = row + "," + col;
        
        if(!visited.contains(key)){
            visited.add(key);
        
            robot.clean();

            for(int i = 0; i < 4; i++){
                if(robot.move()){
                    int[] curDirection = DIRECTIONS[arrow];
                    dfs(row + curDirection[0], col + curDirection[1], robot, arrow);
                }
                //Change robot direction and arrow
                robot.turnRight();//turn clock wise
                arrow = (arrow + 1) % 4;
            }
        }
        //Move Back
        moveBack(robot);
    }
    private void moveBack(Robot robot){
        //Turn 180 degree back
        robot.turnLeft();
        robot.turnLeft();
        
        robot.move();
        
        //Turn back the original direction
        robot.turnRight();
        robot.turnRight();
    }
}
