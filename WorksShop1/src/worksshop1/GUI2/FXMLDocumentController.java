/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksshop1.GUI2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import worksshop_1.Building;
import worksshop_1.BuildingSystem;

/**
 *
 * @author Daniel
 */
public class FXMLDocumentController implements Initializable {
    
    BuildingSystem bs;
    ObservableList<Building> allBuildings;
    
    @FXML
    private ListView<?> BuildingList;
    @FXML
    private Button AllButton;
    @FXML
    private Button TempButton;
    @FXML
    private Button AirButton;
    @FXML
    private TextArea AirText;
    @FXML
    private TextArea tempText;
    @FXML
    private LineChart<?, ?> HisGraph;
    
    
   @FXML
   private void handlebutton(){}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        bs  = new BuildingSystem();
        bs.createSomeStuff();
        allBuildings = FXCollections.observableArrayList();
        
        
        
    }    
    
}
