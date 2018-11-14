package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Food tracker™");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Button button = new Button();
        button.setText("Click me!");
    }


    public static void main(String[] args) {
        /*
        Whenever the main java program starts it calls launch(args) and sets up the program
        as a JavaFX application. The app will call the method start().

        Stage - Entire window in JavaFX
        Scene - Content within the Stage
         */
        launch(args);
    }
}
