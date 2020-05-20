package s4.it.lab1;

import s4.it.CustomUtils;

import static java.lang.System.*;
import java.util.Scanner;

public class Lab1
{
    public static void main(String[] args)
    {
        CustomUtils.PrintInFrame("Lab 1. Табулирование функции и вычисление суммы бесконечного ряда");
        Scanner in = new Scanner(System.in);
        boolean is_end = false;
        while(!is_end)
        {
            out.print("Choose the part (1/2)|exit='exit': ");
            String input = in.next();
            switch (input)
            {
                case "1":
                    out.println("=== Part 1 ===");
                    Part1();
                    break;
                case "2":
                    out.println("=== Part 2 ===");
                    Part2();
                    break;
                case "exit":
                    is_end = true;
                    break;
            }
        }
    }

    /*
        Вариант 11
     */
    private static void Part1()
    {
        final double a = 2.7, b = 0.27, dx = 0.5;
        double y, x;
        for(x = 0; x <= 7; x += dx)
        {
            if(x < 2.3)
                y = (a + b) / (Math.pow(Math.E, x) + Math.cos(x));
            else if (x < 5)
                y = (a + b) * (x + 1);
            else
                y = Math.pow(Math.E, x) + Math.sin(x);
            out.println(" x = " + x + "\ty = " + String.format("%.2f", y));
        }
    }

    /* Вариант 29 */
    private static void Part2()
    {
        out.println("S = SUM(infinity, n = 0) ( x^(2n) / (2n)! ) = COSH(x)");
        double dx = 0.5;
        double y, x, x_min, x_max;
        x_min = 0;
        x_max = 7;
        for(x = x_min; x <= x_max; x += dx)
        {
            y = Math.cosh(x);
            out.println(" x = " + x + "\ty = " + y);
        }
    }
}


