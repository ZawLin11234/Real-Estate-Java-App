package application.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.Entity.UseraccountEntity;


public class LogInController {

	public static String checkLogin(String username,String password,String profile) throws IOException {
		Main m = new Main();
		UseraccountEntity a = new UseraccountEntity();	
		if(a.checkLogin(username.toString(), password.toString(),profile)) {
			return "Success";
		}
		
		else if(username.isEmpty() && password.isEmpty()) {
			return "Empty";
		}
		else {
			return"Wrong";
		}
	}
	
	
}
