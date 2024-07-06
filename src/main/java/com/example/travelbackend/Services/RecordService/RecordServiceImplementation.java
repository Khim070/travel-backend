package com.example.travelbackend.Services.RecordService;

import com.example.travelbackend.Dao.RecordDao.RecordDao;
import com.example.travelbackend.api.models.Record;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImplementation implements RecordService{

    private RecordDao recordDao;

    @Autowired
    public RecordServiceImplementation(RecordDao recordDao){
        this.recordDao = recordDao;
    }
    @Override
    public List<Record> findAll() {
        return recordDao.findAll();
    }

    @Transactional
    @Override
    public Record addRecord(Record record) {
        record.setId(0);
        Record result = recordDao.saveRecord(record);
        return result;
    }

    @Transactional
    @Override
    public List<Record> addRecords(List<Record> records) {
        records.forEach(record -> record.setId(0));
        return recordDao.saveAll(records);
    }
}
