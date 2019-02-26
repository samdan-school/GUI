package sample;

import javafx.application.Application;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        HBox hbox = new HBox();
        GridPane grid = new GridPane();
        grid.setHgap(3);
        grid.setVgap(3);

        TextField text = new TextField("Mongoliin saihan oron");
        text.setMinWidth(180);

//        Button bt1 = new Button();
//        Button bt2 = new Button("MR");
//        Button bt3 = new Button("M+");
//        Button bt4 = new Button("M-");
//        Button bt5 = new Button("CE");
//        grid.add(bt1, 0, 0);
//        grid.add(bt2, 1, 0);
//        grid.add(bt3, 2, 0);
//        grid.add(bt4, 3, 0);
//        grid.add(bt5, 4, 0);

        Button[] btnArray = new Button[25];
        String[] btnText = {"MC", "MR", "M+", "M-", "CE", "7", "8", "9", "÷", "√", "4", "5", "6", "x", "%", "1", "2", "3", "-", "1/x", "0", ".", "+/-", "+", "="};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                btnArray[i * 5 + j] = new Button(btnText[i * 5 + j]);
                grid.add(btnArray[i * 5 + j], j, i);
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
}

// online-calculator.com