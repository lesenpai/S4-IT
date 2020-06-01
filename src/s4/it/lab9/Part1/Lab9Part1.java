/*
    1. Продемонстрировать создание нескольких потоков (thread) с синхронизацией (см.
       файл «Лекция. Многопоточное программирование»). Например, в одном потоке
       запустить задачу «вычисление бесконечного ряд», а в другом задачу
       «табулирование функции».
 */

package s4.it.lab9.Part1;

import s4.it.CustomUtils;
import java.util.ArrayList;
import static java.lang.System.out;

public class Lab9Part1
{
    public static void main(String[] args)
    {
        CustomUtils.PrintInFrame("Lab 9.1. Потоки, синхронизация потоков");

        new FibonacciSequenceThread("Fibonacci-thread", 20).start();

        new ArraySortThread("Sort-thread", 20).start();
    }

    static synchronized <T> void PrintLineSync(T s)
    {
        out.println(s);
    }
}

class ArraySortThread extends Thread
{
    private int ArraySize;

    ArraySortThread(String name, int arraySize)
    {
        super(name);
        ArraySize = arraySize;
    }

    public void run()
    {
        Log("START");

        Log("Print array...");
        var array = new ArrayList<Integer>();

        for(int i = 0; i < ArraySize; i++)
        {
            array.add(CustomUtils.Random(0, 50));
        }

        InsertionSort(array);

        for(int i = 0; i < array.size(); i++)
        {
            var progress = CustomUtils.Percent((double)i / array.size());
            Lab9Part1.PrintLineSync(getName() + " [" + progress + "] " + array.get(i));
        }

        Log("END");
    }

    private void Log(String message)
    {
        out.println(getName() + " [" + message + "]");
    }

    private void InsertionSort(ArrayList<Integer> array)
    {
        int i, key, j, size = array.size();

        for(i = 1; i < size; i++)
        {
            key = array.get(i);
            j = i - 1;

            while (j >= 0 && array.get(i) > key)
            {
                array.set(j + 1, array.get(j));
                j = j - 1;
            }

            array.set(j + 1, key);
        }
    }
}

class FibonacciSequenceThread extends Thread
{
    private int N;

    FibonacciSequenceThread(String name, int n)
    {
        super(name);
        N = n;
    }

    public void run()
    {
        Log("START");

        Log("Print sequence...");
        var seq = CreateSequence();

        for(int i = 0; i < seq.size(); i++)
        {
            var progress = CustomUtils.Percent((double)i / seq.size());
            if(progress.length() == 2)
            {
                progress = " " + progress;
            }
            Lab9Part1.PrintLineSync(getName() + " [" + progress + "] " + seq.get(i));
        }


        Log("END");
    }

    private void Log(String message)
    {
        out.println(getName() + " [" + message + "]");
    }

    private ArrayList<Long> CreateSequence()
    {
        var seq = new ArrayList<Long>();

        if(N < 1)
        {
            return seq;
        }

        seq.add(1L);

        if(N == 1)
        {
            return seq;
        }

        seq.add(1L);

        if(N == 2)
        {
            return seq;
        }

        for(int i = 3; i <= N; i++)
        {
            seq.add(seq.get(i - 3) + seq.get(i - 2));
        }

        return seq;
    }
}
