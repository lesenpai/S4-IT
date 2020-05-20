package s4_it;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.System.*;

public class CustomUtils
{
    public static void PrintInFrame(String s)
    {
        Character lt_corner = '┌', rt_corner = '┐', rb_corner = '┘', lb_corner = '└', vertical = '│', horizontal = '─';
        var horizontal_line = horizontal.toString().repeat(s.length() + 2);
        out.println(lt_corner + horizontal_line + rt_corner);
        out.println(vertical + " " + s + " " + vertical);
        out.println(lb_corner + horizontal_line + rb_corner);
    }

    public static int Random(int min, int max)
    {
        return (new Random()).nextInt((max - min) + 1) + min;
    }

    public static int FindMax(Integer[] arr)
    {
        if(arr.length == 0)
        {
            return -1;
        }
        int max = arr[1];
        int max_i = 0;
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
                max_i = i;
            }
        }
        return max_i;
    }

    /*
        \details Читает строку формата 0#1 ... 20#14
     */
    public static Integer[] StringToArrayNumbered(String source)
    {
        var list = new ArrayList<Integer>();
        //var numbered_items =  source.replaceAll("\\s{2,}", " ").split("\\s+"); // like 123#56
        var numbered_items =  source.split("\\s+"); // like 123#56
        for(int i = 0; i < numbered_items.length; i++)
        {
            numbered_items[i] = numbered_items[i].split("\\[")[0];
            list.add(Integer.parseInt(numbered_items[i]));
        }
        return list.toArray(Integer[]::new);
    }

    public static String ArrayToStringNumbered(Integer[] array, String delim)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++)
        {
            sb.append(array[i]).append("[").append(i).append(']').append(delim);
        }
        return sb.toString();
    }

    public static String MatrixToString(Integer[][] mtx, int justification)
    {
        var sb = new StringBuilder();
        int size = mtx.length;
        // line iteration
        for (Integer[] integers : mtx)
        {
            // column iteration
            for (int col = 0; col < size; col++)
            {
                sb.append(String.format("%" + justification + "d", integers[col]));
            }
            sb.append("\n\n");
        }
        return sb.toString();
    }

    public static Integer[][] StringToMatrix(String source, int size)
    {
        var mtx = new ArrayList<ArrayList<Integer>>();
        var numbers = source.trim().replace("\n", "").split("\\s+");
        // line iteration
        for(int row = 0; row < size; row++)
        {
            var row_items = new ArrayList<Integer>();
            // column iteration
            for(int col = 0; col < size; col++)
            {
                row_items.add(Integer.parseInt(numbers[row * size + col]));
            }
            mtx.add(row_items);
        }
        return mtx.stream()
                .map(l -> l.stream().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
    }
}
