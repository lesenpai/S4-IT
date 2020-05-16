/*
    13. Создать суперкласс Пассажиро-перевозчик и подклассы Самолет, Поезд,
        Автомобиль. Определить время и стоимость передвижения.
 */

package s4.it.lab7.vehicle;

/* Пассажиро-перевозчик */
public abstract class Vehicle
{
    // K RUB / km
    public double travelPriceRubKm;
    // km/h
    public double speedKmH;

    public Vehicle(double travel_price_rub_km, double speed_km_h)
    {
        travelPriceRubKm = travel_price_rub_km;
        speedKmH = speed_km_h;
    }
}
