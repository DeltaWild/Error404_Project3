import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* FrameDemo.java requires no other files. */
public class FrameDemo {

  private static void searchGui() {
    // Create and set up main window.
    JFrame frame = new JFrame("Search");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // ************************************************************* */
    JTextField searchBox = new JTextField(""); // search box
    searchBox.setBounds(100, 50, 350, 30);
    frame.add(searchBox);

    JTextArea searchReturn = new JTextArea(); // return text box
    searchReturn.setBounds(25, 150, 550, 150);
    // jScrollPane1.setViewportView(maintTextArea);
    frame.add(searchReturn);

    JLabel jSearch1 = new JLabel("Search:");
    jSearch1.setBounds(25, 50, 100, 30);
    frame.add(jSearch1);

    JLabel jIndex1 = new JLabel("Indexed Files: 0"); // indexed file return text
    jIndex1.setBounds(250, 350, 100, 30);
    frame.add(jIndex1);

    // *************************************************************** */
    // radio buttons

    JRadioButton aLLTermButton = new JRadioButton("All Terms");
    aLLTermButton.setBounds(112, 100, 100, 50);
    frame.add(aLLTermButton);

    JRadioButton anyTermButton = new JRadioButton("Any Terms");
    anyTermButton.setBounds(274, 100, 100, 50);
    frame.add(anyTermButton);

    JRadioButton exactTermButton = new JRadioButton("Exact Term");
    exactTermButton.setBounds(436, 100, 100, 50);
    frame.add(exactTermButton);

    ButtonGroup buttons = new ButtonGroup();
    buttons.add(aLLTermButton);
    buttons.add(anyTermButton);
    buttons.add(exactTermButton);
    // ***************************************************************** */
    JButton aboutButton = new JButton("About"); // About button
    aboutButton.setBounds(450, 350, 125, 30);
    frame.add(aboutButton);

    aboutButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        aboutGui();
      }
    });
    // *************************************************************** */
    JButton maintainButton = new JButton("Maintenance"); // Maintenance button
    maintainButton.setBounds(25, 350, 125, 30);
    frame.add(maintainButton);

    maintainButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        maintenanceGui();
      }
    });
    // *********************************************************************** */
    JButton searchButton = new JButton("Search"); // Search Button
    searchButton.setBounds(475, 50, 100, 30);
    frame.add(searchButton);

    searchButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        searchButton.setText("Oops! Error 404: Not Found");
      }
    });

    // ************************************************************************ */
    JLabel emptyLabel = new JLabel("");
    emptyLabel.setPreferredSize(new Dimension(600, 400)); // Sets main serch window size
    frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

    // Display the window.
    frame.pack();
    frame.setVisible(true);
    frame.setSize(625, 450);
    frame.setLocationRelativeTo(null); 
  }

  private static void aboutGui() { // About window

    // Create and set up the window.
    JFrame frameAbout = new JFrame("About");

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

    JTextArea maintTextArea = new JTextArea(); // Maintenance return text area
    maintTextArea.setBounds(25, 75, 550, 200);
    // jScrollPane1.setViewportView(maintTextArea);
    frame.add(maintTextArea);

    // *********************************************************** */
    JButton maintAddFile = new JButton("Add File"); // Add File button
    maintAddFile.setBounds(37, 300, 150, 30);
    frame.add(maintAddFile);

    maintAddFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        maintTextArea.setText("404 (Not Found)");
      }
    });
    // *************************************************************** */
    JButton maintRebuild = new JButton("Rebuild Out of Date"); // Rebuild button
    maintRebuild.setBounds(224, 300, 150, 30);
    frame.add(maintRebuild);

    maintRebuild.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        maintTextArea.setText("401 (Unauthorized)");
      }
    });
    // *************************************************************** */
    JButton maintRemoveFile = new JButton("Remove File"); // Remove File button
    maintRemoveFile.setBounds(411, 300, 150, 30);
    frame.add(maintRemoveFile);

    maintRemoveFile.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        maintTextArea.setText("403 (Forbidden)");
      }
    });
    // *************************************************************** */

    JLabel maintLabel1 = new JLabel("Search Engine - Index Maintenance"); // Title
    maintLabel1.setBounds(125, 25, 350, 30);
    frame.add(maintLabel1);
    maintLabel1.setFont(maintLabel1.getFont().deriveFont(20.0f));

    JLabel maintLabel2 = new JLabel("Indexed Files: 0"); // Index file count
    maintLabel2.setBounds(250, 350, 100, 30);
    frame.add(maintLabel2);
    // *********************************************************** */

    JLabel emptyLabel = new JLabel("");
    emptyLabel.setPreferredSize(new Dimension(600, 400)); // sets window size
    frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

    // Display the window.
    frame.pack();
    frame.setVisible(true);
    frame.setLocationRelativeTo(null); 
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
