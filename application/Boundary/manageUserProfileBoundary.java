package application.Boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.ManageUserAccountController;
import application.Controller.manageUserProfileController;
import application.Entity.ObjectPass;
import application.Entity.Profile;
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


public class manageUserProfileBoundary implements Initializable{
	@FXML
    private Button cancelButton;

    @FXML
    private TableColumn<Profile, String> descriptionColumn;

    @FXML
    private Button logout;

    @FXML
    private TableColumn<Profile, String> profileColumn;
    
    @FXML
    private TableColumn<Profile, String> statusColumn;

    @FXML
    private Label profileLabel;

    @FXML
    private TableView<Profile> table;

    @FXML
    private TextField profileTextField;
    
    @FXML
    private Button viewButton;
    
    ObservableList<Profile> array1 = manageUserProfileController.retriveData();
    
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("afterLogin.fxml");
	}
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	profileColumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("name"));
	
	descriptionColumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("description"));
	
	statusColumn.setCellValueFactory(new PropertyValueFactory<Profile,String>("status"));
	
	table.setItems(array1);
	}


	@FXML
	void rowClicked(MouseEvent event) {
		Profile clickedUser = table.getSelectionModel().getSelectedItem();
		profileLabel.setText(String.valueOf(clickedUser.getName()));	
	}
	public void searchTable(String name) {
		ObservableList<Profile> searchList = FXCollections.observableArrayList();
		 for (Profile user : array1) {
			 if(user.getName().equals(name)) {
				 searchList.add(user);
			 }
		 }
		 table.setItems(searchList);
	}
	public void searchButtonAction(ActionEvent event)throws IOException{
		String userN = profileTextField.getText().toString().trim();
		searchTable(userN);
	}
    
	public void viewClicked(ActionEvent event)throws IOException{
		ObjectPass.userName= profileLabel.getText();
		ObservableList<Profile> currentTableData = table.getItems();
		ObservableList<Profile> viewData = null;
		String currentUsername = profileLabel.getText().toString();
		for (Profile user : currentTableData) {
			if(user.getName() == currentUsername ) {
				Main m = new Main();
				m.changeScene("viewUserProfile.fxml");
				break;
			}
		}
		
	}
    
    
}
