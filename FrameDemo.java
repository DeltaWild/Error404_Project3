import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* FrameDemo.java requires no other files. */
public class FrameDemo {

  private static void searchGui() {
    // Create and set up the window.
    JFrame frame = new JFrame("Search");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // ************************************************************* */
    JTextField jTextField1 = new JTextField(""); // search box
    jTextField1.setBounds(100, 100, 200, 30);
    frame.add(jTextField1);

    JTextArea searchTextArea = new JTextArea();
    searchTextArea.setBounds(25, 200, 550, 100);
    // jScrollPane1.setViewportView(maintTextArea);
    frame.add(searchTextArea);

    JLabel jSearch1 = new JLabel("Search:");
    jSearch1.setBounds(25, 100, 200, 30);
    frame.add(jSearch1);

    JLabel jIndex1 = new JLabel("Indexed Files: 0");
    jIndex1.setBounds(225, 350, 200, 30);
    frame.add(jIndex1);

    // *************************************************************** */
    JRadioButton jButton1 = new JRadioButton("All Terms"); // radio buttons
    jButton1.setBounds(50, 150, 100, 30);
    frame.add(jButton1);

    JRadioButton jButton2 = new JRadioButton("Any Terms");
    jButton2.setBounds(150, 150, 100, 30);
    frame.add(jButton2);

    JRadioButton jButton3 = new JRadioButton("Exact Term");
    jButton3.setBounds(250, 150, 100, 30);
    frame.add(jButton3);

    ButtonGroup buttons = new ButtonGroup();
    buttons.add(jButton1);
    buttons.add(jButton2);
    buttons.add(jButton3);
    // ***************************************************************** */
    JButton a = new JButton("About"); // About button
    a.setBounds(375, 350, 100, 30);
    frame.add(a);

    a.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        aboutGui();
      }
    });
    // *************************************************************** */
    JButton b = new JButton("Maintenance"); // Maintenance button
    b.setBounds(25, 350, 150, 30);
    frame.add(b);

    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        maintenanceGui();
      }
    });
    // *********************************************************************** */
    JButton c = new JButton("Search"); // Search Button
    c.setBounds(300, 100, 100, 30);
    frame.add(c);

    c.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        searchTextArea.setText("Oops! Error 404: Not Found");
      }
    });

    // ************************************************************************ */
    JLabel emptyLabel = new JLabel("");
    emptyLabel.setPreferredSize(new Dimension(600, 400));
    frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  private static void aboutGui() {

    // Create and set up the window.
    JFrame frameAbout = new JFrame("About");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel label = new JLabel("");
    label.setPreferredSize(new Dimension(400, 400));

    label.setText(
        "<html>Developer names<br><br>Lauren Bartlett<p>SeanBrown<p>Briana McKenzie<br><br>Error404_Project3<br><br />https://github.com/DeltaWild/Error404_Project3.git"
            + "<br /><br />I don't know HTML, obviously  </html>");

    frameAbout.getContentPane().add(label, BorderLayout.CENTER);

    // Display the window.
    frameAbout.pack();
    frameAbout.setVisible(true);
  }

  private static void maintenanceGui() {
    // Create and set up the window.
    JFrame frame = new JFrame("Maintenance");
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextArea maintTextArea = new JTextArea();
    maintTextArea.setBounds(25, 75, 550, 200);
    // jScrollPane1.setViewportView(maintTextArea);
    frame.add(maintTextArea);

    // *********************************************************** */
    JButton maintRemoveFile = new JButton("Remove File"); // Remove File button
    maintRemoveFile.setBounds(400, 300, 150, 30);
    frame.add(maintRemoveFile);

    maintRemoveFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        maintTextArea.setText("403 (Forbidden)");
      }
    });
    // *************************************************************** */
    JButton maintAddFile = new JButton("Add File"); // Add File button
    maintAddFile.setBounds(25, 300, 150, 30);
    frame.add(maintAddFile);

    maintAddFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        maintTextArea.setText("404 (Not Found)");
      }
    });
    // *************************************************************** */
    JButton maintRebuild = new JButton("Rebuild Out of Date"); // Add File button
    maintRebuild.setBounds(220, 300, 150, 30);
    frame.add(maintRebuild);

    maintRebuild.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        maintTextArea.setText("401 (Unauthorized)");
      }
    });
    // *************************************************************** */

    JLabel maintLabel1 = new JLabel("Search Engine - Index Maintenance");
    maintLabel1.setBounds(100, 25, 400, 30);
    frame.add(maintLabel1);
    maintLabel1.setFont(maintLabel1.getFont().deriveFont(20.0f));

    JLabel maintLabel2 = new JLabel("Indexed Files: 0");
    maintLabel2.setBounds(225, 350, 200, 30);
    frame.add(maintLabel2);
    // *********************************************************** */

    JLabel emptyLabel = new JLabel("");
    emptyLabel.setPreferredSize(new Dimension(600, 400));
    frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

    // Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        searchGui();

      }
    });
  }
}
