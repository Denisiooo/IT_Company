package Hierarchy;

public class Financing {
    private long Id;
    private long SoftwareId;
    private int InvestorId;
    private String Investor;
    private int Amount;

    public Financing(long id, long softwareId, int investorId, String investor, int amount) {
        Id = id;
        SoftwareId = softwareId;
        InvestorId = investorId;
        Investor = investor;
        Amount = amount;
    }

    public Financing() {
    }

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

    public int getInvestorId() {
        return InvestorId;
    }

    public void setInvestorId(int investorId) {
        InvestorId = investorId;
    }

    public String getInvestor() {
        return Investor;
    }

    public void setInvestor(String investor) {
        Investor = investor;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Financing{" +
                "Id=" + Id +
                ", SoftwareId=" + SoftwareId +
                ", InvestorId=" + InvestorId +
                ", Investor='" + Investor + '\'' +
                ", Amount=" + Amount +
                '}';
    }
}
