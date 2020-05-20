package fxml;


import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import backend.BookStore;
import backend.IBookStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class CheckOutController implements Initializable{
	
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

    }

    @FXML
    void checkAct(ActionEvent event) {

    }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

}
