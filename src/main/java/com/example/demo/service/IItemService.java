package com.example.demo.service;

import com.example.demo.entity.Item;

import java.util.List;

public interface IItemService {
    List<Item> parseItemsFromFile();

    void save(Item item);

    Item findById(int id);
}
