package utils.Stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class StaxWriter {
    public static void main(String[] args) {
    writer();
    }

    private static void writer() {
        Random random = new Random();
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("Programmers2.xml"));

            writer.writeStartDocument("1.0");
            writer.writeStartElement("ProgrammersInfo");

            for (int i = 1; i <= 3; i++) {
                writer.writeStartElement("Programmers");

                writer.writeStartElement("Name");
                writer.writeAttribute("id", String.valueOf(i));
                writer.writeCharacters("Denis # " + i);
                writer.writeEndElement();

                writer.writeStartElement("ProgrammingLanguage");
                writer.writeCharacters("Java");
                writer.writeEndElement();

                writer.writeStartElement("Level");
                writer.writeCharacters("Middle");
                writer.writeEndElement();

                writer.writeStartElement("StudyTime");
                writer.writeCharacters(String.valueOf(random.nextInt(6)));
                writer.writeEndElement();

                writer.writeEndElement();
            }

            writer.writeEndDocument();
            writer.flush();
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}
