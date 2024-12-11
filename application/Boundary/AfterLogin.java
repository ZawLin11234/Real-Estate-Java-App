package application.Boundary;

import java.io.*;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class AfterLogin {

	@FXML
	private Button logout;
	@FXML
	private Button CreateUserProfileButton;

	@FXML
	private Button createUserAccountButton;
	
	@FXML
	private Button manageUserAccountButton;

	@FXML
	private Button manageUserProfilesButton;
	
	
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void createUserAccount(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("createUserAccountDisplay.fxml");
	}
	public void manageUserAccounts(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("manageUserAccount.fxml");
	}
	public void manageUserProfile(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("manageUserProfile.fxml");
	}
	public void createUserProfile(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("createUserProfile.fxml");
	}
}
