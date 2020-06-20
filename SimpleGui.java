import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
public class SimpleGui{
    public static void main(String args[]){
       JFrame frame = new JFrame("David's First Frame/Window");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       frame.setSize(500,500);

       JPanel buttonPanel = new JPanel();
       JButton button1 = new JButton("Press");
       JButton button2 = new JButton("Click Me");
       JButton exitButton = new JButton("Exit");


       exitButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                System.out.println("User clicked Exit Button...exiting..."); 
                System.exit(0); 
        }  
        });  
       buttonPanel.add(button1);
       buttonPanel.add(button2);
       buttonPanel.add(exitButton);

       JPanel textFieldPanel = new JPanel();
       JLabel firstNameLabel = new JLabel("First Name");
       JTextField firstNameTextField = new JTextField("...",10);
       textFieldPanel.add(firstNameLabel);
       textFieldPanel.add(firstNameTextField);

       //JPanel panelOfPanels = new JPanel();
       //panelOfPanels.add(buttonPanel);
       //panelOfPanels.add(textFieldPanel);

       JPanel directionButtonPanel=new JPanel();
       JButton upButton = new JButton("UP");
       directionButtonPanel.add(upButton);

       frame.getContentPane().add(BorderLayout.NORTH, textFieldPanel);
       frame.getContentPane().add(BorderLayout.CENTER, directionButtonPanel);
       frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
       frame.setVisible(true);
    }
}
