package com.example.demo;

import com.example.demo.entity.Payment;
import com.example.demo.service.IDataFromFileSaverService;
import com.example.demo.service.report.IReportService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        IDataFromFileSaverService dataFromFileSaverService = ctx.getBean(IDataFromFileSaverService.class);
        IReportService reportService = ctx.getBean(IReportService.class);
        List<Payment> payments = reportService.findAll();
        payments.forEach(p -> System.out.println(p.getItems()));
    }
}