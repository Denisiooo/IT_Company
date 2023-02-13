package DAO;

import hierarchy.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ProgrammersDAO implements IProgrammersDAO {
    private static final Logger LOGGER = LogManager.getLogger(ProgrammersDAO.class);

    public static final String ALL_PROGRAMMERS = "SELECT * FROM programmers";
    public static final String USERS_BY_ID = "SELECT * FROM programmers WHERE ID_Employee = ?";
    public static final String UPDATE = "UPDATE programmers SET Phone_number = ? WHERE ID_Employee = ?";
//    public static final String DELETE = "DELETE FROM programmers WHERE ID_Employee = ?";
    public static final String CREATE = "INSERT INTO programmers (Surname, Name, Patronymic, Phone_number, Date_of_Birth) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Programmers> findAll() throws SQLException, IOException {
        List<Programmers> programmers = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(ALL_PROGRAMMERS);
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                String surname = resultSet.getString(2);
                String name = resultSet.getString(3);
                String patronymic = resultSet.getString(4);
                int phoneNumber = resultSet.getInt(5);
                String dateOfBirth = resultSet.getString(6);

                programmers.add(new Programmers(id, surname, name, patronymic, phoneNumber, dateOfBirth));
            }
            LOGGER.info(programmers);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return programmers;
    }

    @Override
    public Programmers getEntityById(long id) throws SQLException, IOException {
        Programmers programmers = new Programmers();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(USERS_BY_ID)) {
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                programmers.setIdEmployee(resultSet.getLong("ID_Employee"));
                programmers.setSurname(resultSet.getString("Surname"));
                programmers.setName(resultSet.getString("Name"));
                programmers.setPatronymic(resultSet.getString("Patronymic"));
                programmers.setPhoneNumber(resultSet.getInt("Phone_number"));
                programmers.setDateOfBirth(resultSet.getString("Date_of_birth"));
            }
            LOGGER.info(programmers.getIdEmployee() + " " + programmers.getSurname() + " " + programmers.getName() +
                    " " + programmers.getPatronymic() + " " + programmers.getPhoneNumber() + " " + programmers.getDateOfBirth());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return programmers;
    }

    @Override
    public boolean update(Programmers entity) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, entity.getPhoneNumber());
            ps.setLong(2, entity.getIdEmployee());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean create(Programmers entity) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement(CREATE);
//            ps.setLong(1, entity.getIdEmployee());
            ps.setString(1, entity.getSurname());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getPatronymic());
            ps.setInt(4, entity.getPhoneNumber());
            ps.setString(5, entity.getDateOfBirth());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean remove(long id) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection()) {
            Statement ps = connection.createStatement();
            String del = "DELETE FROM programmers WHERE ID_Employee = " + id;
            ps.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }
}
