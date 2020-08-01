import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class DrawingALineSegment extends JFrame {

    public void paint (Graphics g) {

        System.out.println("I was called!");
        System.out.println("-------- BEGIN ---------");
        Graphics2D g2d = (Graphics2D)g;

        g2d.drawLine(0,0,500,500);

        safeSleep(1);

        g2d.drawLine(0,500,500,0);  

        g2d.drawRect(25,55,100,50);

        g2d.fillOval(50,80,100,50);

        g2d.drawString("Hi I'm David",200,200);
        System.out.println("-------- END ---------");

        // How would you write DAVID
        // D A V I D
        // A is doable...we just did diagonals
        // V is doable for same reason
        // I also
        // D.....we need a half circle...an oval



    }

    public void safeSleep(int numSeconds) {
        if (numSeconds <=0) {
            System.out.println("Doesn't make sense to go back in time or stay still...Y u do dis!");
            return;
        }

        try
        {
            Thread.sleep(numSeconds * 1000);
        }
        catch(InterruptedException ex)
        {
            System.out.println("WHOOPS");
            Thread.currentThread().interrupt();
        } 
    }

    public static void main(String args[]) {
        DrawingALineSegment frame = new DrawingALineSegment();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.out.println("Y you do dis :(");
            }
        });

        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
