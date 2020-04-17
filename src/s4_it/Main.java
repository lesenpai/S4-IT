package s4_it;

import s4_it.lab1.Lab1;
import s4_it.lab3.Lab3;
import s4_it.lab4.Lab4;

import java.util.Scanner;

import static java.lang.System.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {
        CustomUtils.PrintInFrame("S4. IT. Lab Manager");
        var in = new Scanner(System.in);
        boolean is_end = false;
        while(!is_end)
        {
            out.print("Choose lab number (1,4)|exit=\"exit\": ");
            var input = in.next();
            switch (input)
            {
                case "1":
                    Lab1.main(null);
                    break;
                case "2":
                    s4_it.lab2.Lab2.main(null);
                    break;
                case "3":
                    Lab3.main(null);
                    break;
                case "4":
                    Lab4.main(null);
                    break;
                case "exit":
                    is_end = true;
                    break;
            }
        }
    }
}
