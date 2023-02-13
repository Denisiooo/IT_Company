package utils.myBatis;

import DAO.myBatis.ContractDAO;
import hierarchy.Contract;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;

public class MyBatisMain {
    private static final Logger LOGGER = LogManager.getLogger(MyBatisMain.class);

    public static void main(String[] args) throws SQLException, IOException {
//        LOGGER.info(new DAO.myBatis.ProgrammersDAO().getEntityById(3));
        ContractDAO contractDAO = new ContractDAO();
        Contract contract = new Contract();
        contract.setCustomerId(6);
        contract.setCustomer("smth");
        contract.setDescription("www");
        contract.setAgreementDate("2000-11-11");
        contract.setDeadline("2000-12-12");
        contract.setDevelopmentCost(500);
        LOGGER.info(contractDAO.create(contract));
    }
}
