package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import backend.BookStore;
import backend.IBookStore;
import components.IPerson;
import components.IUser;
import components.Publisher;
import components.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

public class StoreController implements Initializable {

	private IBookStore myStore = BookStore.getInstance();

	private IUser theUser;

	@FXML
	private JFXListView<String> cartList;
	
	@FXML
    private JFXButton logOutBtn;

	@FXML
	private JFXButton checkOutCartBtn;

	@FXML
	private JFXButton cancelCartBtn;

	@FXML
	private JFXButton removeBookCartBtn;

	@FXML
	private JFXListView<String> searchList;

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
	private JFXButton settingsSaveBtn;

	@FXML
	private Label settingsLabel;

	@FXML
	private JFXButton settingsDemandBtn;

	@FXML
	private JFXPasswordField settingsPass;

	@FXML
	private JFXPasswordField settingsconfirm;

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
	private JFXListView<String> mangaeDemandList;

	@FXML
	private JFXButton manageDemandConfirmBtn;

	@FXML
	private JFXButton manageDemandRejectBtn;

	@FXML
	private JFXListView<String> manageOrdersList;

	@FXML
	private JFXButton manageOrderConfirmBtn;

	@FXML
	private JFXTextField manageNewOrderISBN;

	@FXML
	private JFXButton manageNewOrderBtn;

	@FXML
	private JFXButton showReportsBtn;

	@FXML
	private JFXTextField manageNewOrderNum;

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

	@FXML
	private JFXTextField newPubTxt;

	@FXML
	private JFXButton newPubAddBtn;
	
	@FXML
    private Label addNewPubLabel;

	@FXML
    private JFXListView<String> manageDemandList;
	
	@FXML
    private Label addNewBookFeedBackLabel;

	@FXML
	void manageAddBookAct(ActionEvent event) {
		if(manageAddBookTitle.getText().trim().isEmpty()
				|| manageAddYear.getText().trim().isEmpty()
				|| manageAddCategory.getText().trim().isEmpty()
				|| manageAddAuthor.getText().trim().isEmpty()
				|| manageAddPrice.getText().trim().isEmpty()
				|| manageAddAmount.getText().trim().isEmpty()
				|| manageAddPublisher.getText().trim().isEmpty()) {
			addNewBookFeedBackLabel.setText("*All fields should not be plank");
		} else {
			HashMap<String, String> newBook = new HashMap<>();
			newBook.put("title", manageAddBookTitle.getText());
			newBook.put("publisher_name", manageAddPublisher.getText());
			newBook.put("publication_year", manageAddYear.getText());
			newBook.put("price", manageAddPrice.getText());
			newBook.put("category", manageAddCategory.getText());
			newBook.put("NoOfBooks", manageAddAmount.getText());
			newBook.put("author", manageAddAuthor.getText());
			myStore.addNewBook(newBook);
		}
	}
	

	@FXML
	void addPubBtn(ActionEvent event) {
		if(newPubTxt.getText().trim().isEmpty()
				|| manageAddPubAddress.getText().trim().isEmpty()
				|| manageAddPubPhone.getText().trim().isEmpty()) {
			addNewPubLabel.setText("*All fields should be filled.");
		} else {
			IPerson newPub =  new Publisher(newPubTxt.getText(), manageAddPubAddress.getText(), manageAddPubPhone.getText());
			myStore.addNewPublisher(newPub);
			newPubTxt.clear();
			manageAddPubAddress.clear();
			manageAddPubPhone.clear();
			addNewPubLabel.setText("*Data added successfully.");
		}
	}
	

