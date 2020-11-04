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

        g.fillRect(200, 100, 100, 100);
        Color c = new Color(200,0,200); 
        g.setColor(c);
        g.fillOval(299,200,100,100);
    }

    /**
     * This method includes some useful
     * functionality that you will want
     * to include in your code. Feel free
     * to rename or delete this method
     */
    public void myMethod () {

        for(var arrays : currentStates){
            for(var current : arrays){
                current = DEAD;
            }
        }

        currentStates[arraySize/2 - 1][arraySize] = ALIVE;
        currentStates[arraySize/2][arraySize] = ALIVE;
        currentStates[arraySize/2 + 1][arraySize] = ALIVE;

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

    /**
     * This method reduces flickering of the display
     * Don't change it.
     */
    public void update(Graphics g) {
        for(var arrays : currentStates){
            for(var current : arrays){
                Color aliveColor = new Color(135,67, 200);
                Color deadColor = new Color(WHITE);

                if(current == ALIVE){
                    g.setColor(aliveColor);
                }
                else{
                    g.setColor(deadColor);
                }

            }
        }
        paint(g);
    }
}
