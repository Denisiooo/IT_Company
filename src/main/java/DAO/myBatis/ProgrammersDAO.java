package DAO.myBatis;

import DAO.IProgrammersDAO;
import hierarchy.Programmers;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

public class ProgrammersDAO implements IProgrammersDAO {
    private static final Logger LOGGER = LogManager.getLogger(ProgrammersDAO.class);

    @Override
    public List<Programmers> findAll() throws SQLException, IOException {
        return null;
    }

    @Override
    public Programmers getEntityById(long id) throws SQLException, IOException {
        try {
            Reader reader = Resources.getResourceAsReader("mybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
                IProgrammersDAO programmersDAO = sqlSession.getMapper(IProgrammersDAO.class);
                return programmersDAO.getEntityById(id);
            }
        } catch (IOException ex) {
            LOGGER.info(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean update(Programmers entity) throws SQLException, IOException {
        return false;
    }

    @Override
    public boolean create(Programmers entity) throws SQLException, IOException {
        return false;
    }

    @Override
    public boolean remove(long id) throws SQLException, IOException {
        return false;
    }
}
