package Hierarchy;

import java.util.Date;

public class CalendarPlan {
    private long Id;
    private long SoftwareId;
    private String NameOfWorks;
    private Date PlannedStartDate;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getSoftwareId() {
        return SoftwareId;
    }

    public void setSoftwareId(long softwareId) {
        SoftwareId = softwareId;
    }

    public String getNameOfWorks() {
        return NameOfWorks;
    }

    public void setNameOfWorks(String nameOfWorks) {
        NameOfWorks = nameOfWorks;
    }

    public Date getPlannedStartDate() {
        return PlannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        PlannedStartDate = plannedStartDate;
    }

    @Override
    public String toString() {
        return "CalendarPlan{" +
                "Id=" + Id +
                ", SoftwareId=" + SoftwareId +
                ", NameOfWorks='" + NameOfWorks + '\'' +
                ", PlannedStartDate=" + PlannedStartDate +
                '}';
    }
}
