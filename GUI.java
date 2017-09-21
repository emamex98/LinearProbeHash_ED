import javax.swing.*;
import java.awt.*;

class GUI extends JFrame{

  public GUI(){
    super("Linear Probe Hash");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setSize(600,450);

    PersonFinder mainPanel = new PersonFinder();
    this.add(mainPanel, BorderLayout.NORTH);

    this.setVisible(true);
  }

  public static void main(String[] args) {
    GUI newGUI = new GUI();
  }

}
