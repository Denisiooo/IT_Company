package DAO.myBatis.mappers;

import hierarchy.Contract;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

public interface IContractMapper {
    @Results({
            @Result(property = "IDNumberOfContract", column = "ID_Number_of_contract"),
            @Result(property = "customerId", column = "Customer_ID"),
            @Result(property = "customer", column = "Customer"),
            @Result(property = "description", column = "Description"),
            @Result(property = "agreementDate", column = "Agreement_date"),
            @Result(property = "deadline", column = "Deadline"),
            @Result(property = "developmentCost", column = "Development_cost")
    })

    @Insert("INSERT INTO contract (Customer_ID, Customer, Description, Agreement_date, Deadline, Development_cost) VALUES (#{customerId}, #{customer}, #{description}, #{agreementDate}, #{deadline}, #{developmentCost})")
    public abstract boolean create(Contract entity);
}
