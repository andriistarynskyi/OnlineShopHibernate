package com.example.demo.service;

import com.example.demo.entity.Item;

public interface IItemService {
    boolean parseItemsFromFile();

    void save(Item item);

    Item findById(int id);
}
