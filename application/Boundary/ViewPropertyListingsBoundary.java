package application.Boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.ManageUserAccountController;
import application.Controller.ViewPropertyListingsController;
import application.Entity.AccountPass;
import application.Entity.IdPass;
import application.Entity.ObjectPass;
import application.Entity.Property;
import application.Entity.Useraccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ViewPropertyListingsBoundary implements Initializable {
	@FXML
    private TableColumn<Property, String> agentColumn;

    @FXML
    private Button cancelButton;

    @FXML
    private TableColumn<Property, String> conditionColumn;

    @FXML
    private TableColumn<Property, Integer> idColumn;

    @FXML
    private TableColumn<Property, String> locationColumn;

    @FXML
    private Button logout;

    @FXML
    private TableColumn<Property, Double> priceColumn;

    @FXML
    private TableColumn<Property, Integer> roomColumn;

    @FXML
    private TableColumn<Property, String> sellerColumn;

    @FXML
    private TableView<Property> table;

    @FXML
    private TableColumn<Property, String> typeColumn;

    @FXML
    private Label typeDetailLabel;

    @FXML
    private Button viewButton;

    @FXML
    private TextField conditionTextField;

//	ObservableList<Useraccount> array1 = FXCollections.observableArrayList(
//			//super(username, password, name, email, phone_number, agency_name, license_number, profile, status);
//			new Admin("Zaw", "password4", "Zaw@example.com","Zaw Lin Htike"),
//			new Buyer("Matthew", "password3","Matthew Blah Blah", "Matthew@example.com","123456789"),
//			new Agent("Raymond", "password3","Raymond Blah", "Raymond@example.com","12312312312","Agency1", "12333333"),
//			new Seller("Jeff", "password3","Jeff Blah Blah","Jeff@example.com","12312321321")
//
//			);
	ObservableList<Property> array1 = ViewPropertyListingsController.retriveData();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	idColumn.setCellValueFactory(new PropertyValueFactory<Property,Integer>("propertyId"));
	
	typeColumn.setCellValueFactory(new PropertyValueFactory<Property,String>("propertyType"));
	
	roomColumn.setCellValueFactory(new PropertyValueFactory<Property,Integer>("room"));
	
	locationColumn.setCellValueFactory(new PropertyValueFactory<Property,String>("location"));
	
	conditionColumn.setCellValueFactory(new PropertyValueFactory<Property,String>("condition"));
	
	priceColumn.setCellValueFactory(new PropertyValueFactory<Property,Double>("price"));
	
	agentColumn.setCellValueFactory(new PropertyValueFactory<Property,String>("agent"));
	
	sellerColumn.setCellValueFactory(new PropertyValueFactory<Property,String>("seller"));
	
	
	table.setItems(array1);
	}
	
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("afterLoginBuyer.fxml");
	}

	@FXML
	void rowClicked(MouseEvent event) {
		Property clickedUser = table.getSelectionModel().getSelectedItem();
		IdPass.id = clickedUser.getPropertyId();
		typeDetailLabel.setText(String.valueOf(clickedUser.getPropertyType()));	
		ViewPropertyListingsController.addCount(clickedUser.getPropertyId());
	}


	public void searchTable(String type) {
		ObservableList<Property> searchList = FXCollections.observableArrayList();
		 for (Property property : array1) {
			 if(property.getCondition().equals(type)) {
				 searchList.add(property);
			 }
		 }
		 table.setItems(searchList);
	}
	public void searchButtonAction(ActionEvent event)throws IOException{
		String type = conditionTextField.getText().toString().trim();
		searchTable(type);
	}
	public void saveButtonAction(ActionEvent event)throws IOException{
		ViewPropertyListingsController.saveProperty(AccountPass.userName, AccountPass.profile, IdPass.id);
		typeDetailLabel.setText("Saved Property!");	
	}
	public void buyButtonAction(ActionEvent event)throws IOException{
		Main m = new Main();
		m.changeScene("buyProperty.fxml");
	}

}
