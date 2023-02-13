package hierarchy;


import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

@JsonRootName(value = "Programmers")
public class Programmers {
    private long idEmployee;
    private String surname;
    private String name;
    private String patronymic;
    private int phoneNumber;
    //    @JsonSerialize(using = DaraSerializer.class)
//    @JsonDeserialize(using = DataDeserializer.class)
    private String dateOfBirth;

    public Programmers(long idEmployee, String surname, String name, String patronymic, int phoneNumber, String dateOfBirth) {
        this.idEmployee = idEmployee;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Programmers(String surname, String name, String patronymic, int phoneNumber, String dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public Programmers() {

    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //    @XmlJavaTypeAdapter(DataAdapter.class)
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Programmers{" +
                "IdEmployee=" + idEmployee +
                ", Surname='" + surname + '\'' +
                ", Name='" + name + '\'' +
                ", Patronymic='" + patronymic + '\'' +
                ", PhoneNumber=" + phoneNumber +
                ", DateOfBirth=" + dateOfBirth +
                '}';
    }

    public static Programmers Factory(Scanner scanner, Logger LOGGER) {
        LOGGER.info("Enter surname");
        String surname = scanner.next();
        LOGGER.info("Enter name");
        String name = scanner.next();
        LOGGER.info("Enter patronymic");
        String patronymic = scanner.next();
        LOGGER.info("Enter phone number");
        int phoneNumber = scanner.nextInt();
        LOGGER.info("Enter date of birth");
        String dateOfBirth = scanner.next();
        return new Programmers(surname, name, patronymic, phoneNumber, dateOfBirth);
    }
}
