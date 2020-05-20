package fxml;


import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CheckOutController implements Initializable{

	@FXML
    private JFXTextField creditCardTxt;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton checkBtn;

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
