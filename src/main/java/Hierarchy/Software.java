package Hierarchy;

import java.util.Date;

public class Software {
    private long Id;
    private long NumberOfContract;
    private String NameOfTheSoftware;
    private int Version;
    private int TypeId;
    private String Type;
    private Date DateOfIssue;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getNumberOfContract() {
        return NumberOfContract;
    }

    public void setNumberOfContract(long numberOfContract) {
        NumberOfContract = numberOfContract;
    }

    public String getNameOfTheSoftware() {
        return NameOfTheSoftware;
    }

    public void setNameOfTheSoftware(String nameOfTheSoftware) {
        NameOfTheSoftware = nameOfTheSoftware;
    }

    public int getVersion() {
        return Version;
    }

    public void setVersion(int version) {
        Version = version;
    }

    public int getTypeId() {
        return TypeId;
    }

    public void setTypeId(int typeId) {
        TypeId = typeId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Date getDateOfIssue() {
        return DateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        DateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "Software{" +
                "Id=" + Id +
                ", NumberOfContract=" + NumberOfContract +
                ", NameOfTheSoftware='" + NameOfTheSoftware + '\'' +
                ", Version=" + Version +
                ", TypeId=" + TypeId +
                ", Type='" + Type + '\'' +
                ", DateOfIssue=" + DateOfIssue +
                '}';
    }
}
