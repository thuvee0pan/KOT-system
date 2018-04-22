package application.Waiter;
import java.net.URL;
import java.util.ResourceBundle;
import application.MainCon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;


public class MainControler implements Initializable {

	@FXML
	public ComboBox<String> tableNo;
	@FXML
	public ListView<String> foodList;
	@FXML 
	public Button total;
	@FXML
	public Button reset;
	@FXML
	public TextField totalOut;
	
	ObservableList<String> tb = FXCollections.observableArrayList("TB001","TB002");	 
	ObservableList<String> foodlist = FXCollections.observableArrayList("Meal","Drinks","Desert");	 
	

	@Override  
	public void initialize(URL location, ResourceBundle resources) {
		tableNo.setItems(tb);
		foodList.setItems(foodlist);
		
	}	
}
