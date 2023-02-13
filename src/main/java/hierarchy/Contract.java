package hierarchy;

import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Contract {
    private long IDNumberOfContract;
    private long customerId;
    private String customer;
    private String description;
    private String agreementDate;
    private String deadline;
    private int developmentCost;

    public Contract(long IDNumberOfContract, long customerId, String customer, String description, String agreementDate, String deadline, int developmentCost) {
        this.IDNumberOfContract = IDNumberOfContract;
        this.customerId = customerId;
        this.customer = customer;
        this.description = description;
        this.agreementDate = agreementDate;
        this.deadline = deadline;
        this.developmentCost = developmentCost;
    }

    public Contract(long customerId, String customer, String description, String agreementDate, String deadline, int developmentCost) {
        this.customerId = customerId;
        this.customer = customer;
        this.description = description;
        this.agreementDate = agreementDate;
        this.deadline = deadline;
        this.developmentCost = developmentCost;
    }

    public Contract() {
    }

    public long getIDNumberOfContract() {
        return IDNumberOfContract;
    }

    public void setIDNumberOfContract(long IDNumberOfContract) {
        this.IDNumberOfContract = IDNumberOfContract;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAgreementDate() {
        return agreementDate;
    }

    public void setAgreementDate(String agreementDate) {
        this.agreementDate = agreementDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getDevelopmentCost() {
        return developmentCost;
    }

    public void setDevelopmentCost(int developmentCost) {
        this.developmentCost = developmentCost;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "IDNumberOfContract=" + IDNumberOfContract +
                ", CustomerId=" + customerId +
                ", Customer='" + customer + '\'' +
                ", Description='" + description + '\'' +
                ", AgreementDate=" + agreementDate +
                ", Deadline=" + deadline +
                ", DevelopmentCost=" + developmentCost +
                '}';
    }

    public static Contract Factory(Scanner scanner, Logger LOGGER){
        LOGGER.info("Enter customer Id");
        long customerId = scanner.nextLong();
        LOGGER.info("Enter customer");
        String customer = scanner.next();
        LOGGER.info("Enter description");
        String description = scanner.next();
        LOGGER.info("Enter agreement date");
        String agreementDate = scanner.next();
        LOGGER.info("Enter deadline");
        String deadline = scanner.next();
        LOGGER.info("Enter development cost");
        int developmentCost = scanner.nextInt();
        return new Contract(customerId, customer, description, agreementDate, deadline, developmentCost);
    }
}
