package csvreader;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("table.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("CSV Reader");
        stage.setOnCloseRequest(windowEvent -> Platform.exit());
        stage.show();


    }



    public static void main(String[] args) {
        launch(args);
    }
}
