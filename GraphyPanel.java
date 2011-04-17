package graphy;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
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

    private int xScaleMin;
    private int xScaleMax;
    private int yScaleMin;
    private int yScaleMax;
    private long yCeiling;
    private ArrayList<GraphLabel> yAxisLabels;
    private ArrayList<Line2D> yAxisStartIntervals;
    private static final int WINDOW_OFFSET_X = 40;
    private static final int WINDOW_OFFSET_Y = 40;
    private static final int INTERVAL_WIDTH = 10;

    public GraphyPanel() {
        xScaleMin = 0;
        xScaleMax = 100;
        yScaleMin = 0;
        yScaleMax = 100;

        //Add ten percent to teh max y scale, to make sure all data is displayed
        yCeiling = Math.round(yScaleMax * .10);
        yScaleMax += yCeiling;
        System.out.println("Adding 10% ("+yCeiling+") to yScaleMax. New max y scale is: "+yScaleMax );
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        FontMetrics metrics = g2.getFontMetrics();

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

        setYScale(yAxisHeight, yAxisStart);

        //Grab an array of all intervals along the y axis and draw them out
        for(Line2D line : yAxisStartIntervals){
            g2.draw(line);
        }

        for(GraphLabel label : yAxisLabels){
            //We need to check the width of the current label, to ensure we
            //display it in the rigth position next to the graph
            System.out.println("Processing labels: width of current label = " + metrics.stringWidth(label.getLabelText()));
            int offset = metrics.stringWidth(label.getLabelText());
            g2.drawString(label.getLabelText(), label.getxPosition() - offset, label.getyPosition());
        }
        
    }

    /**
     * Creates an array of all interval lines along the y axis of the graph. The
     * number of intervals is dynamically resized to accommodate changes to the
     * size of the display area. Also figures out the numeric interval width
     * based off of the current window size and updates the interval values
     * accordingly.
     *
     * @param yAxisHeight The actual height of the y axis
     * @param yAxisStart The point in the window where the y axis begins
     * @return An array of Line objects that represent y axis intervals
     */
    private void setYScale(int yAxisHeight, int yAxisStart){
        yAxisStartIntervals = new ArrayList();
        yAxisLabels = new ArrayList();

        int intervalXStart = WINDOW_OFFSET_X - INTERVAL_WIDTH/2;
        int intervalXEnd = WINDOW_OFFSET_X + INTERVAL_WIDTH/2;

        int tempYScale = yScaleMax;

        //Check the interval to height ratio - If its greater than 10, no
        //changes need be made.
        float intervalSpace = (float)yAxisHeight/(float)yScaleMax;

        //Check to see if there are more interval lines than the total height
        //of our current y axis. If there are, divide by two until we can
        //display them all a reasonable distance apart.
        while (intervalSpace < 15.0){
            System.out.println("range too large; intervalSpace="+intervalSpace+", yScale="+tempYScale);
            tempYScale = tempYScale/2;
            intervalSpace = (float)yAxisHeight/(float)tempYScale;
        }

        System.out.println("Total intervals present: " + tempYScale);
        System.out.println("Numeric Interval Height: " + yScaleMax/tempYScale);

        int numericSpacing = yScaleMax/tempYScale;

        //Set the initial amount from 0 to put the first interval line
        float increase = intervalSpace;
        float numericIncrease = numericSpacing;

        for (int i = yScaleMin; i < tempYScale; i++){
            //Add an interval line at the correct position along the y axis
            Line2D line = new Line2D.Float(intervalXStart, yAxisStart - increase,
                    intervalXEnd, yAxisStart - increase);
            //Add a label next to the previously added interval line with the
            //correct numeric value
            GraphLabel intervalLabel = new GraphLabel(Float.toString(yScaleMin + numericIncrease),
                    intervalXStart, yAxisStart - increase + 4);
            //Add both the line and the label to be drawn
            yAxisStartIntervals.add(line);
            yAxisLabels.add(intervalLabel);

            increase += intervalSpace;
            numericIncrease += numericSpacing;
        }
    }
}
