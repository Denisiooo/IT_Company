package Hierarchy;

public class Investors {
    private long InvestorId;
    private String InvestorName;
    private String Address;
    private int PhoneNumber;

    public long getInvestorId() {
        return InvestorId;
    }

    public void setInvestorId(long investorId) {
        InvestorId = investorId;
    }

    public String getInvestorName() {
        return InvestorName;
    }

    public void setInvestorName(String investorName) {
        InvestorName = investorName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Investors{" +
                "InvestorId=" + InvestorId +
                ", InvestorName='" + InvestorName + '\'' +
                ", Address='" + Address + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                '}';
    }
}
