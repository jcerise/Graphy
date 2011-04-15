package graphy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Jeremy Cerise
 * @version 4/14/2011
 *
 * The main drawing panel where the graphs are displayed. Trying to keep all
 * non-drawing logic out of this class.
 */
public class GraphyPanel extends JPanel {

    int xScaleMin;
    int xScaleMax;
    int yScaleMin;
    int yScaleMax;
    private static final int WINDOW_OFFSET_X = 40;
    private static final int WINDOW_OFFSET_Y = 40;
    private static final int INTERVAL_WIDTH = 10;

    public GraphyPanel() {
        xScaleMin = 0;
        xScaleMax = 100;
        yScaleMin = 0;
        yScaleMax = 500000000;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.BLACK);

        //Get the size of the current active window
        Dimension size = getSize();
        System.out.println("Height="+size.getHeight()+", yScale="+yScaleMax);
        Insets insets = getInsets();

        int width = size.width - insets.left - insets.right;
        int height = size.height - insets.top - insets.bottom;

        int yAxisStart = height - WINDOW_OFFSET_Y;
        int xAxisStart = width - WINDOW_OFFSET_X;
        int yAxisHeight = yAxisStart - 40;

        //Draw the initial Axes. These will always remain the same scale, and
        //will automatically resize as the window grows or shrinks.
        g2.drawLine(WINDOW_OFFSET_X, WINDOW_OFFSET_Y, WINDOW_OFFSET_X, yAxisStart);
        g2.drawLine(WINDOW_OFFSET_X, yAxisStart, xAxisStart, yAxisStart);

        //Grab an array of all intervals along the y axis and draw them out
        ArrayList<Line2D> yIntervals = setYScale(yAxisHeight, yAxisStart);
        for(Line2D line : yIntervals){
            g2.draw(line);
        }
        
    }

    /**
     * Creates an array of all interval lines along the y axis of the graph. The
     * number of intervals is dynamically resized to accommodate changes to the
     * size of the display area.
     *
     * @param yAxisHeight The actual height of the y axis
     * @param yAxisStart The point in the window where the y axis begins
     * @return An array of Line objects that represent y axis intervals
     */
    private ArrayList setYScale(int yAxisHeight, int yAxisStart){
        ArrayList<Line2D> yAxisStartIntervals = new ArrayList<Line2D>();

        int intervalXStart = WINDOW_OFFSET_X - INTERVAL_WIDTH/2;
        int intervalXEnd = WINDOW_OFFSET_X + INTERVAL_WIDTH/2;

        int tempYScale = yScaleMax;

        //Check the interval to height ratio - If its greater than 10, no
        //changes need be made.
        float intervalSpace = (float)yAxisHeight/(float)yScaleMax;

        //Check to see if there are more interval lines than the total height
        //of our current y axis. If there are, divide by two until we can
        //display them all a reasonable distance apart.
        while (intervalSpace < 10.0){
            System.out.println("range too large; intervalSpace="+intervalSpace+", yScale="+tempYScale);
            tempYScale = tempYScale/2;
            intervalSpace = (float)yAxisHeight/(float)tempYScale;
        }

        //Set the initial amount from 0 to put the first interval line
        float increase = intervalSpace;

        for (int i = yScaleMin; i < tempYScale; i++){
            Line2D line = new Line2D.Float(intervalXStart, yAxisStart - increase, intervalXEnd, yAxisStart - increase);
            yAxisStartIntervals.add(line);
            increase += intervalSpace;
        }
        
        return yAxisStartIntervals;
    }
}
