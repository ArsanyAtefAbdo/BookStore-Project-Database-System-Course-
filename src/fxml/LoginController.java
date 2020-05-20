package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import backend.IBookStore;
import components.IUser;
import components.User;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class LoginController implements Initializable {

	private IBookStore myStore;

	@FXML
	private JFXTextField logInUserName;

	@FXML
	private JFXPasswordField logInPass;

	@FXML
	private JFXButton logInBtn;

	@FXML
	private JFXTextField signUpFirstName;

	@FXML
	private JFXPasswordField signUpPass;

	@FXML
	private JFXPasswordField signUpConfirm;

	@FXML
	private JFXButton signUpBtn;

	@FXML
	private JFXTextField signUpLastName;

	@FXML
	private JFXTextField signUpUserName;

	@FXML
	private JFXTextField signUpEmail;

	@FXML
	private JFXTextField signUpPhone;

	@FXML
	private JFXTextField signUpAddress;

	@FXML
	private Label signUpLabel;

	@FXML
	private Label logInLabel;

	@FXML
	void logInAct(ActionEvent event) {
		if (logInPass.getText().trim().isEmpty() || logInUserName.getText().trim().isEmpty()) {
			logInLabel.setText("Enter both user name and password.");
		} else {
			IUser loginUser;
			try {
				loginUser = myStore.logIn(logInUserName.getText(), logInPass.getText());
			} catch (Exception e) {
				loginUser = null;
			}
			if (loginUser == null) {
				logInLabel.setText("This user doesn't exist");
			} else {
				//open the store.
			}
		}
	}

	@FXML
	void signUpAct(ActionEvent event) {
		//if blanks.
		if(signUpFirstName.getText().trim().isEmpty()
				||signUpLastName.getText().trim().isEmpty()
				||signUpUserName.getText().trim().isEmpty()
				||signUpEmail.getText().trim().isEmpty()
				||signUpPhone.getText().trim().isEmpty()
				||signUpAddress.getText().trim().isEmpty()
				||signUpPass.getText().trim().isEmpty()
				||signUpConfirm.getText().trim().isEmpty()) {
			signUpLabel.setText("All fields should be entered.");
		} else {
			//if passwords are not identical.
			if(!signUpPass.getText().equals(signUpConfirm.getText())) {
				signUpLabel.setText("Passwords are not identical.");
			} else {
				//create user.
				IUser signupUser = new User(signUpUserName.getText(), signUpAddress.getText(), signUpPhone.getText());
				signupUser.setFirst_name(signUpFirstName.getText());
				signupUser.setLast_name(signUpLastName.getText());
				signupUser.setPassword(signUpPass.getText());
				signupUser.setEmail(signUpEmail.getText());
				signupUser.setIsManager(false);
				
				//check if exist.
				boolean exist = false;
				try {
					System.out.println("here");
					exist = myStore.signUp(signupUser);
					
					if(!exist) {
						signUpLabel.setText("This user already exists.");
					} else {
						//open store.
						signUpLabel.setText("success.");
					}
				} catch (Exception e) {
					signUpLabel.setText(e.getMessage());
					System.out.println(e.getMessage());
//					System.out.println(exist);
				}
				
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		RequiredFieldValidator validator = new RequiredFieldValidator();
//		logInPass.getValidators().add(validator);
//		validator.setMessage("this field should not be blank");

	}
}
