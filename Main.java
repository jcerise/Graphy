/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphy;

/**
 *
 * @author jeremy
 */

import javax.swing.SwingUtilities;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          GraphyView graphy = new GraphyView();
          GraphyPanel graphPanel = new GraphyPanel();
          graphy.add(graphPanel);
          graphy.setVisible(true);
        }
      });
    }

}
