package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import model.Histogram;

public class HistogramDisplay extends ApplicationFrame{
    
    private final Histogram <String> histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
        
    }
    
    public void execute(){
        setVisible(true);
    }

    private JPanel createPanel() {
        JPanel jPanel = new ChartPanel(createChart(createDataset()));
        jPanel.setPreferredSize(new Dimension (500,400));
        return jPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", "Dominios email", "Nº de emails", dataSet, PlotOrientation.VERTICAL, false, false, rootPaneCheckingEnabled); 
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (String key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", key);
        }
        return dataSet;
    }
    
    
}
