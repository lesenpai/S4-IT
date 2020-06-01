/*
    Создать консольные приложения (двумя способами: с использованием класса String и с использованием класса StringBuffer)

    Задание I: вариант 9
    Ввести с клавиатуры слово и символ «А». Удалить в слове первый по
    порядку символ «А» и присоединить символ «А» к началу полученного слова.
    Если в слове нет символа «А», то выдать соответствующее
    текстовое сообщение и присоединить символ «А» к началу слова. Вывести слово и символ.

    -------
    Используя StringBuffer
 */

package s4.it.lab5.task1.console;

import s4.it.CustomUtils;
import java.util.Scanner;
import static java.lang.System.out;

public class Lab5Task1ConsoleStringBuffer
{
    public static void main(String[] args)
    {
        CustomUtils.PrintInFrame("Lab 5: Строки и символы. Часть I (с использованием класса StringBuffer)");
        var in = new Scanner(System.in);

        out.print("Введите слово: ");
        var word = new StringBuffer(in.nextLine());
        if (word.length() == 0)
        {
            out.println("Ошибка! Получена пустая строка.");
            return;
        }

        out.print("Введите символ: ");
        var symbol_raw = in.next();
        if(symbol_raw.length() > 1)
        {
            out.println("Ошибка! Длина полученной строки больше 1.");
            return;
        }

        char symbol = symbol_raw.charAt(0);
        int symbol_pos = word.indexOf(Character.toString(symbol));
        if(symbol_pos == -1)
        {
            out.printf("Символ '%c' не найден в слове '%s'.%n", symbol, word);
        }
        else
        {
            out.printf("Удаление первого по порядку символа '%c'...%n", symbol);
            word.replace(symbol_pos, symbol_pos + 1, "");
            out.printf("Слово = '%s'.%n", word);
        }

        out.printf("Добавление символа '%c' к началу слова...%n", symbol);
        word.insert(0, symbol);

        out.printf("Полученное слово: '%s', символ: '%c'.%n", word, symbol);
    }
}
