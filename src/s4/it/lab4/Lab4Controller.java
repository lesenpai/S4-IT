package s4.it.lab4;

import s4.it.CustomUtils;
import s4.it.lab2.Lab2;
import s4.it.lab3.Lab3;
import s4.it.lab4.Utils.Table1Record;
import s4.it.lab4.Utils.Table2Record;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.HashMap;
import java.util.stream.Stream;

public class Lab4Controller
{
    @FXML
    private TextArea _taDescription;
    //
    // Lab1.1
    //
    @FXML
    private TextField _l1n1TfXMin;
    @FXML
    private TextField _l1n1TfXMax;
    @FXML
    private TextField _l1n1TfDeltaX;
    @FXML
    private Label _l1n1LblErrorMessage;
    @FXML
    private TableView _l1n1TvTable;
    //
    // Lab1.2
    //
    @FXML
    private TextField _l1n2TfXMin;
    @FXML
    private TextField _l1n2TfXMax;
    @FXML
    private TextField _l1n2TfDeltaX;
    @FXML
    private Label _l1n2LblErrorMessage;
    @FXML
    private TableView _l1n2TvTable;
    //
    // Lab2.1
    //
    @FXML
    private TextField _l2TfArraySize;
    @FXML
    private TextArea _l2TaArray1Source;
    @FXML
    private TextArea _l2TaArray2Source;
    @FXML
    private TextField _l2TfRequiredElement;
    @FXML
    private Label _l2LblArray1SearchResult;
    @FXML
    private TextArea _l2TaArray1Sorted;
    @FXML
    private TextArea _l2TaArray2Sorted;
    @FXML
    private Label _l2LblArray2SearchResult;
    @FXML
    private Label _l2LblArray1SearchMaxResult;
    @FXML
    private Label _l2LblArray2SearchMaxResult;
    @FXML
    private TextArea _l2TaMergedArray;
    @FXML
    private ToggleButton _l2TglRequiredItem;
    @FXML
    private Label _l2LblGenerateArraysErrorMessage;
    @FXML
    private Label _l2LblGoErrorMessage;
    //
    // Lab3
    //
    @FXML
    private TextField _l3TfMatrixSize;
    @FXML
    private Label _l3LblGenerateErrorMessage;
    @FXML
    private TextArea _l3TaMatrix;
    @FXML
    // Fully Positive Lines
    private TextField _l3TfFPLIndexes;
    @FXML
    // Fully Positive Lines
    private TextField _l3TfFPLItemsProducts;
    @FXML
    // Diagonals Parallel to the Main: Diagonal with Max Sum: Info
    private TextArea _l3TaDPMDMSInfo;
    @FXML
    private Label _l3LblGoErrorMessage;
    private int _l3MatrixSize;

    private final String _lab1n1Description = "Лабораторная 1.1. Табулирование функции.\n" +
            "Вариант 11.\n" +
            "a = 2.7, b = 0.27, 0 <= x <= 7, dx = 0.5\n" +
            "y = \n" +
            "\t1) (a + b) / ( e^x + cos(x) ), если x < 2.3\n" +
            "\t2) (a + b)(x + 1), если 2.3 <= x <5\n" +
            "\t3) e^x + sin(x), если x >= 5";
    private final String _lab1n2Description = "Лабораторная 1.2. Вычисление суммы бесконечного ряда.\n" +
            "Вариант 29.\n" +
            "S = sum(infinity, n = 0) ( x^(2n) / (2n)! ) = cosh(x)\n" +
            "0.1 <= x <= 1; dx = 0.1; точость = 10^(-5)";
    private final String _lab2n1Description = "Лабораторная 2.1. Поиск, сортировка и слияние одномерных массивов.\n" +
            "Вариант 5.\n" +
            "Даны два одномерных целочисленных массива.\n" +
            "Произвести поиск заданного значения:\n" +
            "в первом из них – методом последовательного перебора с использованием барьерного элемента,\n" +
            "а во втором – бинарный поиск, предварительно отсортировав этот массив методом вставки.\n" +
            "Первый массив отсортировать затем выбором наименьшего элемента.\n" +
            "Произвести слияние полученных массивов";
    private final String _lab3Description = "Лабораторная 3. Двумерные массивы.\n" +
            "Вариант 4.\n" +
            "Дана целочисленная квадратная матрица. Определить:\n" +
            "1) Произведение элементов в тех строках,\n" +
            "   которые не содержат отрицательных элементов\n" +
            "2) Максимум среди сумм элементов диагоналей,\n" +
            "   параллельных главной диагонали матрицы.";

