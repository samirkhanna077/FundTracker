package sample.model;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class created by Sam
 */
public class SceneManager {

    private static final String BASE_PATH = "/sample/view/";

    private Pane pane;
    private HashMap<String, Pane> screenMap = new HashMap<String, Pane>() {{
        try {
            put("sample", FXMLLoader.load(getClass().getResource(BASE_PATH + "sample.fxml")));
            put("Tracker", FXMLLoader.load(getClass().getResource(BASE_PATH + "Tracker.fxml")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }};

    public SceneManager(Pane pane) {
        this.pane = pane;
    }

    public void addScreen(String name) throws IOException {
        screenMap.put(name, FXMLLoader.load(getClass().getResource(BASE_PATH + WordUtils.capitalize(name) +".fxml")));
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        //general case
        activate(name, 600, 400);
    }
    public void activate(String name, int width, int height) {
        //this method is overloaded when the size of the window needs to change
        Pane window = screenMap.get(name);
        pane.getChildren().setAll(window);
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setTitle(WordUtils.capitalize(name));
    }

    public void changeScene(String name) throws IOException {
        Stage oldStage = (Stage) pane.getScene().getWindow();
        oldStage.close();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(BASE_PATH + name + ".fxml"));
        loader.load();
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle(WordUtils.capitalize(name));
        stage.show();
    }
}
