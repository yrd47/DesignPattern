package CSDN.chart;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Created by yrd on 2017/12/7.
 */
public class XMLUtil {

    public static String getChartType() {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
            Document document = builder.parse(new File("config.xml"));

            //获取包含图标类型的文本节点
            NodeList nodeList = document.getElementsByTagName("chartType");
            Node node = nodeList.item(0).getFirstChild();
            String chartType = node.getNodeName().trim();
            System.out.println(chartType);
            return chartType;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
