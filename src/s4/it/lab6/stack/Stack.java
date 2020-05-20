package s4.it.lab6.stack;

public class Stack<T>
{
    private final Stack<T> t = this;
    
    private Node<T> head = null;

    public Stack Push(T value)
    {
        var node = new Node<>(value);
        if(t.head != null)
            node.next = t.head;
        t.head = node;
        return this;
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

    public boolean IsEmpty()
    {
        return t.head == null;
    }

    public int Find(T val)
    {
        if(t.head == null)
            return -1;

        if(t.head.next == null && t.head.value == val)
            return 0;

        var current = t.head;
        int i = 0;
        for(; current.next != null; i++)
        {
            if(current.value == val)
                return i;

            current = current.next;
        }
        return -1;
    }
}

class Node<T>
{
    public T value;
    public Node<T> next;

    public Node(T value_)
    {
        value = value_;
    }
}
