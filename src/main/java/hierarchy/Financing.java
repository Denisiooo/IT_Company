package hierarchy;

import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Financing {
    private long id;
    private long softwareId;
    private int investorId;
    private String investor;
    private int amount;

    public Financing(long id, long softwareId, int investorId, String investor, int amount) {
        this.id = id;
        this.softwareId = softwareId;
        this.investorId = investorId;
        this.investor = investor;
        this.amount = amount;
    }

    public Financing(long softwareId, int investorId, String investor, int amount) {
        this.softwareId = softwareId;
        this.investorId = investorId;
        this.investor = investor;
        this.amount = amount;
    }

    public Financing() {
    }

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

    public int getInvestorId() {
        return investorId;
    }

    public void setInvestorId(int investorId) {
        this.investorId = investorId;
    }

    public String getInvestor() {
        return investor;
    }

    public void setInvestor(String investor) {
        this.investor = investor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Financing{" +
                "Id=" + id +
                ", SoftwareId=" + softwareId +
                ", InvestorId=" + investorId +
                ", Investor='" + investor + '\'' +
                ", Amount=" + amount +
                '}';
    }

    public static Financing Factory(Scanner scanner, Logger LOGGER){
        LOGGER.info("Enter software Id");
        long softwareId = scanner.nextLong();
        LOGGER.info("Enter investor Id");
        int investorId = scanner.nextInt();
        LOGGER.info("Enter investor");
        String investor = scanner.next();
        LOGGER.info("Enter amount");
        int amount = scanner.nextInt();
        return new Financing(softwareId, investorId, investor, amount);
    }
}
