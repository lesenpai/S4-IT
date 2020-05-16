/*
    Создать консольные приложения (двумя способами: с использованием класса String и с использованием класса StringBuffer)

    Задание II: вариант 11

        Написать программу, которая считывает с клавиатуры текст и выводит
        на экран только строки, не содержащие двузначных чисел.

    --------
    Используя String
 */

package s4.it.lab5.task2.console;

import s4.it.CustomUtils;
import java.util.Scanner;
import static java.lang.System.out;

public class Lab5Task2ConsoleString
{
    public static void main(String[] args)
    {
        CustomUtils.printInFrame("Lab 5: Строки и символы. Часть II (с использованием класса String)");
        out.println("Введите текст, разделяя предложения с помощью '_':");
        var in = new Scanner(System.in);

        var text = in.nextLine();
        var delim = "_";
        String[] sentences = text.split(delim);

        boolean are_any_sentences_match = false;
        out.println("Строки, не содержащие двузначных чисел:");

        for(var sentence : sentences)
        {
            int curr_num_len = 0;
            boolean contains_2digit_num = false;

            for(int i = 0; i < sentence.length(); i++)
            {
                if(Character.isDigit(sentence.charAt(i)))
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
                    if(i == sentence.length() - 1 || !Character.isDigit(sentence.charAt(i + 1)))
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
                out.printf("\"%s\"%n", sentence);
                are_any_sentences_match = true;
            }
        }

        if(!are_any_sentences_match)
        {
            out.println("Нет таких строк");
        }
    }
}
