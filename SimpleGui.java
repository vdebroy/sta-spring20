import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
public class SimpleGui implements KeyListener{

    public static void main(String args[]){

       SimpleGui sg = new SimpleGui();

       JFrame frame = new JFrame("David's First Frame/Window");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       frame.setSize(500,500);

       JPanel buttonPanel = new JPanel();
       JButton button1 = new JButton("Press");
       //
       
       // The first kind of constructor (no parameters)
       //JButton button2 = new JButton();
       // Example of JButton(String text)
       JButton button2 = new JButton("Click Me");


       JButton exitButton = new JButton("Exit");


       exitButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                System.out.println("User clicked Exit Button...exiting..."); 
                button2.setText("Text Changed!");
                System.exit(0); 
        }  
        }); 
        
        
       buttonPanel.add(button1);
       buttonPanel.add(button2);
       buttonPanel.add(exitButton);

       JPanel textPanel = new JPanel();
       JLabel outputLabel = new JLabel("Output");

       //JTextArea outputTextArea = new JTextArea(5,30);
       JTextArea outputTextArea = new JTextArea();
       outputTextArea.addKeyListener(sg);
       //outputTextArea = new JTextArea();
       JScrollPane areaScrollPane = new JScrollPane(outputTextArea); 
       areaScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(300, 100));       
       textPanel.add(outputLabel);
       textPanel.add(areaScrollPane);

       JPanel directionButtonPanel=new JPanel();
       JButton upButton = new JButton("UP");
       JButton downButton = new JButton("DOWN");
       JButton leftButton = new JButton("LEFT");
       JButton rightButton = new JButton("RIGHT");

       upButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){ 
                writeOutput("UP",outputTextArea);
        }  
        });
        downButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    writeOutput("DOWN",outputTextArea);
        }  
        });
        leftButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                writeOutput("LEFT",outputTextArea);
        }  
        });
        rightButton.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                writeOutput("RIGHT",outputTextArea);
        }  
        });

       directionButtonPanel.add(upButton);
       directionButtonPanel.add(downButton);
       directionButtonPanel.add(leftButton);
       directionButtonPanel.add(rightButton);

       frame.getContentPane().add(BorderLayout.NORTH, textPanel);
       frame.getContentPane().add(BorderLayout.CENTER, directionButtonPanel);
       frame.getContentPane().add(BorderLayout.SOUTH, buttonPanel);
       frame.setVisible(true);
    }

    public static void writeOutput(String direction, JTextArea area) {
        String message = "User selected: " + direction + "\n";
        System.out.print(message); 
        area.append(message);
    }

    public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");
    }

    public void keyPressed(KeyEvent e) {
        displayInfo(e, "KEY PRESSED: ");
    }

    public void keyReleased(KeyEvent e) {
        displayInfo(e, "KEY RELEASED: ");
    }
    
    private void displayInfo(KeyEvent e, String keyStatus){
        
        //You should only rely on the key char if the event
        //is a key typed event.
        int id = e.getID();
        String keyString;
        if (id == KeyEvent.KEY_TYPED) {
            char c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        } else {
            int keyCode = e.getKeyCode();
            keyString = "key code = " + keyCode
                    + " ("
                    + KeyEvent.getKeyText(keyCode)
                    + ")";
        }
        
        int modifiersEx = e.getModifiersEx();
        String modString = "extended modifiers = " + modifiersEx;
        String tmpString = KeyEvent.getModifiersExText(modifiersEx);
        if (tmpString.length() > 0) {
            modString += " (" + tmpString + ")";
        } else {
            modString += " (no extended modifiers)";
        }
        
        String actionString = "action key? ";
        if (e.isActionKey()) {
            actionString += "YES";
        } else {
            actionString += "NO";
        }
        
        String locationString = "key location: ";
        int location = e.getKeyLocation();
        if (location == KeyEvent.KEY_LOCATION_STANDARD) {
            locationString += "standard";
        } else if (location == KeyEvent.KEY_LOCATION_LEFT) {
            locationString += "left";
        } else if (location == KeyEvent.KEY_LOCATION_RIGHT) {
            locationString += "right";
        } else if (location == KeyEvent.KEY_LOCATION_NUMPAD) {
            locationString += "numpad";
        } else { // (location == KeyEvent.KEY_LOCATION_UNKNOWN)
            locationString += "unknown";
        }
    
    }    
}
