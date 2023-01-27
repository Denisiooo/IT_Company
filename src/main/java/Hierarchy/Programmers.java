package Hierarchy;


import java.sql.Date;

public class Programmers {
    private long IdEmployee;
    private String Surname;
    private String Name;
    private String Patronymic;
    private int PhoneNumber;
    private String DateOfBirth;

    public Programmers(long idEmployee, String surname, String name, String patronymic, int phoneNumber, String dateOfBirth) {
        IdEmployee = idEmployee;
        Surname = surname;
        Name = name;
        Patronymic = patronymic;
        PhoneNumber = phoneNumber;
        DateOfBirth = dateOfBirth;
    }

    public Programmers() {

    }

    public long getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        IdEmployee = idEmployee;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String patronymic) {
        Patronymic = patronymic;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Programmers{" +
                "IdEmployee=" + IdEmployee +
                ", Surname='" + Surname + '\'' +
                ", Name='" + Name + '\'' +
                ", Patronymic='" + Patronymic + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", DateOfBirth=" + DateOfBirth +
                '}';
    }
}
