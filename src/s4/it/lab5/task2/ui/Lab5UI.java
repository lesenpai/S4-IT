package s4.it.lab5.task2.ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Lab5UI extends Application
{
    @FXML
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        var loader = new FXMLLoader(getClass().getResource("Lab5UI.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("S4. IT. Lab 5. Task 2");

        stage.show();
    }
}