/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfacegraph;

import Controller.ControllerActions;
import Model.Borda;
import Model.Computador;
import Model.NodeFX;
import Model.Roteador;
import Model.Vertice;
import java.awt.Canvas;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.animation.FillTransition;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.FileChooser;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author limam
 */
public class FXMLTentavivaController implements Initializable {

    @FXML
    Group canvasGroup;

    ControllerActions controller;
    NodeFX selectedNode = null;
    private int countHandler = 0;
    private LinkedList<NodeFX> listaNos;

    @FXML
    private void handleButtonAction(ActionEvent event) throws FileNotFoundException {
        controller.inicializarGrafo();
        this.carregarGrafoInterface();
        this.estabelecerConexoes();

    }

    private void estabelecerConexoes() {
        Iterator it = controller.getConexoes().iterator();
        Iterator it2 = this.listaNos.iterator();
        while (it.hasNext()) {

            Borda b = (Borda) it.next();
            while(it2.hasNext()) {
               NodeFX no = (NodeFX)it2.next();
               
            }

        }
    }

    EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent mouseEvent) {
            NodeFX circle = (NodeFX) mouseEvent.getSource();
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED && mouseEvent.getButton() == MouseButton.PRIMARY) {
                System.out.println(circle.getIdentifier().getText());
                if (!circle.getSelected()) {
                    if (selectedNode != null) {
                        Line edgeLine = new Line(selectedNode.getPoint().x, selectedNode.getPoint().y, circle.getPoint().x, circle.getPoint().y);
                        canvasGroup.getChildren().add(edgeLine);
                        selectedNode = null;
                    } else {
                        countHandler = +1;
                        circle.setIsSelected(true);
                        selectedNode = circle;

                    }

                }
            }
        }

    };

    private void carregarGrafoInterface() {
        canvasGroup.getChildren().clear();
        Iterator it = controller.getGrafo().getVertices().entrySet().iterator();
        int y = 0;
        int x = 0;
        int counter = 0;
        while (it.hasNext()) {
            Map.Entry<String, Vertice> entry = (Map.Entry<String, Vertice>) it.next();
            System.out.println(entry.getValue());
            if (counter <= 3) {
                x = x + 100;
            } else {
                y = -50;
                x = x + 100;
            }
            if (entry.getValue().getConteudo() instanceof Computador) {
                Computador computador = (Computador) entry.getValue().getConteudo();
                NodeFX n = new NodeFX(x, y, 1.2, computador.getIdentificador());
                canvasGroup.getChildren().add(n);
                canvasGroup.getChildren().add(n.getIdentifier());
                listaNos.add(n);
                ScaleTransition tr = new ScaleTransition(Duration.millis(100), n);
                tr.setByX(10f);
                tr.setByY(10f);
                tr.setInterpolator(Interpolator.EASE_OUT);
                tr.play();
                n.setOnMousePressed(mouseHandler);
                n.setOnMouseReleased(mouseHandler);
                n.setOnMouseDragged(mouseHandler);
                n.setOnMouseExited(mouseHandler);
                n.setOnMouseEntered(mouseHandler);

            }
            if (entry.getValue().getConteudo() instanceof Roteador) {
                Roteador roteador = (Roteador) entry.getValue().getConteudo();
                NodeFX a = new NodeFX(x, y, 1.2, roteador.getIdentificador());
                canvasGroup.getChildren().add(a);
                canvasGroup.getChildren().add(a.getIdentifier());
                listaNos.add(a);
                ScaleTransition tr1 = new ScaleTransition(Duration.millis(100), a);
                tr1.setByX(10f);
                tr1.setByY(10f);
                tr1.setInterpolator(Interpolator.EASE_OUT);
                tr1.play();
                a.setOnMousePressed(mouseHandler);
                a.setOnMouseReleased(mouseHandler);
                a.setOnMouseDragged(mouseHandler);
                a.setOnMouseExited(mouseHandler);
                a.setOnMouseEntered(mouseHandler);
            }
            counter++;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller = new ControllerActions();
        listaNos = new LinkedList<>();
        NodeFX cirle = new NodeFX(30, 40, 1.2, "Primeiro");
        NodeFX cir = new NodeFX(100, 180, 1.2, "Segundo");
        canvasGroup.getChildren().add(cirle.getIdentifier());
        canvasGroup.setAutoSizeChildren(true);
        canvasGroup.getChildren().add(cirle);

        canvasGroup.getChildren().add(cir);
        canvasGroup.getChildren().add(cir.getIdentifier());

        ScaleTransition tr = new ScaleTransition(Duration.millis(100), cirle);
        ScaleTransition tr1 = new ScaleTransition(Duration.millis(100), cir);
        tr.setByX(10f);
        tr1.setByX(10f);
        tr.setByY(10f);
        tr1.setByY(10f);
        tr.setInterpolator(Interpolator.EASE_OUT);
        tr1.setInterpolator(Interpolator.EASE_OUT);
        tr.play();
        tr1.play();

        Line edgeLine = new Line(cirle.getCenterX(), cirle.getCenterY(), cir.getCenterX(), cir.getCenterY());
        canvasGroup.getChildren().add(edgeLine);
        edgeLine.setId("line");

        // TODO
    }

}
