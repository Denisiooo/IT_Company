package hierarchy;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Programmers")
public class Investors {
    private long InvestorId;
    private String InvestorName;
    private String Address;
    private int PhoneNumber;

    public Investors(long investorId, String investorName, String address, int phoneNumber) {
        InvestorId = investorId;
        InvestorName = investorName;
        Address = address;
        PhoneNumber = phoneNumber;
    }

    public Investors() {
    }

    @JsonGetter
    public long getInvestorId() {
        return InvestorId;
    }

    public void setInvestorId(long investorId) {
        InvestorId = investorId;
    }

    @JsonGetter
    public String getInvestorName() {
        return InvestorName;
    }

    public void setInvestorName(String investorName) {
        InvestorName = investorName;
    }

    @JsonGetter
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @JsonGetter
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
