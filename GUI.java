/*
  ______ __  __          __  __ ________   _____   ___
 |  ____|  \/  |   /\   |  \/  |  ____\ \ / / _ \ / _ \
 | |__  | \  / |  /  \  | \  / | |__   \ V / (_) | (_) |
 |  __| | |\/| | / /\ \ | |\/| |  __|   > < \__, |> _ <
 | |____| |  | |/ ____ \| |  | | |____ / . \  / /| (_) |
 |______|_|  |_/_/    \_\_|  |_|______/_/ \_\/_/  \___/

Emanuel Estrada Larios - A01633605
*/

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
