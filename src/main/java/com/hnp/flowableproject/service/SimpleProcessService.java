package com.hnp.flowableproject.service;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleProcessService {


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;



    @Transactional
    public void startProcess(String processKey, String document) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("document", document);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processKey, variables);
        System.out.println(processInstance.getProcessDefinitionId());
        System.out.println(processInstance.getProcessDefinitionId());
    }


    public void getTask(String group) {
        List<Task> tasks = taskService.createTaskQuery()
                .taskCandidateGroup(group)
                .list();
        System.out.println("size = " + tasks.size());
        for(Task t: tasks) {
            System.out.println(t.getId());
            Map<String, Object> variables = taskService.getVariables(t.getId());
            String document = (String) variables.get("document");
            System.out.println(document);
        }
    }


    public void review(String id) {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", false);
        taskService.complete(id, variables);
    }
}
