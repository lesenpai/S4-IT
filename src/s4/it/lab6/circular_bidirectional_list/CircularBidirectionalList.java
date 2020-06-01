package s4.it.lab6.circular_bidirectional_list;

/*
* Циклический двунаправленный список
* */
public class CircularBidirectionalList<T>
{
    private final CircularBidirectionalList<T> t = this;

    private Node<T> head = null;

    public int Size()
    {
        if (t.head == null)
            return 0;

        Node<T> current = t.head;
        int i = 1;
        for (; current.next != t.head; i++)
        {
            current = current.next;
        }
        return i;
    }

    public void AddFront(T value)
    {
        var node = new Node<>(value);
        if (head == null)
        {
            t.head = node;
            t.head.prev = t.head;
            t.head.next = t.head;
        }
        else
        {
            // меняем .mNext последнего элемента
            t.head.prev.next = node;
            node.prev = t.head.prev;
            node.next = t.head;
            t.head.prev = node;
            t.head = node;
        }
    }

    public void AddBack(T value)
    {
        var node = new Node<>(value);
        if (t.head == null)
        {
            t.head = node;
            t.head.prev = t.head;
            t.head.next = t.head;
        }
        else
        {
            // меняем .mNext последнего элемента
            t.head.prev.next = node;
            node.prev = t.head.prev;
            node.next = t.head;
            t.head.prev = node;
        }
    }

    public T At(int index)
    {
        if (index < 0 || index >= Size())
        {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = t.head;
        for (int i = 0; ; i++)
        {
            if (i == index)
            {
                return current.value;
            }

            current = current.next;
        }
    }
}

class Node<T>
{
    private final Node<T> t = this;

    public T value;
    public Node<T> prev;
    public Node<T> next;

    public Node(T value)
    {
        t.value = value;
    }
}
