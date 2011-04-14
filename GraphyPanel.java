package graphy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;

import javax.swing.JPanel;

/**
 * @author Jeremy Cerise
 * @version 4/14/2011
 *
 * The main drawing panel where the graphs are displayed
 */
public class GraphyPanel extends JPanel {

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    Graphics2D g2d = (Graphics2D) g;

    g2d.setColor(Color.BLUE);

    for (int i = 0; i <= 100; i++) {
      Dimension size = getSize();
      Insets insets = getInsets();

      int w = size.width - insets.left - insets.right;
      int h = size.height - insets.top - insets.bottom;

      Random r = new Random();
      int x = Math.abs(r.nextInt()) % w;
      int y = Math.abs(r.nextInt()) % h;
      int circum = r.nextInt(200);
      g2d.drawOval(x, y, circum, circum);
    }
  }
}
