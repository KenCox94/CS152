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

public class Assignment8 extends Canvas {

    public static void main (String[] args) {

        //Creates the screen for your CA
        JFrame frame = new JFrame("Cellular Automata"); //give screen a name
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Assignment8 canvas = new Assignment8();

        // Sets the size of the screen
        // See https://docs.oracle.com/javase/9/docs/api/javafx/scene/canvas/Canvas.html
        canvas.setSize(700, 700);       
    

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

        g.fillRect(200, 100, 10, 10);
        Color c = new Color(200,0,200); 
        g.setColor(c);
        g.fillOval(299,200,10,10);
    }

    /**
     * This method includes some useful
     * functionality that you will want
     * to include in your code. Feel free
     * to rename or delete this method
     */
    public void myMethod () {
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
        paint(g);
    }
}
