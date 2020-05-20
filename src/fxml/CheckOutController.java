package fxml;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import backend.BookStore;
import backend.IBookStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CheckOutController implements Initializable {

	private IBookStore myStore = BookStore.getInstance();

	@FXML
	private JFXTextField creditCardTxt;

	@FXML
	private JFXDatePicker datePicker;

	@FXML
	private JFXButton cancelBtn;

	@FXML
	private JFXButton checkBtn;

	@FXML
	private Label checkLabel;

	@FXML
	void cancelAct(ActionEvent event) {
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.close();
	}

	@FXML
	void checkAct(ActionEvent event) {

		if (creditCardTxt.getText().trim().isEmpty() || datePicker.getEditor().getText().trim().isEmpty()) {
			checkLabel.setText("All fields must be entered!");
		} else {

			String creditcard = creditCardTxt.getText();
			int length = creditcard.length();

			if (!(length == 16 && checkNum(creditcard))) {
				checkLabel.setText("Invalid credit card!");
			} else {

				// date is mm/dd/yyyy
				String date = datePicker.getEditor().getText();

				String[] Date = date.split("/");

				StringBuilder myDate = new StringBuilder();

				myDate.append(Date[2]);
				myDate.append("-");
				myDate.append(Date[1]);
				myDate.append("-");
				myDate.append(Date[0]);

				// newdate is yyyy-dd-mm
				String newdate = myDate.toString();

				LocalDate date1 = LocalDate.now();
				LocalDate date2 = LocalDate.of(Integer.parseInt(Date[2]), Integer.parseInt(Date[0]),
						Integer.parseInt(Date[1]));

				if (date1.isAfter(date2)) {
					checkLabel.setText("Invalid Date!");
				} else {
					myStore.chechOut(creditcard, newdate);
					Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
					window.close();
				}
			}
		}
	}

	public boolean checkNum(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!isDigit(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	static boolean isDigit(char c) {

		return c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8'
				|| c == '9';
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

}
