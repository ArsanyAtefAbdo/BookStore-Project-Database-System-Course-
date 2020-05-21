package fxml;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import backend.BookStore;
import backend.IBookStore;
import components.Cart;
import components.IBook;
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
import javafx.scene.control.Tab;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;

public class StoreController implements Initializable {

	private IBookStore myStore = BookStore.getInstance();

	private IUser theUser;
	
    private HashMap<String, Pair<String, String>>filters;
    
    private ArrayList<IBook> reusltBooks;
    
    @FXML
    private Label findBookErrorLabel;

    @FXML
    private Tab managingTab;

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
    private JFXDatePicker findYearTxt;

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
    private Label totalPriceLabel;
	
	//Methods.
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
		cartList.getItems().clear();
		totalPriceLabel.setText("total price :  0");
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
			String[] splited = i.split("\\s+");
			String toAdd = splited[1];
			selectedItemsArrayList.add(toAdd);
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
				String temp = "ISBN: " + entry.getKey() + " Amount: " + entry.getValue();
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
			window.setTitle("BookStore:Edit Book");
			window.show();
			window.setResizable(false);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void newOrderAct(ActionEvent event) {
		if(manageNewOrderISBN.getText().trim().isEmpty()
				|| manageNewOrderNum.getText().trim().isEmpty()) {
			//Do Nothing.
		} else {
			myStore.placeOrder(manageNewOrderISBN.getText(), Integer.parseInt(manageNewOrderNum.getText()));
			try {
				Map<String, String> ordersHashMap = myStore.getOrders();
				ArrayList<String> ordersList = new ArrayList<String>();
				for (Map.Entry<String, String> entry : ordersHashMap.entrySet()) {
					String temp = "ISBN: " + entry.getKey() + " Amount: " + entry.getValue();
					ordersList.add(temp);
				}
				ObservableList<String> ordersObservList = FXCollections.observableArrayList(ordersList);
				manageOrdersList.setItems(ordersObservList);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
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
    void searchAddBtnAct(ActionEvent event) {
		
		findBookErrorLabel.setText("");
    	int index = searchList.getSelectionModel().getSelectedIndex();
    	if(index < 0 || reusltBooks.isEmpty()) {
    		return;
    	}
    	IBook selectedBook = reusltBooks.get(index);
    	int indexCart = myStore.getCurrentUser().getCart().getBooks().indexOf(selectedBook);
    	if(indexCart > -1) {
    		selectedBook = myStore.getCurrentUser().getCart().getBooks().get(indexCart);
    	}
    	if(selectedBook.getRequest_amount() == selectedBook.getNo_Of_Books()) {
    		findBookErrorLabel.setText("**There are not enough copies now !!");
    		return;
    	}
    	Cart cart = myStore.addBookToCart(selectedBook);
    	cartList.getItems().clear();
    	cartList.getItems().addAll(cart.getReport());
		totalPriceLabel.setText("total price :  " + cart.get_total_price());
		
    }

    @FXML
    void searchBtnAct(ActionEvent event) {
    	findBookErrorLabel.setText("");
    	filters.clear();
    	
    	if(!findBookNameTxt.getText().trim().isEmpty()) {
    		filters.put("title", new Pair<String, String>("=", findBookNameTxt.getText()));
    	}
    	if(!findISBNTxt.getText().trim().isEmpty()) {
    		filters.put("ISBN", new Pair<String, String>("=", findISBNTxt.getText()));
    	}
    	if(!findPublisherTxt.getText().trim().isEmpty()) {
    		filters.put("publisher_name", new Pair<String, String>("=", findPublisherTxt.getText()));
    	}
    	if(!findAuthorTxt.getText().trim().isEmpty()) {
    		filters.put("author", new Pair<String, String>("=", findAuthorTxt.getText()));
    	}
    	if(!findCategoryTxt.getText().trim().isEmpty()) {
    		filters.put("category", new Pair<String, String>("=", findCategoryTxt.getText()));
    	}
    	if(!findYearTxt.getEditor().getText().trim().isEmpty()) {
    		filters.put("publication_year", new Pair<String, String>(findYearBox.getValue(), findYearTxt.getEditor().getText().replaceAll("/", "-")));
    	}
    	if(!findPriceTxt.getText().trim().isEmpty()) {
    		filters.put("price", new Pair<String, String>(findPriceBox.getValue(), findPriceTxt.getText()));
    	}
    	
    	reusltBooks = myStore.search(filters);
    	
    	searchList.getItems().clear();
    	for(IBook book : reusltBooks) {
    		System.out.println(book);
    		searchList.getItems().add(book.toString());
    	}
    }
    
    @FXML
    void removeBookCartBtnAct(ActionEvent event) {
    	
    	int index = cartList.getSelectionModel().getSelectedIndex();
    	if(index < 0) {
    		return;
    	}
    	Cart cart = myStore.removeBookFromCart(index);
    	cartList.getItems().remove(index);
    	cartList.getItems().clear();
    	cartList.getItems().addAll(cart.getReport());
		totalPriceLabel.setText("total price :  " + cart.get_total_price());
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
				String temp = "ISBN: " + entry.getKey() + " Amount: " + entry.getValue();
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
		
		ObservableList<String> operations = FXCollections.observableArrayList("=", ">", "<", ">=", "<=", "<>");
		findPriceBox.setItems(FXCollections.observableArrayList(operations));
		findYearBox.setItems(FXCollections.observableArrayList(operations));
		findPriceBox.setValue("=");
		findYearBox.setValue("=");
		filters = new HashMap<>();
		reusltBooks = new ArrayList<>();
		
		if(!myStore.getCurrentUser().getIsManager()) {
			managingTab.setDisable(true);
		}
		
		StringConverter<LocalDate> sc = new StringConverter<LocalDate>()
		{
		    private DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");

		    @Override
		    public String toString(LocalDate localDate)
		    {
		        if(localDate==null)
		            return "";
		        return dateTimeFormatter.format(localDate);
		    }

		    @Override
		    public LocalDate fromString(String dateString)
		    {
		        if(dateString==null || dateString.trim().isEmpty())
		        {
		            return null;
		        }
		        return LocalDate.parse(dateString,dateTimeFormatter);
		    }
		};
		
		findYearTxt.setConverter(sc);
		
		
	}

}
