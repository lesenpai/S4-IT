package s4_it.lab3;

/*
    Вариант 4
        Дана целочисленная квадратная матрица. Определить:
            1) Произведение элементов в тех строках, которые не содержат отрицательных элементов
            2) Максимум среди сумм элементов диагоналей, параллельных главной диагонали матрицы.
 */
/*
    матрица: 2д массив
    главная диагональ: с СЗ на ЮВ
 */
import s4_it.CustomUtils;

import java.util.*;

import static java.lang.System.out;

public class Lab3
{
    public static void main(String[] args)
    {
        // получаем матрицу
        Integer[][] matrix = SquareMatrix(6, -2, 10);
        out.println("Matrix:");
        PrintMatrix(matrix);
        // пункт 1
        Integer[] positive_rows_indexes = PositiveRowsIndexes(matrix);
        out.println("\nПроизведение элементов в строках, не содержащих отрицательные элементы:");
        {
            int prod;
            for(int pi = 0; pi < positive_rows_indexes.length; pi++)
            {
                prod = matrix[positive_rows_indexes[pi]][0];
                for(int ii = 1; ii < matrix.length; ii++)
                {
                    prod *= matrix[positive_rows_indexes[pi]][ii];
                }
                out.print("#" + (positive_rows_indexes[pi] + 1) + ": " + prod);
                if(pi != positive_rows_indexes.length - 1) out.print(", ");
            }
            out.println();
        }
        // пункт 2
        HashMap<Integer, Integer[]> diagonal_sums = ParallelToMainDiagonalsSums(matrix);
        out.print("\nМаксимум среди сумм элементов диагоналей, параллельных главной диагонали матрицы: ");
        Integer[] keys = diagonal_sums.keySet().toArray(new Integer[0]);
        int max = keys[0];
        for(int i = 1; i < diagonal_sums.size(); i++)
        {
            if (keys[i] > max)
            {
                max = keys[i];
            }
        }
        out.print(max + " " + Arrays.toString(diagonal_sums.get(max)));
        out.println();
    }

    public static HashMap<Integer, Integer[]> ParallelToMainDiagonalsSums(Integer[][] mtx)
    {
        HashMap<Integer, Integer[]> sums = new HashMap<>();
        // начинаем перебор с ЮЗ до СВ
        // с mtx[0][Y] до mtx[0][1], mtx[1][0] до mtx[X][0]
        int sum = 0;
        // нижняя часть
        for(int r = mtx.length - 1; r > 0; r--)
        {
            for(int cr = r, cc = 0; cr < mtx.length; cr++, cc++)
            {
                sum += mtx[cr][cc];
            }
            sums.put(sum, new Integer[]{r, 0});
            sum = 0;
        }
        // верхняя часть
        for(int c = 1; c < mtx.length; c++)
        {
            for(int cr = 0, cc = c; cc < mtx.length; cr++, cc++)
            {
                sum += mtx[cr][cc];
            }
            sums.put(sum, new Integer[]{0, c});
            sum = 0;
        }
        return sums;
    }

    public static Integer[] PositiveRowsIndexes(Integer[][] m)
    {
        ArrayList<Integer> al = new ArrayList<>();
        for(int r = 0; r < m.length; r++)
        {
            for(int c = 0; c < m.length; c++)
            {
                if(m[c][r] < 0)
                {
                    break;
                }
                if(c == m.length - 1) al.add(r);
            }
        }
        return al.toArray(new Integer[0]);
    }

    public static Integer[][] SquareMatrix(int size, int minItemSize, int maxItemSize)
    {
        Integer[][] m = new Integer[size][size];
        for(int r = 0; r < size; r++)
        {
            for(int c = 0; c < size; c++)
            {
                m[r][c] = CustomUtils.Random(minItemSize, maxItemSize);
            }
        }
        return m;
    }

    public static void PrintMatrix(Integer[][] m)
    {
        for(int r = 0; r < m.length; r++)
        {
            for(int c = 0; c < m.length; c++)
            {
                out.print("#[" + r + "][" + c + "] " + m[r][c] + '\t');
            }
            out.println();
        }
    }
}

