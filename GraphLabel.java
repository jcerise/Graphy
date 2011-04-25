
package graphy;

/**
 * @author Jeremy Cerise
 * @version 4/16/11
 *
 * A GraphLabel represents a piece of text that is displayed on on a Graph. It
 * contains an x and y coordinate, and the string to draw at those coordinates.
 */
public class GraphLabel {

    private String labelText;
    private float xPosition;
    private float yPosition;

    public GraphLabel(String labelText, float xPosition, float yPosition){
        this.labelText = labelText;
        
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public void setxPosition(float xPosition) {
        this.xPosition = xPosition;
    }

    public void setyPosition(float yPosition) {
        this.yPosition = yPosition;
    }

    public String getLabelText() {
        return labelText;
    }

    public float getxPosition() {
        return xPosition;
    }

    public float getyPosition() {
        return yPosition;
    }
}