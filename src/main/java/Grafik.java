
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


import javax.swing.*;

    public  class Grafik extends JFrame {
        public double f(double x) {
            return 2.3 * Math.pow(x,3) + 5.75 * Math.pow(x,2) - 7.41 * x - 10.6;
        }

        //Function function = new Function();
        final XYSeries series = new XYSeries("Function");
        final XYSeriesCollection dataset = new XYSeriesCollection();

        public XYPlot plot(double a, double b) {
            for (int i = (int) a; i < b; i++) {
                series.add(i, f(i));
            }

            dataset.addSeries(series);
            JFreeChart chart = ChartFactory.createXYLineChart("Function", "x", "y", dataset);
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
            setContentPane(chartPanel);
            XYPlot plot = chart.getXYPlot();
            plot.setForegroundAlpha(0.5f);
            return plot;
        }
    }


