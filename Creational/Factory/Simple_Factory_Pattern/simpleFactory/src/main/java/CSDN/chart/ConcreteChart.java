package CSDN.chart;

/**
 * Created by yrd on 2017/9/26.
 */

//柱状图类：具体产品类
class HistogramChart implements Chart {

    public HistogramChart() {
        System.out.println("创建柱状图");
    }

    public void display() {
        System.out.println("创建柱状图");
    }
}

//饼状图：具体产品类
class PieChart implements Chart {

    public PieChart() {
        System.out.println("创建饼状图");
    }

    public void display() {
        System.out.println("创建饼状图");
    }
}

//折线图：具体产品类
class LineChart implements Chart {

    public LineChart() {
        System.out.println("创建折线图");
    }

    public void display() {
        System.out.println("创建折线图");
    }
}