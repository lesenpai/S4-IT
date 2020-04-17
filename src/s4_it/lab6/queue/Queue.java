package s4_it.lab6.queue;

/*
    очередь
 */
public class Queue<T>
{
    // size, at, push (в конец), pop (с начала), find(T value)
    private Node<T> _head = null;

    public Queue push(T value)
    {
        var node = new Node<>(value);
        if(_head == null)
            _head = node;
        else
            lastNode().next = node;
        return this;
    }

    private Node lastNode()
    {
        if(_head == null)
            return null;

        var current = _head;
        while(current.next != null)
        {
            current = current.next;
        }
        return current;
    }

    public T pop()
    {
        if(_head == null)
            return null;

        T item = _head.value;
        _head = _head.next;
        return item;
    }

    public int size()
    {
        if(_head == null)
            return 0;

        var current = _head;
        int i = 1;
        for(; current.next != null; i++)
        {
            current = current.next;
        }
        return i;
    }

    public T at(int index)
    {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        var current = _head;
        for(int i = 0; ; i++)
        {
            if(i == index)
                return current.value;

            current = current.next;
        }
    }

    public int find(T value)
    {
        if(_head == null)
            return -1;

        if(_head.next == null && _head.value == value)
            return 0;

        var current = _head;
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
    public T value;
    public Node<T> next;

    public Node(T value_)
    {
        value = value_;
    }
}


