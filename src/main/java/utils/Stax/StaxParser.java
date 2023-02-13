package utils.Stax;

import hierarchy.CalendarPlan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class StaxParser {

    private static final Logger LOGGER = LogManager.getLogger(StaxParser.class);

    public static void main(String[] args) {

        String fileName = "./CalendarPlan.xml";
        List<CalendarPlan> calendarPlanList = parseXmlFile(fileName);
        for (CalendarPlan c : calendarPlanList) {
            LOGGER.info(c.toString());
        }
    }

    private static List<CalendarPlan> parseXmlFile(String filename) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<CalendarPlan> calendarPlanList = new ArrayList<>();
        CalendarPlan calendarPlan = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(filename));
            while (reader.hasNext()){
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()){
                    StartElement startElement = xmlEvent.asStartElement();
                    if (startElement.getName().getLocalPart().equals("CalendarPlan")){
                        calendarPlan = new CalendarPlan();
                        Attribute idAttr = startElement.getAttributeByName(new QName("id"));
                        if (idAttr != null){
                            calendarPlan.setId(Long.parseLong(idAttr.getValue()));
                        }
                    }else if (startElement.getName().getLocalPart().equals("softwareId")){
                        xmlEvent = reader.nextEvent();
                        calendarPlan.setSoftwareId(Long.parseLong(xmlEvent.asCharacters().getData()));
                    }else if (startElement.getName().getLocalPart().equals("nameOfWorks")){
                        xmlEvent = reader.nextEvent();
                        calendarPlan.setNameOfWorks(xmlEvent.asCharacters().getData());
                    }else if (startElement.getName().getLocalPart().equals("plannedStartDate")){
                        xmlEvent = reader.nextEvent();
                        calendarPlan.setPlannedStartDate(simpleDateFormat.parse(xmlEvent.asCharacters().getData()));
                    }
                }

                if (xmlEvent.isEndElement()){
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("CalendarPlan")){
                        calendarPlanList.add(calendarPlan);
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException | ParseException e) {
            e.printStackTrace();
        }
        return calendarPlanList;
    }
}