    public void InitIO()
    {
        _taDescription.setText(_lab1n2Description);
        //
        // Lab 1.1
        //
        _l1n1LblErrorMessage.setText("");
        _l1n1TfXMin.setText("0");
        _l1n1TfXMax.setText("7");
        _l1n1TfDeltaX.setText("0.5");
        _l1n1TvTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn<Integer, Table2Record> column_id1 = new TableColumn<>("ID");
        TableColumn<String, Table2Record> column_x1 = new TableColumn<>("X");
        TableColumn<Integer, Table2Record> column_y_type1 = new TableColumn<>("Y type");
        TableColumn<String, Table2Record> column_y1 = new TableColumn<>("Y");
        column_id1.setCellValueFactory(new PropertyValueFactory<>("_id"));
        column_x1.setCellValueFactory(new PropertyValueFactory<>("_x"));
        column_y_type1.setCellValueFactory(new PropertyValueFactory<>("_yType"));
        column_y1.setCellValueFactory(new PropertyValueFactory<>("_y"));
        _l1n1TvTable.getColumns().addAll(
                column_id1,
                column_x1,
                column_y_type1,
                column_y1
        );
        //
        // Lab 1.2
        //
        _l1n2LblErrorMessage.setText("");
        _l1n2TfXMin.setText("0.1");
        _l1n2TfXMax.setText("1");
        _l1n2TfDeltaX.setText("0.1");
        _l1n2TvTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn<Integer, Table1Record> column_id2 = new TableColumn<>("ID");
        TableColumn<String, Table1Record> column_x2 = new TableColumn<>("X");
        TableColumn<String, Table1Record> column_y2 = new TableColumn<>("S");
        column_id2.setCellValueFactory(new PropertyValueFactory<>("_id"));
        column_x2.setCellValueFactory(new PropertyValueFactory<>("_x"));
        column_y2.setCellValueFactory(new PropertyValueFactory<>("_y"));
        _l1n2TvTable.getColumns().addAll(column_id2, column_x2, column_y2);
        //
        // Lab 2.1
        //
        _l2TfArraySize.setText("24");
        _l2TfRequiredElement.setText("10");
        _l2LblGenerateArraysErrorMessage.setText(null);
        _l2LblGoErrorMessage.setText(null);
        _l2LblArray1SearchResult.setText("...");
        _l2LblArray2SearchResult.setText("...");
        _l2LblArray1SearchMaxResult.setText("...");
        _l2LblArray2SearchMaxResult.setText("...");
        //
        // Lab 3
        //
        _l3TfMatrixSize.setText("8");
        _l3LblGenerateErrorMessage.setText(null);
        _l3LblGoErrorMessage.setText(null);
        _l3TaDPMDMSInfo.setText(null);
    }

    @FXML
    private void Tab_SelectionChanged(Event e)
    {
        var tab_id = ((Tab)e.getSource()).getId();
        switch (tab_id)
        {
            case "_tab1n1":
                _taDescription.setText(_lab1n1Description);
                break;
            case "_tab1n2":
                _taDescription.setText(_lab1n2Description);
                break;
            case "_tab2n1":
                _taDescription.setText(_lab2n1Description);
                break;
            case "_tab3":
                _taDescription.setText(_lab3Description);
                break;
        }
    }

    //
    // Lab1.1
    //
    /*
        \brief Проверить input'ы, вывести сообщение о неправильном вводе,
            либо посчитать результат и вывести его в таблицу
     */
    @FXML
    private void L1n1BtnCalculate_Action()
    {
        _l1n1LblErrorMessage.setText("");
        _l1n1TvTable.getItems().clear();
        try
        {
            if(!(Double.parseDouble(_l1n1TfXMin.getText()) <= Double.parseDouble(_l1n1TfXMax.getText()) &&
                    Double.parseDouble(_l1n1TfDeltaX.getText()) > 0)
            )
            {
                throw new Exception("Ошибка: неправильный ввод");
            }
            double x, x_min, x_max, delta_x, y;
            double a = 2.7, b = -0.27;
            int id, y_type;
            x_max = Double.parseDouble(_l1n1TfXMax.getText());
            x_min = Double.parseDouble(_l1n1TfXMin.getText());
            delta_x = Double.parseDouble(_l1n1TfDeltaX.getText());
            for(x = x_min, id = 1; x < x_max; x += delta_x, id++)
            {
                if(x < 2.3)
                {
                    y = (a + b) / (Math.pow(Math.E, x) + Math.cos(x));
                    y_type = 1;
                }
                else if(x < 5)
                {
                    y = (a + b) * (x + 1);
                    y_type = 2;
                }
                else
                {
                    y = Math.pow(Math.E, x) + Math.sin(x);
                    y_type = 3;
                }
                _l1n1TvTable.getItems().add(new Table1Record(
                        id,
                        String.format("%.2f", x),
                        y_type,
                        String.format("%.3f", y)
                ));
            }
        }
        catch (Exception ex)
        {
            _l1n1LblErrorMessage.setText(ex.getMessage());
        }
    }

