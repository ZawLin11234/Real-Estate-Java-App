package application.Boundary;

import java.io.*;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class CreateUserAccountB {

	@FXML
	private Button logout;
	private Button adminButton;
	private Button cancelButton;
	private Button createButton;
	private Button buyerButton;
	private Button sellerButton;
	private Button agentButton;
	
	
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	public void createAdminAccount(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("createUserAccountAdminBoundary.fxml");
	}
	public void userCancel(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("afterLogin.fxml");
	}
	public void createBuyerAccount(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("createUserAccountBuyer.fxml");
	}
	public void createSellerAccount(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("createUserAccountSeller.fxml");
	}
	public void createAgentAccount(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("createUserAccountAgent.fxml");
	}
}