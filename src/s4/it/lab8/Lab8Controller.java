/*
    Тема: Пакеты и исключительные ситуации

    1. Изучить работу с пакетами [OK]
    2. Создать приложение, в котором:
        a. Продемонстрировать умение работать с пакетами (доступ к именам из
           других пакетов, импорт пакетов) [OK]
        b. Продемонстрировать умение обрабатывать исключительные ситуации:
             С использованием множественного блока catch() [OK]
             С использованием вложенных блоков try() [FCK IT]
             С использованием искусственного генерирования исключений [OK]
             С использованием выбрасывания исключений методами [OK]
             С использованием создания собственных исключений [OK]

    *Примечание: в качестве образца использовать приложение «Калькулятор»
 */

package s4.it.lab8;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import s4.it.lab8.calculator.Calculator;
import s4.it.lab8.calculator.CalculatorException.CalculatorException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Lab8Controller
{
    @FXML
    public TextField TF_Expression;

    @FXML
    public Button
            Btn_Clear,
            Btn_BackSpace,
            Btn_Equal,

            Btn_Add,
            Btn_Subtract,
            Btn_Multiply,
            Btn_Divide,

            Btn_7, Btn_8, Btn_9,
            Btn_4, Btn_5, Btn_6,
            Btn_1, Btn_2, Btn_3,
            Btn_0,

            Btn_Point;

    private Lab8View View;

    private final String MULTIPLY_SYMBOL = "ｘ";
    private final String DIVIDE_SYMBOL = "÷";

    private final Map<String, String> OPERATORS_MAP = new HashMap<>() {{
        put(MULTIPLY_SYMBOL, "*");
        put(DIVIDE_SYMBOL, "/");
    }};

    public Lab8Controller()
    {
        View = new Lab8View(this);
    }

    @FXML
    private void Btn_INPUT_Click(Event e)
    {
        var button = (Button)e.getSource();
        var symbol = button.getText();
        var expression = TF_Expression.getText();
        View.SetExpression(expression + symbol);

        /*if(Character.isDigit(symbol.charAt(0)))
        {
            View.SetExpression(expression + symbol);
        }
        else
        {
            switch (symbol)
            {
                case "+":
                case "-":
                    View.SetExpression(expression + symbol);
                    break;

                case MULTIPLY_SYMBOL:
                    View.SetExpression(expression + "*");
                    break;

                case DIVIDE_SYMBOL:
                    View.SetExpression(expression + "/");
                    break;

                case ".":
                    View.SetExpression(expression + ".");
                    break;
            }
        }*/
    }

    @FXML
    private void Btn_Equal_Click()
    {
        double result;
        var expression = new AtomicReference<>(TF_Expression.getText());

        try
        {
            OPERATORS_MAP.forEach((k, v) -> expression.set(expression.get().replace(k, v)));
            result = Calculator.Run(expression.get());
            View.SetExpression(Double.toString(result));
        }
        catch (CalculatorException | ArithmeticException e)
        {
            View.SetExpression(e.getMessage());
        }
        catch (Exception e)
        {
            var stackTrace = Arrays.toString(e.getStackTrace());
            View.AlertError(stackTrace);
        }
    }

    @FXML
    private void Btn_Clear_Click()
    {
        View.ResetExpression();
    }

    @FXML
    private void Btn_BackSpace_Click()
    {
        var expression = TF_Expression.getText();
        expression = expression.substring(0, expression.length() - 1);
        View.SetExpression(expression);
    }
}
