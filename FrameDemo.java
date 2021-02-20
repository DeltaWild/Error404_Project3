 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
/* FrameDemo.java requires no other files. */
public class FrameDemo {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    
    
     private static void searchGui() {
        //Create and set up the window.
        JFrame frame = new JFrame("Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JButton a = new JButton("About");
        a.setBounds(250,350,100,30);
        frame.add(a);
         
        a.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
            aboutGui();
          }
        });

        JButton b = new JButton("Maintenance");
        b.setBounds(50,350,150,30);
        frame.add(b);

        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
             maintenanceGui();
            }
          });

        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(400, 400));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
     

    private static void aboutGui() {
        
              
        
        //Create and set up the window.
        JFrame frameAbout = new JFrame("About");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JLabel label = new JLabel("");
        label.setPreferredSize(new Dimension(400, 400));
        label.setText("<html>     Search Engine 1.0<br>     Error404_Project3<br>     I don't know HTML  </html>");
        frameAbout.getContentPane().add(label, BorderLayout.CENTER);

        //Display the window.
        frameAbout.pack();
        frameAbout.setVisible(true);
    }
 



    private static void maintenanceGui() {
        //Create and set up the window.
        JFrame frame = new JFrame("Maintenance");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(400, 400));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                searchGui();
                //aboutGui();
               
                
            }
        });
    }
}

