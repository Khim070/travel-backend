package com.example.travelbackend.Dao.RecordDao;

import com.example.travelbackend.api.models.MenuBar;
import com.example.travelbackend.api.models.Record;

import java.util.List;

public interface RecordDao {
    List<Record> findAll();
    Record saveRecord(Record record);
    Record findById(int id);

    List<Record> saveAll(List<Record> records);
}
