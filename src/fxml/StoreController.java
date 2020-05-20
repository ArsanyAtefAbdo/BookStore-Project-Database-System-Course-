package fxml;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import components.IUser;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class StoreController implements Initializable{
	
	private IUser theUser;
	
	@FXML
    private JFXListView<?> cartList;

    @FXML
    private JFXButton checkOutCartBtn;

    @FXML
    private JFXButton cancelCartBtn;

    @FXML
    private JFXButton removeBookCartBtn;

    @FXML
    private JFXListView<?> searchList;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton searchBtn;

    @FXML
    private JFXTextField findBookNameTxt;

    @FXML
    private JFXTextField findPublisherTxt;

    @FXML
    private JFXTextField findYearTxt;

    @FXML
    private JFXTextField findPriceTxt;

    @FXML
    private JFXTextField findCategoryTxt;

    @FXML
    private JFXComboBox<String> findYearBox;

    @FXML
    private JFXComboBox<String> findPriceBox;

    @FXML
    private JFXTextField findISBNTxt;

    @FXML
    private JFXTextField findAuthorTxt;

    @FXML
    private JFXTextField settingsFirstName;

    @FXML
    private JFXTextField settingsLastName;

    @FXML
    private JFXTextField settingsUserName;

    @FXML
    private JFXTextField settingsEmail;

    @FXML
    private JFXTextField settingsPhone;

    @FXML
    private JFXTextField settingsAddress;

    @FXML
    private JFXTextField settingsPass;

    @FXML
    private JFXTextField settingsconfirm;

    @FXML
    private JFXButton settingsSaveBtn;

    @FXML
    private JFXButton settingsDemandBtn;

    @FXML
    private JFXTextField manageAddBookTitle;

    @FXML
    private JFXTextField manageAddPublisher;

    @FXML
    private JFXTextField manageAddYear;

    @FXML
    private JFXTextField manageAddPrice;

    @FXML
    private JFXTextField manageAddCategory;

    @FXML
    private JFXButton manageAddBtn;

    @FXML
    private JFXListView<?> mangeDemandList;

    @FXML
    private JFXButton mangeDemandConfirmBtn;

    @FXML
    private JFXButton mangeDemandRejectBtn;

    @FXML
    private JFXListView<?> mangeOrdersList;

    @FXML
    private JFXButton mangeOrderConfirmBtn;

    @FXML
    private JFXTextField mangeNewOrderISBN;

    @FXML
    private JFXButton mangeNewOrderBtn;

    @FXML
    private JFXButton showReportsBtn;

    @FXML
    private JFXTextField mangeNewOrderNum;

    @FXML
    private JFXTextField manageAddAmount;

    @FXML
    private JFXTextField manageAddAuthor;

    @FXML
    private JFXButton editBookBtn;

    @FXML
    private JFXTextField manageAddPubAddress;

    @FXML
    private JFXTextField manageAddPubPhone;

	public void intiateData(IUser user) {
		theUser = user;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
