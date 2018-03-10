/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics.scene;

import analytics.Analytics;
import analytics.controllers.DashboardController;
import analytics.controllers.LoginController;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class SceneContent {
    
    private Analytics application;        
    
    public void gotoLogin() {
        try {
            LoginController login = (LoginController) replaceSceneContent("/analytics/screens/login2.fxml");
            login.setApp(application);
        } catch (Exception ex) {
            Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void gotoProfile() {
        try {
            DashboardController profile = (DashboardController) replaceSceneContent("/analytics/screens/dashboard_1.fxml");
            profile.setApp(application);
        } catch (Exception ex) {
            Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void userLogout(){                
        gotoLogin();
    }
    
    private Initializable replaceSceneContent(String fxml) throws Exception {
        Stage stage = Analytics.getPrimaryStage();
        FXMLLoader loader = new FXMLLoader();
        InputStream in = Analytics.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Analytics.class.getResource(fxml));
        AnchorPane page;
        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        } 
        Scene scene = new Scene(page);

        stage.setScene(scene);
        stage.sizeToScene();
        return (Initializable) loader.getController();
    }
}
