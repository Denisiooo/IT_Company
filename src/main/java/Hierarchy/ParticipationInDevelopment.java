package Hierarchy;

public class ParticipationInDevelopment {
    private long Id;
    private int CalendarPlanId;
    private int EmployeeId;
    private String Employee;
    private String JobDescription;
    private String ProgrammingLanguage;

    public ParticipationInDevelopment(long id, int calendarPlanId, int employeeId, String employee, String jobDescription, String programmingLanguage) {
        Id = id;
        CalendarPlanId = calendarPlanId;
        EmployeeId = employeeId;
        Employee = employee;
        JobDescription = jobDescription;
        ProgrammingLanguage = programmingLanguage;
    }

    public ParticipationInDevelopment() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public int getCalendarPlanId() {
        return CalendarPlanId;
    }

    public void setCalendarPlanId(int calendarPlanId) {
        CalendarPlanId = calendarPlanId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String employee) {
        Employee = employee;
    }

    public String getJobDescription() {
        return JobDescription;
    }

    public void setJobDescription(String jobDescription) {
        JobDescription = jobDescription;
    }

    public String getProgrammingLanguage() {
        return ProgrammingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        ProgrammingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "ParticipationInDevelopment{" +
                "Id=" + Id +
                ", CalendarPlanId=" + CalendarPlanId +
                ", EmployeeId=" + EmployeeId +
                ", Employee='" + Employee + '\'' +
                ", JobDescription='" + JobDescription + '\'' +
                ", ProgrammingLanguage='" + ProgrammingLanguage + '\'' +
                '}';
    }
}
