package com.example.demo;

import com.example.demo.service.IItemService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        IItemService itemService = ctx.getBean(IItemService.class);
        itemService.parseItemsFromFile();
    }
}
