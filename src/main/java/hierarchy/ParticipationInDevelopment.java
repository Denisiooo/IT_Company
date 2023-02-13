package hierarchy;

import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ParticipationInDevelopment {
    private long id;
    private int calendarPlanId;
    private int employeeId;
    private String employee;
    private String jobDescription;
    private String programmingLanguage;

    public ParticipationInDevelopment(long id, int calendarPlanId, int employeeId, String employee, String jobDescription, String programmingLanguage) {
        this.id = id;
        this.calendarPlanId = calendarPlanId;
        this.employeeId = employeeId;
        this.employee = employee;
        this.jobDescription = jobDescription;
        this.programmingLanguage = programmingLanguage;
    }

    public ParticipationInDevelopment(int calendarPlanId, int employeeId, String employee, String jobDescription, String programmingLanguage) {
        this.calendarPlanId = calendarPlanId;
        this.employeeId = employeeId;
        this.employee = employee;
        this.jobDescription = jobDescription;
        this.programmingLanguage = programmingLanguage;
    }

    public ParticipationInDevelopment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCalendarPlanId() {
        return calendarPlanId;
    }

    public void setCalendarPlanId(int calendarPlanId) {
        this.calendarPlanId = calendarPlanId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "ParticipationInDevelopment{" +
                "Id=" + id +
                ", CalendarPlanId=" + calendarPlanId +
                ", EmployeeId=" + employeeId +
                ", Employee='" + employee + '\'' +
                ", JobDescription='" + jobDescription + '\'' +
                ", ProgrammingLanguage='" + programmingLanguage + '\'' +
                '}';
    }

    public static ParticipationInDevelopment Factory(Scanner scanner, Logger LOGGER){
        LOGGER.info("Enter calendar plan Id");
        int calendarPlanId = scanner.nextInt();
        LOGGER.info("Enter employee Id");
        int employeeId = scanner.nextInt();
        LOGGER.info("Enter employee");
        String employee = scanner.next();
        LOGGER.info("Enter job description");
        String jobDescription = scanner.next();
        LOGGER.info("Enter programming language");
        String programmingLanguage = scanner.next();
        return new ParticipationInDevelopment(calendarPlanId, employeeId, employee, jobDescription, programmingLanguage);
    }
}
