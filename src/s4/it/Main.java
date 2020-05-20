package s4.it;

import s4.it.lab5.task1.console.Lab5Task1ConsoleString;
import s4.it.lab5.task2.ui.Lab5UI;
import s4.it.lab1.Lab1;
import s4.it.lab2.Lab2;
import s4.it.lab3.Lab3;
import s4.it.lab4.Lab4;
import s4.it.lab6.Lab6;
import s4.it.lab5.task1.console.Lab5Task1ConsoleStringBuffer;
import s4.it.lab5.task2.console.Lab5Task2ConsoleString;
import s4.it.lab7.Lab7;
import s4.it.lab8.Lab8;
import s4.it.lab9.Part1.Lab9Part1;
import s4.it.lab9.Part2.Lab9Part2;
import s4.it.lab9.Part3.Lab9Part3;

import java.util.Scanner;
import static java.lang.System.*;

public class Main
{
    public static void main(String[] args)
    {
        Lab9Part3.main(null);
        if(true) return;

        CustomUtils.PrintInFrame("S4. IT. Lab Manager");
        String labs_list_info = "Labs codes list: 1, 2, 3, 4, " +
                                "5-1-c-S, 5-1-c-SB, 5-1-ui, " +
                                "5-2-c-S, 5-2-ui" +
                                "6, 7, 8" +
                                "9-1, 9-2, 9-3";
        var in = new Scanner(System.in);
        boolean is_end = false;

        while(!is_end)
        {
            out.print("\nВведите <номер_лабораторной>|labs-list|exit: ");
            var input = in.next();
            switch (input)
            {
                case "1":
                    Lab1.main(null);
                    break;

                case "2":
                    Lab2.main(null);
                    break;

                case "3":
                    Lab3.main(null);
                    break;

                case "4":
                    Lab4.main(null);
                    break;

                case "5-1-c-S":
                    Lab5Task1ConsoleString.main(null);
                    break;

                case "5-1-c-SB":
                    Lab5Task1ConsoleStringBuffer.main(null);
                    break;

                case "5-1-ui":
                    s4.it.lab5.task1.ui.Lab5UI.main(null);
                    break;

                case "5-2-c-S":
                    Lab5Task2ConsoleString.main(null);
                    break;

                case "5-2-ui":
                    Lab5UI.main(null);
                    break;

                case "6":
                    Lab6.main(null);
                    break;

                case "7":
                    Lab7.main(null);
                    break;

                case "8":
                    Lab8.main(null);
                    break;

                case "9-1":
                    Lab9Part1.main(null);
                    break;

                case "9-2":
                    Lab9Part2.main(null);
                    break;

                case "9-3":
                    Lab9Part3.main(null);
                    break;

                case "exit":
                    is_end = true;
                    break;

                case "labs-list":
                    out.println(labs_list_info);
                    break;

                default:
                    out.println("Ошибка! Неизвестная команда.");
                    break;
            }
        }
    }
}
