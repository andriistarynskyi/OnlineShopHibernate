package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileReaderService {

    @Autowired
    ItemService itemService;

    public boolean saveItems() {
        itemService.parseItemsFromFile().forEach(i -> itemService.save(i));
        System.out.println("Items from file were saved to DB");
        return true;
    }
}
