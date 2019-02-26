package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField txtInterestEarned;

    @FXML
    private TextField txtFutureValue;

    @FXML
    private TextField txtPrincipal;

    @FXML
    private TextField txtInterestRate;

    @FXML
    private TextField txtPeriods;

    @FXML
    private RadioButton rdoMonthly;

    @FXML
    private RadioButton rdoQuarterly;

    @FXML
    private RadioButton rdoSemiannually;

    @FXML
    private RadioButton rdoAnnually;

    @FXML
    private Button btnCalculate;

    @FXML
    private Button btnClose;

    @FXML
    void closwWindows(ActionEvent event) {

    }

}
