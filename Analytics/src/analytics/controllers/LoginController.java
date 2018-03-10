package analytics.controllers;

import analytics.Analytics;
import analytics.model.User;
import analytics.scene.SceneContent;
import analytics.security.Authenticator;
import analytics.service.SendHTMLEmail;

import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ToggleGroup;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController extends AnchorPane implements Initializable {       
    
    @FXML
    private AnchorPane signInToggle, signInPane, requestAccessPane;

    @FXML
    private Label exit, errorMessage, submitMessage;

    @FXML
    private TextField username, firstname, surname, role, email;

    @FXML
    private PasswordField password;
   
    @FXML
    private ToggleGroup loginPageToggle;
     
    @FXML
    private ToggleButton requestToggleButton, signInToggleBtn;
    
    private User loggedUser;
    private Analytics application;  
    Stage stage = Analytics.getPrimaryStage();
    
    SceneContent sceneContent = new SceneContent();
    
    public void setApp(Analytics application){
        this.application = application;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMessage.setText("");
        username.setPromptText("username");
        password.setPromptText("password");
        
    }
    
    @FXML
    void handleExit(MouseEvent event) {
        System.exit(0);
    }
       
    @FXML
    public boolean handleLoginRequest(ActionEvent event) {
        System.out.println("username: " + username.getText() + ", Password: " + password.getText());
        if (Authenticator.validate(username.getText(), password.getText())) {
            loggedUser = User.of(username.getText());            ;
            System.out.println("TRUE: " + loggedUser.getId());
            sceneContent.gotoProfile();
            return true;
        } else {
            errorMessage.setText("Username/Password is incorrect");
            return false;
        }
    }
    
    @FXML
    void clearErrorMessage(KeyEvent event) {
        if (errorMessage.getText() == "Username/Password is incorrect") {
            errorMessage.setText(null);
        }
        
        if (submitMessage.getText() == "Error sending request email") {
            submitMessage.setText(null);
        }
    }
    
    @FXML
    void handleAccessRequest(ActionEvent event) throws IOException {
        System.out.println("The following person wants access to the dashboard: Firstname - " + firstname.getText() + 
                " Surname - " + surname.getText() + " Role - " + role.getText() + " email - " + email.getText());       
        boolean emailSuccess = SendHTMLEmail.sendEmail(firstname.getText(), surname.getText(), role.getText(), email.getText());        
        if (emailSuccess) {                        
            submitMessage.setText("Request email was sent successfully");
        } else {
            submitMessage.setText("Error sending request email");                    
        }
    }

    @FXML
    void handleRequestToggle(ActionEvent event) {
        username.clear();
        password.clear();
        errorMessage.setText(null);
        signInPane.visibleProperty().set(false);
        requestAccessPane.visibleProperty().set(true);
    }

    @FXML
    void handleSignInToggle(ActionEvent event) {
        firstname.clear();
        surname.clear();
        role.clear();
        email.clear();
        submitMessage.setText(null);
        signInPane.visibleProperty().set(true);
        requestAccessPane.visibleProperty().set(false);
    }
}