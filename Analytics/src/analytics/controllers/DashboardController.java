/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics.controllers;

import analytics.Analytics;
import analytics.scene.SceneContent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class DashboardController extends AnchorPane implements Initializable {
    private Analytics application;
    
    SceneContent sceneContent = new SceneContent();
    private Stage stage;
    
    @FXML
    private Label usernameDisplay, dateDisplay;

    @FXML
    private MenuItem profileBtn, settingsBtn, logout;

    @FXML
    private Button dashboardBtn, reportBtn, queryBtn;    

    @FXML
    private AnchorPane dashboardPane;

    @FXML
    public void userLogout(ActionEvent event) {         
         sceneContent.userLogout();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {      
        //TODO
    }
    
    public void setApp(Analytics application){
        this.application = application;
//        User loggedUser = application.getLoggedUser();
//        user.setText(loggedUser.getId());
//        email.setText(loggedUser.getEmail());
//        phone.setText(loggedUser.getPhone());
//        if (loggedUser.getAddress() != null) {
//            address.setText(loggedUser.getAddress());
//        }
//        subscribed.setSelected(loggedUser.isSubscribed());
//        success.setOpacity(0);
    }
    
}
