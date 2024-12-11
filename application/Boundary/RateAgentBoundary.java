package application.Boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Controller.ManageUserAccountController;
import application.Controller.RateAgentController;
import application.Controller.ViewDetailedAdminController;
import application.Entity.AccountPass;
import application.Entity.ObjectPass;
import application.Entity.Useraccount;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class RateAgentBoundary implements Initializable{

	@FXML
    private Label agencyLabel;

    @FXML
    private Button cancelButton;

    @FXML
    private Button createButton;

    @FXML
    private Label emailLabel;

    @FXML
    private Label licenseLabel;

    @FXML
    private Button logout;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private Label userNameDetailLabel;
	@FXML
	private ChoiceBox<String> rateChoiceBox;
	
    @FXML
    private TextField reviewTextField;
    
    ObservableList<Useraccount> array1 = ManageUserAccountController.retriveData();
    
    private String[] ratings = {"1","2","3","4","5"};
    
    public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("rateAgentMenu.fxml");
	}
	
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		rateChoiceBox.getItems().addAll(ratings);
		userNameDetailLabel.setText(ObjectPass.userName);
		Useraccount displayAccount;
		for(Useraccount user:array1) {
			if(user.getUsername().toString().equals(ObjectPass.userName)&&user.getProfile().equals("Agent")) {
					Useraccount agent =user;	
					System.out.println(agent.getPassword());
					phoneLabel.setText(agent.getPhone_number());
					nameLabel.setText(agent.getName());
					emailLabel.setText(agent.getEmail());
					licenseLabel.setText(agent.getLicense_number());
					agencyLabel.setText(agent.getAgency_name());
			}
		}
		
	}
	public void rateButtonAction() {
		//(String star, String review, String username1, String profile1, String username2, String profile2)
		int star =Integer.parseInt(rateChoiceBox.getValue().toString());
		Useraccount agent = null ;
		for(Useraccount user:array1) {
			if(user.getUsername().toString().equals(ObjectPass.userName)&&user.getProfile().equals("Agent")) {
				agent = user;
				break;
			}
		}
		boolean result = RateAgentController.rateAgent(star, reviewTextField.getText().toString(), agent.getUsername(),agent.getProfile(), AccountPass.userName, AccountPass.profile);
		if(result == true) {
			resultLabel.setText("Reviewed successfully!");
			
		}else {
			resultLabel.setText("Reviewe Failed!");
		}
	}
}