    //
    // Lab1.2
    //
    /*
        \brief Проверить input'ы, вывести сообщение о неправильном вводе,
            либо посчитать результат и вывести его в таблицу
     */
    @FXML
    private void L1n2BtnCalculate_Action()
    {
        _l1n2LblErrorMessage.setText("");
        _l1n2TvTable.getItems().clear();
        try
        {
            if(!(Double.parseDouble(_l1n2TfXMin.getText()) <= Double.parseDouble(_l1n2TfXMax.getText()) &&
                    Double.parseDouble(_l1n2TfDeltaX.getText()) > 0)
            )
            {
                throw new Exception("Ошибка: неправильный ввод");
            }
            double x, x_min, x_max, delta_x, y;
            int id;
            x_max = Double.parseDouble(_l1n2TfXMax.getText());
            x_min = Double.parseDouble(_l1n2TfXMin.getText());
            delta_x = Double.parseDouble(_l1n2TfDeltaX.getText());
            for(x = x_min, id = 1; x < x_max; x += delta_x, id++)
            {
                y = Math.cosh(x);
                _l1n2TvTable.getItems().add(new Table2Record(
                        id,
                        String.format("%.2f", x),
                        String.format("%.5f", y))
                );
            }
        }
        catch (Exception ex)
        {
            _l1n2LblErrorMessage.setText(ex.getMessage());
        }
    }

    //
    // Lab2.1
    //
    /*
        \brief Проверить input'ы (размер массива), вывести сообщение о неправильном вводе,
            либо сгенерировать массивы и вывести из в текстовое поле
     */
    @FXML
    private void L2BtnGenerateArrays_Action()
    {
        _l2LblGenerateArraysErrorMessage.setText(null);
        // прочитать размер массива
        int size;
        try
        {
            size = Integer.parseInt(_l2TfArraySize.getText());
            if(size < 1)
                throw new Exception();

        }
        catch (Exception ex)
        {
            _l2LblGenerateArraysErrorMessage.setText("Неверно задан размер массива");
            return;
        }
        // сгенерировать массивы по размеру
        var array1 = Lab2.CreateArray(size, 1, 20);
        var array2 = Lab2.CreateArray(size, 1, 20);
        // отобразить массивы в UI
        _l2TaArray1Source.setText(CustomUtils.arrayToStringNumbered(array1, "    "));
        _l2TaArray2Source.setText(CustomUtils.arrayToStringNumbered(array2, "    "));
    }

    /*
        @brief Прочитать текстбоксы с массивами, вывести сообщение о неправильном вводе,
            либо сделать <то что надо>
     */
    @FXML
    private void L2BtnGo_Action()
    {
        _l2LblGoErrorMessage.setText(null);
        _l2LblArray1SearchResult.setText("...");
        _l2LblArray2SearchResult.setText("...");
        _l2LblArray1SearchMaxResult.setText("...");
        _l2LblArray2SearchMaxResult.setText("...");
        Integer[] array1, array2;
        int required_item = 0;
        try
        {
            array1 = CustomUtils.stringToArrayNumbered(_l2TaArray1Source.getText());
            array2 = CustomUtils.stringToArrayNumbered(_l2TaArray2Source.getText());
        }
        catch (Exception ex)
        {
            _l2LblGoErrorMessage.setText("Массив записан неверно");
            return;
        }
        try
        {
            if(_l2TglRequiredItem.isSelected())
                required_item = Integer.parseInt(_l2TfRequiredElement.getText());
        }
        catch (Exception ex)
        {
            _l2LblGoErrorMessage.setText("Элемент для поиска записан неверно");
            return;
        }
        if(_l2TglRequiredItem.isSelected())
        {
            int search_res = Lab2.BarrierSearch(required_item, array1);
            if(search_res == -1 )
                _l2LblArray1SearchResult.setText("элемент не найден");
            else
                _l2LblArray1SearchResult.setText("#" + search_res);
        }
        _l2LblArray1SearchMaxResult.setText(Integer.toString(Lab2.FindMax(array1)));
        Lab2.SelectionSort(array1);
        _l2LblArray2SearchMaxResult.setText(Integer.toString(Lab2.FindMax(array2)));
        Lab2.InsertionSort(array2);
        _l2TaArray1Sorted.setText(CustomUtils.arrayToStringNumbered(array1, "    "));
        _l2TaArray2Sorted.setText(CustomUtils.arrayToStringNumbered(array2, "    "));
        if(_l2TglRequiredItem.isSelected())
        {
            int search_res = Lab2.BinarySearch(required_item, array2, 0, array2.length - 1);
            if(search_res == -1)
                _l2LblArray2SearchResult.setText("элемент не найден");
            else
                _l2LblArray2SearchResult.setText("#" + search_res);
        }
        var merged = Lab2.MergeSortedArrays(array1, array2);
        _l2TaMergedArray.setText(CustomUtils.arrayToStringNumbered(merged, "    "));
    }

