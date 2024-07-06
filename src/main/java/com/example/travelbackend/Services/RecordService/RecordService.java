package com.example.travelbackend.Services.RecordService;

import com.example.travelbackend.api.models.Record;
import jakarta.transaction.Transactional;

import java.util.List;

public interface RecordService {

    List<Record> findAll();
    @Transactional
    Record addRecord(Record record);

    @Transactional
    List<Record> addRecords(List<Record> records);
}
