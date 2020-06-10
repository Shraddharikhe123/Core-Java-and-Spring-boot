package com.techChallenge.techgig.dao;

import com.techChallenge.techgig.beans.IGenericVo;

import com.techChallenge.techgig.contants.ResponseMessage;
import com.techChallenge.techgig.dbconfig.DatabaseConfig;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * Dao layer which consist of Select,insert,update and delete configuration(Generic code)
 */
@Component
public class DaoImpl implements IDao {

    @Autowired
    private DatabaseConfig sessionFactory;

    /**
     * @param getallavailableroomsQuery
     * @param conditions
     * @return
     * @throws Exception
     */
    @Override
    public List<IGenericVo> getRequiredData(String getallavailableroomsQuery, List<KeyValue> conditions) throws Exception {
        List<IGenericVo> list = null;
        Transaction transaction = null;
        try (Session session = sessionFactory.getSessionFactory().openSession()) {

            transaction = session.getTransaction();
            transaction.begin();
            Query query = session.createQuery(getallavailableroomsQuery);
            if (conditions != null) {
                for (KeyValue kv : conditions) {
                    if (kv.getValue() instanceof Collection) {
                        ((org.hibernate.query.Query) query).setParameterList(kv.getKey(), (Collection) kv.getValue());
                    } else {

                        query.setParameter(kv.getKey(), kv.getValue());
                    }
                }
            }
            list = query.getResultList();
            transaction.commit();


            return list;
        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            throw new Exception(ResponseMessage.DATA_NOT_FOUND, e);
        }
    }

    @Override
    public boolean save(IGenericVo iGenericVo) throws Exception {
        Transaction transaction = null;

        try (Session session = sessionFactory.getSessionFactory().openSession()) {

            transaction = session.getTransaction();
            transaction.begin();

            session.saveOrUpdate(iGenericVo);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception(ResponseMessage.DATA_NOT_FOUND, e);
        }
        return true;
    }

    @Override
    public boolean deleteData(String bookingDetailWithReferenceID, List<KeyValue> conditions) throws Exception {
        Transaction transaction = null;
        try (Session session = sessionFactory.getSessionFactory().openSession()) {
            transaction = session.getTransaction();
            transaction.begin();
            org.hibernate.query.Query query = session.createQuery(bookingDetailWithReferenceID);
            if (conditions != null) {
                for (KeyValue kv : conditions) {
                    if (kv.getValue() instanceof Collection) {
                        query.setParameterList(kv.getKey(), (Collection) kv.getValue());
                    } else {
                        query.setParameter(kv.getKey(), kv.getValue());
                    }
                }
            }
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new Exception(ResponseMessage.DATA_NOT_FOUND, e);

        }
    }
}

