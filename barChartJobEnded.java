package com.example.assignmentfop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class barChartJobEnded extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Bar Chart Sample");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("Number of jobs ended every month from June to December");
        xAxis.setLabel("Month");
        yAxis.setLabel("Number of Job Ended");
        JobEnded a = new JobEnded();
        a.countJobEnded();;

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2022");
        for(int i=0;i<a.month.length;i++) {
            series1.getData().add(new XYChart.Data(a.month[i], a.countJobCompleted[i]));
        }

        Scene scene = new Scene(bc, 800, 700);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
}
