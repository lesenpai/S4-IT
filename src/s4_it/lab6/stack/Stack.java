package s4_it.lab6.stack;

public class Stack<T>
{
    // size, at, push(в начало), pop(с начала), find(T val), isEmpty()
    private Node<T> _head = null;

    public Stack Push(T value)
    {
        var node = new Node<>(value);
        if(_head != null)
            node.next = _head;
        _head = node;
        return this;
    }

    public T Pop()
    {
        if(_head == null)
            return null;

        T item = _head.value;
        _head = _head.next;
        return item;
    }

    public int Size()
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

    public T At(int index)
    {
        if(index < 0 || index >= Size())
            throw new IndexOutOfBoundsException();

        var current = _head;
        for(int i = 0; ; i++)
        {
            if(i == index)
                return current.value;

            current = current.next;
        }
    }

    public boolean IsEmpty()
    {
        return _head == null;
    }

    public int Find(T val)
    {
        if(_head == null)
            return -1;

        if(_head.next == null && _head.value == val)
            return 0;

        var current = _head;
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
