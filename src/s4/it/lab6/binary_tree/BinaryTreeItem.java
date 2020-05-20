package s4.it.lab6.binary_tree;

public class BinaryTreeItem<T extends Comparable>
{
    private final BinaryTreeItem<T> t = this;

    public T value;
    public BinaryTreeItem<T> parent = null;
    public BinaryTreeItem<T> left = null;
    public BinaryTreeItem<T> right = null;

    public BinaryTreeItem(T value)
    {
        t.value = value;
    }

    public BinaryTreeItem(T value, BinaryTreeItem<T> parent)
    {
        t.value = value;
        t.parent = parent;
    }

    public void SetLeft(T value)
    {
        t.left = new BinaryTreeItem<>(value, this);
    }

    public void SetRight(T value)
    {
        t.right = new BinaryTreeItem<>(value, this);
    }
}
