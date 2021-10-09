package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import sample.model.SceneManager;

public class CalculateController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button toAnalyse;

    @FXML
    void initialize() {
        toAnalyse.setOnAction(event -> {
            try {
                new SceneManager(anchorPane).changeScene("Analyse");
            } catch (IOException e) {
                e.printStackTrace();

                //System.out.println("Hello World!");
            }
        });

    }
}
