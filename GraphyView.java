package graphy;

/**
 * @author Jeremy Cerise
 * @version 4/14/2011
 * 
 * This doesn't do anything yet, but you can bet it will eventually be able to
 * visualize you some datas.
 */

import java.awt.Dimension;
import javax.swing.JFrame;

public class GraphyView extends JFrame{

  public GraphyView(){
    setTitle("Graphy - Data Visualization in the Palm of Your Hand");
    setSize(800, 600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setMinimumSize(new Dimension(250,150));
  }

}
