package Companies.google;

/**
 * you are controlling a robot that is located somewhere in a room. 
 * The room is modeled as an m x n binary grid where 0 represents a wall and 1 represents an empty slot.
 * 
 * The robot starts at an unknown location in the room that is guaranteed to be empty,
 * and you do not have access to the grid, but you can move the robot using the given API Robot.
 * 
 * You are tasked to use the robot to clean the entire room (i.e., clean every empty cell in the room).
 * the robot with the four given APIs can move forward, turn left, or turn right. Each turn is 90 degrees.
 * 
 * When the robot tries to move into a wall cell, its bumper sensor detects the obstacle, and it stays on the current cell.
 * 
 * Design an algorithm to clean the entire room using the following APIs:
 * 
 * Note that the initial direction of the robot will be facing up.
 * You can assume all four edges of the grid are all surrounded by a wall.
 */

import java.util.HashSet;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current
    // cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();

    public void turnRight();

    // Clean the current cell.
    public void clean();
}

public class RobotRoomCleaner {
    int[][] dirs = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    HashSet<String> visited;

    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        exploreDfs(robot, 0, 0, 0);
    }

    private void exploreDfs(Robot robot, int row, int col, int currDir) {
        robot.clean();
        visited.add(row + "," + col);

        for (int i = 0; i < 4; i++) {
            int newDir = (currDir + i) % 4;
            int newRow = row + dirs[newDir][0];
            int newCol = col + dirs[newDir][1];

            if (visited.add(newRow + "," + newCol) && robot.move()) {
                exploreDfs(robot, newRow, newCol, newDir);
                goBack(robot);
            }

            robot.turnRight();
        }

    }

    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