    //
    // Lab3
    //
    /*
        \brief Прочитать размер матрицы, вывести сообщение о неправильном вводе,
            либо создать и записать в UI матрицу
     */
    @FXML
    private void L3BtnGenerate_Action()
    {
        _l3LblGenerateErrorMessage.setText(null);
        _l3TaMatrix.setText(null);
        _l3TfFPLIndexes.setText(null);
        _l3TfFPLItemsProducts.setText(null);
        _l3TaDPMDMSInfo.setText(null);
        // прочитать размер матрицы
        try
        {
            _l3MatrixSize = Integer.parseInt(_l3TfMatrixSize.getText());
            if(_l3MatrixSize < 1)
                throw new Exception();
        }
        catch (Exception ex)
        {
            _l3LblGenerateErrorMessage.setText("Неверно задан размер матрицы");
            return;
        }
        // создать матрицу по размеру
        var matrix = Lab3.SquareMatrix(_l3MatrixSize, -8, 50);
        // записать матрцу в UI
        _l3TaMatrix.setText(CustomUtils.matrixToString(matrix, 5));
    }

    /*
        \brief Прочитать матрицу, вывести сообщение об ошибке,
            либо <сделать то что надо>
     */
    @FXML
    private void L3BtnGo_Action()
    {
        _l3LblGoErrorMessage.setText(null);
        _l3TfFPLIndexes.setText(null);
        _l3TfFPLItemsProducts.setText(null);
        _l3TaDPMDMSInfo.setText(null);
        // прочитать матрицу
        var matrix = new Integer[0][0];
        try
        {
            if(_l3TaMatrix.getText().isEmpty())
                throw new Exception();

            matrix = CustomUtils.stringToMatrix(_l3TaMatrix.getText(), _l3MatrixSize);
        }
        catch (Exception ex)
        {
            _l3LblGoErrorMessage.setText("Матрица записана неверно");
            return;
        }
        // строки, не содержищие отрицательные элементы...
        var positive_rows_indexes = Lab3.PositiveRowsIndexes(matrix);
        // записать %positive_rows_indexes в UI
        var sb = new StringBuilder();
        for(int item : positive_rows_indexes)
        {
            sb.append("#").append(item + 1).append("  ");
        }
        _l3TfFPLIndexes.setText(sb.toString());
        // ... произведения их элементов...
        sb.setLength(0);
        Stream<Integer> int_stream;
        for(var i : positive_rows_indexes)
        {
            int_stream = Stream.of(matrix[i]);
            sb.append(int_stream.reduce((a, b) -> a * b).get()).append("[").append(i + 1).append("]   ");
        }
        _l3TfFPLItemsProducts.setText(sb.toString());
        sb.setLength(0);
        sb.append("Среди диагоналей, параллельных главной диагонали, наибольшую сумму элементов имеет диагональ с началом в точке ");
        HashMap<Integer, Integer[]> diagonal_sums = Lab3.ParallelToMainDiagonalsSums(matrix);
        Integer[] keys = diagonal_sums.keySet().toArray(new Integer[0]);
        int max = keys[0];
        for(int i = 1; i < diagonal_sums.size(); i++)
        {
            if (keys[i] > max)
                max = keys[i];
        }
        //sb.append(Arrays.toString(diagonal_sums.get(max))).append(", и она равна ").append(max);
        sb.append("(x: ").append(diagonal_sums.get(max)[1] + 1)
                .append("; y: ").append(diagonal_sums.get(max)[0] + 1).append(") ").append(", и она равна ").append(max);
        _l3TaDPMDMSInfo.setText(sb.toString());
    }

}


