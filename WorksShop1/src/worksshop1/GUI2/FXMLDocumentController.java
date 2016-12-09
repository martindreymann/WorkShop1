/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksshop1.GUI2;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import worksshop_1.Building;
import worksshop_1.BuildingSystem;

/**
 *
 * @author Daniel
 */
public class FXMLDocumentController implements Initializable {

    BuildingSystem bs;
    ObservableList<Building> allBuildings;
    Building clickedBuilding = null;

    @FXML
    private ListView<Building> BuildingList;
    @FXML
    private Button AllButton;
    @FXML
    private TextArea AirText;
    @FXML
    private TextArea tempText;
    @FXML
    private LineChart<String, Double> HisGraph;
    @FXML
    private TextField addCO2Measure;
    @FXML
    private TextField addTempMeasure;
    @FXML
    private Button saveMeasureButton;

    @FXML
    private void handleReadMeasurements(ActionEvent e) {

        if (clickedBuilding != null) {
            clickedBuilding.readAllMeasurements();
            updateLineChart();
        }
    }

    @FXML
    private void saveNewMeasurementHandler(ActionEvent e) {

        try {
            if (clickedBuilding != null) {
                double co2 = Double.parseDouble(addCO2Measure.getText());
                double temp = Double.parseDouble(addTempMeasure.getText());

                clickedBuilding.addNewMeasure(temp, co2);

                addCO2Measure.clear();
                addTempMeasure.clear();
                updateLineChart();
            }

        } catch (NumberFormatException nfe) {
            errorMessage();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        bs = new BuildingSystem();
        bs.createSomeStuff();
        allBuildings = FXCollections.observableArrayList(bs.getAllBuildings());
        BuildingList.setItems(allBuildings);

    }

    @FXML
    private void inventoryOnClick(MouseEvent event) {

        // double click to drop item from inventory to current room
        if (event.getClickCount() == 2 && BuildingList.getSelectionModel().getSelectedItem() != null) {
            clickedBuilding = BuildingList.getSelectionModel().getSelectedItem();

            tempText.clear();
            for (String s : clickedBuilding.getTemperature()) {
                tempText.appendText(s);
            }

            AirText.clear();
            for (String s : clickedBuilding.getAirQuality()) {
                AirText.appendText(s);
            }

            updateLineChart();

        }

    }

    private void updateLineChart() {
        HisGraph.getData().clear();

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("CO2");
        Map<String, Double> map1 = clickedBuilding.getAQdata();
        for (String s : clickedBuilding.getAQdata().keySet()) {
            series1.getData().add(new XYChart.Data(s, map1.get(s)));
        }

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("C");
        Map<String, Double> map2 = clickedBuilding.getTdata();
        for (String s : clickedBuilding.getTdata().keySet()) {
            series2.getData().add(new XYChart.Data(s, map2.get(s)));
        }

        HisGraph.getData().addAll(series1, series2);
    }
    
    private void errorMessage(){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Oh you didnt!");
        alert.setHeaderText("You really fucked up...");
        alert.setContentText("You didn't enter a number you piece of shit!");
        alert.showAndWait();
    }

}
