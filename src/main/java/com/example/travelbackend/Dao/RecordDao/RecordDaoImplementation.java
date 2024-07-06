package com.example.travelbackend.Dao.RecordDao;

import com.example.travelbackend.api.models.Record;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RecordDaoImplementation implements RecordDao {

    private EntityManager entityManager;

    @Autowired
    public RecordDaoImplementation(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Record> findAll() {
        TypedQuery<Record> query = entityManager.createQuery("SELECT r FROM Record r", Record.class);
        List<Record> result  = query.getResultList();
        return result;
    }

    @Override
    public Record saveRecord(Record record) {
        Record result = entityManager.merge(record);
        return result;
    }

    @Override
    public Record findById(int id) {
        Record result = entityManager.find(Record.class, id);
        return result;
    }

    @Override
    public List<Record> saveAll(List<Record> records) {
        for (Record record : records) {
            entityManager.merge(record);
        }
        return records;
    }
}
