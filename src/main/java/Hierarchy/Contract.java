package Hierarchy;

import java.util.Date;

public class Contract {
    private long IDNumberOfContract;
    private long CustomerId;
    private String Customer;
    private String Description;
    private String AgreementDate;
    private String Deadline;
    private int DevelopmentCost;

    public Contract(long IDNumberOfContract, long customerId, String customer, String description, String agreementDate, String deadline, int developmentCost) {
        this.IDNumberOfContract = IDNumberOfContract;
        CustomerId = customerId;
        Customer = customer;
        Description = description;
        AgreementDate = agreementDate;
        Deadline = deadline;
        DevelopmentCost = developmentCost;
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
        return CustomerId;
    }

    public void setCustomerId(long customerId) {
        CustomerId = customerId;
    }

    public String getCustomer() {
        return Customer;
    }

    public void setCustomer(String customer) {
        Customer = customer;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAgreementDate() {
        return AgreementDate;
    }

    public void setAgreementDate(String agreementDate) {
        AgreementDate = agreementDate;
    }

    public String getDeadline() {
        return Deadline;
    }

    public void setDeadline(String deadline) {
        Deadline = deadline;
    }

    public int getDevelopmentCost() {
        return DevelopmentCost;
    }

    public void setDevelopmentCost(int developmentCost) {
        DevelopmentCost = developmentCost;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "IDNumberOfContract=" + IDNumberOfContract +
                ", CustomerId=" + CustomerId +
                ", Customer='" + Customer + '\'' +
                ", Description='" + Description + '\'' +
                ", AgreementDate=" + AgreementDate +
                ", Deadline=" + Deadline +
                ", DevelopmentCost=" + DevelopmentCost +
                '}';
    }
}
