package hierarchy;

import java.util.Date;

public class CalendarPlan {
    private long id;
    private long softwareId;
    private String nameOfWorks;
    private Date plannedStartDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSoftwareId() {
        return softwareId;
    }

    public void setSoftwareId(long softwareId) {
        this.softwareId = softwareId;
    }

    public String getNameOfWorks() {
        return nameOfWorks;
    }

    public void setNameOfWorks(String nameOfWorks) {
        this.nameOfWorks = nameOfWorks;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    @Override
    public String toString() {
        return "CalendarPlan{" +
                "Id=" + id +
                ", SoftwareId=" + softwareId +
                ", NameOfWorks='" + nameOfWorks + '\'' +
                ", PlannedStartDate=" + plannedStartDate +
                '}';
    }
}
