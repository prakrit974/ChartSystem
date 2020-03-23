package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Fausses données
        ArrayList<XYChart.Series> listSeries = new ArrayList<XYChart.Series>();
        ArrayList<Boolean> listSeriesDisplayingState = new ArrayList<Boolean>();

        for (int i = 0; i < 5; i++) {
            listSeries.add(new XYChart.Series());
            listSeries.get(i).setName("Serie N° " + Integer.toString(i + 1));
            for (int j = 0; j < 12; j++) {
                listSeries.get(i).getData().add(new XYChart.Data(Integer.toString(j + 1), 5 + Math.random() * 10));
            }
        }

        for (int i = 0; i < listSeries.size(); i++) {
            listSeriesDisplayingState.add(true);
        }

        // Création de la LineChartView
        primaryStage.setTitle("Line Chart Sample");

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("Fruit rate, 2019");

        Scene scene  = new Scene(lineChart,800,600);

        for (int seriesNb = 0; seriesNb < listSeries.size(); seriesNb++) {
            if (listSeriesDisplayingState.get(seriesNb)) lineChart.getData().addAll(listSeries.get(seriesNb));
        }

        // Affichage de la scene
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
