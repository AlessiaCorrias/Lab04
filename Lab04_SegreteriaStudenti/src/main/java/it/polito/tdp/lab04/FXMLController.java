/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Model model;
	

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="comboCorsi"
    private ComboBox<Corso> comboCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaIscritti"
    private Button btnCercaIscritti; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="check"
    private CheckBox check; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="btnCercaCorsi"
    private Button btnCercaCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="btnIscrivi"
    private Button btnIscrivi; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML // fx:id="Reset"
    private Button Reset; // Value injected by FXMLLoader

    @FXML
    void cercaCorsi(ActionEvent event) {
    	txtResult.clear();
    	int m ;
    	String ms = txtMatricola.getText();
    	
    	try {
    	m = Integer.parseInt(ms);
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire una matricola valida !");
    		throw new NumberFormatException("Devi inserire una matricola valida !!");
    	}
    	
    	if(!model.cercaCorsiStudente(m).equals(null) && !model.cercaCorsiStudente(m).equals("") ) {
    	txtResult.appendText(model.cercaCorsiStudente(m));
    	return;
    	} else {
    		txtResult.appendText("Devi inserire una matricola valida !");
    		return; 
    	}


    }
    
    @FXML
    void completa(ActionEvent event) {
    	txtResult.clear();
    	Studente s;
    	int m ;
    	String ms = txtMatricola.getText();
    	
    	try {
    	m = Integer.parseInt(ms);
    	s=model.completa(m);
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire una matricola valida !");
    		throw new NumberFormatException("Devi inserire una matricola valida !!");
    		
    	}
    	
    	if(s!=null) {
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	} else {
    		txtResult.appendText("Devi inserire una matricola valida !");
    		return;
    	}

    }

    @FXML
    void cercaIscritti(ActionEvent event) {
    	txtResult.clear();
    	Corso scelta = comboCorsi.getValue();
    	
    	if(scelta != null && scelta!=model.getCo()) {
    		if(txtMatricola.getText()== null || txtMatricola.getText().equals("")) {
    	txtResult.appendText(model.cercaIscrittiCorso(scelta)); 
    		} else {
    			int m ;
    	    	String ms = txtMatricola.getText();
    	    	
    	    	try {
    	    	m = Integer.parseInt(ms);
    	    	} catch (NumberFormatException e) {
    	    		txtResult.appendText("Devi inserire una matricola valida !");
    	    		throw new NumberFormatException("Devi inserire una matricola valida !!");
    	    	}
    	    	
    	    	//ho matricola m nel fomato corretto e un corso selezionato (scelta)
    	    	//funzione che da true se iscritto false se non iscritto
    	    	if(model.isIscritto(m,scelta)==true) {
    	    		txtResult.appendText("Lo studente è già iscritto al corso");
    	    	} else {
    	    		if(model.esisteStudente(m)==true) 
    	    		txtResult.appendText("Lo studente non è iscritto al corso");
    	    		else
    	    			txtResult.appendText("Lo studente non è presente nel sistema");	
    	    	}
    		}
    	} else {
    		txtResult.appendText("Selezionare un corso");
    		return;
    	}

    }

    @FXML
    void iscrivi(ActionEvent event) {
    	//da fare
    }

    @FXML
    void reset(ActionEvent event) {
    	txtMatricola.clear();
    	txtNome.clear();
    	txtCognome.clear();
    	txtResult.clear();
    	comboCorsi.setValue(model.getCo());
    	check.setSelected(false);
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert comboCorsi != null : "fx:id=\"comboCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Reset != null : "fx:id=\"Reset\" was not injected: check your FXML file 'Scene.fxml'.";
        
    }

	public void setModel(Model model) {
		this.model = model;
		comboCorsi.getItems().addAll(this.model.getElencoCorsi());
	}
}
