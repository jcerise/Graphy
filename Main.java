/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphy;

/**
 *
 * @author Jeremy Cerise
 * @version 4/14/2011
 *
 * Graphy is a small, lightweight, data visulization utility that allows you to
 * quickly import a datasource, and then display and animate the resulting
 * graphs in a clean, easy to understand format.
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
