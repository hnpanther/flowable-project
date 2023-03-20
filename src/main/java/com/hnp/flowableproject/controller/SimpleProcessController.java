package com.hnp.flowableproject.controller;

import com.hnp.flowableproject.entity.Document;
import com.hnp.flowableproject.service.SimpleProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleProcessController {


    @Autowired
    private SimpleProcessService simpleProcessService;

    @PostMapping("start-process")
    public void startProcess() {
        Document document = new Document();
        document.setAuthor("user");
        document.setId(1);
        document.setTitle("new document");
        this.simpleProcessService.startProcess("simple-process", "this is first document ");
    }


    @GetMapping("get-task")
    public void getTask() {
        this.simpleProcessService.getTask("reviewer");
    }


    @PostMapping("review/{id}")
    public void review(@PathVariable String id) {
        this.simpleProcessService.review(id);
    }
}
