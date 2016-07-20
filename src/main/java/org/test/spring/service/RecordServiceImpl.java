package org.test.spring.service;

import org.springframework.stereotype.Service;
import org.test.spring.model.Record;
import org.test.spring.dao.RecordDao;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    private RecordDao recordDao;

    public void setRecordDao(RecordDao recordDao) {
        this.recordDao = recordDao;
    }


    @Override
    @Transactional
    public void addRec(Record record) {
        this.recordDao.addRec(record);
    }

    @Override
    @Transactional
    public void updateRec(Record record) {
        this.recordDao.updateRec(record);
    }

    @Override
    @Transactional
    public void removeRec(int id) {
        this.recordDao.removeRec(id);
    }

    @Override
    @Transactional
    public Record getRecById(int id) {
        return this.recordDao.getRecById(id);
    }

    @Override
    @Transactional
    public List<Record> listRec() {
        return this.recordDao.listRec();
    }
}