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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
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
    private Button TempButton;
    @FXML
    private Button AirButton;
    @FXML
    private TextArea AirText;
    @FXML
    private TextArea tempText;
    @FXML
    private LineChart<String, Double> HisGraph;

    @FXML
    private void handleReadMeasurements(ActionEvent e) {
        if (clickedBuilding != null) {
            clickedBuilding.readAllMeasurements();
            updateLineChart();
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
        Map<String, Double> map = clickedBuilding.getChartData();
        for (String s : clickedBuilding.getChartData().keySet()) {
            series1.getData().add(new XYChart.Data(s, map.get(s)));

        }
        HisGraph.getData().add(series1);
    }

}
