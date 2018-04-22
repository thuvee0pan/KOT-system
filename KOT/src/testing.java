import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class testing extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root;
		
		root= FXMLLoader.load(getClass().getResource("/application/MainDash.fxml"));
		Scene scene = new Scene(root,300,400);
	//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public static void main(String args[]) {

	launch(args);

	}

}
