package application.Boundary;

import java.io.*;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class AfterLoginBuyer {

    @FXML
    private Button logout;

    @FXML
    private Button manageButton;

    @FXML
    private Button rateButton;

    @FXML
    private Button viewButton;
    
	public void userLogOut(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("Sample.fxml");
	}
	
	public void viewPropertyListings(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("viewPropertyListing.fxml");
	}
	public void rateAgentMenu(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("rateAgentMenu.fxml");
	}
	public void manageSavedProperty(ActionEvent event)throws IOException {
		Main m = new Main();
		m.changeScene("manageSavedPropertyListing.fxml");
	}

}
