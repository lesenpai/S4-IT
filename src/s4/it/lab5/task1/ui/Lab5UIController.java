/*
    Создать приложение с использованием графического интерфейса (любым способом)

    Задание I: вариант 9

        Ввести с клавиатуры слово и символ «А». Удалить в слове первый по
        порядку символ «А» и присоединить символ «А» к началу полученного
        слова. Если в слове нет символа «А», то выдать соответствующее
        текстовое сообщение и присоединить символ «А» к началу слова.
        Вывести слово и символ.
*/

package s4.it.lab5.task1.ui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import s4.it.CustomUtils;

public class Lab5UIController
{
    @FXML private TextField TF_Word;
    @FXML private TextField TF_Symbol;
    @FXML private TextField TF_NewWord;

    @FXML private void Btn_Go_Click()
    {
        String word;
        Character symbol;

        // Check input
        try
        {
            word = TF_Word.getText();
            if(word.isEmpty())
            {
                throw new Exception();
            }

            var symbol_raw = TF_Symbol.getText();
            if(symbol_raw.length() != 1)
            {
                throw new Exception();
            }

            symbol = symbol_raw.charAt(0);
        }
        catch (Exception ignore)
        {
            CustomUtils.alert("Ошибка! Не правильный ввод", Alert.AlertType.ERROR);
            return;
        }

        // Processing
        if(word.indexOf(symbol) == -1)
        {
            CustomUtils.alert(String.format("Символ '%c' не найден в слове '%s'.%n", symbol, word), Alert.AlertType.INFORMATION);
        }
        else
        {
            word = word.replaceFirst(String.valueOf(symbol), "");
        }

        word = symbol + word;
        TF_NewWord.setText(word);
    }
}
