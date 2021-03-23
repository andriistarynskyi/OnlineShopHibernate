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

        dataFromFileSaverService.save();

        List<Payment> payments = reportService.findAll();

//        get all purchased items by women sorted by number of sales
        reportService.getItemsPurchasedByWomen(payments).forEach(i -> System.out.println(i));

        System.out.println("--------------------");

//        save top three best selling items to file
        System.out.println(reportService.saveBestSellersToFile(payments));

//        save three candidates to remove to file
        System.out.println(reportService.saveCandidatesToRemoveToFile(payments));

//        get top three bestselling items
        reportService.getBestSellers(payments).forEach(i -> System.out.println(i));

        System.out.println("--------------------");
//        get three items - candidates to remove
        reportService.getCandidatesToRemove(payments).forEach(i -> System.out.println(i));
    }
}