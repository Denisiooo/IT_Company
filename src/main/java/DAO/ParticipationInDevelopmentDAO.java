package DAO;

import hierarchy.ParticipationInDevelopment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipationInDevelopmentDAO implements IParticipationInDevelopmentDAO {
    private static final Logger LOGGER = LogManager.getLogger(ParticipationInDevelopmentDAO.class);

    public static final String ALL_PARTICIPATIONS = "SELECT * FROM participation_in_development";
    public static final String EMPLOYEE_BY_ID = "SELECT * FROM participation_in_development WHERE ID = ?";
    public static final String UPDATE = "UPDATE participation_in_development SET Programming_language = ? " +
            "WHERE ID = ?";
    public static final String DELETE = "DELETE FROM participation_in_development WHERE Сalendar_plan_ID = ?";
    public static final String CREATE = "INSERT INTO participation_in_development (Сalendar_plan_ID, Employee_ID, Employee, " +
            "Job_description, Programming_language) " +
            "VALUES (?, ?, ?, ?, ?)";


    @Override
    public List<ParticipationInDevelopment> findAll() throws SQLException, IOException {
        List<ParticipationInDevelopment> participationInDevelopments = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(ALL_PARTICIPATIONS);
            while (resultSet.next()) {
                long id = resultSet.getLong(1);
                int calendarPlanId = resultSet.getInt(2);
                int employeeId = resultSet.getInt(3);
                String employee = resultSet.getString(4);
                String jobDescription = resultSet.getString(5);
                String programmingLanguage = resultSet.getNString(6);
                participationInDevelopments.add(new ParticipationInDevelopment(id, calendarPlanId, employeeId, employee,
                        jobDescription, programmingLanguage));
            }
            LOGGER.info(participationInDevelopments);
        }catch (SQLException e){
            LOGGER.info(e.getMessage());
        }
        return participationInDevelopments;
    }

    @Override
    public ParticipationInDevelopment getEntityById(long id) throws SQLException, IOException {
        ParticipationInDevelopment participationInDevelopment = new ParticipationInDevelopment();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(EMPLOYEE_BY_ID)) {
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                participationInDevelopment.setId(resultSet.getLong(1));
                participationInDevelopment.setCalendarPlanId(resultSet.getInt(2));
                participationInDevelopment.setEmployeeId(resultSet.getInt(3));
                participationInDevelopment.setEmployee(resultSet.getString(4));
                participationInDevelopment.setJobDescription(resultSet.getString(5));
                participationInDevelopment.setProgrammingLanguage(resultSet.getString(6));
            }
            LOGGER.info(participationInDevelopment.getId() + " " + participationInDevelopment.getCalendarPlanId() + " "
            + participationInDevelopment.getEmployeeId() + " " + participationInDevelopment.getEmployee() + " "
            + participationInDevelopment.getJobDescription() + " " + participationInDevelopment.getProgrammingLanguage());
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return participationInDevelopment;
    }

    @Override
    public boolean update(ParticipationInDevelopment entity) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE)) {
              ps.setString(1, entity.getProgrammingLanguage());
              ps.setLong(2, entity.getId());
              ps.executeUpdate();
              ps.close();
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }

    @Override
    public boolean create(ParticipationInDevelopment entity) throws SQLException, IOException {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.addBatch("SET FOREIGN_KEY_CHECKS=0");
//            ps.addBatch("SET FOREIGN_KEY_CHECKS=1");
            ps.executeBatch();
            ps.setInt(1, entity.getCalendarPlanId());
            ps.setInt(2, entity.getEmployeeId());
            ps.setString(3, entity.getEmployee());
            ps.setString(4, entity.getJobDescription());
            ps.setString(5, entity.getProgrammingLanguage());
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
            String del = "DELETE FROM participation_in_development WHERE ID = " + id;
            stmt.executeUpdate(del);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        }
        return true;
    }
}
