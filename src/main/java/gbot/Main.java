package gbot;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * A GUI for GBot using FXML.
 *
 * Adapted from https://se-education.org/guides/tutorials/javaFxPart4.html
 */
public class Main extends Application {
    private final GBot gbot = new GBot("./data/tasks.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setGBot(gbot);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
