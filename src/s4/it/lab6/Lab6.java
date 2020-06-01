/*
    Задание 1
        A. 2. Создать метод, который заменяет в списке L все вхождения E1 на E2
            - Replace()
        C. 4. Создать метод, который оставляет в списке только первые вхождения элементов
            - Unique()
    Задание 2
        2. Создать метод, который печатает в обратном порядке элементы непустого списка
            a) CircularBidirectionalList.PrintReverse()
                Использует Node.mPrev
            б) PrintListReverse()
                Использует .At() и .Size() у CircularBidirectionalList
 */

package s4.it.lab6;

import static java.lang.System.*;

import s4.it.CustomUtils;
import s4.it.lab6.binary_tree.BinaryTree;
import s4.it.lab6.binary_tree.BinaryTreePrinter;
import s4.it.lab6.circular_bidirectional_list.CircularBidirectionalList;
import s4.it.lab6.queue.Queue;
import s4.it.lab6.singly_linked_list.SinglyLinkedList;
import s4.it.lab6.stack.Stack;
import java.util.Random;
import java.util.Scanner;

public class Lab6
{
    public static void main(String[] args)
    {
        CustomUtils.PrintInFrame("Lab 6: Динамические структуры данных.");

        /* Task 1. Singly linked list */

        out.println("--- Task 1. Singly linked list ---");
        var list = new SinglyLinkedList<Integer>();
        out.println("A. 2.\n" + "Added 8 random items, 10 at front, 20 at back, 30 at front:");

        for(int i = 0; i < 8; i++)
        {
            list.AddBack(Random(1, 5));
        }

        list.AddFront(10)
                .AddBack(20)
                .AddFront(30);
        PrintCollection(list);

        out.println("Replace all 1 with 9...");
        list.Replace(1, 9);
        PrintCollection(list);

        out.println("C. 4.\n" + "Add 40 at back 2 times...");
        list.AddBack(40)
                .AddBack(40);
        PrintCollection(list);

        out.println("Call .Unique()...");
        list.Unique();
        PrintCollection(list);
        out.println();

        /* Task 2. Circular bidirectional list */

        out.println("--- Task 2. Circular bidirectional list ---");
        out.println("2.\nAdd 10 random items...");
        var cbl = new CircularBidirectionalList<Integer>();

        for(int i = 0; i < 10; i++)
        {
            cbl.AddBack(Random(1, 20));
        }

        PrintCollection(cbl);
        out.println("Call PrintListReverse()...");
        PrintCollectionReverse(cbl);
        out.println();

        /* Task 3. Queue */

        out.println("--- Task 3. Queue ---");
        var que = new Queue<Integer>();
        out.println("Add 8 items...");
        que.Push(1)
                .Push(2)
                .Push(3)
                .Push(4)
                .Push(5)
                .Push(6)
                .Push(7)
                .Push(8);
        PrintCollection(que);
        out.println("Call .Pop()...");
        que.Pop();
        PrintCollection(que);
        int required = 7;
        out.print(String.format("Try to find %d: ", required));
        int result = que.Find(required);

        if((Integer)result != null)
        {
            out.println(String.format("found at %d position", result));
        }
        else
        {
            out.println("not found");
        }

        out.println();

        /* Task 4. Stack */

        out.println("----- Task 4. Stack -----");
        var stack = new Stack<String>();
        out.println("Добавим в стек все дни недели (.Push())...");
        stack.Push("Понедельник")
                .Push("Вторник")
                .Push("Среда")
                .Push("Четверг")
                .Push("Пятница")
                .Push("Суббота")
                .Push("Воскресенье");
        PrintCollection(stack);
        out.println("Очистим стек (.Pop()) и добавим дни недели в обратном порядке...");

        while (!stack.IsEmpty())
        {
            stack.Pop();
        }

        stack.Push("Воскресенье")
                .Push("Суббота")
                .Push("Пятница")
                .Push("Четверг")
                .Push("Среда")
                .Push("Вторник")
                .Push("Понедельник");
        PrintCollection(stack);
        out.println("Уберем 'понедельник'...");
        stack.Pop();
        PrintCollection(stack);
        var required_day = "Суббота";
        out.print(String.format("Попробуем найти \"%s\": ", required_day));
        result = stack.Find(required_day);
        if((Integer)result != null)
        {
            out.println(String.format("found at %d position", result));
        }
        else
        {
            out.println("not found");
        }
        out.println();

        /* Task 5. Binary tree */

        out.println("----- Task 5. Binary Tree -----");

        BinaryTree tree = new BinaryTree();
        final int size = 30;
        int[] nums = new int[size];

        for(int i = 0; i < size; i++)
        {
            nums[i] = Random(0, 100);
        }

        out.println("Одномерный целочисленный массив:");
        CustomUtils.printArrayWithLineBreak(nums);
        out.print("\n\n");

        tree.AddRange(CustomUtils.integerArray(nums));
        BinaryTreePrinter printer = new BinaryTreePrinter(tree.root);

        out.println("Двоичное дерево:");
        printer.Print();

        out.println("Введите элемент для поиска (1/2): ");

        var in = new Scanner(System.in);
        required = in.nextInt();

        out.printf("Результат поиска: %b%n", tree.Contains(required));
        out.println("Введите элемент для поиска (2/2): ");

        required = in.nextInt();

        out.printf("Результат поиска: %b%n", tree.Contains(required));
    } // main()

    public static void PrintCollectionReverse(CircularBidirectionalList list)
    {
        if(list.Size() == 0)
        {
            out.println("Collection is empty");
            return;
        }

        for(int i = list.Size(); i > -1; i--)
        {
            try
            {
                out.print(list.At(i) + " ");
            }
            catch (Exception ex) {}
        }

        out.println();
    }

    public static void PrintCollection(Stack stack)
    {
        if(stack.Size() == 0)
        {
            out.println("Collection is empty");
            return;
        }

        for(int i = 0; i < stack.Size(); i++)
        {
            try
            {
                out.print(stack.At(i) + " ");
            }
            catch (Exception ex) {}
        }

        out.println();
    }

    public static void PrintCollection(Queue que)
    {
        if(que.Size() == 0)
        {
            out.println("Collection is empty");
            return;
        }

        for(int i = 0; i < que.Size(); i++)
        {
            try
            {
                out.print(que.At(i) + " ");
            }
            catch (Exception ex) {}
        }

        out.println();
    }

    public static void PrintCollection(CircularBidirectionalList list)
    {
        if(list.Size() == 0)
        {
            out.println("Collection is empty");
            return;
        }

        for(int i = 0; i < list.Size(); i++)
        {
            try
            {
                out.print(list.At(i) + " ");
            }
            catch (Exception ex) {}
        }

        out.println();
    }

    public static void PrintCollection(SinglyLinkedList list)
    {
        if(list.Size() == 0)
        {
            out.println("Collection is empty");
            return;
        }

        for(int i = 0; i < list.Size(); i++)
        {
            try
            {
                out.print(list.At(i) + " ");
            }
            catch (Exception ex){}
        }

        out.println();
    }

    public static int Random(int min, int max)
    {
        return new Random().nextInt((max - min) + 1) + min;
    }
}
