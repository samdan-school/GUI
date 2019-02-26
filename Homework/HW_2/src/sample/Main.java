package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
    // Operand
    double op1 = Double.NaN;
    double op2 = Double.NaN;
    double result = Double.NaN;
    String operation = "";
    int counter = 0;
    String textMsg = "";

    TextField text;

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        HBox hbox = new HBox();
        GridPane grid = new GridPane();
        grid.setHgap(3);
        grid.setVgap(3);

        text = new TextField("");
        text.setMinWidth(180);

        Button[] btnArray = new Button[25];
        String[] btnText = {"MC", "MR", "M+", "M-", "CE", "7", "8", "9", "÷", "√", "4", "5", "6", "x", "%", "1", "2", "3", "-", "1/x", "0", ".", "+/-", "+", "="};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                btnArray[i * 5 + j] = new Button(btnText[i * 5 + j]);
                grid.add(btnArray[i * 5 + j], j, i);
                btnArray[i * 5 + j].setOnAction(e -> btncode(e));
            }
        }

        hbox.getChildren().add(text);
        root.setTop(hbox);
        root.setCenter(grid);

        root.setMargin(hbox, new Insets(0, 0, 10, 0));

        Scene scene = new Scene(root, 205, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void btncode(ActionEvent e) {
        String btnValue = ((Button) e.getSource()).getText();
        switch (btnValue) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                if ((!checkNull(result) && checkNull(op1)) && operation.equals("")) result = Double.NaN;
                textMsg += btnValue;
                text.setText(textMsg);
                break;
            case "+":
            case "-":
            case "x":
            case "÷":
            case "%":
                if (checkNull(result)) {
                    setOps(textMsg);
                    counter++;
                }
                operation = btnValue;

                textMsg = btnValue;
                text.setText(textMsg);

                textMsg = "";
                break;
            case "=":
                setOps(textMsg);
                System.out.println(op1 + operation + op2 + " = " + result);
                if (checkOps()) break;
                else if (!checkNull(result) && checkNull(op2)) {
                    op2 = op1;
                    op1 = result;
                }
                if (!operation.equalsIgnoreCase("")) {
                    switch (operation) {
                        case "+":
                            result = op1 + op2;
                            text.setText(result + "");
                            break;
                        case "-":
                            result = op1 - op2;
                            text.setText(result + "");
                            break;
                        case "x":
                            result = op1 * op2;
                            text.setText(result + "");
                            break;
                        case "÷":
                            result = op1 / op2;
                            text.setText(result + "");
                            break;
                        case "%":
                            result = op1 % op2;
                            text.setText(result + "");
                            break;
                    }
                }
                System.out.println(op1 + operation + op2 + " = " + result + '\n');
                op1 = Double.NaN;
                op2 = Double.NaN;
                counter = 0;
                operation = "";
                textMsg = "";
                break;
            case "√":
                if (!checkNull(result)) {
                    result = Math.sqrt(result);
                    text.setText(result + "");
                } else if (!checkNull(op1)) {
                    result = Math.sqrt(op1);
                    text.setText(result + "");
                }
                break;
            case "1/x":
                if (!checkNull(result)) {
                    result = 1 / result;
                    text.setText(result + "");
                } else if (!checkNull(op1)) {
                    result = 1 / result;
                    text.setText(result + "");
                }
                break;
            case "CE":
                op1 = Double.NaN;
                op2 = Double.NaN;
                operation = "";
                counter = 0;
                textMsg = "";
                text.setText(textMsg);
        }
    }

    public boolean checkNull(Double num) {
        return Double.isNaN(num);
    }

    public void setOps(String v) {
        if (counter % 2 == 0)
            op1 = Double.parseDouble(v);
        else {
            op2 = Double.parseDouble(v);
        }
    }

    public boolean checkOps() {
        return checkNull(op1) && checkNull(op2);
    }
}

// online-calculator.com