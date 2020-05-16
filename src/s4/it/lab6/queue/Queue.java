package s4.it.lab6.queue;

/*
    очередь
 */
public class Queue<T>
{
    private final Queue<T> t = this;
    
    private Node<T> head = null;

    public Queue Push(T value)
    {
        var node = new Node<>(value);
        if(t.head == null)
            t.head = node;
        else
            LastNode().next = node;
        return this;
    }

    private Node LastNode()
    {
        if(t.head == null)
            return null;

        var current = t.head;
        while(current.next != null)
        {
            current = current.next;
        }
        return current;
    }

    public T Pop()
    {
        if(t.head == null)
            return null;

        T item = t.head.value;
        t.head = t.head.next;
        return item;
    }

    public int Size()
    {
        if(t.head == null)
            return 0;

        var current = t.head;
        int i = 1;
        for(; current.next != null; i++)
        {
            current = current.next;
        }
        return i;
    }

    public T At(int index)
    {
        if(index < 0 || index >= Size())
            throw new IndexOutOfBoundsException();

        var current = t.head;
        for(int i = 0; ; i++)
        {
            if(i == index)
                return current.value;

            current = current.next;
        }
    }

    public int Find(T value)
    {
        if(t.head == null)
            return -1;

        if(t.head.next == null && t.head.value == value)
            return 0;

        var current = t.head;
        int i = 0;

        for(; current.next != null; i++)
        {
            if(current.value == value)
                return i;

            current = current.next;
        }

        return -1;
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


