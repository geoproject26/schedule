package org.test.spring.dao;

import org.test.spring.model.Record;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordDaoImpl implements RecordDao {
    private static final Logger logger = LoggerFactory.getLogger(RecordDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRec(Record record) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(record);
    }

    @Override
    public void updateRec(Record record) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(record);
    }

    @Override
    public void removeRec(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Record record = (Record) session.load(Record.class, new Integer(id));

        if (record != null) {
            session.delete(record);
        }
    }

    @Override
    public Record getRecById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Record record = (Record) session.load(Record.class, new Integer(id));
        logger.info("Rec successfully loaded. Details: " + record);

        return record;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Record> listRec() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Record> list = (List<Record>) session.createQuery("from Record").list();
        return list;
    }


}