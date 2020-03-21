/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author limam
 */
public class NodeFX extends Circle {

    Point point;
    Label distance = new Label("Dist. : INFINITY");
    Label visitTime = new Label("Visit : 0");
    Label lowTime = new Label("Low : 0");
    Label id;
    boolean isSelected = false;
    String valueNode;
    private Map<NodeFX, Integer> vizinhos;
    public NodeFX(double x, double y, double rad, String name) {
        super(x, y, rad);
        point = new Point((int) x, (int) y);
        this.valueNode = name;
        id = new Label(name);
        id.setLayoutX(x - 18);
        id.setLayoutY(y - 18);
        this.setOpacity(0.5);
        this.setBlendMode(BlendMode.MULTIPLY);
        this.setId("node");
        this.setFill(Color.BLACK);
        vizinhos = new HashMap<>();
      }
    

    

    public Map<NodeFX, Integer> getVizinhos() {
        return vizinhos;
    }

    public void setVizinhos(Map<NodeFX, Integer> vizinhos) {
        this.vizinhos = vizinhos;
    }
    public String getValueNode(){
        return this.valueNode;
    }
    public Label getIdentifier(){
        return this.id;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Label getDistance() {
        return distance;
    }

    public void setDistance(Label distance) {
        this.distance = distance;
    }

    public Label getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Label visitTime) {
        this.visitTime = visitTime;
    }

    public Label getLowTime() {
        return lowTime;
    }

    public void setLowTime(Label lowTime) {
        this.lowTime = lowTime;
    }



    public boolean getSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
}