	@FXML
	void cancelCartAct(ActionEvent event) {
		myStore.clearCart();
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
	void confirmBookOrderAct(ActionEvent event) {
		ObservableList<String> selectedItems = manageOrdersList.getSelectionModel().getSelectedItems();
		ArrayList<String> selectedItemsArrayList = new ArrayList<String>();
		for (String i :selectedItems) {
			selectedItemsArrayList.add(i);
		}
		try {
			myStore.confirmOrders(selectedItemsArrayList);
		} catch (Exception e) {
			// Nothing happens.
		}
		try {
			Map<String, String> ordersHashMap = myStore.getOrders();
			ArrayList<String> ordersList = new ArrayList<String>();
			for (Map.Entry<String, String> entry : ordersHashMap.entrySet()) {
				String temp = entry.getKey() + " " + entry.getValue();
				ordersList.add(temp);
			}
			ObservableList<String> ordersObservList = FXCollections.observableArrayList(ordersList);
			manageOrdersList.setItems(ordersObservList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	void demandConfirmBtnAct(ActionEvent event) {
		ObservableList<String> selectedItems = manageDemandList.getSelectionModel().getSelectedItems();
		ArrayList<String> selectedItemsArrayList = new ArrayList<String>();
		for (String i :selectedItems) {
			selectedItemsArrayList.add(i);
		}
		try {
			myStore.acceptUser(selectedItemsArrayList);
		} catch (Exception e) {
			// Nothing happens.
		}
		try {
			ArrayList<String> demandPrivUsers = myStore.getdemandUsers();
			ObservableList<String> demnandPrivObserList = FXCollections.observableArrayList(demandPrivUsers);
			manageDemandList.setItems(demnandPrivObserList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FXML
	void demandManagerPrivilagesAct(ActionEvent event) {
		myStore.demandUser();
		try {
			ArrayList<String> demandPrivUsers = myStore.getdemandUsers();
			ObservableList<String> demnandPrivObserList = FXCollections.observableArrayList(demandPrivUsers);
			manageDemandList.setItems(demnandPrivObserList);
		} catch (Exception e) {
			// Nothing happens.
		}
	}

	@FXML
	void demandRejectBtnAct(ActionEvent event) {
		ObservableList<String> selectedItems = manageDemandList.getSelectionModel().getSelectedItems();
		ArrayList<String> selectedItemsArrayList = new ArrayList<String>();
		for (String i :selectedItems) {
			selectedItemsArrayList.add(i);
		}
		try {
			myStore.rejectUser(selectedItemsArrayList);
		} catch (Exception e) {
			// Nothing happens.
		}
		try {
			ArrayList<String> demandPrivUsers = myStore.getdemandUsers();
			ObservableList<String> demnandPrivObserList = FXCollections.observableArrayList(demandPrivUsers);
			manageDemandList.setItems(demnandPrivObserList);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	@FXML
	void editBookAct(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/EditBook.fxml"));
			Parent theStore = loader.load();

			Scene storeScene = new Scene(theStore);

			// this line gets the stage information.
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

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
		if (settingsFirstName.getText().trim().isEmpty() || settingsLastName.getText().trim().isEmpty()
				|| settingsUserName.getText().trim().isEmpty() || settingsEmail.getText().trim().isEmpty()
				|| settingsPhone.getText().trim().isEmpty() || settingsAddress.getText().trim().isEmpty()
				|| settingsPass.getText().trim().isEmpty() || settingsconfirm.getText().trim().isEmpty()) {
			settingsLabel.setText("*All fields should be filled.");

		} else {
			if (!settingsPass.getText().equals(settingsconfirm.getText())) {
				settingsLabel.setText("*Passwords should be identical.");
			} else {
				IUser newUser = new User(settingsUserName.getText(), settingsAddress.getText(),
						settingsPhone.getText());
				newUser.setFirst_name(settingsFirstName.getText());
				newUser.setLast_name(settingsLastName.getText());
				newUser.setEmail(settingsEmail.getText());
				newUser.setPassword(settingsPass.getText());
				newUser.setIsManager(theUser.getIsManager());
				boolean exist = myStore.updateSettings(newUser);
				if (!exist) {
					settingsLabel.setText("this user name already exists.");
				} else {
					settingsLabel.setText("Data saved suuccessfully.");
				}

			}
		}

	}

	@FXML
	void showReportsAct(ActionEvent event) {

	}

	@FXML
    void logOut(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/SignIn_Up.fxml"));
			Parent signIn_Up = loader.load();
			
			Scene signIn_UpScene = new Scene(signIn_Up);
			
			Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(signIn_UpScene);
			window.setTitle("BookStore");
			window.show();
			window.setResizable(false);
		} catch (Exception e) {
			// Nothing happens.
		}
		
    }
	
	public void intiateData(IUser user) {
		theUser = user;
		settingsFirstName.setText(theUser.getFirst_name());
		settingsLastName.setText(theUser.getLast_name());
		settingsUserName.setText(theUser.getName());
		settingsEmail.setText(theUser.getEmail());
		settingsPhone.setText(theUser.getPhone());
		settingsAddress.setText(theUser.getAddress());
		settingsPass.setText(theUser.getPassword());
		settingsconfirm.setText(theUser.getPassword());
		try {
			ArrayList<String> demandPrivUsers = myStore.getdemandUsers();
			ObservableList<String> demnandPrivObserList = FXCollections.observableArrayList(demandPrivUsers);
			manageDemandList.setItems(demnandPrivObserList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Map<String, String> ordersHashMap = myStore.getOrders();
			ArrayList<String> ordersList = new ArrayList<String>();
			for (Map.Entry<String, String> entry : ordersHashMap.entrySet()) {
				String temp = entry.getKey() + " " + entry.getValue();
				ordersList.add(temp);
			}
			ObservableList<String> ordersObservList = FXCollections.observableArrayList(ordersList);
			manageOrdersList.setItems(ordersObservList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		manageOrdersList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		manageDemandList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

}
