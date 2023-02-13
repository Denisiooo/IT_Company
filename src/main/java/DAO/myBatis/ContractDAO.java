package DAO.myBatis;

import DAO.IContractDAO;
import DAO.myBatis.mappers.IContractMapper;
import hierarchy.Contract;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.myBatis.MyBatisDaoFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ContractDAO implements IContractDAO {
    private static final Logger LOGGER = LogManager.getLogger(ContractDAO.class);
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public List<Contract> findAll() throws SQLException, IOException {
        return null;
    }

    @Override
    public Contract getEntityById(long id) throws SQLException, IOException {
        return null;
    }

    @Override
    public boolean update(Contract entity) throws SQLException, IOException {
        return false;
    }

    @Override
    public boolean create(Contract entity) throws SQLException, IOException {
        boolean res = false;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IContractMapper contractMapper = sqlSession.getMapper(IContractMapper.class);
            try {
                res = contractMapper.create(entity);
                sqlSession.commit();
            } catch (Exception e) {
                sqlSession.rollback();
                LOGGER.error(e.getMessage(), e);
            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return res;
    }

    @Override
    public boolean remove(long id) throws SQLException, IOException {
        return false;
    }
}
