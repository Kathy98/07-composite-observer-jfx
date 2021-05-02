package ohm.softa.a07;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// This is the entrypoint to your application.
// The main method launches the JavaFX application,
// which is started in start. Nothing needs to be changed here.

public class App extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("views/main.fxml"));
		stage.setTitle("Cafeteria");
		stage.setScene(new Scene(root, 800, 600));
		stage.show();

		// set exit-on-close
		stage.setOnCloseRequest(e -> Platform.exit());
	}
}
