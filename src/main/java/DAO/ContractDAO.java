package DAO;

import hierarchy.Contract;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO implements IContractDAO {
    private static final Logger LOGGER = LogManager.getLogger(ContractDAO.class);

    public static final String ALL_CONTRACT = "SELECT * FROM contract";
    public static final String USERS_BY_ID = "SELECT * FROM contract WHERE ID_Number_of_contract = ?";
    public static final String UPDATE = "UPDATE contract SET Customer = ? WHERE ID_Number_of_contract = ?";
    public static final String DELETE = "DELETE FROM contract WHERE Customer_ID = ?";
    public static final String CREATE = "INSERT INTO contract (Customer_ID, Customer, Description, Agreement_date, Deadline, Development_cost) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public List<Contract> findAll() throws SQLException, IOException {
        List<Contract> contracts = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(ALL_CONTRACT);
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                long custId = resultSet.getLong(2);
                String customer = resultSet.getString(3);
                String description = resultSet.getString(4);
                String agreementDate = resultSet.getString(5);
                String deadline = resultSet.getString(6);
                int cost = resultSet.getInt(7);
                contracts.add(new Contract(id, custId, customer, description, agreementDate, deadline, cost));
            }
            LOGGER.info(contracts);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return contracts;
    }

    @Override
    public Contract getEntityById(long id) throws SQLException, IOException {
        Contract contract = new Contract();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(USERS_BY_ID)) {
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
//                contract.setIDNumberOfContract(resultSet.getLong(1));
                contract.setCustomerId(resultSet.getLong(1));
                contract.setCustomer(resultSet.getString(2));
                contract.setDescription(resultSet.getString(3));
                contract.setAgreementDate(resultSet.getString(4));
                contract.setDeadline(resultSet.getString(5));
                contract.setDevelopmentCost(resultSet.getInt(6));
            }
            LOGGER.info(contract.getIDNumberOfContract() + " " + contract.getCustomerId() + " " + contract.getCustomer()
                    + " " + contract.getDescription() + " " + contract.getAgreementDate() + " " + contract.getDeadline() + " "
                    + contract.getDevelopmentCost());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return contract;
    }

    @Override
    public boolean update(Contract entity) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getCustomer());
            ps.setLong(2, entity.getIDNumberOfContract());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean create(Contract entity) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.addBatch("SET FOREIGN_KEY_CHECKS=0");
            ps.executeBatch();
            ps.setLong(1, entity.getCustomerId());
            ps.setString(2, entity.getCustomer());
            ps.setString(3, entity.getDescription());
            ps.setString(4, entity.getAgreementDate());
            ps.setString(5, entity.getDeadline());
            ps.setInt(6, entity.getDevelopmentCost());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean remove(long id) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            String del = "DELETE FROM contract WHERE ID_Number_of_contract = " + id;
            stmt.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }
}
