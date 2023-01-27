package Hierarchy;

import java.util.Date;

public class ActsOfWorkPerformed{
    private long ActId;
    private Date ActDate;
    private long IdNumberOfContract;

    public long getActId() {
        return ActId;
    }

    public void setActId(long actId) {
        ActId = actId;
    }

    public Date getActDate() {
        return ActDate;
    }

    public void setActDate(Date actDate) {
        ActDate = actDate;
    }

    public long getIdNumberOfContract() {
        return IdNumberOfContract;
    }

    public void setIdNumberOfContract(long idNumberOfContract) {
        IdNumberOfContract = idNumberOfContract;
    }

    @Override
    public String toString() {
        return "ActsOfWorkPerformed{" +
                "ActId=" + ActId +
                ", ActDate=" + ActDate +
                ", IdNumberOfContract=" + IdNumberOfContract +
                '}';
    }
}
