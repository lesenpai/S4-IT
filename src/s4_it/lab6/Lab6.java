package s4_it.lab6;
import static java.lang.System.*;

import s4_it.lab6.circular_bidirectional_list.CircularBidirectionalList;
import s4_it.lab6.singly_linked_list.SinglyLinkedList;
import s4_it.lab6.queue.Queue;
import s4_it.lab6.stack.Stack;

import java.util.Random;
/*
    Задание 1
        A. 2. Создать метод, который заменяет в списке L все вхождения E1 на E2
            -- replace()
        C. 4. Создать метод, который оставляет в списке только первые вхождения элементов
            -- unique()
    Задание 2
        2. Создать метод, который печатает в обратном порядке элементы непустого списка
            a) CircularBidirectionalList.printReverse()
                Использует Node.mPrev
            б) printListReverse()
                Использует .at() и .size() у CircularBidirectionalList
 */
public class Lab6
{
    public static void main(String[] args) throws Exception
    {
        out.println("*** Task 1. Singly linked list ***");
        var list = new SinglyLinkedList<Integer>();
        out.println("A. 2.\n" + "Added 8 random items, 10 at front, 20 at back, 30 at front:");
        for(int i = 0; i < 8; i++)
        {
            list.addBack(Random(1, 5));
        }
        list.addFront(10)
                .addBack(20)
                .addFront(30);
        PrintCollection(list);
        out.println("Replaced all 1 with 9:");
        list.replace(1, 9);
        PrintCollection(list);
        out.println("C. 4.\n" + "Added: 40 at back 2 times:");
        list.addBack(40)
                .addBack(40);
        PrintCollection(list);
        out.println("Called .unique():");
        list.unique();
        PrintCollection(list);
        out.println();

        out.println("*** Task 2. Circular bidirectional list ***");
        out.println("2.\nAdded: 10 ranodom items:");
        var cbl = new CircularBidirectionalList<Integer>();
        for(int i = 0; i < 10; i++)
        {
            cbl.addBack(Random(1, 20));
        }
        PrintCollection(cbl);
        out.println("Called CircularBidirectionalList.printReverse():");
        cbl.printReverse();
        out.println("Called printListReverse():");
        PrintCollectionReverse(cbl);
        out.println();

        out.println("*** Task 3. Queue ***");
        var que = new Queue<Integer>();
        out.println("Added 8 items:");
        que.push(1)
                .push(2)
                .push(3)
                .push(4)
                .push(5)
                .push(6)
                .push(7)
                .push(8);
        PrintCollection(que);
        out.println("Called .pop():");
        que.pop();
        PrintCollection(que);
        int required = 7;
        out.print(String.format("Try to find %d: ", required));
        int result = que.find(required);
        if((Integer)result != null)
            out.println(String.format("found at %d position", result));
        else
            out.println("not found");
        out.println();

        out.println("*** Task 4. Stack ***");
        var stack = new Stack<String>();
        out.println("Добавим в стек все дни недели (.Push()):");
        stack.Push("Понедельник")
                .Push("Вторник")
                .Push("Среда")
                .Push("Четверг")
                .Push("Пятница")
                .Push("Суббота")
                .Push("Воскресенье");
        PrintCollection(stack);
        out.println("Очистим стек (.Pop()) и добавим дни недели в обратном порядке:");
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
        out.println("Уберем понедельник:");
        stack.Pop();
        PrintCollection(stack);
        var required_day = "Суббота";
        out.print(String.format("Попробуем найти \"%s\": ", required_day));
        result = stack.Find(required_day);
        if((Integer)result != null)
            out.println(String.format("found at %d position", result));
        else
            out.println("not found");
        out.println();
    }

    public static void PrintCollectionReverse(CircularBidirectionalList list)
    {
        if(list.size() == 0)
        {
            out.println("Collection is empty");
            return;
        }
        for(int i = list.size(); i > -1; i--)
        {
            try
            {
                out.print(list.at(i) + " ");
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
        if(que.size() == 0)
        {
            out.println("Collection is empty");
            return;
        }
        for(int i = 0; i < que.size(); i++)
        {
            try
            {
                out.print(que.at(i) + " ");
            }
            catch (Exception ex) {}
        }
        out.println();
    }

    public static void PrintCollection(CircularBidirectionalList list)
    {
        if(list.size() == 0)
        {
            out.println("Collection is empty");
            return;
        }
        for(int i = 0; i < list.size(); i++)
        {
            try
            {
                out.print(list.at(i) + " ");
            }
            catch (Exception ex) {}
        }
        out.println();
    }

    public static void PrintCollection(SinglyLinkedList list)
    {
        if(list.size() == 0)
        {
            out.println("Collection is empty");
            return;
        }
        for(int i = 0; i < list.size(); i++)
        {
            try
            {
                out.print(list.at(i) + " ");
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
