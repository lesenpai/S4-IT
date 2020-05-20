package s4.it.DataType;

public class Result<T>
{
    public boolean Success;
    public T Value;

    public Result()
    {
    }

    public Result(boolean success, T value)
    {
        Success = success;
        Value = value;
    }
}
