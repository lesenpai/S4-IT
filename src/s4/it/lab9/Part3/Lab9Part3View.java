package s4.it.lab9.Part3;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import s4.it.CustomUtils;

import java.util.Optional;

public class Lab9Part3View
{
    public Lab9Part3Controller Controller;
    //public Lab9Part3Model Model;

    private Stage Stg_StageElement;

    public Lab9Part3View(Lab9Part3Controller controller)
    {
        Controller = controller;
        //Model = controller.model
    }

    public void ErrorAlert(String message)
    {
        CustomUtils.Alert(message, Alert.AlertType.ERROR);
    }

    public void Exit()
    {
        SetStageElement();
        Stg_StageElement.close();
    }

    public void SetText(String text)
    {
        Controller.TA_Text.setText(text);
    }

    public void SetTitle(String title)
    {
        SetStageElement();
        Stg_StageElement.setTitle(title);
    }

    public Optional<ButtonType> AskForSave()
    {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Есть несохраненные изменения. Сохранить?");
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        return alert.showAndWait();
    }

    private void SetStageElement()
    {
        if(Stg_StageElement == null)
        {
            Stg_StageElement = (Stage)Controller.AP_RootElement.getScene().getWindow();
        }
    }

}
