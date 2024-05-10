package musicplayer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserInterface extends Application {

    @Override
    public void start(Stage window) {

        // Creating a Vertical layout for title and Horizontal for the buttons
        VBox vBox = new VBox();
        HBox hBox = new HBox(6);
        hBox.setPadding(new Insets(100,100,100,100));
        vBox.setAlignment(Pos.CENTER);

        // Setting scene dimensions, adding style and fixating the window
        Scene scene = new Scene(vBox, 1500, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        window.setResizable(false);

        // Header text
        Text titleText = new Text();
        titleText.setId("titleText");
        titleText.setText("'A CHILDISH NOISEMAKER WITH FARM ANIMALS'");


        /* Creating a set of buttons for with sound events attached */

        // Cow sound
        Button cow = new Button();
        cow.setId("cow");
        cow.setMinHeight(130);
        cow.setMinWidth(200);
        cow.setOnAction(e -> Sounds.getSound(cow.getId()));


        // Pig Sound
        Button pig = new Button();
        pig.setId("pig");
        pig.setMinHeight(130);
        pig.setMinWidth(200);
        pig.setOnAction(e -> Sounds.getSound(pig.getId()));


        // Horse Sound
        Button horse = new Button();
        horse.setId("horse");
        horse.setMinHeight(130);
        horse.setMinWidth(200);
        horse.setOnAction(e -> Sounds.getSound(horse.getId()));


        // Dog Barking Sound
        Button dog = new Button();
        dog.setId("dog");
        dog.setMinHeight(130);
        dog.setMinWidth(200);
        dog.setOnAction(e -> Sounds.getSound(dog.getId()));

        // Cat Meowing Sound
        Button cat = new Button ();
        cat.setId("cat");
        cat.setMinHeight(130);
        cat.setMinWidth(200);
        cat.setOnAction(e -> Sounds.getSound(cat.getId()));


        // Rooster Sound
        Button rooster = new Button ();
        rooster.setId("rooster");
        rooster.setMinHeight(130);
        rooster.setMinWidth(200);
        rooster.setOnAction(e -> Sounds.getSound(rooster.getId()));

        // Adding title and buttons to layout
        vBox.getChildren().add(titleText);
        vBox.getChildren().addAll(hBox);
        hBox.getChildren().addAll(pig,cow,horse,cat,rooster,dog);




        // Setting Window Title and initiating scene
        window.setTitle("Sound Player - Kids Edition");
        window.setScene(scene);
        window.show();
    }



}
