package com.example.travelbackend.api.controllers;

import com.example.travelbackend.Services.RecordService.RecordService;
import com.example.travelbackend.api.models.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RecordController {
    private RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService){
        this.recordService = recordService;
    }

    @GetMapping("/record")
    public List<Record> getAllRecord(){
        return recordService.findAll();
    }


    @PostMapping("/record/only")
    public Record addRecord(@RequestBody Record record){
        return recordService.addRecord(record);
    }

    @PostMapping("/record")
    public List<Record> addRecords(@RequestBody List<Record> records){
        return recordService.addRecords(records);
    }
}
