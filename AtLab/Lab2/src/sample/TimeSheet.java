package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.util.zip.GZIPInputStream;

public class TimeSheet extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    // Top
    TextField tfHourlySalary;
    Button btnFind;

    // Center
    TextField days[][];

    // Bottom
    TextField[] pays;
    Button btnClose;


    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        root.setPadding(new Insets(10));

        VBox top = getTop();
        top.setSpacing(5);
        GridPane center = getCenter();
        BorderPane bottom = getBottom();

        root.getChildren().addAll(top, center, bottom);

        Scene scene = new Scene(root, 600, 350);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fun Department Store - New Time Sheet");
        primaryStage.show();
    }

    VBox getTop() {
        // Boxes
        VBox vBox = new VBox();
        HBox hb1 = new HBox();
        hb1.setSpacing(10);
        HBox hb2 = new HBox();
        hb2.setSpacing(10);

        // lbls
        Label lbl1 = new Label("Employee #:");
        Label lbl2 = new Label("Hourly Salary:");
        Label lbl3 = new Label("Time Sheet #:");

        // tfs
        TextField tfEmployeeNo = new TextField();
        tfEmployeeNo.setPromptText("Ex. 12345678");
        TextField tfEmployeeName = new TextField();
        tfEmployeeName.setPromptText("Employee Full Name");

        tfHourlySalary = new TextField();
        tfHourlySalary.setPromptText("Employee Hourly Salary");
        TextField tfTimeSheet = new TextField();
        tfTimeSheet.setPromptText("Time Sheet #");

        // btns
        btnFind = new Button("Find");

        // Add node to HBox
        hb1.getChildren().addAll(lbl1, tfEmployeeNo, tfEmployeeName, btnFind);
        hb2.getChildren().addAll(lbl2, tfHourlySalary, lbl3, tfTimeSheet);

        Separator separator1 = new Separator(Orientation.HORIZONTAL);
        vBox.getChildren().addAll(hb1, hb2, separator1);

        return vBox;
    }

    GridPane getCenter() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(5);

        // Controls
        days = new TextField[2][8];
        Label[] labels = {new Label("Monday"), new Label("Tuesday"), new Label("Wednesday"), new Label("Thursday"), new Label("Friday"), new Label("Saturday"), new Label("Sunday"), new Label("Total"), new Label("Week1"), new Label("Week2")};

        for (int i = 0; i < 8; i++) {
            days[0][i] = new TextField();
            days[0][i].setMaxWidth(55);
            days[1][i] = new TextField();
            days[1][i].setMaxWidth(55);
            grid.add(labels[i], i + 1, 0);
            grid.add(days[0][i], i + 1, 1);
            grid.add(days[1][i], i + 1, 2);
        }
        grid.add(labels[8], 0, 1);
        grid.add(labels[9], 0, 2);

        grid.add(new Separator(Orientation.HORIZONTAL), 0, 3, 9 ,1);

        return grid;
    }

    BorderPane getBottom() {
        BorderPane borderPane = new BorderPane();
        GridPane innerGrid = new GridPane();
        innerGrid.setHgap(5);
        innerGrid.setVgap(5);
        Label[] labels = {new Label("Time"), new Label("Pay"), new Label("Regular:"), new Label("Overtime:"), new Label("Gross Salary:")};

        pays = new TextField[5];
        btnClose = new Button("Close");
        for (int i = 0; i < 5; i++) {
            pays[i] = new TextField();
            pays[i].setMaxWidth(55);
        }
        pays[4].setMaxWidth(90);

        // lbls
        innerGrid.add(labels[0], 1 ,0);
        innerGrid.add(labels[1], 2 ,0);
        innerGrid.add(labels[2], 0 ,1);
        innerGrid.add(labels[3], 0 ,2);
        innerGrid.add(labels[4], 0 ,3);

        // pays
        innerGrid.add(pays[0], 1 ,1);
        innerGrid.add(pays[1], 2 ,1);
        innerGrid.add(pays[2], 1 ,2);
        innerGrid.add(pays[3], 2 ,2);
        innerGrid.add(pays[4], 1 ,3, 2 , 1);
        innerGrid.add(btnClose, 10 , 3);

        borderPane.setLeft(new HBox());
        borderPane.setCenter(innerGrid);

        return borderPane;
    }
}
