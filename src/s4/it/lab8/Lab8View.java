package s4.it.lab8;

import javafx.scene.control.Alert;

public class Lab8View
{
    public Lab8Controller Controller;

    public Lab8View(Lab8Controller controller)
    {
        this.Controller = controller;
    }

    public void SetExpression(String expression)
    {
        Controller.TF_Expression.setText(expression);
    }

    public void ResetExpression()
    {
        Controller.TF_Expression.setText("");
        Controller.TF_Expression.setText("");
    }

    public void AlertError(String message)
    {
        var alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.setHeight(20);

        alert.showAndWait();
    }
}
