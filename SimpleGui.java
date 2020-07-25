import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.net.URL;
public class SimpleGui {

    public static void main(String args[]){

       JTextArea outputTextArea = new JTextArea();
       SimpleGui sg = new SimpleGui();

       JFrame frame = new JFrame("David's First Frame/Window");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       frame.setSize(500,500);

       KeyListener listener = new KeyListener() {
        @Override
        public void keyPressed(KeyEvent event) {
            //printEventInfo("Key Pressed", event);
        }
        @Override
        public void keyReleased(KeyEvent event) {
            printEventInfo("Key Released", event);
        }
        @Override
        public void keyTyped(KeyEvent event) {
            //printEventInfo("Key Typed", event);
        }
        private void printEventInfo(String str, KeyEvent e) {
            //System.out.println(str);
            int code = e.getKeyCode();
            String getKeyText = KeyEvent.getKeyText(code);
            //System.out.println("   Code: " + KeyEvent.getKeyText(code));

            if (getKeyText == "Up") {
                writeOutput("UP",outputTextArea);

            }else if (getKeyText == "Down") {
                writeOutput("DOWN",outputTextArea);
            }else if (getKeyText == "Left") {
                writeOutput("LEFT",outputTextArea);
            }else if (getKeyText == "Right") {
                writeOutput("RIGHT",outputTextArea);

            }else {
                System.out.println("Invalid key press");
            }

            /*
            System.out.println("   Char: " + e.getKeyChar());
            int mods = e.getModifiersEx();
            System.out.println("    Mods: "
                    + KeyEvent.getModifiersExText(mods));
            System.out.println("    Location: "
                    + keyboardLocation(e.getKeyLocation()));
            System.out.println("    Action? " + e.isActionKey());
            */
        }
        private String keyboardLocation(int keybrd) {
            switch (keybrd) {
                case KeyEvent.KEY_LOCATION_RIGHT:
                    return "Right";
                case KeyEvent.KEY_LOCATION_LEFT:
                    return "Left";
                case KeyEvent.KEY_LOCATION_NUMPAD:
                    return "NumPad";
                case KeyEvent.KEY_LOCATION_STANDARD:
                    return "Standard";
                case KeyEvent.KEY_LOCATION_UNKNOWN:
                default:
                    return "Unknown";
            }
        }
    };


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
       //JTextArea outputTextArea = new JTextArea();
       // How do we get to listen to keypresses anywhere in the frame?
       outputTextArea.addKeyListener(listener);
       //outputTextArea = new JTextArea();
       JScrollPane areaScrollPane = new JScrollPane(outputTextArea); 
       areaScrollPane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(300, 100));       
       textPanel.add(outputLabel);
       textPanel.add(areaScrollPane);

       JPanel directionButtonPanel=new JPanel();

       ImageIcon upIcon = new ImageIcon("icons8-up-24.png");

       JButton upButton = new JButton("UP", upIcon);


       URL downIconUrl = null;
       try {
            downIconUrl = new URL("https://raw.githubusercontent.com/vdebroy/sta-spring20/master/icons8-down-arrow-25.png");
       } catch (Exception ex) {
           System.out.println("WHOOPS");
       }
       ImageIcon downIcon = new ImageIcon(downIconUrl);
       JButton downButton = new JButton("DOWN",downIcon);
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

       JPanel gridPanel = new JPanel();
       JLabel colLabel1 = new JLabel("1");
       JLabel colLabel2 = new JLabel("2");
       gridPanel.add(colLabel1);
       gridPanel.add(colLabel2);


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
 
}
