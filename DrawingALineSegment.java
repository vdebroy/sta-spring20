import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class DrawingALineSegment extends JFrame {

    public void paint (Graphics g) {

        System.out.println("I was called!");
        System.out.println("-------- BEGIN ---------");
        Graphics2D g2d = (Graphics2D)g;

        //draw2DCharacter('x',g2d);
        //draw2DCharacter('v',g2d);
        //draw2DCharacter('y',g2d);

        draw2DCharacter('a',g2d, 0,50,200, 200);
        //draw2DCharacter('x',g2d,500,500);
        draw2DCharacter('v',g2d,200,200,200,200);

        g2d.drawString("Hi I'm David",200,200);
        System.out.println("-------- END ---------");

    }

    public void draw2DCharacter(char c, Graphics2D g2d, int startX, int startY, int height, int width) {

        // Compute the end x, y based on width, height
        switch (c) {
            case 'x' :
                System.out.println("Draw an X");
                g2d.drawLine(startX,startY,width,height);
                g2d.drawLine(startX,height,width,startY);                
                break;
            case 'v' :
                System.out.println("Draw a Y");
                g2d.drawLine(startX,startY,width/2,height);
                g2d.drawLine(width/2,height,width,startY);                
                break;
            case 'y' :
                g2d.drawLine(startX,startY,width/2,height/2);
                g2d.drawLine(width/2,height/2,width,startY);
                g2d.drawLine(width/2,height/2,width/2,height);
                break;
            case'a' : 
                g2d.drawLine(startX,height,width/2,startY);
                g2d.drawLine(width/2,startY,width,height);

                // How do we do the math to find out the middle of each
                // of the sides: /\
                g2d.drawLine(width/4,height/2,3*width/4,height/2);
                break;
            default :
                System.out.println("U G L Y");
        }

    }


    public void safeSleep(int milliSeconds) {
        if (milliSeconds <=0) {
            System.out.println("Doesn't make sense to go back in time or stay still...Y u do dis!");
            return;
        }

        try
        {
            Thread.sleep(milliSeconds);
        }
        catch(InterruptedException ex)
        {
            System.out.println("WHOOPS");
            Thread.currentThread().interrupt();
        } 
    }

    public void safeSleepSeconds(int numSeconds) {
        safeSleep (numSeconds * 1000);
    }

    public static void main(String args[]) {
        DrawingALineSegment frame = new DrawingALineSegment();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.out.println("Y you do dis :(");
            }
        });

        frame.setSize(600,600);
        frame.setVisible(true);
    }
}
