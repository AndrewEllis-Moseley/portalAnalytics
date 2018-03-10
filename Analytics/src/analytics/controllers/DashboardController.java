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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Andrew
 */
public class DashboardController extends AnchorPane  implements Initializable {
    private Analytics application;
    
    SceneContent sceneContent = new SceneContent();
    private Stage stage;
    
    @FXML   private Label usernameDisplay, dateDisplay;
    @FXML   private MenuItem profileBtn, settingsBtn, logout;
    @FXML   private Button dashboardBtn, reportBtn, queryBtn;    
    @FXML   private AnchorPane dashboardPane;
    @FXML   private LineChart<?, ?> sessionCountLineChart;
    @FXML   private CategoryAxis xAxis;
    @FXML   private NumberAxis yAxis;
    @FXML   private PieChart errorCountPieChart;
    
    public void userLogout(ActionEvent event) {         
         sceneContent.userLogout();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {      
        //Set session count dashboard graph on initialize
        sessionCountGraph();
        //Set error count dashboard graph on initialize
        errorCountGraph();
    }
    
    public void setApp(Analytics application){
        this.application = application;
        
    }   
    
    /**
     * Dashboard session count line chart
     */    
    public void sessionCountGraph() {
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();        
        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                       
        //defining a series
        XYChart.Series admiral = new XYChart.Series();
        admiral.setName("Admiral");
        //populating the series with data
        admiral.getData().add(new XYChart.Data("1", 9));
        admiral.getData().add(new XYChart.Data("2", 11));
        admiral.getData().add(new XYChart.Data("3", 32));
        admiral.getData().add(new XYChart.Data("4", 34));
        admiral.getData().add(new XYChart.Data("5", 56));
        admiral.getData().add(new XYChart.Data("6", 34));
        admiral.getData().add(new XYChart.Data("7", 24));
        admiral.getData().add(new XYChart.Data("8", 15));
        admiral.getData().add(new XYChart.Data("9", 12));
        
        XYChart.Series diamond = new XYChart.Series();
        diamond.setName("Diamond");
        //populating the series with data
        diamond.getData().add(new XYChart.Data("1", 9));
        diamond.getData().add(new XYChart.Data("2", 11));
        diamond.getData().add(new XYChart.Data("3", 32));
        diamond.getData().add(new XYChart.Data("4", 44));
        diamond.getData().add(new XYChart.Data("5", 66));
        diamond.getData().add(new XYChart.Data("6", 102));
        diamond.getData().add(new XYChart.Data("7", 84));
        diamond.getData().add(new XYChart.Data("8", 99));
        diamond.getData().add(new XYChart.Data("9", 3));
        
        XYChart.Series elephant = new XYChart.Series();
        elephant.setName("Elephant");
        //populating the series with data
        elephant.getData().add(new XYChart.Data("1", 1));
        elephant.getData().add(new XYChart.Data("2", 5));
        elephant.getData().add(new XYChart.Data("3", 35));
        elephant.getData().add(new XYChart.Data("4", 36));
        elephant.getData().add(new XYChart.Data("5", 56));
        elephant.getData().add(new XYChart.Data("6", 66));
        elephant.getData().add(new XYChart.Data("7", 53));
        elephant.getData().add(new XYChart.Data("8", 14));
        elephant.getData().add(new XYChart.Data("9", 17));
        
        XYChart.Series bell = new XYChart.Series();
        bell.setName("Bell");
        //populating the series with data
        bell.getData().add(new XYChart.Data("1", 4));
        bell.getData().add(new XYChart.Data("2", 1));
        bell.getData().add(new XYChart.Data("3", 3));
        bell.getData().add(new XYChart.Data("4", 4));
        bell.getData().add(new XYChart.Data("5", 6));
        bell.getData().add(new XYChart.Data("6", 4));
        bell.getData().add(new XYChart.Data("7", 4));
        bell.getData().add(new XYChart.Data("8", 5));
        bell.getData().add(new XYChart.Data("9", 2));
        
        
        
        sessionCountLineChart.getData().addAll(admiral, diamond, elephant, bell);
    }

    private void errorCountGraph() {
        ObservableList<PieChart.Data> picChartData 
                = FXCollections.observableArrayList(
                    new PieChart.Data("Error", 394),
                    new PieChart.Data("Session Expired", 845),
                    new PieChart.Data("Oops", 149),
                    new PieChart.Data("Document Errort", 39));
        
        errorCountPieChart.setData(picChartData);
        
        final Label caption = new Label("");
        caption.setTextFill(Color.DARKORANGE);
        caption.setStyle("-fx-font: 24 arial;");
//        
        for (final PieChart.Data data : errorCountPieChart.getData()) {            
//            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {});
//            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
//                e -> {
//                    double total = 0;
//                    for (PieChart.Data d : chart.getData()) {
//                        total += d.getPieValue();
//                    }
//                    caption.setTranslateX(e.getSceneX());
//                    caption.setTranslateY(e.getSceneY());
//                    String text = String.format("%.1f%%", 100*data.getPieValue()/total) ;
//                    caption.setText(text);
//                 }
//                );
        }
//        
    }
    
}
