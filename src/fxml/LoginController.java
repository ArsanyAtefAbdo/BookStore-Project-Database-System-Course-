package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import backend.BookStore;
import backend.IBookStore;
import components.IUser;
import components.User;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

public class LoginController implements Initializable {

	private IBookStore myStore = BookStore.getInstance();

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
				try {
					FXMLLoader loader = new FXMLLoader();
					loader.setLocation(getClass().getResource("/fxml/Store.fxml"));
					Parent theStore = loader.load();
					
					Scene storeScene = new Scene(theStore);
					
					//access StoreController and call the method.
					StoreController controller = loader.getController();
					controller.intiateData(loginUser);
					
					//this line gets the stage information.
					Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
					
					window.setScene(storeScene);
					window.setTitle("BookStore");
					window.show();
					window.setResizable(false);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
						try {
							FXMLLoader loader = new FXMLLoader();
							loader.setLocation(getClass().getResource("/fxml/Store.fxml"));
							Parent theStore = loader.load();
							
							Scene storeScene = new Scene(theStore);
							
							//access StoreController and call the method.
							StoreController controller = loader.getController();
							controller.intiateData(signupUser);
							
							//this line gets the stage information.
							Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
							
							window.setScene(storeScene);
							window.setTitle("BookStore");
							window.show();
							window.setResizable(false);
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
