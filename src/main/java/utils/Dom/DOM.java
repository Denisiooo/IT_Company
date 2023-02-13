package utils.Dom;

import hierarchy.CalendarPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DOM {

    private static final Logger LOGGER = LogManager.getLogger(DOM.class);

    public static void main(String[] args) {
        String filePath ="./CalendarPlan.xml";
        File xmlFile = new File(filePath);
        //Получение фабрики, чтобы после получить билдер документов
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            //Получаем из фабрики билдер, который парсит XML
            builder = factory.newDocumentBuilder();
            //Парсим XML, создав структуру Document. после этого есть доступ ко всем элементам
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            LOGGER.info("Our root element " + document.getDocumentElement().getNodeName());

            NodeList nodeList = document.getElementsByTagName("CalendarPlan");
            List<CalendarPlan> calendarPlanList = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                calendarPlanList.add(getCalendarPlan(nodeList.item(i)));
            }
            
            for (CalendarPlan c: calendarPlanList) {
                LOGGER.info(c.toString());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static CalendarPlan getCalendarPlan(Node node) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CalendarPlan calendarPlan = new CalendarPlan();
        if (node.getNodeType() == Node.ELEMENT_NODE){
            Element element = (Element) node;
            calendarPlan.setId(Long.parseLong(getTagValue(element.getAttribute("id"))));
            calendarPlan.setSoftwareId(Long.parseLong(getTagValue("softwareId", element)));
            calendarPlan.setNameOfWorks(getTagValue("nameOfWorks", element));
            calendarPlan.setPlannedStartDate(simpleDateFormat.parse(getTagValue("plannedStartDate", element)));
        }
        return calendarPlan;
    }

    private static String getTagValue(String id) {
        return id;
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
