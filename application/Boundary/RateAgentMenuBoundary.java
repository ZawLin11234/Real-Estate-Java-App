package application.Boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.ManageUserAccountController;
import application.Controller.RateAgentMenuController;
import application.Entity.ObjectPass;
import application.Entity.Useraccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class RateAgentMenuBoundary implements Initializable{
    @FXML
    private TableView<Useraccount> table;

	@FXML
    private TableColumn<Useraccount, String> userNameColumn;

    @FXML
    private TableColumn<Useraccount, String> emailColumn;

    @FXML
    private TableColumn<Useraccount, String> accountTypeColumn;
    

    @FXML
    private TableColumn<Useraccount, String> activeColumn;
    
    @FXML
    private Label usernameLabel;
    
    @FXML
    private Label userNameDetailLabel;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private TextField userNameTextField;
    
    @FXML
    private TextField passwordField;
    
    String usernamePass = "";

//	ObservableList<Useraccount> array1 = FXCollections.observableArrayList(
//			//super(username, password, name, email, phone_number, agency_name, license_number, profile, status);
//			new Admin("Zaw", "password4", "Zaw@example.com","Zaw Lin Htike"),
//			new Buyer("Matthew", "password3","Matthew Blah Blah", "Matthew@example.com","123456789"),
//			new Agent("Raymond", "password3","Raymond Blah", "Raymond@example.com","12312312312","Agency1", "12333333"),
//			new Seller("Jeff", "password3","Jeff Blah Blah","Jeff@example.com","12312321321")
//
//			);
	ObservableList<Useraccount> array1 = RateAgentMenuController.retrieveAgents();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	userNameColumn.setCellValueFactory(new PropertyValueFactory<Useraccount,String>("username"));
	
	emailColumn.setCellValueFactory(new PropertyValueFactory<Useraccount,String>("email"));
	
	accountTypeColumn.setCellValueFactory(new PropertyValueFactory<Useraccount,String>("profile"));
	
	activeColumn.setCellValueFactory(new PropertyValueFactory<Useraccount,String>("status"));
	
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
//	@FXML
//	void rowClicked(MouseEvent event) {
//		Useraccount clickedUser = table.getSelectionModel().getSelectedItem();
//		usernameLabel.setText(String.valueOf(clickedUser.getUsername()));
//		emailField.setText(String.valueOf(clickedUser.getEmail()));
//		passwordField.setText(String.valueOf(clickedUser.getPassword()));
//		
//	}
	
	@FXML
	void rowClicked(MouseEvent event) {
		Useraccount clickedUser = table.getSelectionModel().getSelectedItem();
		usernameLabel.setText(String.valueOf(clickedUser.getUsername()));	
	}
	


	
	public void searchTable(String userName) {
		ObservableList<Useraccount> searchList = FXCollections.observableArrayList();
		 for (Useraccount user : array1) {
			 if(user.getUsername().equals(userName)) {
				 searchList.add(user);
			 }
		 }
		 table.setItems(searchList);
	}
	public void searchButtonAction(ActionEvent event)throws IOException{
		String userN = userNameTextField.getText().toString().trim();
		searchTable(userN);
	}

	
	public void rateClicked(ActionEvent event)throws IOException{
		ObjectPass.userName= usernameLabel.getText();
		ObservableList<Useraccount> currentTableData = table.getItems();
		ObservableList<Useraccount> viewData = null;
		String currentUsername = usernameLabel.getText().toString();
		for (Useraccount user : currentTableData) {
			if(user.getUsername() == currentUsername && user.getProfile().equals("Agent")) {
				Main m = new Main();
				m.changeScene("rateAgent.fxml");
				break;
			}else {
				usernameLabel.setText("Wrong user");
			}
		}
		
	}

}
