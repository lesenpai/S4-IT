package s4.it.lab9.Part3;

import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class Lab9Part3Model
{
    public Lab9Part3View View;

    public String FileName;
    public final String DEFAULT_FILE_NAME = "untitled";
    public final String APP_NAME = "S4 / IT / Lab 9.3";
    public boolean IsFileOpen = false;
    public boolean IsFIleSaved = true;

    public Lab9Part3Model(Lab9Part3View view)
    {
        View = view;
        FileName = DEFAULT_FILE_NAME;
    }

    public void OpenFile()
    {
        var chooser = new FileChooser();
        chooser.setTitle("Open file");
        var file = chooser.showOpenDialog(new Stage());
        if(file != null)
        {
            try
            {
                FileName = file.toString();
                var text = Files.readString(file.toPath(), StandardCharsets.UTF_8);
                View.SetText(text);
                SetTitleFile();

                IsFileOpen = true;
            }
            catch (Exception e)
            {
                View.ErrorAlert("Не удалось открыть файл.");
            }
        }
    }

    public void SetTitleFile()
    {
        View.SetTitle(APP_NAME + " - " + FileName);
    }

    public boolean SaveAs(String text)
    {
        var chooser = new FileChooser();
        chooser.setTitle("Save As");
        var file = chooser.showSaveDialog(new Stage());

        if(file != null)
        {
            try
            {
                FileName = file.toString();
                var writer = new BufferedWriter(new FileWriter(FileName));
                writer.write(text);
                writer.close();
                SetTitleFile();

                IsFIleSaved = true;

                return true;
            }
            catch (Exception e)
            {
                View.ErrorAlert("Неудалось сохранить файл");
                return false;
            }
        }

        return false;
    }

    public void Exit(String text)
    {
        if(!IsFIleSaved)
        {
            var responce = View.AskForSave();
            if(responce.isPresent())
            {
                var btnType = responce.get();
                if(btnType == ButtonType.YES)
                {
                    if(SaveAs(text))
                    {
                        View.Exit();
                    }
                }
                else
                {
                    View.Exit();
                }
            }
        }

        View.Exit();
    }

    // "APP_NAME - filename" => "APP_NAME - filename*"
    public void MarkFileChanged()
    {
        View.SetTitle(APP_NAME + " - " + FileName + "*");

        IsFIleSaved = false;
    }
}
