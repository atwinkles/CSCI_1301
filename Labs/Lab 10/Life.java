/*
* Life.java
* Author: Alexander Winkles
* Submission Date: March 28, 2017
*
* Purpose: A Java application designed to play Conway's Game of
* Life. This utilizes the Grid.jar file given by instructors
* to indefinitely play based on the games rules.
* 
* Statement of Academic Honesty:
*
* The following code represents my own work. I have neither 
* received nor given inappropriate assistance. I have not copied
* or modified code from any source other than the course webpage
* or the course textbook. I recognize that any unauthorized
* assistance or plagiarism will be handled in accordance with
* the University of Georgia's Academic Honesty Policy and the
* policies of this course. I recognize that my work is based
* on an assignment created by the Department of Computer
* Science at the University of Georgia. Any publishing
* or posting of source code for this project is strictly
* prohibited unless you have written consent from the Department
* of Computer Science at the University of Georgia.
*/

public class Life {

    public static void main(String[] args) {

        // delcares the size of the overall grid and individual cells
        int gridSize = 200;
        int cellSize = 3;
    
        // creates a new instance of the Grid class
        Grid grid = new Grid(gridSize, cellSize, "The Game of Life");

        // sets the delay of the grid updating
        grid.setDelay(10);

        // sets the color indices for alive and dead cells
        int aliveColor = 1;
        int deadColor = 0;

        // generates an intiial grid of alive and dead cells randomly
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int r = (int)(Math.random()*100);
                if (r > 49) grid.setPos(i,j,aliveColor);
                else grid.setPos(i,j,deadColor);
            }
        }

        // creates the initial grid
        grid.initialize();

        // plays the game indefinitely, checking the neighborhood of each cell and applying game rules to update cell values
        while(true) {
            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    if (grid.getPos(i,j) == aliveColor) {
                        if (grid.matchingNeighbors(i,j,1) == 2 || grid.matchingNeighbors(i,j,1) == 3) {
                            continue;
                        }
                        else {
                            grid.setPos(i,j,deadColor);
                        }
                    }
                    else {
                        if (grid.matchingNeighbors(i,j,1) == 3) {
                            grid.setPos(i,j,aliveColor);
                        }
                        else {
                            continue;
                        }
                    }
                }
            }
        
            // updates grid after each iteration
            grid.update();
        }


    }
}
