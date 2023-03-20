package com.hnp.flowableproject.service;

import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;

public class RejectServiceTask implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.println("======================");
        System.out.println("Rejected Document...");
        System.out.println("======================");
    }
}
