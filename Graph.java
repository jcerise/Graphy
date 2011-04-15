
package graphy;

import java.util.ArrayList;

/**
 * @author Jeremy Cerise
 * @version 4/14/2011
 *
 * A graph object, this is a data representation of the graph that will be drawn
 * and animated on the main screen. It contains all the data necessary to create
 * a new graphical representation of supplied data.
 */

public class Graph {

  int xScaleMax;
  int yScaleMax;
  int xScaleMin;
  int yScaleMin;
  int xRange;
  int yRange;
  ArrayList points;
  ArrayList<String> axes;
  String graphType;

  public void Graph(int xScaleMin, int yScaleMin, int xScaleMax, int yScaleMax,
          ArrayList points, ArrayList axes, String graphType){
      
  }

  public void setAxes(ArrayList<String> axes) {
    this.axes = axes;
  }

  public void setGraphType(String graphType) {
    this.graphType = graphType;
  }

  public void setPoints(ArrayList points) {
    this.points = points;
  }

  public void setxScaleMax(int xScaleMax) {
    this.xScaleMax = xScaleMax;
  }

  public void setxScaleMin(int xScaleMin) {
    this.xScaleMin = xScaleMin;
  }

  public void setyScaleMax(int yScaleMax) {
    this.yScaleMax = yScaleMax;
  }

  public void setyScaleMin(int yScaleMin) {
    this.yScaleMin = yScaleMin;
  }

  public ArrayList<String> getAxes() {
    return axes;
  }

  public String getGraphType() {
    return graphType;
  }

  public ArrayList getPoints() {
    return points;
  }

  public int getxScaleMax() {
    return xScaleMax;
  }

  public int getxScaleMin() {
    return xScaleMin;
  }

  public int getyScaleMax() {
    return yScaleMax;
  }

  public int getyScaleMin() {
    return yScaleMin;
  }
}
