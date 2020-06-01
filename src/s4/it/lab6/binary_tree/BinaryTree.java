package s4.it.lab6.binary_tree;

public class BinaryTree<T extends Comparable>
{
    private final BinaryTree<T> t = this;

    public BinaryTreeItem<T> root;

    public boolean Add(T value)
    {
        if(t.root == null)
        {
            t.root = new BinaryTreeItem<>(value);
            return true;
        }
        else
        {
            var item = t.root;

            while(true)
            {
                var compare = value.compareTo(item.value);

                if(compare == 0)
                {
                    return false;
                }
                else if(compare < 0)
                {
                    if(item.left == null)
                    {
                        item.SetLeft(value);
                        return true;
                    }
                    else
                    {
                        item = item.left;
                    }
                }
                else if(compare > 0)
                {
                    if(item.right == null)
                    {
                        item.SetRight(value);
                        return true;
                    }
                    else
                    {
                        item = item.right;
                    }
                }
            }
        }
    }

    public void AddRange(T[] range)
    {
        for(var item : range)
        {
            Add(item);
        }
    }

    public boolean Contains(T value)
    {
        if(t.root == null)
        {
            return false;
        }

        var item = t.root;

        while (item != null)
        {
            var compare = value.compareTo(item.value);

            switch (compare)
            {
                case 0:
                    return true;
                case -1:
                    item = item.left;
                    break;
                case 1:
                    item = item.right;
                    break;
            }
        }

        return false;
    }
}
