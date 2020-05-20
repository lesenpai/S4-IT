package s4.it.lab4.Utils;

public class Table2Record
{
    private int _id;
    private String _x;
    private String _y;

    public Table2Record(int id, String x, String y)
    {
        _id = id;
        _x = x;
        _y = y;
    }

    public int get_id()
    {
        return _id;
    }

    public String get_x()
    {
        return _x;
    }

    public String get_y()
    {
        return _y;
    }
}



