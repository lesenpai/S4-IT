/*
    2. Продемонстрировать ввод с клавиатуры в консольном режиме (см файл «Лекция.
       Ввод-вывод информации»). Например, для выполнения варианта задания на
       одномерные массивы в консольном режиме исходный массив ввести с клавиатуры.

       Вариант 5
            В одномерном массиве, состоящем из n вещественных элементов, вычислить:
                1) максимальный элемент массива;
 */

package s4.it.lab9.Part2;

import s4.it.CustomUtils;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.out;

public class Lab9Part2
{
    public static void main(String[] args)
    {
        // enter array splitted by " "
        // do smth with array...
        // print array

        CustomUtils.PrintInFrame("Lab 9.2. Ввод с клавиатуры в консольном режиме");
        out.println("\bВариант 5.\nВ одномерном массиве, состоящем из n вещественных элементов, вычислить максимальный элемент массива\n");

        var in = new Scanner(System.in);

        out.println("Введите массив (разделитель - ' '):");
        var sArray = in.nextLine().replaceAll("\\s", " ").split(" ");
        var array = new Double[sArray.length];

        out.println("Чтение массива...");
        // Array init
        try
        {
            for(int i = 0; i < array.length; i++)
            {
                array[i] = Double.parseDouble(sArray[i]);
            }
        }
        catch (Exception ex)
        {
            out.println("\nОшибка. Неправильный ввод.\n");
            return;
        }

        out.println("Поиск максимального элемента...");
        var maxIndex = CustomUtils.FindMax(array);
        out.println("Максимальный элемент = " + array[maxIndex]);
    }
}
