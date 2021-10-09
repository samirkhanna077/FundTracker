package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import sample.model.SceneManager;

public class AnalyseController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button toBack;

    @FXML
    private Button toQuit;

    @FXML
    void initialize() {
        toQuit.setOnAction(event -> {
            try {
                new SceneManager(anchorPane).changeScene("Tracker");
            } catch (IOException e) {
                e.printStackTrace();

                //System.out.println("Hello World!");
            }
        });

        toBack.setOnAction(event -> {
            try {
                new SceneManager(anchorPane).changeScene("Calculate");
            } catch (IOException e) {
                e.printStackTrace();

                //System.out.println("Hello World!");
            }
        });

    }
}
