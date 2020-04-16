package s4_it.lab4;

public class Table1Record
{
    private int _id;
    private String _x;
    private int _yType;
    private String _y;

    public Table1Record(int id, String x, int y_type, String y)
    {
        _id = id;
        _x = x;
        _yType = y_type;
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

    public int get_yType()
    {
        return _yType;
    }

    public String get_y()
    {
        return _y;
    }
}



