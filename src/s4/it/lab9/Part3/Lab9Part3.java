package s4.it.lab9.Part3;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Lab9Part3 extends Application
{
    @FXML
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        var loader = new FXMLLoader(getClass().getResource("Lab9Part3.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("S4 / IT / Lab 9.3 - untitled");
        stage.show();
    }
}