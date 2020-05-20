package s4_it.lab6.circular_bidirectional_list;

/*
* Циклический двунаправленный список
* */
public class CircularBidirectionalList<T>
{
    // ссылка на первый элемент
    private Node<T> _head = null;

    public int size()
    {
        if (_head == null)
            return 0;

        var current = _head;
        int i = 1;
        for (; current.mNext != _head; i++)
        {
            current = current.mNext;
        }
        return i;
    }

    public void addFront(T value)
    {
        var node = new Node<>(value);
        if (_head == null)
        {
            _head = node;
            _head.mPrev = _head;
            _head.mNext = _head;
        }
        else
        {
            // меняем .mNext последнего элемента
            _head.mPrev.mNext = node;
            node.mPrev = _head.mPrev;
            node.mNext = _head;
            _head.mPrev = node;
            _head = node;
        }
    }

    public void printReverse()
    {
        if (_head == null)
            System.out.println("List is empty");
        else
        {
            var current = _head.mPrev;
            System.out.print(current.mValue + " ");
            current = current.mPrev;
            while (current != _head.mPrev)
            {
                System.out.print(current.mValue + " ");
                current = current.mPrev;
            }
        }
        System.out.println();
    }

    public void addBack(T value)
    {
        var node = new Node<>(value);
        if (_head == null)
        {
            _head = node;
            _head.mPrev = _head;
            _head.mNext = _head;
        }
        else
        {
            // меняем .mNext последнего элемента
            _head.mPrev.mNext = node;
            node.mPrev = _head.mPrev;
            node.mNext = _head;
            _head.mPrev = node;
        }
    }

    public T at(int index) throws Exception
    {
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException();

        var current = _head;
        for (int i = 0; ; i++)
        {
            if (i == index)
                return current.mValue;

            current = current.mNext;
        }
    }
}

class Node<T>
{
    public T mValue;
    public Node<T> mPrev;
    public Node<T> mNext;

    public Node(T value)
    {
        mValue = value;
    }
}
