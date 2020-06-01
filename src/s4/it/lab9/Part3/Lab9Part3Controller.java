/*
    3. Продемонстрировать работу с файлами (чтение и запись) с использованием
        графического диалогового режима (см. файл «Лекция. Ввод-вывод информации» и
        файл «Справка. Работа с файлами и папками»).

        Создать окно с меню:

        Меню
            Файл
                Открыть
                Сохранить как
                Выход
 */

package s4.it.lab9.Part3;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

public class Lab9Part3Controller
{
    public Lab9Part3Model Model;
    public Lab9Part3View View;

    @FXML
    public AnchorPane AP_RootElement;
    @FXML
    public TextArea TA_Text;

    public Lab9Part3Controller()
    {
        View = new Lab9Part3View(this);
        Model = new Lab9Part3Model(View);
    }

    @FXML
    public void MI_File__Open_Action()
    {
        Model.OpenFile();
    }

    @FXML
    public void MI_File__SaveAs_Action()
    {
        Model.SaveAs(TA_Text.getText());
    }

    @FXML
    public void MI_File__Exit_Action()
    {
        Model.Exit(TA_Text.getText());
    }

    @FXML
    public void TA_Text_Typed()
    {
        Model.MarkFileChanged();
    }

}
