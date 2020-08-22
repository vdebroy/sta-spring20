import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class DavidPaintProgram extends JFrame implements MouseListener, MouseMotionListener{

    int previousX;
    int previousY;
    int currentX;
    int currentY;

    public void paint (Graphics g) {
        System.out.println("-------- BEGIN ---------");;

        Graphics2D g2d = (Graphics2D)g;
        Color backgroundColor = g2d.getBackground();

        Color ourColor = new Color(100,200,50);
        //g2d.setBackground(ourColor);
        g2d.setColor(ourColor);

        //System.out.println("Background Color is: " + backgroundColor.toString());
        //g2d.fill3DRect(50, 50, 100,  200, true);
        //g2d.drawRoundRect(50,50,100,100,20,20);

        if (previousX !=0 && currentX!=0) 
            g2d.drawLine(previousX,previousY,currentX,currentY); 
        previousX = currentX;
        previousY=currentY;
        System.out.println("-------- END ---------");

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

    /*
    public String toString() {
        return "Heyyya - this is our toString method";
    }
    */

    public DavidPaintProgram() {
        System.out.println("Default constructor called");
        addMouseListener(this);
        addMouseMotionListener(this);

        previousX = previousY = currentX = currentY = 0;
    }
    public static void main(String args[]) {
        DavidPaintProgram dpp = new DavidPaintProgram();

        System.out.println(dpp.toString());
        dpp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dpp.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.out.println("Y you do dis :(");
            }
        });

        // Our drawing Panel
        JPanel drawingPanel = new JPanel();

        dpp.getContentPane().add(BorderLayout.NORTH, drawingPanel);

        dpp.setSize(600,600);
        dpp.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent event) {
        System.out.println("Mouse was clicked");
   
        // relative to component
        Point p1 = event.getPoint();
        System.out.println(p1.toString());

        currentX = (int)(p1.getX());
        currentY = (int)(p1.getY());

        repaint();
    }
 
    @Override
    public void mouseEntered(MouseEvent event) {
        System.out.println("Mouse entered");
    }
    @Override
    public void mouseExited(MouseEvent event) {
        System.out.println("Mouse exited");
    }
    @Override
    public void mousePressed(MouseEvent event) {
        //System.out.println("Mouse was pressed");
    }
    @Override
    public void mouseReleased(MouseEvent event) {
        System.out.println("Mouse was released");
    }
    @Override
    public void mouseDragged(MouseEvent event) {
        System.out.println("Mouse was dragged");
    }
    @Override
    public void mouseMoved(MouseEvent event) {
        //System.out.println("Mouse was moved");

        Point p1 = event.getPoint();
        System.out.println(p1.toString());

        currentX = (int)(p1.getX());
        currentY = (int)(p1.getY());

        repaint();
    }
}
