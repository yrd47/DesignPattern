package CSDN.chart;

/**
 * Created by yrd on 2017/9/26.
 */
public class client {

    public static void main(String[] args) {
        Chart chart1 = ChartFactory.getChart("histogram");
        chart1.display();
        Chart chart2 = ChartFactory.getChart("pie");
        chart2.display();
        Chart chart3 = ChartFactory.getChart("line");
        chart3.display();
    }
}
