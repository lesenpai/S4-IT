/*

 */

package s4.it.lab7;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import s4.it.lab7.vehicle.Car;
import s4.it.lab7.vehicle.Plane;
import s4.it.lab7.vehicle.Train;

public class Controller
{
    public Car vehicleCar;
    public Train vehicleTrain;
    public Plane vehiclePlain;

    @FXML
    public Label Lbl_CarPrice;
    @FXML
    public Label Lbl_TrainPrice;
    @FXML
    public Label Lbl_PlanePrice;

    @FXML
    public Label Lbl_CarTimeH;
    @FXML
    public Label Lbl_TrainTimeH;
    @FXML
    public Label Lbl_PlaneTimeH;

    @FXML
    public TextField Lbl_DistanceKm;

    private View view;
    private Model model;

    public Controller()
    {
        this.view = new View(this);
        this.model = new Model(view);

        vehicleCar = new Car();
        vehicleTrain = new Train();
        vehiclePlain = new Plane();
    }

    @FXML
    private void Btn_CalculatePrices_Click()
    {
        model.PriceCalculationLogic(Lbl_DistanceKm.getText());
    }
}
