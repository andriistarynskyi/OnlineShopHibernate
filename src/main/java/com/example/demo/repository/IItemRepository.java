package com.example.demo.repository;

import com.example.demo.entity.Item;

public interface IItemRepository {
    void save(Item item);

    Item findById(int id);

    boolean updateItem(Item item);
}
