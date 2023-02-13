package DAO;

import hierarchy.Financing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinancingDAO implements IFinancingDAO{
    private static final Logger LOGGER = LogManager.getLogger(FinancingDAO.class);

    public static final String ALL_INVESTOR = "SELECT * FROM financing";
    public static final String INVESTOR_BY_ID = "SELECT * FROM financing WHERE ID = ?";
    public static final String UPDATE = "UPDATE financing SET Investor = ? WHERE ID = ?";
    public static final String DELETE = "DELETE FROM financing WHERE ID = ?";
    public static final String CREATE = "INSERT INTO financing (Software_ID, Investor_ID, Investor, Amount) " +
            "VALUES (?, ?, ?, ?)";

    @Override
    public List<Financing> findAll() throws SQLException, IOException {
        List<Financing> financings = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery(ALL_INVESTOR);
            while (resultSet.next()){
                long id = resultSet.getLong(1);
                long softwareId = resultSet.getLong(2);
                int investorId = resultSet.getInt(3);
                String investor = resultSet.getString(4);
                int amount = resultSet.getInt(5);
                financings.add(new Financing(id, softwareId, investorId, investor, amount));
            }
            LOGGER.info(financings);
        }catch (SQLException e){
            LOGGER.info(e.getMessage());
        }
        return financings;
    }

    @Override
    public Financing getEntityById(long id) throws SQLException, IOException {
        Financing financing = new Financing();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(INVESTOR_BY_ID)){
            ps.setLong(1,id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                financing.setId(resultSet.getLong(1));
                financing.setSoftwareId(resultSet.getLong(2));
                financing.setInvestorId(resultSet.getInt(3));
                financing.setInvestor(resultSet.getString(4));
                financing.setAmount(resultSet.getInt(5));
            }
            LOGGER.info(financing.getId() + " " + financing.getSoftwareId() + " " + financing.getInvestorId()
            + " " + financing.getInvestor() + " " + financing.getAmount());
        }catch (SQLException e){
            LOGGER.info(e.getMessage());
        }
        return financing;
    }

    @Override
    public boolean update(Financing entity) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getInvestor());
            ps.setLong(2, entity.getId());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean create(Financing entity) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.addBatch("SET FOREIGN_KEY_CHECKS=0");
//            ps.addBatch("SET FOREIGN_KEY_CHECKS=1");
            ps.executeBatch();
             ps.setLong(1, entity.getSoftwareId());
             ps.setInt(2, entity.getInvestorId());
             ps.setString(3, entity.getInvestor());
             ps.setInt(4, entity.getAmount());
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
            String del = "DELETE FROM financing WHERE ID = " + id;
            stmt.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }
}
