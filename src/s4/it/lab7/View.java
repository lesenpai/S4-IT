package s4.it.lab7;

import javafx.scene.control.Alert;
import s4.it.CustomUtils;
import s4.it.lab7.data_type.PriceList;
import s4.it.lab7.data_type.TimeList;

public class View
{
    public Controller window;

    public View(Controller window)
    {
        this.window = window;
    }

    public void PriceCalculationError(Exception ex)
    {
        CustomUtils.Alert(ex.getMessage(), Alert.AlertType.ERROR);
    }

    public void PriceCalculationUpdate(PriceList price_list, TimeList time_list)
    {
        window.Lbl_CarPrice.setText(convertPriceToString(price_list.car));
        window.Lbl_TrainPrice.setText(convertPriceToString(price_list.train));
        window.Lbl_PlanePrice.setText(convertPriceToString(price_list.plane));

        window.Lbl_CarTimeH.setText(convertTimeHToString(time_list.carH));
        window.Lbl_TrainTimeH.setText(convertTimeHToString(time_list.trainH));
        window.Lbl_PlaneTimeH.setText(convertTimeHToString(time_list.planeH));
    }

    /* HELPERS */

    private String convertPriceToString(double price)
    {
        return CustomUtils.toRoundString(price, 2);
    }

    private String convertTimeHToString(double time_h)
    {
        return CustomUtils.toRoundString(time_h, 2);
    }

}
