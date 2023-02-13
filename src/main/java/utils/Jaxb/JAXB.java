package utils.Jaxb;

import hierarchy.Software;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JAXB {

    private static final Logger LOGGER = LogManager.getLogger(JAXB.class);

    public static void main(String[] args) throws JAXBException, IOException {
//        Software software = new Software();
//        software.setId(1);
//        software.setNumberOfContract(12);
//        software.setNameOfTheSoftware("taxx");
//        software.setVersion(5);
//        software.setTypeId(2);
//        software.setType("t");
//        marshalProject(software);
        Software unmarshal = unmarshallProject();
        LOGGER.info(unmarshal);
    }

    public static void marshalProject(Software software) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Software.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(software, new File("./Software.xml"));
    }

    public static Software unmarshallProject() throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(Software.class);
        return (Software) context.createUnmarshaller()
                .unmarshal(new FileReader("./Software.xml"));
    }
}
