package s4.it.lab8;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import s4.it.lab8.calculator.Calculator;
import s4.it.lab8.calculator.CalculatorException.CalculatorException;

import static java.lang.System.out;

public class Lab8 extends Application
{
    @FXML
    public static void main(String[] args)
    {
        launch(args);
        /*double number;

        try
        {
            //number = Calculator.Run("2 + 3 * 7 / 3.5");

            out.println("number is " + number);
        }
        catch (CalculatorException e)
        {
            out.println(e.getMessage());
        }*/
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        var loader = new FXMLLoader(getClass().getResource("Lab8.fxml"));
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("S4 / IT / Lab 8");

        stage.show();
    }
}