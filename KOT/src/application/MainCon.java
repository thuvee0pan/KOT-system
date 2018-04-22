package application;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class MainCon implements Initializable {
	private Stage WaiterLogin = new Stage();
	private Stage kitchen = new Stage();
	private Stage ManagementLogin = new Stage();
	private Stage waiter = new Stage();
	
	@FXML
	public Button Bwaiter;
	@FXML
	public Button BKitchen;
	@FXML
	public Button Bmanagement;
	@FXML
	public Button BLogin;
	@FXML
	private TextField UserId;
	@FXML
	private TextField IdPassword;
	@FXML 
	private Label status;
	
	public void Waiter(ActionEvent Eve) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("WaiterLogin.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		WaiterLogin.setScene(scene);
		WaiterLogin.show();
		
		Stage stage = (Stage)this.Bwaiter.getScene().getWindow();
		stage.close();
		}

	public void Kitchen(ActionEvent Eve) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource(".fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		kitchen.setScene(scene);
		kitchen.show();
		
		Stage stage = (Stage)this.BKitchen.getScene().getWindow();
		stage.close();
	}
	
	public void Management(ActionEvent Eve) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource(".fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		ManagementLogin.setScene(scene);
		ManagementLogin.show();
		
		Stage stage = (Stage)this.Bmanagement.getScene().getWindow();
		stage.close();
	}
	
	
	public void login(ActionEvent Eve) throws Exception{
				//Database Connection 
				Connection connect=null;
				try {Class.forName("com.mysql.jdbc.Driver");
					connect = DriverManager.getConnection("jdbc:mysql://Localhost:3306/KOT?useSSL=true","root","tp607");}
				 catch (Exception e) {	throw e; }

		String Id=UserId.getText();
		String Password= IdPassword.getText();

		
		
		//Get data from Database 		
		 Statement statement = connect.createStatement();
		 ResultSet results = null;
		 results = statement.executeQuery("select * from Waiter");
		 
		    while (results.next()) {		    	
			    String UserId =results.getString("idWaiter");
			    String password = results.getString("password");	
		    
//			    System.out.println( UserId +""+password);
				    if (Id.toUpperCase().equals(UserId) && Password.toUpperCase().equals(password)){
				    	waiter();
				    	break;

				    }else {
				    	status.setText("Wrong User Id or Password" );
				    	
				    }
		    }
		   
	}
	
	
	public void waiter() {
		
		Parent root;
		try {
			root= FXMLLoader.load(getClass().getResource("Waiter/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			waiter.setScene(scene);
			waiter.show();
			Stage stage = (Stage)this.BLogin.getScene().getWindow();
			stage.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		
	}
	
}
