package org.test.spring.dao;

import org.test.spring.model.Record;

import java.util.List;

public interface RecordDao {

    public void addRec(Record records);

    public void updateRec(Record records);

    public void removeRec(int id);

    public Record getRecById(int id);

    public List<Record> listRec();
}
