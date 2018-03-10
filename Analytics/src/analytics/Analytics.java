/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analytics;

import analytics.scene.SceneContent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Andrew
 */
public class Analytics extends Application {
    
    private static Stage stage; 
    SceneContent sceneContent = new SceneContent();
    
    private final double MINIMUM_WINDOW_WIDTH = 390.0;
    private final double MINIMUM_WINDOW_HEIGHT = 500.0;
    
    private static void setPrimaryStage(Stage stage) {
        Analytics.stage = stage;
    }

    public static Stage getPrimaryStage() {
        return Analytics.stage;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            setPrimaryStage(primaryStage);
            stage = primaryStage;          
            sceneContent.gotoLogin();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (Exception ex) {
            Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
        }
//        Parent root = FXMLLoader.load(getClass().getResource("/analytics/screens/login2.fxml"));
//        stage.initStyle(StageStyle.UNDECORATED);
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
//    public void gotoLogin() {
//        try {
//            LoginController login = (LoginController) replaceSceneContent("/analytics/screens/login2.fxml");
//            login.setApp(this);
//        } catch (Exception ex) {
//            Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
//    public User getLoggedUser() {
//        return null;
//    }
    
//     public void gotoProfile() {
//        try {
//            DashboardController profile = (DashboardController) replaceSceneContent("/analytics/screens/dashboard_1.fxml");
//            profile.setApp(this);
//        } catch (Exception ex) {
//            Logger.getLogger(Analytics.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//     
//    public void userLogout(){
////        Object loggedUser = null;
//       gotoLogin();
//    }
    
//    private Initializable replaceSceneContent(String fxml) throws Exception {
//        FXMLLoader loader = new FXMLLoader();
//        InputStream in = Analytics.class.getResourceAsStream(fxml);
//        loader.setBuilderFactory(new JavaFXBuilderFactory());
//        loader.setLocation(Analytics.class.getResource(fxml));
//        AnchorPane page;
//        try {
//            page = (AnchorPane) loader.load(in);
//        } finally {
//            in.close();
//        } 
//        Scene scene = new Scene(page);
//        
//        stage.setScene(scene);
//        stage.sizeToScene();
//        return (Initializable) loader.getController();
//    }
    
}
