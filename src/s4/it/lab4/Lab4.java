package s4.it.lab4;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Lab4 extends Application
{
    @FXML
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        var loader = new FXMLLoader(getClass().getResource("Lab4.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        Lab4Controller controller = loader.getController();
        controller.InitIO();
        stage.setScene(scene);
        stage.setTitle("S4. IT. Lab 4");

        stage.show();
    }
}