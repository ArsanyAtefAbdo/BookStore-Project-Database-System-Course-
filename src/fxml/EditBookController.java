package fxml;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import backend.BookStore;
import backend.IBookStore;
import components.IBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

public class EditBookController implements Initializable{
	
	private IBookStore myStore = BookStore.getInstance();
	
	@FXML
    private JFXListView<String> booksList;

    @FXML
    private JFXTextField oldBookTxt;

    @FXML
    private JFXTextField oldPubTxt;

    @FXML
    private JFXDatePicker oldYearTxt;

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
    private JFXDatePicker newYearTxt;

    @FXML
    private JFXTextField newPriceTxt;

    @FXML
    private JFXTextField newCategoryTxt;

    @FXML
    private JFXTextField NewAuthorTxt;
    
    HashMap<String, Pair<String, String>>filters;
    ArrayList<IBook> selectedBooks;

    @FXML
    void searchAct(ActionEvent event) {
    	
    	filters.clear();
    	if(!oldBookTxt.getText().isEmpty()) {
    		filters.put("title", new Pair<String, String>("=", oldBookTxt.getText()));
    	}
    	if(!oldIsbnTxt.getText().isEmpty()) {
    		filters.put("ISBN", new Pair<String, String>("=", oldIsbnTxt.getText()));
    	}
    	if(!oldPubTxt.getText().isEmpty()) {
    		filters.put("publisher_name", new Pair<String, String>("=", oldPubTxt.getText()));
    	}
    	if(!oldAuthorTxt.getText().isEmpty()) {
    		filters.put("author", new Pair<String, String>("=", oldAuthorTxt.getText()));
    	}
    	if(!oldCategoryTxt.getText().isEmpty()) {
    		filters.put("category", new Pair<String, String>("=", oldCategoryTxt.getText()));
    	}
    	if(!oldPubTxt.getText().isEmpty()) {
    		filters.put("publication_year", new Pair<String, String>(yearBox.getValue(), oldPubTxt.getText()));
    	}
    	if(!oldPriceTxt.getText().isEmpty()) {
    		filters.put("price", new Pair<String, String>(priceBox.getValue(), oldPriceTxt.getText()));
    	}
    	
    	selectedBooks = myStore.search(filters);
    	
    	booksList.getItems().clear();
    	for(IBook book : selectedBooks) {
    		System.out.println(book);
    		booksList.getItems().add(book.toString());
    	}
    	
    }
    
    @FXML
    void saveBtnAct(ActionEvent event) {
    	
    	int index = booksList.getSelectionModel().getSelectedIndex();
    	if(index < 0 || selectedBooks.isEmpty()) {
    		return;
    	}
    	
    	HashMap<String, String> attributes = new HashMap<>();
    	int oldISBN = selectedBooks.get(index).getISBN();
    	
    	
    	if(!newNameTxt.getText().isEmpty()) {
    		attributes.put("title", newNameTxt.getText());
    	}
    	if(!newCategoryTxt.getText().isEmpty()) {
    		attributes.put("category", newCategoryTxt.getText());
    	}
    	if(!newYearTxt.getText().isEmpty()) {
    		attributes.put("publication_year", newYearTxt.getText());
    	}
    	if(!NewAuthorTxt.getText().isEmpty()) {
    		attributes.put("authors", NewAuthorTxt.getText());
    	}
    	if(!newPriceTxt.getText().isEmpty()) {
    		attributes.put("price", newPriceTxt.getText());
    	}
    	if(!newPubTxt.getText().isEmpty()) {
    		attributes.put("publisher_name", newPubTxt.getText());
    	}
    	
    	myStore.updateBook(""+oldISBN, attributes);
    	booksList.getItems().remove(index);
    }
	
    @FXML
    void cancelBtnAct(ActionEvent event) {
		//open store.
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/fxml/Store.fxml"));
			Parent theStore = loader.load();
			
			Scene storeScene = new Scene(theStore);
			
			//access StoreController and call the method.
			StoreController controller = loader.getController();
			controller.intiateData(myStore.getCurrentUser());
			
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
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<String> operations = FXCollections.observableArrayList("=", ">", "<", ">=", "<=", "<>");
		priceBox.setItems(FXCollections.observableArrayList(operations));
		yearBox.setItems(FXCollections.observableArrayList(operations));
		priceBox.setValue("=");
		yearBox.setValue("=");
		filters = new HashMap<>();
		selectedBooks = new ArrayList<>();
	}

}
