package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import backend.BookStore;
import backend.IBookStore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class EditBookController implements Initializable{
	
	private IBookStore myStore = BookStore.getInstance();
	
	@FXML
    private JFXListView<String> booksList;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private JFXTextField oldBookTxt;

    @FXML
    private JFXTextField oldPubTxt;

    @FXML
    private JFXTextField oldYearTxt;

    @FXML
    private JFXTextField oldPriceTxt;

    @FXML
    private JFXTextField oldCategoryTxt;

    @FXML
    private JFXComboBox<String> yearBox;

    @FXML
    private JFXComboBox<String> priceBox;

    @FXML
    private JFXTextField oldIsbnTxt;

    @FXML
    private JFXTextField oldAuthorTxt;

    @FXML
    private JFXTextField newNameTxt;

    @FXML
    private JFXTextField newPubTxt;

    @FXML
    private JFXTextField newYearTxt;

    @FXML
    private JFXTextField newPriceTxt;

    @FXML
    private JFXTextField newCategoryTxt;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXTextField NewAuthorTxt;

    @FXML
    private JFXTextField newPubAddress;

    @FXML
    private JFXTextField newPubPhone;
    
    @FXML
    private JFXButton cancelBtn;

    @FXML
    void searchAct(ActionEvent event) {

    }
	
    @FXML
    void cancelBtnAct(ActionEvent event) {

    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
