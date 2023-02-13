package hierarchy;

import utils.DataAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "Software")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder = {"id", "numberOfContract", "nameOfTheSoftware", "version", "typeId", "type", "dateOfIssue"})
public class Software {

    private long id;
    private long numberOfContract;
    private String nameOfTheSoftware;
    private int version;
    private int typeId;
    private String type;
    private Date dateOfIssue = new Date();

    @XmlAttribute
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }

    @XmlAttribute(name = "contract_number")
    public long getNumberOfContract() {
        return numberOfContract;
    }

    public void setNumberOfContract(long numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    public String getNameOfTheSoftware() {
        return nameOfTheSoftware;
    }

    public void setNameOfTheSoftware(String nameOfTheSoftware) {
        this.nameOfTheSoftware = nameOfTheSoftware;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlJavaTypeAdapter(DataAdapter.class)
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "Software{" +
                "Id=" + id +
                ", NumberOfContract=" + numberOfContract +
                ", NameOfTheSoftware='" + nameOfTheSoftware + '\'' +
                ", Version=" + version +
                ", TypeId=" + typeId +
                ", Type='" + type + '\'' +
//                ", DateOfIssue=" + DateOfIssue +
                '}';
    }
}
