package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FxMain extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        primaryStage.setResizable(false);
        Parent r = FXMLLoader.load(getClass().getResource("login.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("DarBora");

        primaryStage.setScene(new Scene(r, 600, 400));
        primaryStage.show();
    }
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stage.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
