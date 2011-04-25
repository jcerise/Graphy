
package reporter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * @author Jeremy Cerise
 * @version 4/20/11
 *
 * This panel displays all the log information that is sent from ReporterConsole.
 * All of the information is color coded to make it easier to pick out certain
 * pieces of information faster.
 */
public class InfoPanel extends JPanel {

    ArrayList<LogItem> logItems;

    public InfoPanel(){
        logItems = new ArrayList<LogItem>();
        LogItem firstItem = new LogItem("Reporter System", "Welcome to Reporter!", 0);
        logItems.add(firstItem);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int yOffset = 15;
        String logMessage = "";

        for(LogItem item : logItems){
            switch(item.getType()){
                case 1:
                    g2.setColor(new Color(0,34,170));
                    logMessage = "[DEBUG]";
                    break;
                case 2:
                    g2.setColor(new Color(0,170,0));
                    logMessage = "[INFO]";
                    break;
                case 3:
                    g2.setColor(new Color(255,117,0));
                    logMessage = "[ERROR]";
                    break;
                case 4:
                    g2.setColor(new Color(204,119,0));
                    logMessage = "[WARN]";
                    break;
                default:
                    g2.setColor(Color.BLACK);
                    logMessage = "[REPORTER]";
            }
            logMessage += "(" + item.getTag() + ") " + item.getMessage();
            g2.drawString(logMessage, 5, yOffset);
            yOffset += 15;
            //Update the size of the panel so the scrollbars will function
            //correctly
            setPreferredSize(new Dimension(500, yOffset));
        }
    }

    /**
     * Add a new logItem to the panel, and then redraw the panel so it shows
     * @param item The LogItem to add to the panel
     */
    public void appendToLogItems(LogItem item) {
        logItems.add(item);
        repaint();
    }

    /**
     * Clears out all entries in the panel and redraws the panel
     */
    public void clearLog(){
        logItems.clear();
        repaint();

    }

    public ArrayList<LogItem> getLogItems() {
        return logItems;
    }
    

}
