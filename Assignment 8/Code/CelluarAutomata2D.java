/************************************************
 * Assignment 8
 * Name:    Kenneth Cox
 * E-mail:  kecox@unm.edu
 * Course:  CS 152 - Section 00x
 * Date submitted: 9 Nov 2020   
 *
 * A program that generates 2D Cellular Automata
**************************************************/

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;

public class CelluarAutomata2D extends Canvas {

    public static final int DEAD = 0;
    public static final int ALIVE = 1;
    static int screenSize = 700;
    static int cellSize = 10;
    static int arraySize = screenSize / cellSize;
    //static AbstractAutomata gol = new GOLAutomata(arraySize);
    static AbstractAutomata gol = new LangtonAnt(arraySize, 50, 50);

    public static void main (String[] args) {


        //Creates the screen for your CA
        setupScreen(new CelluarAutomata2D(), new JFrame("Cellular Automata"));
        //CelluarAutomata2D canvas = new CelluarAutomata2D();

        // Sets the size of the screen
        // See https://docs.oracle.com/javase/9/docs/api/javafx/scene/canvas/Canvas.html    

        // Sets the background color     
        // See https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html
        //frame.setResizable(false);
        //This calls the method myMethod]
        
    }

    public static void setupScreen(CelluarAutomata2D canvas, JFrame frame){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setSize(screenSize, screenSize);
        canvas.setBackground(new Color(245, 240, 190));
        canvas.run(gol);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * This method draws things on the screen.
     * This is where you will write
     * code that diplays your CA. You do not 
     * call this method. It is called automatically.
     * A few sample drawing features are demonstrated below.
     */
    public void paint(Graphics g, AbstractAutomata cellAutomata) {
        cellAutomata.paintShapes(g, new Color(135,67, 200), new Color(255,255,255), cellSize);
    }

    /**
     * This method includes some useful
     * functionality that you will want
     * to include in your code. Feel free
     * to rename or delete this method
     */
    public void run(AbstractAutomata cellAutomata) {
        cellAutomata.allStatesDead(arraySize);
        cellAutomata.randomArrayAssignment();
        while(true){
            cellAutomata.playBack(arraySize);
            cellAutomata.sleep();
            // The repaint() method redraws your screen. 
            // You can use it to refresh your screen after 
            // you've updated your CA to its next state
            repaint();
        }      
    }

    /**
     * This method reduces flickering of the display
     * Don't change it.
     */
    public void update(Graphics g) {
        paint(g, gol);
    }
}
