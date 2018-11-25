package application;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BookAddController implements Initializable {	
	private myLinkedList<Book> bookList = new myLinkedList<Book>();

	@FXML TableView <Book> tableView;
	
	@FXML private TableColumn <Book,String> titleColumn;
	@FXML private TableColumn <Book,String> authorColumn;
	@FXML private TableColumn <Book,Integer> yearOfPublicationColumn;
	@FXML private TableColumn <Book,String>publisherColumn;
	@FXML private TableColumn <Book,Integer>numberOfPagesColumn;
	@FXML private TableColumn <Book,String>genreColumn;
	@FXML private TableColumn <Book,String>plotDescriptionColumn;
	@FXML private TableColumn <Book,String>bookCoverColumn;
	
	//Initialise the variable in the 
	@FXML private TextField titleTextField;
	@FXML private TextField authorTextField;//author
	@FXML private TextField yearOfPublicationTextField;
	@FXML private TextField publisherTextField;//publisher
	@FXML private TextField numberOfPagesTextField;
	@FXML private TextField genreTextField;//genre
	@FXML private TextArea plotDecriptionTextArea;
	@FXML private TextField imageCoverlinkTextField;
	
	//save button puts the data in the table
	public void saveBookButtonClicked() throws Exception {
		Book books = new Book(titleTextField.getText(), authorTextField.getText(),
				Integer.parseInt(yearOfPublicationTextField.getText()),publisherTextField.getText(),
				Integer.parseInt(numberOfPagesTextField.getText()), genreTextField.getText(),
				plotDecriptionTextArea.getText(),imageCoverlinkTextField.getText());
		tableView.getItems().add(books);
		bookList.add(books);
		System.out.println(bookList.show());
		save();
	}
	
	//this changes the scene form the table add and list to the main list
	public void changeSceneToMainScene(ActionEvent event) throws IOException {
		Parent MainView = FXMLLoader.load(getClass().getResource("MainView.fxml"));
		Scene Mainscene = new Scene(MainView);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(Mainscene);
		window.show();
	}
	
	
	//this method initializes the table 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// setup columns in the table
		
		titleColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
		yearOfPublicationColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("yearOfPublication"));
		publisherColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("publisher"));
		numberOfPagesColumn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("numberOfPages"));
		genreColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("genre"));
		plotDescriptionColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("plotDescription"));
		bookCoverColumn.setCellValueFactory(new PropertyValueFactory<Book,String>("bookCoverImageLink"));

		//tableView.setItems(getBooks());
	}
	
	//this method changes the data to the arraylist collections so that it can be displayed in the table view
	public ObservableList<Book> getBooks(){
		ObservableList<Book>books = FXCollections.observableArrayList();
		books.add(new Book("Manxi", "Manxi jose", 250, "Manxi hazel", 1200, "Manxi", "Manxi", "Manxi"));
	
	return books;
	}
	
	
	//this is the load method that loads saved data to form the xml
	@SuppressWarnings("unchecked")
    public  void load()
    		throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("book.xml"));
      bookList=((myLinkedList<Book>) is.readObject());
        is.close();
    }
    
	/**
	 * this function saves the program data to xml file 
	 * @throws Exception
	 */
    public void save() 
    		throws Exception{
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("booklist.xml"));
        out.writeObject(bookList);
        out.close();    
    }

}
