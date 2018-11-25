package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CharacterAddController implements Initializable {
	
	//these are columns of the table view 
	@FXML TableView <Character> tableView;
	@FXML private TableColumn <Character,String> nameColumn;
	@FXML private TableColumn <Character,String> genderColumn;
	@FXML private TableColumn <Character,String>descriptionColumn;
	
	
	@FXML private TextField nameTextField;
	@FXML private TextField genderTextField;//publisher
	@FXML private TextField descriptionTextField;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// setup columns in the table
		
		nameColumn.setCellValueFactory(new PropertyValueFactory<Character,String>("Name"));
		genderColumn.setCellValueFactory(new PropertyValueFactory<Character,String>("Gender"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<Character,String>("Description"));
	}
	
	public void saveBookButtonClicked() throws Exception {
		Character characters = new Character(nameTextField.getText(), genderTextField.getText()
				,descriptionTextField.getText());
		tableView.getItems().add(characters);
		//bookList.add(books);
		//System.out.println(bookList.show());
		//save();
	}
	
	//this changes the scene form the table add and list to the main list
		public void changeSceneToMainScene(ActionEvent event) throws IOException {
			Parent MainView = FXMLLoader.load(getClass().getResource("MainView.fxml"));
			Scene Mainscene = new Scene(MainView);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(Mainscene);
			window.show();
		}

	
	
	public ObservableList<Character> getCharacters(){
		ObservableList<Character>characters = FXCollections.observableArrayList();
		characters.add(new Character(null, null, null));
	
	return characters;
	}

}
