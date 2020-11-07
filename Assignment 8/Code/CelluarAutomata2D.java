/************************************************
 * Assignment 8
 * Name:    Kennet Cox
 * E-mail:  kecox@unm.edu
 * Course:  CS 152 - Section 00x
 * Date submitted:    
 *
 * A program that generates 2D Cellular Automata
**************************************************/

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color; 
import java.util.Random;

public class CelluarAutomata2D extends Canvas {

    public static final int DEAD = 0;
    public static final int ALIVE = 1;
    static int screenSize = 700;
    static int cellSize = 10;
    static int arraySize = screenSize / cellSize;
    static int[][] currentStates = new int[arraySize][arraySize];
    static int[][] newStates = new int[arraySize][arraySize];

    public static void main (String[] args) {

        //Creates the screen for your CA
        JFrame frame = new JFrame("Cellular Automata"); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CelluarAutomata2D canvas = new CelluarAutomata2D();

        // Sets the size of the screen
        // See https://docs.oracle.com/javase/9/docs/api/javafx/scene/canvas/Canvas.html
        canvas.setSize(screenSize, screenSize);       

        // Sets the background color     
        // See https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
        canvas.setBackground(new Color(245, 240, 190));
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        //frame.setResizable(false);
        canvas.myMethod();  //This calls the method myMethod]
        
    }

    int gameOfLifeRules(int row, int column){
    	int neighborSums = currentStates[row-1][column - 1] + 
        currentStates[row-1][column] + 
        currentStates[row-1][column + 1] + 
        currentStates[row][column - 1] + 
        currentStates[row][column + 1] + 
        currentStates[row + 1][column-1] + 
        currentStates[row+1][column] + 
        currentStates[row+1][column+1];
        
        if( (neighborSums == 2 || neighborSums == 3) && currentStates[row][column] == ALIVE){ 
            return ALIVE; 
        }
        else if(currentStates[row][column] == DEAD && neighborSums == 3){ 
            return ALIVE; 
        }
        return DEAD;
    }

    /**
     * This method draws things on the screen.
     * This is where you will write
     * code that diplays your CA. You do not 
     * call this method. It is called automatically.
     * A few sample drawing features are demonstrated below.
     */
    public void paint(Graphics g) {
        Color aliveColor = new Color(135,67, 200);
        Color deadColor = new Color(255, 255, 255);
        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j<arraySize; j++) {
                if(currentStates[i][j] == ALIVE){
                    g.setColor(aliveColor);
                    g.fillRect(j*cellSize, i*cellSize, cellSize-1, cellSize-1);
                }
                else{
                    g.setColor(deadColor);
                    g.fillRect(j*cellSize, i*cellSize, cellSize-1, cellSize-1);
                }
            }
        }
    }

    /**
     * This method includes some useful
     * functionality that you will want
     * to include in your code. Feel free
     * to rename or delete this method
     */
    public void myMethod() {
        allStatesDead();
        currentStates[arraySize/2 - 1][arraySize/2] = ALIVE;
        currentStates[arraySize/2][arraySize/2] = ALIVE;
        currentStates[arraySize/2 + 1][arraySize/2] = ALIVE;

        randomArrayAssignment();

        while(true){
            playGame();
            sleep();
            // The repaint() method redraws your screen. 
            // You can use it to refresh your screen after 
            // you've updated your CA to its next state
            repaint();
        }      
    }
    
    public void playGame(){
        for(int i = 1; i < arraySize - 1; i++){
            for(int j = 1; j < arraySize - 1; j++){
                newStates[i][j] = gameOfLifeRules(i,j);
            }
        }

        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j<arraySize; j++){
                currentStates[i][j] = newStates[i][j];
            }
        }
        
    }

    public void randomArrayAssignment(){
        for(int i = 0; i < 600; i++){
            int randRow = new Random().nextInt(arraySize);
            int randCol = new Random().nextInt(arraySize);
            if(currentStates[randRow][randCol] != ALIVE){
                currentStates[randRow][randCol] = ALIVE;
            }
        }
    }

    public void allStatesDead(){
        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j < arraySize; j++){
                currentStates[i][j] = DEAD;
            }
        }
    }

    public static void sleep(){
        // This block of code pauses the 
        // program for 500ms (1/2 of a second)
        // It will be useful for animating your CA
        try{ Thread.sleep(500); }
        catch(Exception exc){}
    }

    /**
     * This method reduces flickering of the display
     * Don't change it.
     */
    public void update(Graphics g) {
        paint(g);
    }
}
