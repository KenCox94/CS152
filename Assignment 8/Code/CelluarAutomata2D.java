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

    
    final int DEAD = 0;
    final int ALIVE = 1;
    static int screenSize = 700;
    static int cellSize = 10;
    static int arraySize = screenSize / cellSize;
    int[][] currentStates = new int[arraySize][arraySize];
    int[][] newStates = new int[arraySize][arraySize];

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
        canvas.setBackground(Color.white);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

        canvas.myMethod();  //This calls the method myMethod
    }

    public int gameOfLifeRules(int row, int column){
    	return -1;
    }

    /**
     * This method draws things on the screen.
     * This is where you will write
     * code that diplays your CA. You do not 
     * call this method. It is called automatically.
     * A few sample drawing features are demonstrated below.
     */
    public void paint(Graphics g) {
        // Sets the fill color to be red
        // See https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
  
        g.setColor(Color.red);

        // Draws a filled rectangle at position x, y with width w and heigh h:
        // g.fillRect(x, y, w, h);
        // See https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics.html 
        // for more drawing features

        for(int i = 0; i < arraySize; i++){
            for(int j = 0; j<arraySize; j++) {
                Color aliveColor = new Color(135,67, 200);
                Color deadColor = new Color(255, 255, 255);

                if(currentStates[i][j]== ALIVE){
                    g.setColor(aliveColor);
                    g.fillRect(j*cellSize, i*cellSize, cellSize-1, cellSize-1);
                }
                else{
                    g.setColor(deadColor);
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
    public static void myMethod () {

        for(var arrays : currentStates){
            for(var current : arrays){
                current = DEAD;
            }
        }

        currentStates[arraySize/2 - 1][arraySize/2] = ALIVE;
        currentStates[arraySize/2][arraySize/2] = ALIVE;
        currentStates[arraySize/2 + 1][arraySize/2] = ALIVE;

        // This block of code pauses the 
        // program for 500ms (1/2 of a second)
        // It will be useful for animating your CA
        try{
            Thread.sleep(500);
        } 
        catch (Exception exc){}

        // The repaint() method redraws your screen. 
        // You can use it to refresh your screen after 
        // you've updated your CA to its next state
        repaint();      
    }

    public static void fillAllCellsToEmpty(){
    	//

    }

    public void assignRandomCellsAlive(int[][] multiDimArray, int iters){
    	for(int i = 0; i < iters; i++){

    		int randRow = new Random().nextInt(cellSize);
    		int randCol = new Random().nextInt(cellSize);

    		if(multiDimArray[randRow][randCol] != ALIVE){
    			multiDimArray[randRow][randCol] = ALIVE;
    		}
    		else{
    			continue; 
    		}
    	}
    }

    public static void calculateNextStates(){

    }

    /**
     * This method reduces flickering of the display
     * Don't change it.
     */
    public void update(Graphics g) {
        paint(g);
    }
}