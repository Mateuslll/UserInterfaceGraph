/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterfacegraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 *
 * @author limam
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextArea areaTexto;

    @FXML
    private void handleButtonAction(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("TEXT FILES", "*.txt", "*.text");
        fileChooser.getExtensionFilters().addAll(extFilterTXT);
        File file = fileChooser.showOpenDialog(null);
        String aux_text = null;

        if (file != null) {
            
            System.out.println("File diferente de null");
            System.out.println();
            Scanner leitor = new Scanner(file);

            String linhasDoArquivo = null;

            while (leitor.hasNext()) {

                linhasDoArquivo = leitor.nextLine();
                System.out.println(linhasDoArquivo);
                areaTexto.appendText("\n");
                areaTexto.appendText(linhasDoArquivo);
            }
            
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        // TODO
    }

}
