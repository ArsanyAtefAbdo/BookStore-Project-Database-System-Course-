package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import backend.BookStore;
import backend.IBookStore;
import components.IUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StoreController implements Initializable{
	
	private IBookStore myStore = BookStore.getInstance();
	
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
	
	
	@FXML
    void addBookAct(ActionEvent event) {

    }

    @FXML
    void cancelCartAct(ActionEvent event) {

    }

    @FXML
    void checkOutBtnAct(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/CheckOut.fxml"));
			Parent checkParent = loader.load();
			
			Scene checkScene = new Scene(checkParent);
			
			Stage window = new Stage();
			window.setScene(checkScene);
			window.setTitle("Check Out");
			window.show();
			window.setResizable(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void confirmBookAct(ActionEvent event) {

    }

    @FXML
    void demandConfirmBtnAct(ActionEvent event) {

    }

    @FXML
    void demandManagerPrivilagesAct(ActionEvent event) {

    }

    @FXML
    void demandRejectBtnAct(ActionEvent event) {

    }

    @FXML
    void editBookAct(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/EditBook.fxml"));
			Parent theStore = loader.load();
			
			Scene storeScene = new Scene(theStore);
			
			
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

    @FXML
    void newOrderAct(ActionEvent event) {

    }

    @FXML
    void saveSettingsChangesAct(ActionEvent event) {

    }

    @FXML
    void showReportsAct(ActionEvent event) {

    }
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
