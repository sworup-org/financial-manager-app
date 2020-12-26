package com.poc.FinancialManager.Utility;

import com.poc.FinancialManager.model.FInancialModel;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.style.PieStyler;
import org.knowm.xchart.style.Styler;

import java.io.IOException;

public class ChartGenerator {

    public void chartGeneratorForModel(FInancialModel fInancialModel) throws IOException, IOException {

        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title("FinancialModel Chart for User").theme(Styler.ChartTheme.GGPlot2).build();

        // Customize Chart
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.LabelAndPercentage);
        chart.getStyler().setAnnotationDistance(1.15);
        chart.getStyler().setPlotContentSize(.7);
        chart.getStyler().setStartAngleInDegrees(90);

        // Series
        chart.addSeries("EXPENSE", fInancialModel.getTotalExpense());
        chart.addSeries("SAVINGS", fInancialModel.getSavingsModel().getSavings());

        // or save it in high-res
        BitmapEncoder.saveBitmapWithDPI(chart, "/Users/sworuppatra/IdeaProjects/financial-manager-app/src/main/java/com/poc/FinancialManager/pdfFiles/FinancialModelChart_"+fInancialModel.getUserId(), BitmapEncoder.BitmapFormat.PNG, 300);
    }
}
