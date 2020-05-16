package s4.it.lab7.mvc;

import s4.it.lab7.Lab7Controller;
import s4.it.lab7.mvc.data_type.PriceList;
import s4.it.lab7.mvc.data_type.TimeList;

public class Model
{
    private Lab7Controller window;
    private View view;

    public Model(View view)
    {
        this.window = view.window;
        this.view = view;
    }

    public void PriceCalculationLogic(String s_distance_km)
    {
        var check = PriceCalculationCheck(s_distance_km);
        if(check.isOk)
        {
            var price_list = new PriceList();
            var distance_km = Double.parseDouble(s_distance_km);
            price_list.car = window.vehicleCar.travelPriceRubKm * distance_km;
            price_list.train = window.vehicleTrain.travelPriceRubKm * distance_km;
            price_list.plane = window.vehiclePlain.travelPriceRubKm * distance_km;

            var time_list = new TimeList();
            time_list.carH = distance_km / window.vehicleCar.speedKmH;
            time_list.trainH = distance_km / window.vehicleTrain.speedKmH;
            time_list.planeH = distance_km / window.vehiclePlain.speedKmH;

            view.PriceCalculationUpdate(price_list, time_list);
        }
        else
        {
            view.PriceCalculationError(check.exception);
        }
    }

    private CheckResult PriceCalculationCheck(String distance_km)
    {
        var res = new CheckResult();
        try
        {
            var dist = Double.parseDouble(distance_km);
            if(dist < 0)
            {
                throw new Exception();
            }
        }
        catch (Exception ex)
        {
            res.isOk = false;
            res.exception = ex;
            return res;
        }

        res.isOk = true;
        return res;
    }

    public static class CheckResult
    {
        public boolean isOk;
        public Exception exception;
    }
}
