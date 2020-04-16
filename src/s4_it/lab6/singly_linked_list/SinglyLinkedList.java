package s4_it.lab6.singly_linked_list;
import java.util.ArrayList;

public class SinglyLinkedList<T>
{
    // ссылка на первый элемент
    private Node<T> _head = null;

    public SinglyLinkedList addFront(T value)
    {
        var node = new Node<>(value);
        if(_head != null)
            node.mNext = _head;
        _head = node;
        return this;
    }

    public int size()
    {
        if(_head == null)
            return 0;

        var current = _head;
        int i = 1;
        for(; current.mNext != null; i++)
        {
            current = current.mNext;
        }
        return i;
    }

    public SinglyLinkedList addBack(T value)
    {
        var node = new Node<>(value);
        if(_head == null)
            _head = node;
        else
            lastNode().mNext = node;
        return this;
    }

    private Node lastNode()
    {
        if(_head == null)
            return null;

        var current = _head;
        while(current.mNext != null)
        {
            current = current.mNext;
        }
        return current;
    }

    public T at(int index) throws Exception
    {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        var current = _head;
        for(int i = 0; ; i++)
        {
            if(i == index)
                return current.mValue;

            current = current.mNext;
        }
    }

    public SinglyLinkedList removeAt(int index) throws Exception
    {
        if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        var current = _head;
        for(int i = 0; ; i++)
        {
            if(i == index - 1)
            {
                current.mNext = current.mNext.mNext;
                return this;
            }
            current = current.mNext;
        }
    }

    // заменить все %old_val на %new_val
    public SinglyLinkedList replace(T old_val, T new_val)
    {
        if(_head == null)
            return this;

        var current = _head;
        while (current != null)
        {
            if(current.mValue == old_val)
                current.mValue = new_val;
            current = current.mNext;
        }
        return this;
    }

    // оставить только первые вхождения элементов
    public SinglyLinkedList unique()
    {
        if(_head == null)
            return this;

        ArrayList<T> buffer = new ArrayList<>();
        var current = _head;
        for(int i = 0; current != null; )
        {
            if(buffer.contains(current.mValue))
            {
                try
                {
                    removeAt(i);
                }
                catch (Exception ignore)
                { }
            }
            else
            {
                buffer.add(current.mValue);
                i++;
            }
            current = current.mNext;
        }
        return this;
    }
}

class Node<T>
{
    public T mValue;
    public Node<T> mNext;

    public Node(T value)
    {
        mValue = value;
    }
}


