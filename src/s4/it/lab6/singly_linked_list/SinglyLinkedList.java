package s4.it.lab6.singly_linked_list;
import java.util.ArrayList;

public class SinglyLinkedList<T>
{
    private final SinglyLinkedList<T> t = this;

    private Node<T> head = null;

    public SinglyLinkedList AddFront(T value)
    {
        var node = new Node<>(value);
        if(t.head != null)
        {
            node.next = t.head;
        }
        t.head = node;
        return this;
    }

    public int Size()
    {
        if(t.head == null)
        {
            return 0;
        }
        var current = t.head;
        int i = 1;

        for(; current.next != null; i++)
        {
            current = current.next;
        }

        return i;
    }

    public SinglyLinkedList AddBack(T value)
    {
        var node = new Node<>(value);
        if(t.head == null)
        {
            t.head = node;
        }
        else
        {
            LastNode().next = node;
        }

        return this;
    }

    private Node LastNode()
    {
        if(t.head == null)
        {
            return null;
        }

        var current = t.head;

        while(current.next != null)
        {
            current = current.next;
        }

        return current;
    }

    public T At(int index)
    {
        if(index < 0 || index >= Size())
        {
            throw new IndexOutOfBoundsException();
        }

        var current = t.head;

        for(int i = 0; ; i++)
        {
            if(i == index)
            {
                return current.value;
            }

            current = current.next;
        }
    }

    public SinglyLinkedList RemoveAt(int index)
    {
        if(index < 0 || index >= Size())
            throw new IndexOutOfBoundsException();

        var current = t.head;
        for(int i = 0; ; i++)
        {
            if(i == index - 1)
            {
                current.next = current.next.next;
                return this;
            }

            current = current.next;
        }
    }

    // Заменить все %old_val на %new_val
    public SinglyLinkedList Replace(T old_val, T new_val)
    {
        if(t.head == null)
        {
            return this;
        }

        var current = t.head;

        while (current != null)
        {
            if(current.value == old_val)
            {
                current.value = new_val;
            }
            current = current.next;
        }

        return this;
    }

    // Оставить только первые вхождения элементов
    public SinglyLinkedList Unique()
    {
        if(t.head == null)
        {
            return this;
        }

        ArrayList<T> buffer = new ArrayList<>();
        var current = t.head;

        for(int i = 0; current != null; )
        {
            if(buffer.contains(current.value))
            {
                try
                {
                    RemoveAt(i);
                }
                catch (Exception ignore)
                { }
            }
            else
            {
                buffer.add(current.value);
                i++;
            }
            current = current.next;
        }

        return this;
    }
}

class Node<T>
{
    private final Node<T> t = this;

    public T value;
    public Node<T> next;

    public Node(T value)
    {
        t.value = value;
    }
}


