package s4.it.lab8.calculator;

import s4.it.DataType.IFunc;
import s4.it.DataType.Result;
import s4.it.lab8.calculator.CalculatorException.CalculatorException;
import java.util.ArrayList;
import java.util.Locale;

public class Calculator
{
    private static final Character[] OPERATORS = {'+', '-', '*', '/'};
    private static final Character[] OPERATORS_LVL1 = {'*', '/'};
    private static final Character[] OPERATORS_LVL2 = {'+', '-'};
    private static final Character[] VALID_SYMBOLS = {'+', '-', '/', '*',
                                                      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                                                      '.'};

    public static double Run(String expression) throws CalculatorException
    {
        Locale.setDefault(new Locale("en", "US"));
        expression = PrepareExpression(expression);
        var checkResult = CheckExpression(expression);

        if(!checkResult.Success)
        {
            throw new CalculatorException((String)checkResult.Value);
        }

        /* expression - корректный */

        var numbers = new ArrayList<Double>();
        var operators = new ArrayList<Character>();

        // Заполняем массивы numbers & operators
        for(int pos = 0; pos < expression.length(); )
        {
            var symbol = expression.charAt(pos);

            if(Character.isDigit(symbol))
            {
                var readNumberResult = ReadNumber(expression, pos);
                numbers.add(readNumberResult.Number);
                pos = readNumberResult.Position;
            }
            // Считаем, что символ - оператор
            else
            {
                operators.add(symbol);
                pos++;
            }
        }

        // Сначала выполняем операторы 1-го уровня [*, /]
        PerformOperations(OPERATORS_LVL1, operators, numbers);

        // Затем, выполняем операторы 2-го уровня [+, -]
        PerformOperations(OPERATORS_LVL2, operators, numbers);

        //В numbers должен остаться 1 элемент - он и является результатом
        return numbers.get(0);
    }

    // Считаем, что operators соотвествуют numbers
    private static void PerformOperations(Character[] validOperators, ArrayList<Character> operators, ArrayList<Double> numbers) throws CalculatorException
    {
        for(int i = 0; i < operators.size(); i++)
        {
            var operator = operators.get(i);
            if(Any(validOperators, c -> c == operator))
            {
                if(operator == '/' && numbers.get(i + 1) == 0)
                {
                    throw new CalculatorException("Деление на ноль невозможно");
                }

                numbers.set(i, PerformOperation(numbers.get(i), operators.get(i), numbers.get(i + 1)));
                operators.remove(i);
                numbers.remove(i + 1);
                i--;
            }
        }
    }

    private static double PerformOperation(double left, char operator, double right) throws CalculatorException
    {
        switch (operator)
        {
            case '+':
                return left + right;

            case '-':
                return left - right;

            case '*':
                return left * right;

            case '/':
                return left / right;

            default:
                throw new CalculatorException("Недопустимый оператор");
        }
    }

    public static String PrepareExpression(String expression)
    {
        expression = expression.replace(" ", "");
        // "<operator>..." => "0<operator>..."
        String finalExpression = expression;

        if(!expression.isEmpty())
        {
            if(Any(OPERATORS, c -> c == finalExpression.charAt(0)))
            {
                expression = '0' + expression;
            }
            if(Any(OPERATORS, c -> c == finalExpression.charAt(finalExpression.length() - 1)))
            {
                expression = expression.substring(0, expression.length() - 1);
            }
        }

        return expression;
    }

    // FALSE if found ["++", "1.0.9"] etc.
    // Считаем, что expression не содержит пробелы (т.е. предварительно был вызван PrepareExpression)
    private static Result CheckExpression(String expression)
    {
        if(expression.isEmpty())
        {
            return new Result(false, "Пустая строка");
        }
        // Проверка на содержание недопустимых символов
        if(!All(expression.toCharArray(), c -> Any(VALID_SYMBOLS, c2 -> c2 == c)))
        {
            return new Result(false, "Выражение содержит недопустимый символ");
        }

        boolean bReadPointAtCurrentNumber = false;
        boolean bReadDigit = false;

        // Проверка правильности написания чисел
        for(int pos = 0; pos < expression.length(); pos++)
        {
            char c = expression.charAt(pos);
            // Реагируем на ".5" (должно быть "0.5)
            // Реагируем на повторяющуюся точку в числе (должна быть одна точка)
            if(c == '.' && bReadPointAtCurrentNumber && (bReadPointAtCurrentNumber || !bReadDigit))
            {
                return new Result(false, "Вещественное число содержит более одного разделителя");
            }

            if(Character.isDigit(c))
            {
                bReadDigit = true;
            }
            else if(c == '.')
            {
                bReadPointAtCurrentNumber = true;
            }
            else
            {
                bReadDigit = false;
                bReadPointAtCurrentNumber = false;
            }
        }

        // Проверка на подряд идущие операторы
        for(int pos = 0; pos < expression.length() - 1; pos++)
        {
            var currentC = expression.charAt(pos);
            var nextC = expression.charAt(pos + 1);

            if(Any(OPERATORS, c -> c == currentC) && Any(OPERATORS, c -> c == nextC))
            {
                return new Result(false, "Подряд идущие операторы");
            }
        }

        return new Result(true, null);
    }

    private static boolean All(char[] chars, IFunc func)
    {
        for(var c : chars)
        {
            if(!func.Equal(c))
            {
                return false;
            }
        }

        return true;
    }

    private static boolean Any(Character[] chars, IFunc func)
    {
        for(var c : chars)
        {
            if(func.Equal(c))
            {
                return true;
            }
        }

        return false;
    }

    /*
        Считается, что source корректен
     */
    private static ReadNumberResult ReadNumber(String source, int pos)
    {
        String sNumber = "";

        for( ; pos < source.length(); pos++)
        {
            char c = source.charAt(pos);
            if(Character.isDigit(c) || c == '.')
            {
                sNumber += c;
            }
            else
            {
                break;
            }
        }

        return new ReadNumberResult(Double.parseDouble(sNumber), pos);
    }
}

class ReadNumberResult
{
    public double Number;
    public int Position;

    public ReadNumberResult(){}

    public ReadNumberResult(double number, int position)
    {
        Number = number;
        Position = position;
    }
}

