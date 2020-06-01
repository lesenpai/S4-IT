/*
    Создать консольные приложения (двумя способами: с использованием класса String и с использованием класса StringBuffer)

    Задание II: вариант 11

        Написать программу, которая считывает с клавиатуры текст и выводит
        на экран только строки, не содержащие двузначных чисел.
 */

package s4.it.lab5.task2.ui;

import s4.it.CustomUtils;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class Lab5UIController
{
    @FXML private TextArea TA_Text;
    @FXML private TextArea TA_MatchingLines;

    @FXML
    private void Btn_Go_Click()
    {
        var text = TA_Text.getText();
        var delim = "\n";
        String[] lines = text.split(delim);
        StringBuilder s_builder = new StringBuilder();

        boolean is_any_line_match = false;

        for(var line : lines)
        {
            int curr_num_len = 0;
            boolean contains_2digit_num = false;

            for(int i = 0; i < line.length(); i++)
            {
                if(Character.isDigit(line.charAt(i)))
                {
                    curr_num_len++;
                }
                else
                {
                    curr_num_len = 0;
                    continue;
                }

                if(curr_num_len == 2)
                {
                    if(i == line.length() - 1 || !Character.isDigit(line.charAt(i + 1)))
                    {
                        contains_2digit_num = true;
                        break;
                    }
                    else
                    {
                        i++;
                        curr_num_len++;
                    }
                }
            }

            if(!contains_2digit_num)
            {
                s_builder.append(line).append(delim);
                is_any_line_match = true;
            }
        }

        TA_MatchingLines.setText(s_builder.toString());
        if(!is_any_line_match)
        {
            CustomUtils.Alert("Не найдено строк без двузначных чисел.", Alert.AlertType.INFORMATION);
        }
    }
}
